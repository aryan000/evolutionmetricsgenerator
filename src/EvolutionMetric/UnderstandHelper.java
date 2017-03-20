/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionMetric;

import cNk.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aryan_000
 */


public class UnderstandHelper
{   
    File project;
    String userPath;
    String file_name ;
   public UnderstandHelper(File project , String userPath , String file_name)
    {
        this.project = project;
        this.userPath = userPath;
        this.file_name = file_name;
    }
    
    public void execute()
    {
//        String path = System.getProperty("user.home") + "/Desktop/";
        String folder_name = project.getName();
//        String command = "und create -languages java " + path +  folder_name + ".udb ";
        String command = "und -db " + userPath +"/" + file_name+".udb " + "create -languages java ";
                
                
        command += "add " + project.getPath();
        command += " settings -metrics CountDeclMethod MaxInheritanceTree CountClassDerived CountClassCoupled CountDeclMethodAll PercentLackOfCohesion";
        command += " -metricsOutputFile " + userPath +"/" +  file_name + ".csv";
        command += " analyze metrics ";
        
        
        System.out.println(command);
        
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",command);
        builder.redirectErrorStream(true);
        try {
                   Process p = builder.start();
//                   System.out.println(p);
                   BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                   String line;
                   while (true) {
                       line = r.readLine();
                       if(line==null)
                           break;
//                       System.out.println(line);
//                       System.err.println(line);
                   } 
                   System.out.println("C and K Analysis Complete for " + file_name);
        } catch (IOException ex) {
            Logger.getLogger(UnderstandHelper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    
     public void execute(ProgressBar1 pb)
    {
//        String path = System.getProperty("user.home") + "/Desktop/";
        String folder_name = project.getName();
//        String command = "und create -languages java " + path +  folder_name + ".udb ";
        String command = "und -db " + userPath +"/" + file_name+".udb " + "create -languages java ";
                
                
        command += "add " + project.getPath();
        command += " settings -metrics CountDeclMethod MaxInheritanceTree CountClassDerived CountClassCoupled CountDeclMethodAll PercentLackOfCohesion";
        command += " -metricsOutputFile " + userPath +"/" +  file_name + ".csv";
        command += " analyze metrics ";
        
        pb.set_output("Processing C and K for : " + file_name + "....");
//        System.out.println(command);
        
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",command);
        builder.redirectErrorStream(true);
        try {
                   Process p = builder.start();
//                   System.out.println(p);
                   BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                   String line ;
                   
                   
                   while (true) {
                       
                       line = r.readLine();
//                       Scanner sc = new Scanner(r);
                       if(line==null)
                           break;
//                       System.out.println(line);
//                       pb.set(line);
//                       pb.set(line);
//                       System.err.println(line);
                   } 
                   pb.set_output("C and K for " + file_name + "generated.");
        } catch (IOException ex) {
            Logger.getLogger(UnderstandHelper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    public static void main(String s[])
    {
        UnderstandHelper h = new UnderstandHelper(new File("C:\\Users\\aryan_000\\Desktop\\software\\retrofit\\retrofit-parent-1.2.2"),"C:\\Users\\aryan_000\\Desktop\\","version00");
        ProgressBarTest pb = new ProgressBarTest();
        pb.setVisible(true);
//        h.execute(pb); 
        
    }
}