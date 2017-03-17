/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionMetric;

import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.attributeSelection.BestFirst;
import weka.attributeSelection.CfsSubsetEval;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Reorder;

/**
 *
 * @author aryan_000
 */
/*
class Report_Attribute_Selection
{
     
   Boolean loc , boc , tach , chd , cho , fch , lch , frch , csb , csbs , lca , lcd , wch , wcd , acdf , ataf , wfr , cp ;
   String release_name;
   
   Report_Attribute_Selection()
           {
               loc = boc = tach = chd = cho = fch = lch = frch = csb = csbs = lca = lcd = wcd = wch = acdf = ataf = wfr  = cp = false;
           }
    
}

class Report_ROC
{
    String release_name;
    double roc;
    
    Report_ROC(String release_name , double roc)
    {
        this.release_name = release_name;
        this.roc = roc;
    }
}
*/
class Model1  // only evolution 
{
    Boolean loc , boc , tach , chd , cho , fch , lch , frch , csb , csbs , lca , lcd , wch , wcd , acdf , ataf , wfr , cp ;
    String release_name;
    double roc;
   Model1 ()
           {
               loc = boc = tach = chd = cho = fch = lch = frch = csb = csbs = lca = lcd = wcd = wch = acdf = ataf = wfr  = cp = false;
           }
   private void set_roc(double roc)
   {
       this.roc = roc;
   }
   
   public double get_roc()
   {
       return this.roc;
   }
}




class Model2_attribute_selection
{
  Boolean wmc , dit , noc , cbo , rfc , lcom ,cp;
  String release_name;
  double roc;
  Model2_attribute_selection()
  {
      wmc = dit = noc = cbo = rfc = lcom =cp = false; 
  }
  
  private void set_roc(double roc)
   {
       this.roc = roc;
   }
   
   public double get_roc()
   {
       return this.roc;
   }
}




class Model3_attribute_selection // both candk and evolutionary metrics
{
    Boolean loc , boc , tach , chd , cho , fch , lch , frch , csb , csbs , lca , lcd , wch , wcd , acdf , ataf , wfr , cp ,wmc , dit , noc , cbo , rfc , lcom  ;
    String release_name;
    double roc;
    
    Model3_attribute_selection(){
    loc = boc = tach = chd = cho = fch = lch = frch = csb = csbs = lca = lcd = wcd = wch = acdf = ataf = wfr  = cp = false;
     wmc = dit = noc = cbo = rfc = lcom = false; 
    }
    
    private void set_roc(double roc)
   {
       this.roc = roc;
   }
   
   public double get_roc()
   {
       return this.roc;
   }
}



class Model4_attribute_selection
{
    Boolean cp , icp;
    String release_name;
    double roc;
    Model4_attribute_selection(){
        cp = icp = false;
    }
    
    private void set_roc(double roc)
   {
       this.roc = roc;
   }
   
   public double get_roc()
   {
       return this.roc;
   }
}


public class GenerateModel {
    
     protected Instances useFilter(Instances data) throws Exception {
//        System.out.println("\n2. Filter");
        weka.filters.supervised.attribute.AttributeSelection filter = new weka.filters.supervised.attribute.AttributeSelection();
        CfsSubsetEval eval = new CfsSubsetEval();
        BestFirst search = new BestFirst();
//        GreedyStepwise search = new GreedyStepwise();
//        search.setSearchBackwards(true);
        filter.setEvaluator(eval);
        filter.setSearch(search);
        filter.setInputFormat(data);
        Instances newData = Filter.useFilter(data, filter);
        return newData;
    }
     
     protected double useClassifier1(Instances data) throws Exception {
//        System.out.println("\n 2 Meta Classifier");
        AttributeSelectedClassifier classifier = new AttributeSelectedClassifier();
        Logistic base = new Logistic();
        CfsSubsetEval eval = new CfsSubsetEval();
        BestFirst search = new BestFirst();
        classifier.setClassifier(base);
        classifier.setEvaluator(eval);
        classifier.setSearch(search);
        Evaluation evaluation = new Evaluation(data);
        evaluation.crossValidateModel(classifier, data, 10, new Random(1));
        
        return evaluation.weightedAreaUnderROC();
//        System.out.println("these values are : " + evaluation.pctCorrect());
//        System.out.println("results are :  " + evaluation.toClassDetailsString());
//        System.out.println("classifier results : " + evaluation.toSummaryString());

    }
     
    String userPath;
    int version ; 
    
    GenerateModel(String userPath , int version )
    {
        this.userPath = userPath;
        this.version = version;
    }
    
    GenerateModel()
    {
        
    }
    
    protected void generate_models()
    {
        
        for(int i= 1; i<version-1 ; i++)
        {
            
        }
    } 
    
    public void gen_test()
    {
        File f = new File("C:\\Users\\aryan_000\\Desktop\\finalpro\\final_version05.csv");
        
        String fname = f.getPath();
        ConverterUtils.DataSource source = null;
         try {
             source = new ConverterUtils.DataSource(fname);
             Instances data = source.getDataSet();

             String range = "first";
             int cp_index = 0 ;
             for(int i =2;i<=data.numAttributes();i++)
             {  
                  if(data.attribute(i-1).name().equals("CP"))
                  {cp_index = i; System.out.println(data.attribute(i).name());
                      System.out.println(i);
                      continue;
                  }
                  else if(!range.equals(""))
                      range+= ",";
                    range +=  i;
             }
             range +=","+ cp_index; 
             Reorder r = new Reorder();
             r.setAttributeIndices(range);
             r.setInputFormat(data);
             data = Filter.useFilter(data, r);
             
             
         
             System.out.println(data);
         
         } catch (Exception ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
    }
    
    
    public static void main(String s[])
    {
        System.out.println("hello");
        GenerateModel gm = new GenerateModel();
        gm.gen_test();
        
    }
}

