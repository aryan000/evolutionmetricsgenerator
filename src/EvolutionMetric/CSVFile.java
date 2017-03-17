/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionMetric;

import cNk.*;
import java.util.ArrayList;

/**
 *
 * @author aryan_000
 */
public class CSVFile {
    public String kind ="";
    public String name ="";
    static ArrayList<String> metric_names = new ArrayList<>();
    ArrayList<Integer> metric = new ArrayList<>();
    
   static int count = 0;
  public CSVFile(String st)
  {   
      if(this.count==0)
      load(st);
      else
      {
        int i =0;
        for (String retval: st.split(",")) 
        {

            if(i==0)
            {
                kind = retval;
                i++;
            }
            else if(i==1)
            {
                name = retval.toString();
                i++;
            }
           else if(retval.isEmpty())
           {
               metric.add(0);
           }
            else
           {  
               metric.add(Integer.parseInt(retval));
  //             arr[i-2] = Integer.parseInt(retval?);
  //             i++;
           }

        } 
      }
  } 
  
  public CSVFile()
  {
      
  }
  
  private void load(String st )
  {
      if(this.count==0)
          this.count++;
      
      int i =0;
      for (String retval: st.split(",")) 
      {
            
          if(i==0 || i==1)
          {
              i++;
          }
          else
         {  
             metric_names.add(retval);
         }
                      
      }
  }
}
