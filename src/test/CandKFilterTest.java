/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import EvolutionMetric.CandKFilter1;
import java.io.File;

/**
 *
 * @author aryan_000
 */
public class CandKFilterTest {
    
    public static void main(String s[])
    {  
        
        
       
        
        
        CandKFilter1 c = new CandKFilter1();
        
//        File cnk = new File("C:\\Users\\aryan_000\\Desktop\\pro\\cnk_version03.csv");
//        File project_file = new File("C:\\Users\\aryan_000\\Desktop\\pro\\version03.csv");
//        
        
         File cnk = new File("C:\\Users\\aryan_000\\Desktop\\u\\cnk_version01.csv");
        File project_file = new File("C:\\Users\\aryan_000\\Desktop\\u\\version01.csv");
        
        System.out.println(cnk);
        System.out.println(project_file);
        c.merge_candk( project_file,cnk);
    }
}
