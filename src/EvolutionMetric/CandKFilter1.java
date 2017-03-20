package EvolutionMetric;

import cNk.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Number;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author aryan_000
 */


public class CandKFilter1 extends javax.swing.JFrame {

    /**
     * Creates new form CandKFilter1
     */
    public CandKFilter1() {
        initComponents();
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        csv_label = new javax.swing.JLabel();
        csv_button = new javax.swing.JButton();
        project_file_label = new javax.swing.JLabel();
        file_selection_button = new javax.swing.JButton();
        filter_button = new javax.swing.JButton();
        version_no = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("C and K Filter");

        csv_label.setLabelFor(csv_label);
        csv_label.setText(" No File Selected");
        csv_label.setBorder(javax.swing.BorderFactory.createTitledBorder("Select CSV FILE"));

        csv_button.setText("Browse for CSV");
        csv_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csv_buttonActionPerformed(evt);
            }
        });

        project_file_label.setLabelFor(csv_label);
        project_file_label.setText(" No File Selected");
        project_file_label.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Project FILE"));

        file_selection_button.setText("Browse for Project");
        file_selection_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_selection_buttonActionPerformed(evt);
            }
        });

        filter_button.setText("Filter C and K Metrics");
        filter_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_buttonActionPerformed(evt);
            }
        });

        version_no.setText("8");
        version_no.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Project Version(only in number)"));
        version_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                version_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(version_no, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(csv_label, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(project_file_label, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(file_selection_button)
                            .addComponent(csv_button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(filter_button, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(csv_label)
                    .addComponent(csv_button))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(project_file_label)
                    .addComponent(file_selection_button))
                .addGap(18, 18, 18)
                .addComponent(version_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(filter_button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void file_selection_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_selection_buttonActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser candkfile = new JFileChooser(userDir+"/Desktop");
        candkfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
         FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
     "excel files (*.xls)", "xls");
         candkfile.setFileFilter(xmlfilter);
         int returnvalue = candkfile.showSaveDialog(this);
        File myfile= null;
        if(returnvalue == JFileChooser.APPROVE_OPTION)
        {
            myfile = candkfile.getSelectedFile();
        }
             ArrayList<CSVFile> data = null  ;  
        if(myfile!=null)
        {   
            project_file_label.setText(myfile.getAbsolutePath());
        }
        
    }//GEN-LAST:event_file_selection_buttonActionPerformed

    private void csv_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csv_buttonActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser candkfile = new JFileChooser(userDir+"/Desktop");
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
     "csv files (*.csv)", "csv");
        candkfile.setFileFilter(xmlfilter);
        candkfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnvalue = candkfile.showSaveDialog(this);
        
        File myfile= null;
        if(returnvalue == JFileChooser.APPROVE_OPTION)
        {
            myfile = candkfile.getSelectedFile();
        }
             ArrayList<CSVFile> data = null  ;  
        if(myfile!=null)
        {   
            csv_label.setText(myfile.getAbsolutePath());
        }
        
    }//GEN-LAST:event_csv_buttonActionPerformed

    ArrayList<CSVFile> getcsv( File f)
     {
          ArrayList<CSVFile> data = new ArrayList<>();  
          FileReader fr = null;
            try {
                fr = new FileReader(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CandKFilter1.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader br = new BufferedReader(fr);
            String st ;
            int i = 0;
//            System.out.println("gettting csv file ");
            try { 
                while ((st = br.readLine()) != null) 
                {
//                    System.out.println(st);
                    if(i==0)
                    {
                    CSVFile t = new CSVFile(st); 
                    i++;
                    }
                    else
                    {CSVFile t = new CSVFile(st);
                     data.add(t);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(CandKFilter1.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          return data;
     }
     
     
     ArrayList<String> getjavafiles( File f  , int version)
     {
         ArrayList<String> javafiles = new ArrayList<>();
        
        try {
            Workbook wb = null;
             wb = Workbook.getWorkbook(f);
            Sheet sh = wb.getSheet(version);
//            System.out.println(sh.getRows());
            for(int i =1;i<sh.getRows();i++)
            {  
//                System.out.println(sh.getCell(1,i).getContents());
                javafiles.add(sh.getCell(0,i).getContents());
                
            }
        } catch (IOException | BiffException ex) {
            Logger.getLogger(CandKFilter1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//         System.out.println("before returning");
        return javafiles;
     }
     
  public Boolean ismatch(String jfile , String candkfile)
  {
      
       
      String    pattern = jfile.substring(0,jfile.lastIndexOf("."));
      candkfile = candkfile.replaceAll("^\"|\"$", "");
      Boolean result =  candkfile.matches(".*.\\."+pattern);
      
//      System.out.println( jfile + " and " + candkfile + result );
      return result;
  }
  
  
  public void buildcsv(HashMap<String , CSVFile> candkdata) throws IOException, WriteException 
  {
      File ft = new File("C:\\Users\\aryan_000\\Desktop\\cNk.xls");
       WritableWorkbook workbook =  Workbook.createWorkbook(ft);
       WritableSheet sheet = workbook.createSheet("candk", 0); 
              
        int row = 0 , column = 0;
        sheet.addCell(new Label ( column++ ,row,"FileName "));
        sheet.addCell(new Label ( column++ ,row,"Understand FileName "));
        
        for(int i = 0; i < CSVFile.metric_names.size() ; i++)
        {    
            String col_name =  CSVFile.metric_names.get(i);
//            System.out.println("col name is : " + col_name);
            sheet.addCell(new Label ( column++ ,row,col_name));
        }
        
        row++;
        column=0; 
        
        System.out.println("collected keys are : " + candkdata.size());
        for (String key : candkdata.keySet()) 
        {
            CSVFile temp = candkdata.get(key);
            sheet.addCell(new Label ( column++ ,row,key));
            sheet.addCell(new Label(column++ , row , temp.name.replaceAll("^\"|\"$", "")));
            
        
          for (int i=0;i<temp.metric.size();i++) {
              int num = temp.metric.get(i);
              sheet.addCell(new Number(column++ , row , num));
          } 
          row++;
          column = 0;
//            System.out.println( key  + "    " + temp.name);
            
         }
        
        
        workbook.write();
        workbook.close();
        
        System.out.println("Writing complete");
  }
  
  public void showtable(HashMap<String , CSVFile> candkdata)
  {
       TableDisplay td = new TableDisplay();
       td.setVisible(true);
       
       JTable jt = td.gettable();
       
      DefaultTableModel model = (DefaultTableModel) jt.getModel();
      
//       jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
       JScrollPane js = td.getJScrollPane();
//         js.setViewportView(jt);
          Vector colnames = new Vector();
          colnames.add("S.No");
          colnames.add("Filename");
          colnames.add("Understand File Name");
          colnames.add("CBO");
          colnames.add("WMC");
          colnames.add("RFC");
          colnames.add("LCOM");
          colnames.add("NOC");
          colnames.add("DIT");
         
//       model.setColumnIdentifiers(new Object[] { "S.No"});
       model.setColumnIdentifiers(colnames);
     
//       , Filename","Understand FileName ,CBO,WMC,RFC,LCOM,NOC,DIT 
               
               model.setColumnCount(9);
     int count = 1;
      for (String key : candkdata.keySet()) 
        {  Vector row = new Vector();
        
            CSVFile temp = candkdata.get(key);
//            model.addColumn(key);
//            model.addColumn(temp.name);
            row.add(count++);
            row.add(key);
            row.add(temp.name);
          for (int i=0;i<temp.metric.size();i++) {
              int num = temp.metric.get(i);
//              model.addColumn(num);
              row.add(num);
             
          } 
          model.addRow(row);
//          model.insertRow(row , new Object[] {});
          
//            System.out.println( key  + "    " + temp.name);
            
         }
      
      JButton jb = td.getButton();
      jb.setVisible(true);
        
      
  }
  
  Boolean valid()
  {
      if(csv_label.getText().isEmpty() || csv_label.getText().equalsIgnoreCase(" No File Selected"))
      {JOptionPane.showMessageDialog(rootPane, "Please select the CSV File for C and K");
          return false;
        }
      if(project_file_label.getText().isEmpty() || project_file_label.getText().equalsIgnoreCase(" No File Selected"))
         {JOptionPane.showMessageDialog(rootPane, "Please select the Excel File for Project");
          return false;
        } 
      
      if(version_no.getText().isEmpty())
          {JOptionPane.showMessageDialog(rootPane, "Please select the version of the project ");
          return false;
        }
      
      return true;
  }
    private void filter_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_buttonActionPerformed
        // TODO add your handling code here:
                 
        if(!valid())
            return;
        File f = new File(csv_label.getText());
        ArrayList<CSVFile> data = null  ;  
        data = getcsv(f); 
        
//         System.out.println("printing ");
//         System.out.println(CSVFile.metric_names.toString());
//         for(CSVFile cs : data)
//             System.out.println(cs.kind + cs.metric.toString() );
        System.out.println("received data of csv : " + data.size());
        
        int version = 0;
        version  =  Integer.parseInt(version_no.getText());
        ArrayList<String> javafiles = getjavafiles(new File(project_file_label.getText()),version );
        
        System.out.println("javafiles names received : " + javafiles.size());
        
        HashMap<String, CSVFile> candkdata = new HashMap<>();
        
        String candkfilename; 
        int start = 0;
        for(String filename : javafiles)
        {
            for(CSVFile data1 : data)
            {   
                if(start==0)
                { start++; continue;}
                 
                candkfilename = data1.name;
                
                if(ismatch(filename,candkfilename))
                {
                    candkdata.put(filename,data1);
//                    System.out.println( filename + " and " + candkfilename +  " match found");
                    break;
                }
                else
                {
//                    System.out.println( filename + " and " + candkfilename +  " no match found");
                }
            }
        }
        
        try {
            buildcsv(candkdata);
           // showtable(candkdata);
        } catch (IOException | WriteException ex) {
            Logger.getLogger(CandKFilter1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Some Error Occurred. Cannot write data to csv. \n Try Later");
        }
        
        System.out.println("total rows are : " + candkdata.size());
        
      
//        for (String key : candkdata.keySet()) {
//    // ...
//            
//            CSVFile temp = candkdata.get(key);
//            
//            sheet.addCell(new Label ( column++ ,row,key));
//            
//            System.out.println( key  + "    " + temp.name);
//            
//    }
//        
      
        
        
    }//GEN-LAST:event_filter_buttonActionPerformed

   public void merge_candk(File project_file , File candkfile)
   {
        ArrayList<CSVFile> data = null  ;  
        data = getcsv(candkfile); 
        
//        System.out.println("data from csv is received : " + data.size());
//        ArrayList<String> javafiles = new ArrayList<>();
        FileReader fr = null;
        
        try {
            fr = new FileReader(project_file);
            BufferedReader br = new BufferedReader(fr);
            
            StringBuffer new_data = new StringBuffer();
             String st ;
            File outputFile = new File(project_file.getParent() + "/final_" + project_file.getName() );
            FileOutputStream fos = new FileOutputStream(outputFile); 
            
            System.out.println("file crated");
            // reading project file  
            
            int project_file_ptr = 0;
            Boolean flag ;
            while ((st = br.readLine()) != null) // for every line of project file
            {    
//                System.out.println("line reading is : " + st);
                flag = false;
                if(project_file_ptr==0)
                {   
//                    System.out.println("THis is first line in file ");
                    new_data.append(st);
                    String metric_name = null ;
                    for(int i = 0;i<CSVFile.metric_names.size() ; i++)
                    {   
                        if(CSVFile.metric_names.get(i).equals("CountDeclMethod"))
                            metric_name = "WMC";
                        else if(CSVFile.metric_names.get(i).equals("MaxInheritanceTree"))
                            metric_name = "DIT";
                        else if(CSVFile.metric_names.get(i).equals("CountClassDerived"))
                            metric_name = "NOC";
                        else if(CSVFile.metric_names.get(i).equals("CountClassCoupled"))
                            metric_name = "CBO";
                        else if(CSVFile.metric_names.get(i).equals("CountDeclMethodAll"))
                            metric_name = "RFC";
                        else if(CSVFile.metric_names.get(i).equals("PercentLackOfCohesion"))
                            metric_name = "LCOM"; 
                        
                        new_data.append("," + metric_name);
                    }
                    new_data.append("\n");
                    project_file_ptr++;
                    System.out.println("First line successfully added");
                }
                 else
                {
                    new_data.append(st);
                    String file_name = st.split(",")[0];
                    String candkfilename;
                    int start = 0;
                    for (CSVFile data1 : data) 
                    {
                        if (start == 0) 
                        {
                            start++;
                            continue;
                        }

                        candkfilename = data1.name;

                        if (ismatch(file_name, candkfilename)) 
                        {  
                            int i ;
                            for( i = 0 ; i< data1.metric.size() ; i++)
                            {
                                new_data.append(","  + data1.metric.get(i));
                            }
                            
                             while(i<6)
                            {
                                new_data.append(","  + 0);
                                i++;
                            }
                            new_data.append("\n");
                            flag = true;
                            break;
                        } 
                    } // searching in c and k over
                    
                    if(flag==false)
                    {
                        for(int i = 0 ; i< 6 ; i++)
                            {
                                new_data.append(","  + 0);
                            }
                            new_data.append("\n");
                    }
                }
            }// all java files over
            
            
            fos.write(new_data.toString().getBytes());
           fos.close();
                
                System.out.println("file written successfully");
                
            } catch (FileNotFoundException ex) {
            Logger.getLogger(CandKFilter1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CandKFilter1.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
        
         
       
   }
    private void version_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_version_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_version_noActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CandKFilter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandKFilter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandKFilter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandKFilter1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CandKFilter1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton csv_button;
    private javax.swing.JLabel csv_label;
    private javax.swing.JButton file_selection_button;
    private javax.swing.JButton filter_button;
    private javax.swing.JLabel project_file_label;
    private javax.swing.JTextField version_no;
    // End of variables declaration//GEN-END:variables
}
