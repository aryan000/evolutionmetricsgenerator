/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cNk;

import java.util.ArrayList;

/**
 *
 * @author aryan_000
 */
public class CSVFile {
    public String kind = "";
    public String name = "";
    static ArrayList<String> metric_names = new ArrayList<>();
    ArrayList<Integer> metric = new ArrayList<>();
    
  public CSVFile(String st)
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
              name = retval;
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
  
  public CSVFile()
  {
      
  }
}
