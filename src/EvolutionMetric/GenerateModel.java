/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionMetric;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import weka.filters.unsupervised.attribute.Remove;
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




class Model2 
{
  Boolean wmc , dit , noc , cbo , rfc , lcom ,cp;
  String release_name;
  double roc;
  Model2 ()
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




class Model3 // both candk and evolutionary metrics
{
    Boolean loc , boc , tach , chd , cho , fch , lch , frch , csb , csbs , lca , lcd , wch , wcd , acdf , ataf , wfr , cp ,wmc , dit , noc , cbo , rfc , lcom  ;
    String release_name;
    double roc;
    
    Model3 (){
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



class Model4 
{
    Boolean cp , icp;
    String release_name;
    double roc;
    Model4 (){
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
    
   
    public void gen_model_test(Instances data)
    {
        System.out.println("in model test");
        System.out.println(data.numAttributes());
                Remove r = new Remove();
                r.setAttributeIndices("18,20");
                System.out.println(data.attribute(19).name());
                r.setInvertSelection(false);
         try {
             r.setInputFormat(data);
              data = Filter.useFilter(data, r);
              System.out.println(data.numAttributes());
                data = useFilter(data); 
         } catch (Exception ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
                
         System.out.println(data.numAttributes());
               
    } 
    
    public Instances gen_model1(Instances data)
    {   
//        System.out.println("inside model 1 ");
        String attr = "";
        String attribute ;
        String temp = "";
        for(int i =1;i<data.numAttributes()+1;i++)
        {
             attribute = data.attribute(i-1).name();
             if(attribute.matches("Filename") || attribute.startsWith("File") || attribute.equals("WMC") || attribute.equals("DIT")
                     || attribute.equals("NOC") || attribute.equals("CBO") || attribute.equals("RFC") || attribute.equals("LCOM") || attribute.equals("ICP")
                     )
             {
                 if(!attr.equals(""))
                     attr += ",";
                 attr += i ;
//                 System.out.println(attribute);
             }
                 
        } 
//                System.out.println(attr);
                Remove r = new Remove();
                r.setAttributeIndices(attr);
                r.setInvertSelection(false);
                try {
                    r.setInputFormat(data);
                    data = Filter.useFilter(data, r);
                    data = useFilter(data); // applying attribute selection
                } catch (Exception ex) {
                    Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
//             System.out.println("Model 1 attributes ");
//                for(int i = 0 ; i<data.numAttributes(); i++)
//                    temp += data.attribute(i).name() + ",";
//                
//                System.out.println(temp);
                 if (data.classIndex() == -1)  
                    data.setClassIndex(data.numAttributes() - 1);
        return data;
    }
    
    public Instances gen_model2(Instances data)
    {   
//        System.out.println("inside model 2 ");
        String attr = "";
        String attribute ;
        String temp = "";
        for(int i =1;i<data.numAttributes()+1;i++)
        {
             attribute = data.attribute(i-1).name();
             if(attribute.matches("Filename") || attribute.startsWith("File") || attribute.equals("LOC") || 
                     attribute.equals("BOC")  || attribute.equals("TACH")     || attribute.equals("CHO") || 
                     attribute.equals("CHD")  || attribute.equals("FCH")      || attribute.equals("ICP")  || 
                     attribute.equals("LCH")  || attribute.equals("FRCH")     || attribute.equals("CSB") || 
                     attribute.equals("CSBS") || attribute.equals("LCA")      || attribute.equals("LCD") || 
                     attribute.equals("WCH")  || attribute.equals("WCD")      || attribute.equals("ACDF") || 
                     attribute.equals("ATAF") || attribute.equals("WFR") )
             {
                 if(!attr.equals(""))
                     attr += ",";
                 attr += i ;
//                 System.out.println(attribute);
             }
                 
        } 
//                System.out.println(attr);
                Remove r = new Remove();
                r.setAttributeIndices(attr);
                r.setInvertSelection(false);
                try {
                    r.setInputFormat(data);
                    data = Filter.useFilter(data, r);
                     data = useFilter(data);
                } catch (Exception ex) {
                    Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
                  }
//                
//             System.out.println("Model 2 attributes ");
//                for(int i = 0 ; i<data.numAttributes(); i++)
//                    temp += data.attribute(i).name() + ",";
//                
//                System.out.println(temp);
                 if (data.classIndex() == -1)  
                    data.setClassIndex(data.numAttributes() - 1);
                 
//             System.out.println("in model 2 : " + data.classAttribute());
           return data;
    }
    
    public Instances gen_model3(Instances data)
    {   
//        System.out.println("inside model 3 ");
        String attr = "";
        String attribute ;
        String temp = "";
        for(int i =1;i<data.numAttributes()+1;i++)
        {
             attribute = data.attribute(i-1).name();
             if(attribute.matches("Filename") || attribute.startsWith("File") || attribute.equals("ICP"))
             {
                 if(!attr.equals(""))
                     attr += ",";
                 attr += i ;
//                 System.out.println(attribute);
             }
                 
        } 
//                System.out.println(attr);
                Remove r = new Remove();
                r.setAttributeIndices(attr);
                r.setInvertSelection(false);
                try {
                    r.setInputFormat(data);
                    data = Filter.useFilter(data, r);
                     data = useFilter(data);
                } catch (Exception ex) {
                    Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
//             System.out.println("Model 3 attributes ");
//                for(int i = 0 ; i<data.numAttributes(); i++)
//                    temp += data.attribute(i).name() + ",";
//                
//                System.out.println(temp);
                 if (data.classIndex() == -1)  
                    data.setClassIndex(data.numAttributes() - 1);
                 
                 
              return data;
    }
    
    public Instances gen_model4(Instances data)
    {   
//        System.out.println("inside model 4 ");
        String attr = "";
        String attribute ;
        String temp = "";
        for(int i =1;i<data.numAttributes()+1;i++)
        {
             attribute = data.attribute(i-1).name();
             if(attribute.matches("CP") || attribute.equals("ICP"))
             {
                 if(!attr.equals(""))
                     attr += ",";
                 attr += i ;
//                 System.out.println(attribute);
             }
                 
        } 
//                System.out.println(attr);
                Remove r = new Remove();
                r.setAttributeIndices(attr);
                r.setInvertSelection(true);
                try {
                    r.setInputFormat(data);
                    data = Filter.useFilter(data, r);
                     data = useFilter(data);
                } catch (Exception ex) {
                    Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
//             System.out.println("Model 4 attributes ");
//                for(int i = 0 ; i<data.numAttributes(); i++)
//                    temp += data.attribute(i).name() + ",";
//                
//                System.out.println(temp);
                 if (data.classIndex() == -1)  
                    data.setClassIndex(data.numAttributes() - 1);
                 
                 
           return data;
    }
     
   public Instances put_cp_to_last(Instances data)
   {
         try {
             String range = "first";
             int cp_index = 0 ;
             for(int i =2;i<=data.numAttributes();i++)
             {
                 if(data.attribute(i-1).name().equals("CP"))
                 {cp_index = i; 
//                   System.out.println(data.attribute(i).name());
//                    System.out.println(i);
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
         } catch (Exception ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return data;
             
   } 
   
   public Model1 get_report_model1(Instances data , int version )
    {
        Model1 report = new Model1();
        report.release_name = "Release " + version ;
        for(int i =0;i< data.numAttributes();i++)
        {
            String str = data.attribute(i).name();
            switch(str)
            {
                case "LOC" : report.loc = true; break;
                case "BOC" : report.boc = true; break;
                case "TACH" : report.tach = true; break;
                case "CHD" : report.chd = true;break;
                case "CHO" : report.cho = true; break;
                case "LCD" : report.lcd = true;break;
                case "LCH" : report.lch = true; break;
                case "FCH" : report.fch = true; break;
                case "FRCH" : report.frch = true; break;
                case "CSB" : report.csb = true; break;
                case "CSBS" : report.csbs = true; break;
                case "LCA" : report.lca = true; break;
                case "WCH" : report.wch = true; break;
                case "WCD" : report.wcd = true; break;
                case "ACDF" : report.acdf = true; break;
                case "ATAF" : report.ataf = true; break;
                case "WFR" : report.wfr = true; break;
                case "CP" : report.cp = true; break;
            }
        } 
         try {
             report.roc  = useClassifier1(data);
         } catch (Exception ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
        return report;
    } 
   
   public Model2 get_report_model2(Instances data , int version )
    {
        Model2 report = new Model2();
        report.release_name = "Release " + version ;
        for(int i =0;i< data.numAttributes();i++)
        {
            String str = data.attribute(i).name();
            switch(str)
            {
                case "WMC" : report.wmc = true; break;
                case "DIT" : report.dit = true; break;
                case "NOC" : report.noc = true; break;
                case "CBO" : report.cbo = true;break;
                case "RFC" : report.rfc = true; break;
                case "LCOM" : report.lcom = true;break;
                case "CP" : report.cp = true; break;
            }
        } 
         try {
             report.roc  = useClassifier1(data);
         } catch (Exception ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
        return report;
    } 
   
   public Model3 get_report_model3(Instances data , int version )
    {
        Model3 report = new Model3();
        report.release_name = "Release " + version ;
        for(int i =0;i< data.numAttributes();i++)
        {
            String str = data.attribute(i).name();
            switch(str)
            {
                case "LOC" : report.loc = true; break;
                case "BOC" : report.boc = true; break;
                case "TACH" : report.tach = true; break;
                case "CHD" : report.chd = true;break;
                case "CHO" : report.cho = true; break;
                case "LCD" : report.lcd = true;break;
                case "LCH" : report.lch = true; break;
                case "FCH" : report.fch = true; break;
                case "FRCH" : report.frch = true; break;
                case "CSB" : report.csb = true; break;
                case "CSBS" : report.csbs = true; break;
                case "LCA" : report.lca = true; break;
                case "WCH" : report.wch = true; break;
                case "WCD" : report.wcd = true; break;
                case "ACDF" : report.acdf = true; break;
                case "ATAF" : report.ataf = true; break;
                case "WFR" : report.wfr = true; break;
                case "CP" : report.cp = true; break;
                case "WMC" : report.wmc = true; break;
                case "DIT" : report.dit = true; break;
                case "NOC" : report.noc = true; break;
                case "CBO" : report.cbo = true;break;
                case "RFC" : report.rfc = true; break;
                case "LCOM" : report.lcom = true;break;
            }
        } 
         try {
             report.roc  = useClassifier1(data);
         } catch (Exception ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
        return report;
    } 
   
   public Model4 get_report_model4(Instances data , int version )
    {
        Model4 report = new Model4();
        report.release_name = "Release " + version ;
        for(int i =0;i< data.numAttributes();i++)
        {
            String str = data.attribute(i).name();
            switch(str)
            {
                case "ICP" : report.icp = true; break;
                case "CP" : report.cp = true; break;
            }
        } 
         try {
             report.roc  = useClassifier1(data);
         } catch (Exception ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
        return report;
    } 
   
   public void generate_attribute_file(ArrayList<Model1> m1 , ArrayList<Model2> m2 , ArrayList<Model3> m3 , ArrayList<Model4> m4)
   {
       String file_name = (new File(userPath).getName());
       File f = new File(userPath + "/"+ file_name + "_attribute.csv");
//       
       StringBuffer data = new StringBuffer();
       
       data.append("Model 1 Attributes ").append("\n");
       data.append("Release , LOC , BOC , TACH , CHD , CHO , FCH , LCH , FRCH , CSB , CSBS , LCA , LCD , WCH , WCD , ACDF , ATAF , WFR , CP\n");
       for(int i =0;i<m1.size() ; i++)
            {
                Model1 r = m1.get(i);
                data.append(r.release_name);
              
                if(r.loc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.boc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.tach)
                    data.append(",YES");
                else data.append(",");
                
                if(r.chd)
                    data.append(",YES");
                else data.append(",");
                
                if(r.cho)
                    data.append(",YES");
                else data.append(",");
                
                if(r.lcd)
                    data.append(",YES");
                else data.append(",");
                
                if(r.lch)
                    data.append(",YES");
                else data.append(",");
                
                if(r.fch)
                    data.append(",YES");
                else data.append(",");
                
                if(r.frch)
                    data.append(",YES");
                else data.append(",");
                
                if(r.csb)
                    data.append(",YES");
                else data.append(",");
                
                if(r.csbs)
                    data.append(",YES");
                else data.append(",");
                
                if(r.lca)
                    data.append(",YES");
                else data.append(",");
                
                if(r.wch)
                    data.append(",YES");
                else data.append(",");
                
                if(r.wcd)
                    data.append(",YES");
                else data.append(",");
                
                if(r.acdf)
                    data.append(",YES");
                else data.append(",");
                
                if(r.ataf)
                    data.append(",YES");
                else data.append(",");
                
                if(r.wfr)
                    data.append(",YES");
                else data.append(",");
                
                if(r.cp)
                    data.append(",YES");
                else data.append(",");
                
                data.append("\n");
            }
       data.append("\n\n\n");
       
       data.append("Model 2 Attributes ").append("\n");
       data.append("Release , WMC ,DIT , NOC , CBO , RFC , LCOM , CP\n");
       for(int i =0;i<m2.size() ; i++)
            {
                Model2 r = m2.get(i);
                data.append(r.release_name);
              
                if(r.wmc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.dit)
                    data.append(",YES");
                else data.append(",");
                
                if(r.noc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.cbo)
                    data.append(",YES");
                else data.append(",");
                
                if(r.rfc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.lcom)
                    data.append(",YES");
                else data.append(",");
                
                if(r.cp)
                    data.append(",YES");
                else data.append(",");
                
                data.append("\n");
            }
       data.append("\n\n\n");
       
         data.append("Model 3 Attributes ").append("\n");
       data.append("Release , LOC , BOC , TACH , CHD , CHO , FCH , LCH , FRCH , CSB , CSBS , LCA , LCD , WCH , WCD , ACDF , ATAF , WFR ,WMC ,DIT , NOC , CBO , RFC , LCOM, CP\n");
       for(int i =0;i<m3.size() ; i++)
            {
                Model3 r = m3.get(i);
                data.append(r.release_name);
              
                if(r.loc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.boc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.tach)
                    data.append(",YES");
                else data.append(",");
                
                if(r.chd)
                    data.append(",YES");
                else data.append(",");
                
                if(r.cho)
                    data.append(",YES");
                else data.append(",");
                
                if(r.lcd)
                    data.append(",YES");
                else data.append(",");
                
                if(r.lch)
                    data.append(",YES");
                else data.append(",");
                
                if(r.fch)
                    data.append(",YES");
                else data.append(",");
                
                if(r.frch)
                    data.append(",YES");
                else data.append(",");
                
                if(r.csb)
                    data.append(",YES");
                else data.append(",");
                
                if(r.csbs)
                    data.append(",YES");
                else data.append(",");
                
                if(r.lca)
                    data.append(",YES");
                else data.append(",");
                
                if(r.wch)
                    data.append(",YES");
                else data.append(",");
                
                if(r.wcd)
                    data.append(",YES");
                else data.append(",");
                
                if(r.acdf)
                    data.append(",YES");
                else data.append(",");
                
                if(r.ataf)
                    data.append(",YES");
                else data.append(",");
                
                if(r.wfr)
                    data.append(",YES");
                else data.append(",");
                
                if(r.wmc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.dit)
                    data.append(",YES");
                else data.append(",");
                
                if(r.noc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.cbo)
                    data.append(",YES");
                else data.append(",");
                
                if(r.rfc)
                    data.append(",YES");
                else data.append(",");
                
                if(r.lcom)
                    data.append(",YES");
                else data.append(",");
                
                if(r.cp)
                    data.append(",YES");
                else data.append(",");
                
                data.append("\n");
            }
       data.append("\n\n\n");
       
        data.append("Model 4 Attributes ").append("\n");
       data.append("Release ,ICP , CP\n");
       for(int i =0;i<m4.size() ; i++)
            {
                Model4 r = m4.get(i);
                data.append(r.release_name);
              
                if(r.icp)
                    data.append(",YES");
                else data.append(",");
                
                if(r.cp)
                    data.append(",YES");
                else data.append(",");
                
                data.append("\n");
            }
       data.append("\n\n\n");  
       FileOutputStream fos = null ;
         try {
             fos = new FileOutputStream(f);
             fos.write(data.toString().getBytes());
             fos.close();
         } catch (FileNotFoundException ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
       
                      
           System.out.println("Attribute Report Generated");
   } 
   
   public void generate_accuracy_file(ArrayList<Model1> m1 , ArrayList<Model2> m2 , ArrayList<Model3> m3 , ArrayList<Model4> m4)
   {
       String file_name = (new File(userPath).getName());
       File f = new File(userPath + "/"+ file_name + "_accuracy.csv");
       
       StringBuffer data = new StringBuffer();
       
       data.append("Model 1 Accuracy ").append("\n");
       data.append("Release").append(",").append("Accuracy\n");
        for(int i =0;i<m1.size() ; i++)
        {
            data.append(m1.get(i).release_name).append(",").append(m1.get(i).roc).append("\n");
        }
        data.append("\n\n\n");
        
         data.append("Model 2 Accuracy ").append("\n");
       data.append("Release").append(",").append("Accuracy\n");
        for(int i =0;i<m2.size() ; i++)
        {
            data.append(m2.get(i).release_name).append(",").append(m2.get(i).roc).append("\n");
        }
        data.append("\n\n\n");
        
         data.append("Model 3 Accuracy ").append("\n");
       data.append("Release").append(",").append("Accuracy\n");
        for(int i =0;i<m3.size() ; i++)
        {
            data.append(m3.get(i).release_name).append(",").append(m3.get(i).roc).append("\n");
        }
        data.append("\n\n\n");
        
         data.append("Model 4 Accuracy ").append("\n");
       data.append("Release").append(",").append("Accuracy\n");
        for(int i =0;i<m4.size() ; i++)
        {
            data.append(m4.get(i).release_name).append(",").append(m4.get(i).roc).append("\n");
        }
        data.append("\n\n\n");
        
        FileOutputStream fos = null ;
         try {
             fos = new FileOutputStream(f);
             fos.write(data.toString().getBytes());
             fos.close();
         } catch (FileNotFoundException ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
       
                      
           System.out.println("Accuracy Report Generated");
   }
   
   public void generate_pretty_accuracy_file(ArrayList<Model1> m1 , ArrayList<Model2> m2 , ArrayList<Model3> m3 , ArrayList<Model4> m4)
   {
       String file_name = (new File(userPath).getName());
       File f = new File(userPath + "/"+ file_name + "_accuracy.csv");
       
       StringBuffer data = new StringBuffer();
       
       data.append("Model 1 Accuracy ").append(",,,,").append("Model 2 Accuracy").append(",,,,").append("Model 3 Accuracy ").append(",,,,").append("Model 4 Accuracy").append("\n");
       
       data.append("Release,Accuracy").append(",,,").append("Release,Accuracy").append(",,,").append("Release,Accuracy").append(",,,").append("Release,Accuracy").append("\n");
       double avg1 = 0 , avg2 = 0 , avg3 = 0 , avg4 = 0;
        for(int i =0;i<m1.size() ; i++)
        {
            data.append(m1.get(i).release_name).append(",").append(m1.get(i).roc).append(",,,");
            data.append(m2.get(i).release_name).append(",").append(m2.get(i).roc).append(",,,");
            data.append(m3.get(i).release_name).append(",").append(m3.get(i).roc).append(",,,");
            data.append(m4.get(i).release_name).append(",").append(m4.get(i).roc).append("\n");
            
            avg1+= m1.get(i).roc;
            avg2+= m2.get(i).roc;
            avg3+= m3.get(i).roc;
            avg4+= m4.get(i).roc;
            
        }
        
        data.append("Average,").append(avg1/m1.size()).append(",,,").append("Average,").append(avg2/m2.size()).append(",,,").append("Average,").append(avg3/m3.size()).append(",,,").append("Average,").append(avg4/m4.size()).append("\n");
        data.append("\n\n\n");
        
        
        FileOutputStream fos = null ;
         try {
             fos = new FileOutputStream(f);
             fos.write(data.toString().getBytes());
             fos.close();
         } catch (FileNotFoundException ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
       
                      
           System.out.println("Accuracy Report Generated");
   }
   public void generate()
   {   
       System.out.println("looking for all versions ");
//       version = 10;
//       userPath = "C:\\Users\\aryan_000\\Desktop\\finalpro";
        ArrayList<Model1> m1 = new ArrayList<>(); 
         ArrayList<Model2> m2 = new ArrayList<>();
        ArrayList<Model3> m3 = new ArrayList<>();
        ArrayList<Model4> m4 = new ArrayList<>();
        String file_name = "";
        for(int i =1;i<version-1; i++)
        {
            if(i+1<10)
                file_name = userPath + "/final_version0" + (i+1) + ".csv";
            else 
                file_name = userPath + "/final_version" + (i+1) + ".csv";
            
            File f = new File(file_name);
//            System.out.println(f.getAbsoluteFile());
            
             String fname = f.getPath();
            ConverterUtils.DataSource source = null;
            try {
                source = new ConverterUtils.DataSource(fname);
                Instances data = source.getDataSet();
                data = put_cp_to_last(data);
                
                 m1.add(get_report_model1(gen_model1(data),i+1));
                 m2.add(get_report_model2(gen_model2(data),i+1));
                 m3.add(get_report_model3(gen_model3(data),i+1));
                 m4.add(get_report_model4(gen_model4(data),i+1));
//             
            } catch (Exception ex) {
                Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } // end of for loop
        
        generate_attribute_file(m1,m2,m3,m4);
        generate_pretty_accuracy_file(m1,m2,m3,m4);
//        System.out.println("Total versions are : " + m1.size());
//        System.out.println("Model 1 ");
//         
//        
//          System.out.println("Model 2 ");
//          for(int i =0;i<m2.size() ; i++)
//              System.out.println(m2.get(i).release_name + "  " + m2.get(i).roc);
//        
//          System.out.println("Model 3 ");
//          for(int i =0;i<m3.size() ; i++)
//              System.out.println(m3.get(i).release_name + "  " + m3.get(i).roc);
//        
//          System.out.println("Model 4 ");
//          for(int i =0;i<m4.size() ; i++)
//              System.out.println(m4.get(i).release_name + "  " + m4.get(i).roc);
//        
   }
    public void gen_test()
    {
        File f = new File("C:\\Users\\aryan_000\\Desktop\\finalpro\\final_version05.csv");
        String fname = f.getPath();
        ConverterUtils.DataSource source = null;
         try {
             source = new ConverterUtils.DataSource(fname);
             Instances data = source.getDataSet();
             
             generate();
         
         } catch (Exception ex) {
             Logger.getLogger(GenerateModel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
    }
    
    
    public static void main(String s[])
    {
//        System.out.println("hello");
        GenerateModel gm = new GenerateModel();
        gm.gen_test();
        gm.generate();
        
    }
}

