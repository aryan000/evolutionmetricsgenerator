/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import changeprone1.MainUI;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author aryan_000
 */


/**
 *
 * @author aryan_000
 */

class TachAndChd
{
       int tach ;
       double chd;
    TachAndChd(int tach , double chd)
    {
        this.tach = tach;
        this.chd = chd;
    }
    int getTach()
    {
        return tach;
    }
    double getChd()
    {
        return chd;
    }
}

public class Metric {
    public final static HashMap<String, Integer> fch = new HashMap<>();
    public final static HashMap<String, Integer> lch = new HashMap<>();
    public final static HashMap<String, Integer> frch = new HashMap<>();
    public final static HashMap<String, Integer> loc = new HashMap<>();
    public final static ArrayList<HashMap<String,TachAndChd>> lcaandlcd = new ArrayList<>();
    static int curr_version  = 0;
    public static int  pb_value = 0;
   
public void addCho(File f) throws IOException, BiffException, WriteException 
 { 

    Workbook workbook1 = Workbook.getWorkbook(f); // read mode
    System.out.println("Adding cho in files");
    WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
    int sheetno = workbook.getNumberOfSheets();

    for(int i =0;i<sheetno; i++)
    {
        WritableSheet sheet2 = workbook.getSheet(i);
        System.out.println(sheet2.getCell(0,0).getContents());
        HashMap<String,TachAndChd> tachandchd = new HashMap<>();
        int col_tach = -1;
        int loc_col = -1;
        int cho_col = sheet2.getColumns();
        int chd_col = cho_col+1;
        for(int j =0;j<sheet2.getColumns();j++)
        {
            String temp = sheet2.getCell(j,0).getContents();
//                    System.out.println( "check " + j  + temp);
            if(temp.equals("TACH"))
            {   col_tach = j;
                sheet2.addCell(new Label(cho_col , 0 , "CHO"));
                chd_col = cho_col + 1;
            }

            if(temp.equals("LOC"))
            {
                loc_col = j;
                sheet2.addCell(new Label(chd_col , 0 , "CHD"));
            }
        } 

        int tach_value , loc_value;
        double chd_value;
        if(col_tach!=-1)
        {
            for(int j=1;j<sheet2.getRows();j++)
            {   
                String  filename = sheet2.getCell(0,j).getContents();
                tach_value = Integer.parseInt(sheet2.getCell(col_tach, j).getContents());
                loc_value = Integer.parseInt(sheet2.getCell(loc_col, j).getContents());
                if(tach_value==0)
                {   
                    jxl.write.Number cho = new jxl.write.Number( cho_col, j , tach_value);
                    sheet2.addCell(cho);
                }

                else
                {
                    jxl.write.Number cho = new jxl.write.Number(cho_col , j , 1);
                    sheet2.addCell(cho);
                }

                chd_value = (double)tach_value/loc_value;

                jxl.write.Number chd = new jxl.write.Number(chd_col , j , chd_value);
                sheet2.addCell(chd);

                tachandchd.put(filename, new TachAndChd(tach_value,chd_value));
            } 

           lcaandlcd.add(tachandchd);
        }// end of all the rows in a single sheet
        System.out.println( "Cho  and Chd adding completed");

    } // end of all the sheet

    workbook.write();
    workbook.close();
    workbook1.close();

 }
    
