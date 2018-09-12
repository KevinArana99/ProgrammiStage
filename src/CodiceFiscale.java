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
    private String cfiscale;
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
        /*CODICE DI CONTROLLO*/
        public String Ccodcon()
        {
          char vett_pari[] = new char[14];
       for (int i=1,v=0;i<=14;i+=2,v++)
       {
           vett_pari[v] = cfiscale.charAt(i);
        //   System.out.print("vett_pari["+v+"]="+vett_pari[v]);
          //  System.out.println();
       }
        //metto le celle del vettore in posizione dispari nel vettore dispari
       char vett_disp[] = new char[14];
       for (int i=0,v=0;i<=14;i+=2,v++) 
       {
           vett_disp[v] = cfiscale.charAt(i);
           //System.out.print("vett_disp["+v+"]="+vett_disp[v]);
           // System.out.println();
       }
       
       char[] alpha = new char[26];
       for(int i = 0;i < 26;i++)
       {
           alpha[i] = (char)(97+i);
         //  System.out.println(alpha[i]);
       }
       //converto in numeri il vettore pari secondo la tabella
       int vett_p[] = new int[14];
       for(int i = 0;i < vett_p.length;i++)
       {
           
           if(Character.isDigit(vett_pari[i]))
           {
               switch(vett_pari[i])
              {
                 case'0':{vett_p[i]=0;break;}
                 case'1':{vett_p[i]=1;break;}
                 case'2':{vett_p[i]=2;break;}
                 case'3':{vett_p[i]=3;break;}
                 case'4':{vett_p[i]=4;break;}
                 case'5':{vett_p[i]=5;break;}
                 case'6':{vett_p[i]=6;break;}
                 case'7':{vett_p[i]=7;break;}
                 case'8':{vett_p[i]=8;break;}
                 case'9':{vett_p[i]=9;break;}
               }
           }
            else
           {
              switch(vett_pari[i])
              {
                 case'A':{vett_p[i]=0;break;}
                 case'B':{vett_p[i]=1;break;}
                 case'C':{vett_p[i]=2;break;}
                 case'D':{vett_p[i]=3;break;}
                 case'E':{vett_p[i]=4;break;}
                 case'F':{vett_p[i]=5;break;}
                 case'G':{vett_p[i]=6;break;}
                 case'H':{vett_p[i]=7;break;}
                 case'I':{vett_p[i]=8;break;}
                 case'J':{vett_p[i]=9;break;}
                 case'K':{vett_p[i]=10;break;}
                 case'L':{vett_p[i]=11;break;}
                 case'M':{vett_p[i]=12;break;}
                 case'N':{vett_p[i]=13;break;}
                 case'O':{vett_p[i]=14;break;}
                 case'P':{vett_p[i]=15;break;}
                 case'Q':{vett_p[i]=16;break;}
                 case'R':{vett_p[i]=17;break;}
                 case'S':{vett_p[i]=18;break;}
                 case'T':{vett_p[i]=19;break;}
                 case'U':{vett_p[i]=20;break;}
                 case'V':{vett_p[i]=21;break;}
                 case'W':{vett_p[i]=22;break;}
                 case'X':{vett_p[i]=23;break;}
                 case'Y':{vett_p[i]=24;break;}
                 case'Z':{vett_p[i]=25;break;}
              }
           }
       }
       //converto in numeri il vettore dispari secondo la tabella
        int vett_d[] = new int[14];
       for(int i = 0;i < vett_d.length;i++)
       {
           
           if(Character.isDigit(vett_disp[i]))
           {
               switch(vett_disp[i])
              {
                 case'0':{vett_d[i]=1;break;}
                 case'1':{vett_d[i]=0;break;}
                 case'2':{vett_d[i]=5;break;}
                 case'3':{vett_d[i]=7;break;}
                 case'4':{vett_d[i]=9;break;}
                 case'5':{vett_d[i]=13;break;}
                 case'6':{vett_d[i]=15;break;}
                 case'7':{vett_d[i]=17;break;}
                 case'8':{vett_d[i]=19;break;}
                 case'9':{vett_d[i]=21;break;}
               }
           }
            else
           {
              switch(vett_disp[i])
              {
                 case'A':{vett_d[i]=1;break;}
                 case'B':{vett_d[i]=0;break;}
                 case'C':{vett_d[i]=5;break;}
                 case'D':{vett_d[i]=7;break;}
                 case'E':{vett_d[i]=9;break;}
                 case'F':{vett_d[i]=13;break;}
                 case'G':{vett_d[i]=15;break;}
                 case'H':{vett_d[i]=17;break;}
                 case'I':{vett_d[i]=19;break;}
                 case'J':{vett_d[i]=21;break;}
                 case'K':{vett_d[i]=2;break;}
                 case'L':{vett_d[i]=4;break;}
                 case'M':{vett_d[i]=18;break;}
                 case'N':{vett_d[i]=20;break;}
                 case'O':{vett_d[i]=11;break;}
                 case'P':{vett_d[i]=3;break;}
                 case'Q':{vett_d[i]=6;break;}
                 case'R':{vett_d[i]=8;break;}
                 case'S':{vett_d[i]=12;break;}
                 case'T':{vett_d[i]=14;break;}
                 case'U':{vett_d[i]=16;break;}
                 case'V':{vett_d[i]=10;break;}
                 case'W':{vett_d[i]=22;break;}
                 case'X':{vett_d[i]=25;break;}
                 case'Y':{vett_d[i]=24;break;}
                 case'Z':{vett_d[i]=23;break;}
              }
           }
       }
 //somma del vettore pari
 int sp=0;
 for(int i = 0;i < 14;i++)
 {
     sp = vett_p[i]+sp;
    // System.out.println("vett_p["+i+"]="+vett_p[i]);
 }
 System.out.println("somma delle celle del vettore pari : " + sp);
 //somma del vettore dispari
 int sd=0;
 for(int i = 0;i < 14;i++)
 {
     sd = vett_d[i]+sd;
     //System.out.println("vett_d["+i+"]="+vett_d[i]);
 }
 //System.out.println("somma delle celle del vettore dispari : " + sd);
 //somma vettore pari e dispari e divisione
int s = 0;
s = sp+sd;
//System.out.println("somma dei pari e dei dispari : " + s);
int r = s%26;
//System.out.println("resto della divisione : " + r);
String carattereControllo="";

switch (r) {
case 0:{carattereControllo="A";break;}
case 1:{carattereControllo="B";break;}
case 2:{carattereControllo="C";break;}
case 3:{carattereControllo="D";break;}
case 4:{carattereControllo="E";break;}
case 5:{carattereControllo="F";break;}
case 6:{carattereControllo="G";break;}
case 7:{carattereControllo="H";break;}
case 8:{carattereControllo="I";break;}
case 9:{carattereControllo="J";break;}
case 10:{carattereControllo="K";break;}
case 11:{carattereControllo="L";break;}
case 12:{carattereControllo="M";break;}
case 13:{carattereControllo="N";break;}
case 14:{carattereControllo="O";break;}
case 15:{carattereControllo="P";break;}
case 16:{carattereControllo="Q";break;}
case 17:{carattereControllo="R";break;}
case 18:{carattereControllo="S";break;}
case 19:{carattereControllo="T";break;}
case 20:{carattereControllo="U";break;}
case 21:{carattereControllo="V";break;}
case 22:{carattereControllo="W";break;}
case 23:{carattereControllo="X";break;}
case 24:{carattereControllo="Y";break;}
case 25:{carattereControllo="Z";break;}
}
return carattereControllo;

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
       cfiscale=cfiscale.toUpperCase();
        //metto le celle del vettore in posizione pari nel vettore pari
      String cCcodcon = this.Ccodcon();
      cfiscale = cfiscale.concat(cCcodcon);  
        return GetCfiscale();
    }    
}
