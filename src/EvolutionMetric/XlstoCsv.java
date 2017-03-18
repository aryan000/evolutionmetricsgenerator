/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionMetric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author aryan_000
 */
public class XlstoCsv extends javax.swing.JFrame {

    /**
     * Creates new form XlstoCsv
     */
    public XlstoCsv() {
        initComponents();
        centerText.setText("<html> <center> <h2> Disclaimer !!! </h2> </center><p> This is "
                + " the customised XLS to CSV Converter for the scope of this Project. However you can use it for your own purpose "
                + " as well.<h3> Working </h3> <ol> <li> Select the excel file for the project using Browse Button </li>"
                + "<br> <li> Click on <b> Start XLS Conversion </b>  to convert all sheets to csv</li> <br>"
                + "<li> All the excel sheet will be generated in a folder with name Output + \"x\" and a pop up will guide"
                + "<br> you to the generated folder </li> </ol> \n ");
        filename.setText("");
    }
    
    public void exceltocsv(File inputFile , int version , File outputFile)  
    {
        StringBuffer data = new StringBuffer();
        try{
           FileOutputStream fos = new FileOutputStream(outputFile);
           Workbook workbook = Workbook.getWorkbook(inputFile);
           Sheet sheet = workbook.getSheet(version);
           for(int row =0;row <sheet.getRows();row++)
            {
              for(int col =0;col <sheet.getColumns();col++)
               {
                  Cell cell = sheet.getCell(col, row);
                  String temp = cell.getContents();
//                   System.out.println(temp);
                  data.append(temp);
                  if(col+1!= sheet.getColumns())
                    data.append(",");
               }
                  data.append("\n");
            } 
           fos.write(data.toString().getBytes());
           fos.close();
        }
         catch (IOException | BiffException  ex) {
            Logger.getLogger(XlstoCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void convert(File f )
    {
        try{
              Workbook workbook = Workbook.getWorkbook(f);
              int num_of_sheet = workbook.getNumberOfSheets();
               String userDir = System.getProperty("user.home");
               userDir   = userDir + "/Desktop/Output_" + f.getName();
                Boolean check = new File(userDir).mkdir();
                int j =1;
                while(!check)
                {
                    userDir += j;
                    j++;
                    check = new File(userDir).mkdir();
                }
//                System.out.println(userDir);
//                System.out.println(new File(userDir).getAbsolutePath());
                for(int i =0; i<num_of_sheet; i++)
                {   
                    File outputFile = null;
                    if(i+1<10)
                        outputFile = new File(new File(userDir).getAbsolutePath() + "\\version0" + (i+1) + ".csv");
                    else
                         outputFile = new File(new File(userDir).getAbsolutePath() + "\\version" + (i+1) + ".csv");
                    exceltocsv(f,i,outputFile);
                }
                CompleteCsv c = new CompleteCsv(new File(userDir));
                c.setVisible(true);
                this.dispose();
                System.out.println("Completed");
        }
         catch (IOException | BiffException  ex) {
            Logger.getLogger(XlstoCsv.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"File Cannot be opened");
        }
    }
    
     public void convert_explicit(File f , String userPath )
    {
        try{
              Workbook workbook = Workbook.getWorkbook(f);
              int num_of_sheet = workbook.getNumberOfSheets();
              
                for(int i =0; i<num_of_sheet; i++)
                {   
                    File outputFile = null;
                    if(i+1<10)
                        outputFile = new File(new File(userPath).getAbsolutePath() + "\\version0" + (i+1) + ".csv");
                    else
                         outputFile = new File(new File(userPath).getAbsolutePath() + "\\version" + (i+1) + ".csv");
                    exceltocsv(f,i,outputFile);
                } 
                
                System.out.println("completed here excel conversion");
//                CompleteCsv c = new CompleteCsv(new File(userPath));
//                c.setVisible(true);
//                System.out.println("Completed");
        }
         catch (IOException | BiffException  ex) {
            Logger.getLogger(XlstoCsv.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"File Cannot be opened");
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        select_file_label = new javax.swing.JLabel();
        browse_file_button = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        filename = new javax.swing.JTextField();
        centerText = new javax.swing.JLabel();
        xls_convert_button = new javax.swing.JButton();
        close_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("XLS TO CSV CONVERTER");

        select_file_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        select_file_label.setText("Select  File :");

        browse_file_button.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        browse_file_button.setText("Browse For File");
        browse_file_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browse_file_buttonActionPerformed(evt);
            }
        });

        heading.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("XLS To CSV Converter");

        filename.setText(" ");

        centerText.setText(" ");

        xls_convert_button.setText("Start XLS Conversion ");
        xls_convert_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xls_convert_buttonActionPerformed(evt);
            }
        });

        close_button.setText("Close");
        close_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(centerText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(select_file_label, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(browse_file_button)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(xls_convert_button)
                .addGap(81, 81, 81)
                .addComponent(close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_file_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browse_file_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(centerText, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xls_convert_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browse_file_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browse_file_buttonActionPerformed
        // TODO add your handling code here:
        String userDir = System.getProperty("user.home");
        JFileChooser inputFile = new JFileChooser(userDir+"/Desktop");
        inputFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
        "Excel Files  (*.xls)", "xls");
        inputFile.setFileFilter(xmlfilter);
        int returnvalue = inputFile.showSaveDialog(this);
        
        File myfile= null;
        if(returnvalue == JFileChooser.APPROVE_OPTION)
        {
            myfile = inputFile.getSelectedFile();
//            System.out.println(myfolder);         
        }
        if(myfile!=null)
        {
             filename.setText(myfile.getPath());
        }
        else
            JOptionPane.showMessageDialog(rootPane,"Selection Aborted");
    }//GEN-LAST:event_browse_file_buttonActionPerformed

    private void close_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_buttonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_close_buttonActionPerformed

    private void xls_convert_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xls_convert_buttonActionPerformed
        // TODO add your handling code here:
        System.out.println(filename.getText());
        String inputFile = filename.getText();
        if(inputFile.isEmpty())
        {
            JOptionPane.showMessageDialog(centerText,"No File has been Selected");
        }
        else
        {
            File myfile = new File(inputFile);
            if(!myfile.exists())
            {
                JOptionPane.showMessageDialog(centerText,"File Does not exist");
            }
            else
            {
                 convert(myfile);
            }
        }
    }//GEN-LAST:event_xls_convert_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(XlstoCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XlstoCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XlstoCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XlstoCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XlstoCsv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse_file_button;
    private javax.swing.JLabel centerText;
    private javax.swing.JButton close_button;
    private javax.swing.JTextField filename;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel select_file_label;
    private javax.swing.JButton xls_convert_button;
    // End of variables declaration//GEN-END:variables
}