 public void addFchAndLch(File f) throws IOException, BiffException, WriteException
{

    Workbook workbook1 = Workbook.getWorkbook(f); // read mode
    System.out.println("Adding Fch , Lch , Frch , CSD , Csbc , Lca , Lcd ");
    WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
    int sheetno = workbook.getNumberOfSheets();

    for(int i =0;i<sheetno; i++)
    {
        WritableSheet sheet2 = workbook.getSheet(i);
        String filename ;
        curr_version = i+1;
        int cho_value , cho_col =-1, fch_val;
        int lch_val , frch_val ;

        int fch_col = sheet2.getColumns();
        int lch_col = fch_col+1;
        int frch_col = fch_col+2;
        int csd_col = fch_col+3;
        int csbc_col = fch_col+4;
        int lca_col = fch_col+5;
        int lcd_col = fch_col + 6;
        int wch_col = fch_col + 7;
        int csd_value ;
        double csbc_value;
        int loc_col = -1;
        int boc_col = 1;
        int tach_col = 1, chd_col = 1;

        for(int j =0;j<sheet2.getColumns();j++)
        {
            String temp = sheet2.getCell(j,0).getContents();
            if(temp.equals("CHO"))
            { cho_col = j;
              sheet2.addCell(new Label(fch_col , 0 , "FCH"));
              sheet2.addCell(new Label(lch_col , 0 , "LCH"));
              sheet2.addCell(new Label(frch_col , 0 , "FRCH"));
              sheet2.addCell(new Label(csd_col , 0 , "CSB"));
              sheet2.addCell(new Label(csbc_col , 0 , "CSBS"));
              sheet2.addCell(new Label(lca_col , 0 , "LCA"));
              sheet2.addCell(new Label(lcd_col , 0 , "LCD"));
            }
            if(temp.equals("LOC"))
            {
                loc_col = j;
            } 

            if(temp.equals("TACH"))
            {
                tach_col = j;
            }

            if(temp.equals("CHD"))
            {
                chd_col = j;
            }
            if(temp.equals("BOC"))
            {
                boc_col = j;
            }

        } 

        if(cho_col!=-1)
        {
            for(int j =1;j<sheet2.getRows();j++)
           {
               filename = sheet2.getCell(0,j).getContents();
               
               if (fch.containsKey(filename))
               {
                   fch_val = fch.get(filename);
                   lch_val = lch.get(filename);
                   frch_val = frch.get(filename); 

       // adding fch
                   if(fch_val!=0)
                   {
                       jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , fch_val);
                       sheet2.addCell(fch_metric_value);
                   }
                   else
                   {
                       cho_value = Integer.parseInt(sheet2.getCell(cho_col, j).getContents());
                       if(cho_value==0)
                       {
                          jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , fch_val);
                          sheet2.addCell(fch_metric_value); 
                       }
                       else
                       {
                          jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , curr_version);
                          sheet2.addCell(fch_metric_value); 

                          fch.put(filename, curr_version);
                       }
                   } 


        // adding lch
                  cho_value = Integer.parseInt(sheet2.getCell(cho_col, j).getContents());
                  if(cho_value==0)
                  {
                     jxl.write.Number lch_metric_value = new jxl.write.Number( lch_col, j , lch_val);
                     sheet2.addCell(lch_metric_value);  
                  } 

                  else
                  {
                     jxl.write.Number lch_metric_value = new jxl.write.Number( lch_col, j , curr_version);
                     sheet2.addCell(lch_metric_value);   
                     lch.put(filename, curr_version);
                     frch_val ++;
                     frch.put(filename,frch_val);
                  }

         // adding frch
                  jxl.write.Number frch_metric_value = new jxl.write.Number( frch_col, j , frch_val);
                  sheet2.addCell(frch_metric_value);  
               }
               else {
                   // Java File  not present
                   // birth of a class is here hence not found in map
/*adding fch*/     fch.put(filename,0);
/*adding lch*/     lch.put(filename, 0);
                   lch_val  = 0;
 /*adding frch*/   frch.put(filename,0);
                   jxl.write.Number fch_metric_value = new jxl.write.Number( fch_col, j , 0);
                   sheet2.addCell(fch_metric_value);
                   jxl.write.Number lch_metric_value = new jxl.write.Number( lch_col, j , 0);
                   sheet2.addCell(lch_metric_value);
                   jxl.write.Number frch_metric_value = new jxl.write.Number( frch_col, j , 0);
                   sheet2.addCell(frch_metric_value);
               }

               
// Adding  CSB and CSBS 
               int loc_value = Integer.parseInt(sheet2.getCell(loc_col, j).getContents());
               if(loc.containsKey(filename))
               {
                   csd_value = abs(loc_value - loc.get(filename));
                   csbc_value = (double)csd_value/loc.get(filename);
               }
               else
               {
                   csd_value = 0;
                   csbc_value = 0;
                   loc.put(filename,loc_value);
               }

                jxl.write.Number csd_metric_value = new jxl.write.Number(csd_col, j, csd_value);
                sheet2.addCell(csd_metric_value);

                 jxl.write.Number csbc_metric_value = new jxl.write.Number(csbc_col, j, csbc_value);
                 sheet2.addCell(csbc_metric_value);


 // adding lca and lcd
                   try{
                        int tach_value  =  Integer.parseInt(sheet2.getCell(tach_col, j).getContents());
                        double chd_value =  Double.parseDouble(sheet2.getCell( chd_col, j).getContents());

                        int lca_value ;
                        double lcd_value;
                        if(lch_val==curr_version || lch_val==0)
                        {   
//                            System.out.println("for filename : " + filename + " lch is equal to tach ");
                            lca_value = tach_value;
                            lcd_value =  chd_value;
                        }
                        else
                        {    
//                            System.out.println("for filename : " + filename + " lch is not equal to tach ");
                            HashMap<String,TachAndChd> lca = lcaandlcd.get(lch_val - 1);

                            lca_value = lca.get(filename).getTach();
                            lcd_value =  lca.get(filename).getChd();
                        }


             //System.out.println( " lca value is : " + lca_value + " and " + "lcd value is :  " + lcd_value);
                        jxl.write.Number lca_metric_value = new jxl.write.Number(lca_col, j, lca_value);
                        sheet2.addCell(lca_metric_value);
                        jxl.write.Number lcd_metric_value = new jxl.write.Number(lcd_col, j, lcd_value);
                        sheet2.addCell(lcd_metric_value);
                     }
                   catch(NumberFormatException e)
                   {
                       System.err.println(e);
                   }                            
           } // end of j which is row
        }
        curr_version ++;
    }


    workbook.write();
    workbook.close();
    workbook1.close();
    System.out.println("fch lch  frch csd csbs lca lcd added ");

} 
 
