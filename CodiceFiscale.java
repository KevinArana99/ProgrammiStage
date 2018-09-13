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

public class CodiceFiscale  
{
    private String cognome;
    private String nome;
    private int gg, mm, aaaa;
    private char sesso;
    private String lnas;
    protected String cfiscale;
    private String csvFile = "/Users/vubi/Desktop/anno 5/stage/Codici_Catastali.csv";
    final  int D = 20;
    boolean controllo;
    
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
    public String GetCognome()
    {
        return cognome;
    }
    //GET DATI//
    public String GetNome()
    {
        return nome;
    }
    public int [] GetData()
    {
        int vett[];
        vett = new int [3];
        vett[0]=gg;
        vett[1]=mm;
        vett[2]=aaaa;
        return vett;
    }
    public char GetSesso()
    {
        return sesso;
    }
    public String GetLuogo()
    {
    return lnas;
    }
    public String GetCfiscale()
    {
        return cfiscale;     
    }         

    public String Calcola()
    { 
        Cognome c = new Cognome(cognome);
        Nome n = new Nome(nome);
        Data d = new Data(aaaa,mm,gg);
        LuogoDiNascita l = new LuogoDiNascita (lnas);
        if((sesso == 'f')||(sesso == 'F'))
            controllo=true;
        else
        controllo=false;
        String con = c.calcola(cognome);
        String nom = n.calcola(nome);
        String dat = d.calcola(aaaa, mm, gg, controllo);
        String Ccomune = l.calcola(lnas);
        //  PRENDI LE CONSONANTI //
       cfiscale = cfiscale.concat(con);
       cfiscale = cfiscale.concat(nom);
       cfiscale = cfiscale.concat(dat);
      cfiscale = cfiscale.concat(Ccomune);
       
        //metto le celle del vettore in posizione pari nel vettore pari
      //String cCcodcon = this.Ccodcon();
     // cfiscale = cfiscale.concat(cCcodcon);  
      cfiscale=cfiscale.toUpperCase();
        return GetCfiscale();
    }    
}
