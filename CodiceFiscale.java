/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vubi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author arana
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class CodiceFiscale  
{
    private String cognome;
    private String nome;
    private int gg, mm, aaaa;
    private char sesso;
    private String lnas;
    private String csvFile = "/Users/vubi/Desktop/anno 5/stage/Codici_Catastali.csv";
    final  int D = 20;
    boolean controllo;
    
    protected String cfiscale;
    
    public CodiceFiscale()
    {
        cognome=nome=lnas="";
        cfiscale="";
        gg=mm=aaaa=0;   
    }
     public CodiceFiscale(String cog, String nom, int g, int m, int a, char sex, String ln )
    {
       Set(cog,nom,g,m,a,sex,ln);        
    }
    public boolean Set(String c, String n, int g, int m, int a, char uomo, String ln)
    {
        cognome=c;
        nome=n;
        gg=g;
        mm=m;
        aaaa=a;
        lnas=ln;
        
            
            if((uomo!='M')&& (uomo!='F'))
                return false;
            else
               sesso=uomo;     
     return true;   
    }     
    
    public String GetCfiscale()
    {
        return cfiscale;     
    }         
     
        
    public String Calcola()
    { 
        Cognome c = new Cognome(cognome);
        Nome n = new Nome(nome);
     
        if(sesso == 'f')
            controllo=true;
        else
        controllo=false;
        Data d = new Data(gg,mm,aaaa);
        String con = c.calcola(cognome);
        String nom = n.calcola(nome);
        String dat = d.calcola(gg, mm, D, controllo);
        LuogoDiNascita l = new LuogoDiNascita (lnas);
        //  PRENDI LE CONSONANTI //
        String Ccomune = l.calcola(lnas);
        
       cfiscale = cfiscale.concat(con);
       cfiscale = cfiscale.concat(nom);
       cfiscale = cfiscale.concat(dat);
      
       cfiscale+=String.valueOf(Ccomune);
       cfiscale=cfiscale.toUpperCase();
        //metto le celle del vettore in posizione pari nel vettore pari
      String cCcodcon = this.Ccodcon();
      cfiscale = cfiscale.concat(cCcodcon);  
        return GetCfiscale();
    }    
}
