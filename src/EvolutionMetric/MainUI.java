/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionMetric;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author aryan_000
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
         Boc.bocMap.clear();
        Boc.curr_version = 0;
        Metric.curr_version = 0;
        Metric.fch.clear();
        Metric.frch.clear();
        Metric.lcaandlcd.clear();
        Metric.lch.clear();
        Metric.loc.clear();
        Tach.curr_version=0;
        Tach.tachMap.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heading = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        select_label = new javax.swing.JLabel();
        Upload_button = new javax.swing.JButton();
        select_label1 = new javax.swing.JLabel();
        gen_report_button = new javax.swing.JButton();
        select_label2 = new javax.swing.JLabel();
        csv_convert_button = new javax.swing.JButton();
        select_label3 = new javax.swing.JLabel();
        weka_analysis_button = new javax.swing.JButton();
        select_label4 = new javax.swing.JLabel();
        about_button = new javax.swing.JButton();
        select_label5 = new javax.swing.JLabel();
        Upload_button1 = new javax.swing.JButton();
        select_label6 = new javax.swing.JLabel();
        Upload_button2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Evalution Metric Calculator");

        heading.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        heading.setForeground(new java.awt.Color(51, 51, 255));
        heading.setText("Evolution Metric Calculator");

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/research.jpeg"))); // NOI18N
        icon.setText("jLabel4");

        select_label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select_label.setText("Click to Generate Evolution Metrics  : ");

        Upload_button.setText("Generate Evolution Metrics ");
        Upload_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Upload_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Upload_buttonActionPerformed(evt);
            }
        });

        select_label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select_label1.setText("Click to Generate Report : ");

        gen_report_button.setText("Generate Report");
        gen_report_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gen_report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gen_report_buttonActionPerformed(evt);
            }
        });

        select_label2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select_label2.setText("Click to Convert Excel Sheet to CSV : ");

        csv_convert_button.setText("CSV  Converter");
        csv_convert_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        csv_convert_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csv_convert_buttonActionPerformed(evt);
            }
        });

        select_label3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select_label3.setText("Perform Analysis Using Weka : ");

        weka_analysis_button.setText("Analyse using Weka");
        weka_analysis_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        weka_analysis_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weka_analysis_buttonActionPerformed(evt);
            }
        });

        select_label4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select_label4.setText("About Software Metrics : ");

        about_button.setText("About");
        about_button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        about_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_buttonActionPerformed(evt);
            }
        });

        select_label5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select_label5.setText("Click to Generate OO Metrics : ");

        Upload_button1.setText("Generate OO Metrics");
        Upload_button1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Upload_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Upload_button1ActionPerformed(evt);
            }
        });

        select_label6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select_label6.setText("Click to Process Evolution & OO metrics : ");

        Upload_button2.setText("Generate All");
        Upload_button2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Upload_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Upload_button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(select_label, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_label5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_label2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_label4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_label6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(about_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gen_report_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(weka_analysis_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(csv_convert_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Upload_button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Upload_button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Upload_button, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Upload_button, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(select_label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_label5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Upload_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_label6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Upload_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(select_label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(csv_convert_button, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(select_label3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(weka_analysis_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(select_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gen_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(select_label4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(about_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(heading)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private String project_name = "";
    private String userPath = "";
    private int version = 0;
    public void Reset()
    {
        Boc.bocMap.clear();
        Boc.curr_version = 0;
        Metric.curr_version = 0;
        Metric.fch.clear();
        Metric.frch.clear();
        Metric.lcaandlcd.clear();
        Metric.lch.clear();
        Metric.loc.clear();
        Tach.curr_version=0;
        Tach.tachMap.clear();
    }

    protected  void generate( File [] mydirectory , String proj_name , Helper h)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                Random ran = new Random();
//                int x1 = ran.nextInt(1000) + 1;
                ProgressBar1 pb = new ProgressBar1();
                pb.setVisible(true);
                File f = new File(userPath  +"/"+ project_name + ".xls");
                int count = 1;
                int total_num = mydirectory.length  + 16;
                System.out.println(total_num);
                int inc = 100 / total_num;
                if(inc==0)
                    inc=1;
                System.out.println("inc is : " + inc);
                int num = 0;
//                ProgressBar obj_frame = new ProgressBar();
//                obj_frame.setVisible(true);
                for (File myfile : mydirectory) {
                    ArrayList<Files> filenames = h.Get_List_Of_Files(myfile);
                    try {
                        if (!f.exists()) {
//                System.out.println("File Does not exist ");
                            System.out.println("File sheet " + count + " added ");
                            pb.set("Adding File Sheet " + count , num);
                            WritableWorkbook workbook = null;
                            h.createSheet(workbook, f);
                            num += inc ;
                            pb.set("File sheet " + count + " added ", num);
                            count++;
                        } else {
//                System.out.println("File already found ");
                            System.out.println("File sheet " + count + " added ");
                            pb.set("Adding File Sheet " + count , num);
                            Workbook workbook = Workbook.getWorkbook(f);
                            h.addsheet(workbook, f);
                            workbook.close();
                            num += inc ;
                            pb.set("File sheet " + count + " added ", num);
                            count++;
                        }
                    } catch (IOException | WriteException | BiffException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, " File is already opened or File cannot be created");
                    }
                }
                inc = (100-num)/16;
                num = 100 - inc*16;
//                obj_frame.call(num);
                System.out.println("inc is : " + inc  + "and " + (100- inc*4));
                System.out.println("num is ; " + num);
                Metric m = new Metric();
                try {
                    m.addCho(f);// cho and chd
                    num += inc * 2;
//                        obj_frame.call(num);
                    pb.set("CHO and CHD added ", num);
                    m.addFchAndLch(f); //fch lch  frch csd csbs lca lcd
                    num += inc * 7;
//                        obj_frame.call(num);
                    pb.set("FCH LCH FRCH CSD CSBS LCA LCD added", num);
                    m.addWchAndWCD(f); // wch and wcd
                    num += inc * 2;
//                        obj_frame.call(num);
                    pb.set("WCH and WCD added ", num);
                    m.addAcdfAndATAF(f); // ACDF and ATAF and WFR and ICP
                    num += inc * 4;
//                        obj_frame.call(num);
                    pb.set("ACDF AND ATAF added ", num);
                    m.addCP(f);// cp
                    num += inc;
//                        obj_frame.call(num);
                    pb.set("CP added ", num);
//                    obj_frame.dispose();
                    pb.setVisible(false);
                    Complete c = new Complete(f);
                    c.setVisible(true);
                    Reset();
                } catch (IOException | BiffException | WriteException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                pb.set_output("Evolution Metrics Added");
            }
        }).start();
    }
    
    private void generate_cnk(File [] mydirectory)
    {
       new Thread(new Runnable() {

           @Override
           public void run() {
                   int i = 0; 
                ProgressBar1 pb = new ProgressBar1();
                pb.setVisible(true);
               String filename = "cnk_version";
               
               for (File cnkfile : mydirectory) {
                   
                   pb.set("CNK File " + (i+1) + " Processing ...",i+5);
                   if(i+1<10)
                   {
                       UnderstandHelper h = new UnderstandHelper(cnkfile , userPath , filename +"0" + (i+1));
                         h.execute();
                   }
                   else 
                   {  UnderstandHelper h = new UnderstandHelper(cnkfile , userPath , filename + (i+1));
                     h.execute();
                   }
                     pb.set("CNK File " + (i+1) + " added",i+10);
                   i++;
               
               }
//               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       }).start();
        
    }
    
     private Boolean validate_project_name(String proj_name)
    {
        if( proj_name==null || proj_name.isEmpty() )
        { JOptionPane.showMessageDialog(null,"Project name is invalid.. \n Please try again"); return false; }
        
        else
        {
        String userDir = System.getProperty("user.home");
        userDir   = userDir + "/Desktop/" + proj_name;
        
            System.out.println(userDir);
         Boolean check = new File(userDir).mkdir();
         
         if(!check)
         { JOptionPane.showMessageDialog(null,"Folder Name already exists"); return false; }
         else
         {   
             userPath = userDir;
             return true;
         }   
         }
        
        
        
             
    }
    private void Upload_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Upload_buttonActionPerformed
        // TODO add your handling code here: 
        
         project_name =  JOptionPane.showInputDialog(null, "Please Enter the name of your project :");
       
       Boolean check = validate_project_name(project_name);
       if(!check)
       { System.out.println("Folder not Created"); return ;}
       
        System.out.println("project name is :  "  + project_name);
        JOptionPane.showMessageDialog(null,"Please Select all the folders corresponding to the versions !!!");
        Helper h = new Helper();
        File[] mydirectory = h.Upload_All();
        version = mydirectory.length;
        if(mydirectory==null)
        {   JOptionPane.showMessageDialog(rootPane,"No Folder has been Selected");
            return ;
        }
        
        
        String proj_name = mydirectory[0].getName();
        generate(mydirectory , proj_name , h);
//         generate_cnk(mydirectory);
    }//GEN-LAST:event_Upload_buttonActionPerformed

    private void csv_convert_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csv_convert_buttonActionPerformed
        // TODO add your handling code here:
        XlstoCsv c = new XlstoCsv();
        c.setVisible(true);
    }//GEN-LAST:event_csv_convert_buttonActionPerformed

    private void gen_report_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gen_report_buttonActionPerformed
        // TODO add your handling code here:
        GenerateReport gr = new GenerateReport();
        gr.setVisible(true);
        
    }//GEN-LAST:event_gen_report_buttonActionPerformed

    private void weka_analysis_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weka_analysis_buttonActionPerformed
        // TODO add your handling code here:
        WekaUse wu = new WekaUse();
        wu.setVisible(true);
    }//GEN-LAST:event_weka_analysis_buttonActionPerformed

    private void about_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_buttonActionPerformed
        // TODO add your handling code here:
        About a = new About();
        a.setVisible(true);
    }//GEN-LAST:event_about_buttonActionPerformed

    private void Upload_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Upload_button1ActionPerformed
        // TODO add your handling code here:
         project_name =  JOptionPane.showInputDialog(null, "Please Enter the name of your project :");
       
       Boolean check = validate_project_name(project_name);
       if(!check)
       { System.out.println("Folder not Created"); return ;}
       
        System.out.println("project name is :  "  + project_name);
        JOptionPane.showMessageDialog(null,"Please Select all the folders corresponding to the versions !!!");
        Helper h = new Helper();
        File[] mydirectory = h.Upload_All();
        version = mydirectory.length;
        if(mydirectory==null)
        {   JOptionPane.showMessageDialog(rootPane,"No Folder has been Selected");
            return ;
        }
        
        
        String proj_name = mydirectory[0].getName();
       Thread T1 =  new Thread(new Runnable() {
                @Override
                public void run() {
                    select_label.setText(mydirectory[0].getParent());
                    }
            }); 
       
       T1.start();
//        generate(mydirectory , proj_name , h);
         generate_cnk(mydirectory);
    }//GEN-LAST:event_Upload_button1ActionPerformed

    private void Upload_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Upload_button2ActionPerformed
        // TODO add your handling code here:
        Generate_Full_Report gfr = new Generate_Full_Report();
        gfr.start();
        
    }//GEN-LAST:event_Upload_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Upload_button;
    private javax.swing.JButton Upload_button1;
    private javax.swing.JButton Upload_button2;
    private javax.swing.JButton about_button;
    private javax.swing.JButton csv_convert_button;
    private javax.swing.JButton gen_report_button;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel select_label;
    private javax.swing.JLabel select_label1;
    private javax.swing.JLabel select_label2;
    private javax.swing.JLabel select_label3;
    private javax.swing.JLabel select_label4;
    private javax.swing.JLabel select_label5;
    private javax.swing.JLabel select_label6;
    private javax.swing.JButton weka_analysis_button;
    // End of variables declaration//GEN-END:variables
}
