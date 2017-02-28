/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.attributeSelection.BestFirst;
import weka.attributeSelection.CfsSubsetEval;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;

/**
 *
 * @author aryan_000
 */
public class AttrSelection {
    
    /**
     * uses the meta-classifier
     * @param data
     * @throws java.lang.Exception
     */
    protected static void useClassifier(Instances data) throws Exception {
        System.out.println("\n1. Meta-classfier");
        AttributeSelectedClassifier classifier = new AttributeSelectedClassifier();
        CfsSubsetEval eval = new CfsSubsetEval();
        BestFirst search = new BestFirst();
//        GreedyStepwise search = new GreedyStepwise();
//        search.setSearchBackwards(true);
        J48 base = new J48();
        classifier.setClassifier(base);
        classifier.setEvaluator(eval);
        classifier.setSearch(search);
        Evaluation evaluation = new Evaluation(data);
        evaluation.crossValidateModel(classifier, data, 10, new Random(1));
        System.out.println(evaluation.toSummaryString());
    } 
    
    protected static void useClassifier1(Instances data) throws Exception
    {
        System.out.println("\n 2 Meta Classifier");
        
        AttributeSelectedClassifier classifier = new AttributeSelectedClassifier();
        Logistic base = new Logistic();
        CfsSubsetEval eval = new CfsSubsetEval();
        BestFirst search = new BestFirst();
        classifier.setClassifier(base);
        classifier.setEvaluator(eval);
        classifier.setSearch(search);
        Evaluation evaluation = new Evaluation(data);
        evaluation.crossValidateModel(classifier, data, 10, new Random(1));
        System.out.println("these values are : " + evaluation.pctCorrect());
        System.out.println("results are :  " + evaluation.toClassDetailsString());
        System.out.println("classifier results : " + evaluation.toSummaryString());
        
    }

    /**
     * uses the filter
     * @param data
     * @throws java.lang.Exception
     */
    protected static void useFilter(Instances data) throws Exception {
        System.out.println("\n2. Filter");
        weka.filters.supervised.attribute.AttributeSelection filter = new weka.filters.supervised.attribute.AttributeSelection();
        CfsSubsetEval eval = new CfsSubsetEval();
        BestFirst search = new BestFirst();
//        GreedyStepwise search = new GreedyStepwise();
//        search.setSearchBackwards(true);
        filter.setEvaluator(eval);
        filter.setSearch(search);
        filter.setInputFormat(data);
        Instances newData = Filter.useFilter(data, filter);
        
        // newData is the main result
        
        System.out.println("new data is ; " + newData);
        Instance a = newData.instance(0);
        System.out.println("ath instance is ; " + a.attribute(0));
//        System.out.println("Number of attribute is : " + newData.);
        System.out.println("first attribute is : " + newData.attribute(0).name());
        System.out.println("end");
    }
    public static void main(String s[]) throws Exception
    {
        // Loading the data set
        
        DataSource source = null;
        try {
//            source = new DataSource("/some/where/data.arff");
            File f = new File("\"C:\\\\Users\\\\aryan_000\\\\Desktop\\\\Output\\\\version3.csv\"");
            
            source = new DataSource("C:\\Users\\aryan_000\\Desktop\\Output\\version8.csv");
            Instances data = source.getDataSet();
            
            System.out.println("data's first value is : " + data.attribute(0));
            data.remove(0);
            
            System.out.println(data);
             if (data.classIndex() == -1)
                data.setClassIndex(data.numAttributes() - 1);
             
             
            // 1. filter
//            useFilter(data);
            
            // 2. meta-classifier
            useClassifier1(data);

             
//            AttributeSelection filter = new AttriButeSelection();
        } catch (Exception ex) {
            Logger.getLogger(AttributeSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