public void addWchAndWCD(File f) throws IOException, BiffException, WriteException 
{    
    Workbook workbook1 = Workbook.getWorkbook(f); // read mode
    System.out.println("Adding WCH and WCD");
    WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
    int sheetno = workbook.getNumberOfSheets();

    String filename;
    for(int i =0;i<sheetno; i++)
    {
        WritableSheet sheet2 = workbook.getSheet(i);
        int wch_col , boc_col = 2 , wcd_col ;
        
        curr_version = i+1;
        for(int j =0;j<sheet2.getColumns();j++)
            { 
                String temp = sheet2.getCell(j,0).getContents();
                if(temp.equals("BOC"))
                    boc_col = j;
            } 

        wch_col = sheet2.getColumns();
        wcd_col = wch_col + 1;
        sheet2.addCell(new Label(wch_col , 0 , "WCH"));
        sheet2.addCell(new Label(wcd_col , 0 , "WCD"));
        for(int j =1;j<sheet2.getRows();j++)
        { 
            filename = sheet2.getCell(0,j).getContents();
            int boc_value = Integer.parseInt(sheet2.getCell(boc_col, j).getContents());
//                    System.out.println("boc value is : "+ boc_value);
            double temp;
            double wch_value = 0 , wcd_value = 0;
//                System.out.println(filename + boc_value+1 + curr_version );
            for(int r = boc_value + 1 ; r<= curr_version  ; r++)
            {
                HashMap<String,TachAndChd> lca =  lcaandlcd.get(r-1);
                int tach_val = lca.get(filename).getTach();
                double chd_val = lca.get(filename).getChd();
                temp =   (double) Math.pow(2,r- curr_version);

                wch_value += tach_val*temp;
                wcd_value += chd_val*temp;
//        System.out.println(filename + tach_val + "and " + chd_val + " and " + wch_value + " and " + wcd_value);
            }
            jxl.write.Number wch_metric_value = new jxl.write.Number(wch_col , j ,wch_value);
             sheet2.addCell(wch_metric_value);
             jxl.write.Number wcd_metric_value = new jxl.write.Number(wcd_col , j ,wcd_value);
             sheet2.addCell(wcd_metric_value);
        }

        curr_version++;
    }

   workbook.write();
   workbook.close();
   workbook1.close();
   System.out.println("wch and wcd added ");
   }
   
