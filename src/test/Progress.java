/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import test.ProgressBar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author aryan_000
 */
public class Progress {
 
    public static void main(String s[]) throws InterruptedException
    {
        ProgressBar obj_frame = new ProgressBar();
        obj_frame.setVisible(true);
        
        Scanner sc = new Scanner(System.in);
//        String str= sc.next();
        
        for(int i =0;i<1000;i++)
        {   
            System.out.println(i);
            if(i%10==0)
            {
                obj_frame.call(i);
            }
            else
                TimeUnit.SECONDS.sleep(1);
        }
        
    }
}
