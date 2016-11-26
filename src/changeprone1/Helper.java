/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone1;

import java.io.BufferedReader;
import jxl.write.Label;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jxl.write.Number;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author aryan_000
 */
public class Helper {
    
    

public File Upload_Button()
{
    String userDir = System.getProperty("user.home");
    JFileChooser folder = new JFileChooser(userDir+"/Desktop");
    folder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    int return_value = folder.showDialog(null,"Select Folder ");
    File myfolder = null;
    if(return_value == JFileChooser.APPROVE_OPTION)
    {
        myfolder = folder.getSelectedFile();
    }

    if(myfolder!=null)
    {
        JOptionPane.showMessageDialog(null,"The current choosen file directory is : " + myfolder);
    } 
    else
    {
        JOptionPane.showMessageDialog(null,"You have made no selection : ");
    }

    return myfolder;
}

public File[] Upload_All()
{
    String userDir = System.getProperty("user.home");
    JFileChooser folder = new JFileChooser(userDir+"/Desktop");
    folder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    folder.setMultiSelectionEnabled(true);
    int return_value = folder.showDialog(null,"Select Folder ");
    File[] myfolder = null;
    if(return_value == JFileChooser.APPROVE_OPTION)
    {
        myfolder = folder.getSelectedFiles();
    }

    if(myfolder!=null)
    {
        JOptionPane.showMessageDialog(null,"The current choosen file directory is : " + myfolder);
    } 
    else
    {
        JOptionPane.showMessageDialog(null,"You have made no selection : ");
    }

    return myfolder;
} 


ArrayList<Files> filenames = new ArrayList<>();

 public void  sortByName()
{
     Collections.sort(filenames, (Files o1, Files o2) -> o1.Filename.compareTo(o2.Filename));
} 
 
public ArrayList<Files> Get_List_Of_Files ( File folder)
{ 
    filenames.clear();
    if(folder ==null)
        return filenames;
    List_Of_Files( folder);
    sortByName();
    return filenames;
}
    
private void  List_Of_Files( File folder )
{
    for(File testfile : folder.listFiles())
    {
        if(testfile.isDirectory())
        { List_Of_Files(testfile  ); }
        else
        {
            String ext =""  ;
            String temp = testfile.getPath();
            int i = temp.lastIndexOf('.');
            if(i>0)
                ext = temp.substring(i+1);
            if(ext.equals("java"))
            {filenames.add(new Files(testfile.getName(),testfile.length(),testfile , testfile.getPath()));}
        }
    }
}


public  int getLines(File f) throws IOException 
{
    FileReader fr;
    fr = new FileReader(f);
    BufferedReader br;
    br = new BufferedReader(fr);
    int i = 0;
    boolean isEOF = false;
    do {
        String t = br.readLine();
        if (t != null) {
            isEOF = true;
            t = t.replaceAll("\\n|\\t|\\s", "");
            if ((!t.equals("")) && (!t.startsWith("//"))) {
                i = i + 1;
            }
        } else {
            isEOF = false;
        }
    } while (isEOF);
    br.close();
    fr.close();
    return i;
 }
  
public void createSheet( WritableWorkbook workbook , File f  ) throws IOException, WriteException, BiffException
{       
  System.out.println("Creating the Output File ");
  workbook = Workbook.createWorkbook(f);
  String version = "version " +  1 ;
  WritableSheet sheet = workbook.createSheet(version, 0);
  int count = 1;
  int row =  0 ;
  int column = 0;
  sheet.addCell(new Label ( column++ ,row, "Filename " + version ));
  sheet.addCell(new Label(column++ , row , "LOC"));
  sheet.addCell(new Label(column++ , row , "BOC"));
  sheet.addCell(new Label(column++ , row , "TACH"));
  row++;
  column = 0;
  Boc.curr_version  = 1;
  for (Files filename : filenames) 
   {
    Label fname = new Label ( column++ ,row, filename.Filename);
    File location =  filename.file;
    Number loc = new Number(column++ , row , getLines(location)) {};
    sheet.addCell(fname);
    sheet.addCell(loc);
    int boc_value = Boc.curr_version;
    Boc.bocMap.put(filename.Filename, boc_value);
    Tach.tachMap.put(filename.Filename, location);
    Number boc = new Number(column++ , row , boc_value);
    Number tach = new Number(column++ , row , 0);
    sheet.addCell(boc);
    sheet.addCell(tach);
    row++;
    column = 0;

    }
  workbook.write();
  workbook.close();
  System.out.println("File created and added BOC , LOC and Tach");
}

public void addsheet(Workbook workbook1, File f) throws IOException, WriteException, BiffException 
{
 System.out.println("Adding sheet to the File when File is found ");
 WritableWorkbook workbook = Workbook.createWorkbook(f, workbook1);
 int sheetno = workbook.getNumberOfSheets();
 for (int i = 0; i < sheetno; i++) 
 {
  WritableSheet sheet2 = workbook.getSheet(i);
 }
 
  String version = "version " + (sheetno + 1);
  WritableSheet sheet = workbook.createSheet(version, sheetno + 1);
  Boc.curr_version = sheetno + 1;
  int count = 1;
  int row = 0;
  int column = 0;
  sheet.addCell(new Label(column++, row, "Filename " + version));
  sheet.addCell(new Label(column++, row, "LOC"));
  sheet.addCell(new Label(column++, row, "BOC"));
  sheet.addCell(new Label(column++ , row , "TACH"));
  row++;
  column = 0;
  for (Files filename : filenames) 
  {
    Label fname = new Label(column++, row, filename.Filename);
    File location = filename.file;
    Number loc = new Number(column++, row, getLines(location));
    sheet.addCell(fname);
    sheet.addCell(loc);
    int boc_value;
    if (Boc.bocMap.containsKey(filename.Filename)) {
                boc_value = Boc.bocMap.get(filename.Filename);
            } else {
                boc_value = Boc.curr_version;
                Boc.bocMap.put(filename.Filename, boc_value);
            }

    Number boc = new Number(column++, row, boc_value);
    sheet.addCell(boc);
    
    int tach_value  = 0;
    if(Tach.tachMap.containsKey(filename.Filename))
    { 
        File prev = Tach.tachMap.get(filename.Filename);
        File curr = location;
        
        Comparator C = new Comparator(prev , curr);
        tach_value  = C.GetTach();
        Tach.tachMap.put(filename.Filename, curr);
    }
    else
    {
        Tach.tachMap.put(filename.Filename, location);
    }
    Number tach = new Number(column++, row, tach_value);
    sheet.addCell(tach);
    row++;
    column = 0;

  }
    
   workbook.write();
   workbook.close();
   workbook1.close();
   System.out.println("finished when the file already exists");
 } 
   

   public static void main(String s[])
   {
       MainUI m = new MainUI();
       m.setVisible(true);
   }
}



class Files
{
   String Filename = new String();
    long Filesize ;
    String FileLocation = new String();
    File file ;

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
       FileLocation = floc;
   }
}


class Boc {
   public final static HashMap<String, Integer> bocMap = new HashMap<>();
        static int curr_version  = 0;
}
 
class Tach{
    public final static HashMap<String ,File> tachMap = new HashMap<>();
    static int curr_version = 0;
}