public void addAcdfAndATAF(File f) throws IOException, BiffException, WriteException  
   {
            Workbook workbook1 = Workbook.getWorkbook(f); // read mode
            System.out.println("Adding ACDF ATAF and WFR");
            WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
        try {
            
            int sheetno = workbook.getNumberOfSheets();
            String filename;
             
            for(int i =0;i<sheetno; i++)
            {
                WritableSheet sheet2 = workbook.getSheet(i);
                curr_version = i+1;
                int acdf_col = -1 ,ataf_col = -1 , frch_col = -1 ;
                int boc_col = 1 , frch_value=0 ,wfr_col = -1 , wfr_value=0;
                double acdf_value = 0 , ataf_value = 0;
                int icp_col = -1 ;
                
                
                for(int j =0;j<sheet2.getColumns();j++)
                {
                    String temp = sheet2.getCell(j,0).getContents();
                    if(temp.equals("BOC"))
                        boc_col = j;
                    if(temp.equals("FRCH"))
                        frch_col = j;
                }
                
                acdf_col = sheet2.getColumns();
                ataf_col = acdf_col + 1;
                wfr_col = acdf_col+2;
                icp_col = acdf_col+3;
//                System.out.println("Current version is : " + curr_version);
                sheet2.addCell(new Label(acdf_col , 0 , "ACDF"));
                sheet2.addCell(new Label(ataf_col , 0 , "ATAF"));
                sheet2.addCell(new Label(wfr_col , 0 , "WFR"));
                sheet2.addCell(new Label(icp_col , 0 , "ICP"));
                for(int j =1;j<sheet2.getRows();j++)
                {
                    filename = sheet2.getCell(0,j).getContents();
                    int boc_value = Integer.parseInt(sheet2.getCell(boc_col, j).getContents());
//                    System.out.println("boc value is : "+ boc_value);
                    frch_value = Integer.parseInt(sheet2.getCell(frch_col, j).getContents());
                    double icp_val= 0;
                    if(frch_value ==0)
                    {
                        jxl.write.Number acdf_metric_value = new jxl.write.Number(acdf_col , j ,0);
                        sheet2.addCell(acdf_metric_value);
                        jxl.write.Number ataf_metric_value = new jxl.write.Number(ataf_col , j ,0);
                        sheet2.addCell(ataf_metric_value);
                        
                        wfr_value = 0;
                        for(int r = boc_value + 1 ; r<= curr_version  ; r++)
                        {
                            HashMap<String,TachAndChd> lca =  lcaandlcd.get(r-1);
                            int wfr_tach_value = lca.get(filename).getTach();
                            
                            if(wfr_tach_value==0)
                                continue;
                            else
                                wfr_value += r-1;
                        }
                        jxl.write.Number wfr_metric_value = new jxl.write.Number(wfr_col, j, wfr_value);
                        sheet2.addCell(wfr_metric_value);
                        jxl.write.Number icp_metric_value = new jxl.write.Number(icp_col, j,icp_val);
                        sheet2.addCell(icp_metric_value);
                    }
                    else
                    {
                        double chd_value = 0;
                        int tach_value = 0;
                        int wfr_tach_value = 0;
                        wfr_value = 0;
                        for(int r = boc_value + 1 ; r<= curr_version  ; r++)
                        {
                            HashMap<String,TachAndChd> lca = lcaandlcd.get(r-1);
                            wfr_tach_value = lca.get(filename).getTach();
                            tach_value += wfr_tach_value;
                            chd_value += lca.get(filename).getChd();
                            
                            if(wfr_tach_value==0)
                                continue;
                            else
                                wfr_value += r-1;
                        }
                        acdf_value = (double)chd_value/frch_value;
                        ataf_value = (double)tach_value/frch_value;
                        
                        jxl.write.Number acdf_metric_value = new jxl.write.Number(acdf_col, j, acdf_value);
                        sheet2.addCell(acdf_metric_value);
                        jxl.write.Number ataf_metric_value = new jxl.write.Number(ataf_col, j, ataf_value);
                        sheet2.addCell(ataf_metric_value);
                        jxl.write.Number wfr_metric_value = new jxl.write.Number(wfr_col, j, wfr_value);
                        sheet2.addCell(wfr_metric_value);
                        
                        
                        icp_val = (double)frch_value / (curr_version - boc_value);
                        
//                        System.out.println(filename + " has " + frch_value + " and " + curr_version +  " and " + boc_value );
                        jxl.write.Number icp_metric_value = new jxl.write.Number(icp_col, j,icp_val);
                        sheet2.addCell(icp_metric_value);
                        
                    }
                    
                }
                curr_version++;
            }
            workbook.write();
            workbook.close();
            workbook1.close();
            System.out.println("ACDF and ATAF and WFR and ICP added ");
        } catch (IOException | WriteException ex) {
            Logger.getLogger(Metric.class.getName()).log(Level.SEVERE, null, ex);
            workbook.close();
            workbook1.close();
        }
   }


