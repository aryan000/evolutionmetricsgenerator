/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;

/**
 *
 * @author aryan_000
 */
public class WekaUse {
    
    public static void main(String s[])
    {
        BufferedReader breader = null;
        try {
            breader  = new BufferedReader(new FileReader("C:\\Users\\aryan_000\\Desktop\\Output\\version2.csv"));
            Instances train = new Instances(breader);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WekaUse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WekaUse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
