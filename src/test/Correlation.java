/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import org.apache.commons.math3.stat.correlation.*;
/**
 *
 * @author aryan_000
 */
public class Correlation {
    
    
    public static void main(String s[])
    {
        double x[] = {1,2,3,7,5};
        double y[] = {1,2,9,4,5};
        
        double sc;
        sc = new SpearmansCorrelation().correlation(x,y);
        
        double r = sc;
        double p_value = r*Math.sqrt((x.length-2)/(1-r*r));
        
        System.out.println(sc);
        System.out.println(p_value);
    }
}
