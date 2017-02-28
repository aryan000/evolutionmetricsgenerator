/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionMetric;

import java.io.File;

/**
 *
 * @author aryan_000
 */
public class Files
{
    String Filename = new String();
    long Filesize ;
    String FileLocation = new String();
    File file ;
    String parent;

   public Files()
   {
       Filename = null;
       Filesize = 0;
       FileLocation = null; 
       
   }
   public Files(String fname , long fsize, File file , String floc)
   {
       Filename = fname;
       Filesize = fsize;
       this.file = file;
       this.parent = file.getParentFile().getName() ;
       FileLocation = floc;
   }
}
