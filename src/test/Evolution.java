/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;

/**
 *
 * @author aryan_000
 */
public class Evolution {
    
  private  int loc;  private int boc;  private int tach;
  private  double chd;  private   int cho;  private  int fch;
  private  int lch;  private  int frch;  private  int csb;
  private  double csbs;  private  int lca;  private  double lcd;
  private  double wch;  private  double wcd;  private  double acdf;
  private  double ataf;  private  int wfr;  private  double icp;
  private Boolean cp;
  int version;
  File file;
  String filename;
    
    Evolution()
    {
        loc = 0;          boc = 0;          tach = 0;
        chd = 0;          cho = 0;          fch = 0;
        lch = 0;          frch = 0;         csb = 0;
        csbs = 0;         lca = 0;          lcd = 0;
        wch = 0;          wcd = 0;          acdf = 0;
        ataf = 0;         wfr = 0;          icp = 0;
        cp = false; version = 0;
    }
    
    int Getloc()
    {
        return this.loc;
    }
    
    int Getboc()
    {
        return this.boc;
    }
    
    int Gettach()
    {
        return this.tach;
    }
    
    double Getchd()
    {
        return this.chd;
    }

    int Getcho()
    {
        return this.cho;
    }
    
    int Getfch()
    {
        return this.fch;
    }
    
    int Getlch()
    {
        return this.lch;
    }
    
    int Getfrch()
    {
        return this.frch;
    }
    
    int Getcsb()
    {
        return this.csb;
    }
    
    double Getcsbs()
    {
        return this.csbs;
    }
    
    int Getlca()
    {
        return this.lca;
    }
    
    double Getlcd()
    {
        return this.lcd;
    }
    
    double Getwch()
    {
        return this.wch;
    }
    
    double Getwcd()
    {
        return this.wcd;
    }
    
    double Getacdf()
    {
        return this.acdf;
    }
    
    double Getataf()
    {
        return this.ataf;
    }
    
    int Getwfr()
    {
        return this.wfr;
    }
    
    double Geticp()
    {
        return this.icp;
    }
    
    Boolean Getcp()
    {
        return this.cp;
    }
          
    void Setloc(int loc)
    {
        this.loc = loc;
    }
    
    void Setboc( int boc )
    {
          this.boc = boc;
    }
    
    void Settach(int tach)
    {
        this.tach = tach;
    }
    
     void Setchd(double chd)
    {
         this.chd = chd;
    }

    void  Setcho(int cho )
    {
         this.cho = cho;
    }
    
    void  Setfch(int fch )
    {
          this.fch = fch;
    }
    
    void  Setlch(int lch)
    {
          this.lch = lch;
    }
    
    void  Setfrch( int frch )
    {
        this.frch = frch;
    }
    
    void Setcsb(int csb)
    {
         this.csb = csb;
    }
    
    void Setcsbs(double csbs)
    {
          this.csbs = csbs;
    }
    
    void Setlca( int lca)
    {
        this.lca = lca;
    }
    
    void Setlcd(double lcd)
    {
       this.lcd = lcd;
    }
    
    void Setwch(double wch)
    {
          this.wch = wch;
    }
    
    void  Setwcd(double wcd)
    {
        this.wcd = wcd;
    }
    
    void Setacdf(double acdf)
    {
         this.acdf = acdf;
    }
    
    void Getataf(double ataf)
    {
         this.ataf = ataf;
    }
    
    void Setwfr(int wfr)
    {
        this.wfr = wfr;
    }
    
    void  Seticp(double icp )
    {
        this.icp = icp;
    }
    
    void  Setcp(Boolean cp)
    {
        this.cp = cp;
    }
    
    void Setfile(File f)
    {
        this.file = f;
    }
    
    void Setversion(int version )
    {
        this.version = version;
    }
    
    void Setfilename(String fname)
    {
        this.filename = fname;
    }
    
}