ArrayList<HashMap<String,Integer>> metricCP = new ArrayList<>();
private void populateCho(File f) throws IOException, BiffException
{
     Workbook workbook = Workbook.getWorkbook(f); 
     int sheetno = workbook.getNumberOfSheets();
     Sheet sheet = workbook.getSheet(0);
     
     int cho_col = 0;
     for (int j = 0; j < sheet.getColumns(); j++) {
            String temp = sheet.getCell(j, 0).getContents();
            
            if (temp.equals("CHO")) {
                cho_col = j;
            }
        } 
     
     int cho_val ;
     String filename;
     for(int i =0;i<sheetno ;i++)
     {  
         HashMap<String,Integer> h = new HashMap<>();
          sheet = workbook.getSheet(i);
          for (int j = 1; j < sheet.getRows(); j++) {
            filename = sheet.getCell(0, j).getContents();
            cho_val = Integer.parseInt(sheet.getCell(cho_col, j).getContents());
            h.put(filename, cho_val);
            }
          metricCP.add(h);
        
//         System.out.println("i si : " + i );
     }
     
     workbook.close();
     
     
     System.out.println("populated");
}
public void addCP(File f) throws IOException, BiffException, WriteException
{   
    System.out.println("populating ");
    populateCho(f);
    Workbook workbook1 = Workbook.getWorkbook(f); // read mode
    System.out.println("Adding CP");
    WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1); // write mode
    int sheetno = workbook.getNumberOfSheets();
    String filename;
    for (int i = 0; i < sheetno - 1; i++) {
        
       WritableSheet sheet2 = workbook.getSheet(i);
      
        int cp_col = sheet2.getColumns();
        int cp_val = 0 ;
        sheet2.addCell(new Label(cp_col, 0, "CP"));
        for (int j = 1; j < sheet2.getRows(); j++) {
            filename = sheet2.getCell(0, j).getContents();
           
            int cho_val = metricCP.get(i+1).get(filename);
            if(cho_val==0)
                cp_val = 0;
            else cp_val = 1;
            jxl.write.Number cp_metric_value = new jxl.write.Number(cp_col, j,cp_val);
             sheet2.addCell(cp_metric_value);
           
            }
        
       
    }
    workbook.write();
    workbook.close();
    workbook1.close();
    System.out.println("CP added ");
}
public void create(File myfolder)
    {
        if(myfolder!=null)
        {   
            
            try {
                addCho(myfolder);
                addFchAndLch(myfolder);
                addWchAndWCD(myfolder);
                addAcdfAndATAF(myfolder);
                System.out.println("here compligin");
//                addCP(myfolder);
                JOptionPane.showMessageDialog(null," Completed ...\nData is Populated in the excel file ");
               } 
            catch (IOException | BiffException | WriteException ex) {
                Logger.getLogger(Metric.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } 
        else  System.out.println("Selected folder is : " + myfolder);
    } 



   public static void main(String s[])
   {
       MainUI m = new MainUI();
       m.setVisible(true);
   }
}



 