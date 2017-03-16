/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cNk;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aryan_000
 */


public class UnderstandHelper
{   
    File project;
   public UnderstandHelper(File project)
    {
        this.project = project;
    }
    
    public void execute()
    {
        String path = System.getProperty("user.home") + "/Desktop/";
        String folder_name = project.getName();
//        String command = "und create -languages java " + path +  folder_name + ".udb ";
        String command = "und -db " + path + folder_name+".udb " + "create -languages java ";
                
                
        command += "add " + project.getPath();
        command += " settings -metrics CountDeclMethod MaxInheritanceTree CountClassDerived CountClassCoupled CountDeclMethodAll PercentLackOfCohesion";
        command += " -metricsOutputFile " + path + folder_name + ".csv";
        command += " analyze metrics quit";
        
        
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
                       System.out.println(line);
//                       System.err.println(line);
                   }
        } catch (IOException ex) {
            Logger.getLogger(UnderstandHelper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
}