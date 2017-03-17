/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aryan_000
 */
public class ThreadTest  extends Thread {
    
    public void run() {
         System.out.println(" thread : " + this.getName() + " " + this.isAlive());
         
         
         
         if(this.getName().equals("Thread-1"))
             try {
                 System.out.println("sleeping");
                 Thread.sleep(2000);
         } catch (InterruptedException ex) {
             Logger.getLogger(ThreadTest.class.getName()).log(Level.SEVERE, null, ex);
         }
         for(int i = 0 ; i<5;i++)
             System.out.println( i + this.getName());
    } 
    public static void main(String s[])
    {
//        Thread a = new ThreadTest();
//        Thread b = new ThreadTest();
//        
//        a.start();
//        b.start();
        
        String s = "AndroidApacheClient.java";
        System.out.println(s);
        s = s.replaceAll("^\"|\"$", "");
        
    }
}
