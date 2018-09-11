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

public class Persona {
    
    private String cognome;
    private String nome;
    private int gg, mm, aaaa;
    private char sesso;
    private String lnas;
    private String prv;
    private String cfiscale;
    private String csvFile = "/Users/vubi/Desktop/anno 5/Codici_Catastali.csv";
      final  int D = 20;
    public Persona()
    {
        cognome=nome=lnas=prv="";
        cfiscale="";
        gg=mm=aaaa=0;   
    }
    
     public Persona(String cog, String nom, int g, int m, int a, char sex, String ln, String pv)
    {
       Set(cog,nom,g,m,a,sex,ln,pv);        
    }
    public boolean Set(String c, String n, int g, int m, int a, char uomo, String ln, String pv)
    {
        cognome=c;
        nome=n;
        gg=g;
        mm=m;
        aaaa=a;
        lnas=ln;
        prv=pv;
            
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
    
    public String GetNome(){
        return nome;
    }
    public int [] GetData(){
        int vett[];
        vett = new int [3];
        vett[0]=gg;
        vett[1]=mm;
        vett[2]=aaaa;
        return vett;
    }
    public char GetSesso(){
        return sesso;
    }
    public String GetLuogo(){
    return lnas;
    }
    public String GetProvincia(){
        return prv;
    }
    
    public String GetCfiscale(){
        return cfiscale;
        
    } 
    
    @SuppressWarnings("empty-statement")
	public char [] gest_n(String s)
	{
            char vocali[] = new char[D];
	    char consonanti[] = new char[D];
            char vett[] = new char[3];
		for(int i = 0;i < vocali.length;i++)
                {
                    vocali[i] = ' ';
                }
                for(int i = 0; i < consonanti.length;i++)
                {
                    consonanti[i] = ' ';
                }
		String temp[] = new String[2];
                s = s.replace(" ", "");
                for(int i = 0; i < s.length();i++)
		{
			if(s.charAt(i) == ' ')
			{
				temp = s.split(" ");
				s = String.valueOf(temp[0]);
			    s = s.concat(temp[1]);
			}
                }
                
                int c=0;
                for(int i = 0,v=0;i < s.length();i++)
		{
			switch(s.charAt(i)) 
			{
			case 'a':
				vocali[v] = s.charAt(i);v++;
				break;
			case 'e':
				vocali[v] = s.charAt(i);v++;
				break;
			case 'i':
				vocali[v] = s.charAt(i);v++;
				break;
                       
			case 'o':
				vocali[v] = s.charAt(i);v++;
				break;
                        
			case 'u':
				vocali[v] = s.charAt(i);v++;
				break;
                        
			default :
				consonanti[c] = s.charAt(i);c++;
                                 System.out.println("VETTORE CONSONANTI\nconsonanti["+c+"]="+consonanti[c]);
                        /*if(c > 3)
                        {
                           consonanti[1] = ' ';
                        }
                                */
				break;
                        }
		}
                System.out.println("Cognome : " + s);
		
		
			for(int i = 0; i < vocali.length;i++)
			{
				for(int j = 1;i+j < vocali.length;j++)
				{
					if(vocali[i]==vocali[i+j])
					{
						vocali[i+j] = ' ';
					}
				}
			}
                       
                        int k=1;
                        int l;
			for(l = 1; l < consonanti.length;l++)
			{		
					if(consonanti[l] != consonanti[l-1])
					{
						consonanti[k] = consonanti[l];
                                                k++;
                                              //  c--;
                                         }
                        }
                        for(int i = 0;i < consonanti.length;i++)
                        {
                             System.out.println("VETTORE SENZA DOPPIONI\nconsonanti["+i+"]="+consonanti[i]);
                        }
                       
                          char t[]=new char[D];
                            for(int i = 0,v=0;i < vocali.length;i++)
                            {
                               if(vocali[i]!=' ')
                               {
                                   t[v]=vocali[i];
                                    v++;
                               }
                            }
                          vocali = t;
                          char p[]=new char[D];
                          for(int i = 0,v=0;i < consonanti.length;i++)
                            {
                               if(consonanti[i]!=' ')
                               {
                                   p[v]=consonanti[i];
                                    v++;
                               }
                            }
                          consonanti = p;
                          for(int i = 0 ; i < consonanti.length;i++)
                          {
                              System.out.println("VETTORE SENZA DOPPIONI E SENZA SPAZI\nconsonanti["+i+"]="+consonanti[i]);
                          }
                        
                        if(c>3)
                        {
                             for (int i =0; i< consonanti.length; i++)
                            {
                                if(i==1)
                                {
                                    consonanti[i]= ' ';
                                    String a = String.valueOf(consonanti);
                                    a = a.replace(" ", "");
                                    consonanti = a.toCharArray();
                                 }
                         
                            }
                           for(int i = 0 ; i < consonanti.length;i++)
                          {
                              System.out.println("VETTORE CORRETTO\nconsonanti["+i+"]="+consonanti[i]);
                          }
                        for(int i = 0; i < vett.length ;i++)
                        {
                           vett[i] = consonanti[i];
                           System.out.println(vett[i]);
                        }
                      }
                        if(c == 3)
                        {
                            vett = consonanti;
                          for(int i = 0 ; i < vett.length;i++)
                          {
                              System.out.println("VETTORE CORRETTO\nconsonanti["+i+"]="+vett[i]);
                          }
                        }
                        if(c < 3)
                        {
                           int i = 0;
                       for(;!(vett[i] == '\0');i++);
                      // System.out.println(i);
                       if(i == 2)
                       {
                          vett[2] = vocali[0];
                       }
                       if(i == 1)
                       {
                           vett[1] = vocali[0];
                           vett[2] = vocali[1];
                       }
                      
                        }
                        
                       
                      /* 
                         for(int i = 0;i < vett.length;i++)
                        {
                            if(vett[i]== ' ')
                            {
                                for(int v = 0;v < vett.length;v++,i++)
                                {
                                    vett[i] = 'x';
                                }
                            }
                        
                        }
                        
          
			//System.out.println(s + "\nvocali : " +String.valueOf(vocali));
			//System.out.println("consonanti : " +String.valueOf(consonanti));
                       
	*/
 return vett;
        }
 
       @SuppressWarnings("empty-statement")
	public char [] gest_c(String s)
	{
            char vocali[] = new char[D];
	    char consonanti[] = new char[D];
            char vett[] = new char[3];
		for(int i = 0;i < vocali.length;i++)
                {
                    vocali[i] = ' ';
                }
                for(int i = 0; i < consonanti.length;i++)
                {
                    consonanti[i] = ' ';
                }
		String temp[] = new String[2];
                s = s.replace(" ", "");
		/*
                for(int i = 0; i < s.length();i++)
		{
			if(s.charAt(i) == ' ')
			{
				temp = s.split(" ");
				s = String.valueOf(temp[0]);
			    s = s.concat(temp[1]);
			}
                }
                */
                int c=0;
                for(int i = 0,v=0;i < s.length();i++)
		{
			switch(s.charAt(i)) 
			{
			case 'a':
				vocali[v] = s.charAt(i);v++;
				break;
			case 'e':
				vocali[v] = s.charAt(i);v++;
				break;
			case 'i':
				vocali[v] = s.charAt(i);v++;
				break;
                       
			case 'o':
				vocali[v] = s.charAt(i);v++;
				break;
                        
			case 'u':
				vocali[v] = s.charAt(i);v++;
				break;
                        
			default :
				consonanti[c] = s.charAt(i);c++;
				break;
			}
		}
                //System.out.println("Cognome : " + s);
		
		
			for(int i = 0; i < vocali.length;i++)
			{
				for(int j = 1;i+j < vocali.length;j++)
				{
					if(vocali[i]==vocali[i+j])
					{
						vocali[i+j] = ' ';
					}
				}
			}
                        int k=1;
                        int l;
			for(l = 1; l < consonanti.length;l++)
			{		
					if(consonanti[l] != consonanti[l-1])
					{
						consonanti[k] = consonanti[l];
                                                k++;
                                              //  c--;
			}
                          char t[]=new char[D];
                            for(int i = 0,v=0;i < vocali.length;i++)
                            {
                               if(vocali[i]!=' ')
                               {
                                   t[v]=vocali[i];
                                    v++;
                               }
                            }
                          vocali = t;
                          char p[]=new char[D];
                          for(int i = 0,v=0;i < consonanti.length;i++)
                            {
                               if(consonanti[i]!=' ')
                               {
                                   p[v]=consonanti[i];
                                    v++;
                               }
                            }
                          consonanti = p;
                       
                        for(int i = 0; i < vett.length ;i++)
                        {
                           vett[i] = consonanti[i];
                        }
                      
                        if(c < 3)
                        {
                             int i = 0;
                       for(;!(vett[i] == '\0');i++);
                      // System.out.println(i);
                       if(i == 2)
                       {
                          vett[2] = vocali[0];
                       }
                       if(i == 1)
                       {
                           vett[1] = vocali[0];
                           vett[2] = vocali[1];
                       }
                      
                        }
                      
                       /* 
                         for(int i = 0;i < vett.length;i++)
                        {
                            if(vett[i]== ' ')
                            {
                                for(int v = 0;v < vett.length;v++,i++)
                                {
                                    vett[i] = 'x';
                                }
                            }
                        }
*/
			//System.out.println(s + "\nvocali : " +String.valueOf(vocali));
			//System.out.println("consonanti : " +String.valueOf(consonanti));
                       
	}
 return vett;
        }
    public String Calcola()
    { 
        
        /*  PRENDI LE CONSONANTI 
                */
        
        char consCog[]= this.gest_c(cognome);
        char consNom[]= this.gest_n(nome);
        
       // System.out.println("cognome : "+String.valueOf(consCog));
        //System.out.println("nome : "+String.valueOf(consNom));
        
        /*ANNO DI NASCITA*/
        
        String nasc = Integer.toString(aaaa);
        char codAnno[]=new char[2];
        codAnno[0]=nasc.charAt(2);
         codAnno[1]=nasc.charAt(3);
         
        /*MESE DI NASCITA*/
        
        char codMese;
        
        switch(mm) 
        {
            case 1 :
                codMese= 'A';
                break;
            case 2 :
                codMese= 'B';
                break;
            
            case 3 :
                codMese= 'C';
                break;
                
            case 4 :
                codMese= 'D';
                break;
                
            case 5 :
                codMese= 'E';
                break;    
                
            case 6 :
                codMese= 'H';
                break;    
                
            case 7 :
                codMese= 'L';
                break;
                
            case 8 :
                codMese= 'M';
                break;
                
            case 9 :
                codMese= 'P';
                break;    
                
            case 10 :
                codMese= 'R';
                break;    
                
            case 11 :
                codMese= 'S';
                break;
                
            case 12 :
                codMese= 'T';
                break;    
                
            default :
                return "";
                
        }
        
        
        /*GIORNO DI NASCITA*/
        
        String ggCod = " ";
        if(sesso=='F')
        {
            gg+=40;
        }
            ggCod=Integer.toString(gg);
         if(ggCod.length() == 1)
             ggCod='0'+ggCod;
        /*COMUNE DI NASCITA*/
       /*
        String csvFile = "/Users/Kevin/Documents/Codici_Catastali.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        String codCom = lnas.toUpperCase();
        //lettura del file csv
        try 
        {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {

                // use comma as separator
               
               String[] country = line.split(cvsSplitBy);
               //stampa dati csv
                System.out.println("Comune : " + country[0] + " , Codice catastale : " + country[1]);
              //  if(codCom.equals(country[0]))
               
            }

        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try
                {
                    br.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        */
       String csvFile = "/Users/Kevin/Documents/Codici_Catastali.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        String codCom = lnas.toUpperCase();
       String[] country;
        //lettura del file csv
        try 
        {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                 country = line.split(cvsSplitBy);
               //stampa dati csv
                System.out.println("Comune : " + country[0] + " , Codice catastale : " + country[1]);
              //  if(codCom.equals(country[0]))
               if(codCom.equals(country[0]))
               {
                  codCom = country[1];
                 break;
               }
            }
            
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try
                {
                    br.close();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
      
       
        
        /*CODICE DI CONTROLLO*/
        
        
       cfiscale=String.valueOf(consCog);
       cfiscale+=String.valueOf(consNom);
       cfiscale+=String.valueOf(codAnno);
       cfiscale+=String.valueOf(codMese);
       cfiscale+=String.valueOf(ggCod);
       cfiscale+=String.valueOf(codCom);
       cfiscale=cfiscale.toUpperCase();
        //metto le celle del vettore in posizione pari nel vettore pari
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
 System.out.println("somma delle celle del vettore dispari : " + sd);
 //somma vettore pari e dispari e divisione
int s = 0;
s = sp+sd;
System.out.println("somma dei pari e dei dispari : " + s);
int r = s%26;
System.out.println("resto della divisione : " + r);
/*      int sommaPari=0;
for (int i=1;i<=14;i+=2){
switch (cfiscale.charAt(i)) {
case '0': {sommaPari+=0;break;}
case '1': {sommaPari+=1;break;}
case '2': {sommaPari+=2;break;}
case '3': {sommaPari+=3;break;}
case '4': {sommaPari+=4;break;}
case '5': {sommaPari+=5;break;}
case '6': {sommaPari+=6;break;}
case '7': {sommaPari+=7;break;}
case '8': {sommaPari+=8;break;}
case '9': {sommaPari+=9;break;}
case 'A': {sommaPari+=0;break;}
case 'B': {sommaPari+=1;break;}
case 'C': {sommaPari+=2;break;}
case 'D': {sommaPari+=3;break;}
case 'E': {sommaPari+=4;break;}
case 'F': {sommaPari+=5;break;}
case 'G': {sommaPari+=6;break;}
case 'H': {sommaPari+=7;break;}
case 'I': {sommaPari+=8;break;}
case 'J': {sommaPari+=9;break;}
case 'K': {sommaPari+=10;break;}
case 'L': {sommaPari+=11;break;}
case 'M': {sommaPari+=12;break;}
case 'N': {sommaPari+=13;break;}
case 'O': {sommaPari+=14;break;}
case 'P': {sommaPari+=15;break;}
case 'Q': {sommaPari+=16;break;}
case 'R': {sommaPari+=17;break;}
case 'S': {sommaPari+=18;break;}
case 'T': {sommaPari+=19;break;}
case 'U': {sommaPari+=20;break;}
case 'V': {sommaPari+=21;break;}
case 'W': {sommaPari+=22;break;}
case 'X': {sommaPari+=23;break;}
case 'Y': {sommaPari+=24;break;}
case 'Z': {sommaPari+=25;break;}
}
}
int sommaDispari=0;
for (int i=0;i<=13;i+=2) {
switch (cfiscale.charAt(i)) {
case '0': {sommaDispari+=1;break;}
case '1': {sommaDispari+=0;break;}
case '2': {sommaDispari+=5;break;}
case '3': {sommaDispari+=7;break;}
case '4': {sommaDispari+=9;break;}
case '5': {sommaDispari+=13;break;}
case '6': {sommaDispari+=15;break;}
case '7': {sommaDispari+=17;break;}
case '8': {sommaDispari+=19;break;}
case '9': {sommaDispari+=21;break;}
case 'A': {sommaDispari+=1;break;}
case 'B': {sommaDispari+=0;break;}
case 'C': {sommaDispari+=5;break;}
case 'D': {sommaDispari+=7;break;}
case 'E': {sommaDispari+=9;break;}
case 'F': {sommaDispari+=13;break;}
case 'G': {sommaDispari+=15;break;}
case 'H': {sommaDispari+=17;break;}
case 'I': {sommaDispari+=19;break;}
case 'J': {sommaDispari+=21;break;}
case 'K': {sommaDispari+=2;break;}
case 'L': {sommaDispari+=4;break;}
case 'M': {sommaDispari+=18;break;}
case 'N': {sommaDispari+=20;break;}
case 'O': {sommaDispari+=11;break;}
case 'P': {sommaDispari+=3;break;}
case 'Q': {sommaDispari+=6;break;}
case 'R': {sommaDispari+=8;break;}
case 'S': {sommaDispari+=12;break;}
case 'T': {sommaDispari+=14;break;}
case 'U': {sommaDispari+=16;break;}
case 'V': {sommaDispari+=10;break;}
case 'W': {sommaDispari+=22;break;}
case 'X': {sommaDispari+=25;break;}
case 'Y': {sommaDispari+=24;break;}
case 'Z': {sommaDispari+=23;break;}
}
}
int interoControllo = (sommaPari+sommaDispari)%26;
*/
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
      cfiscale = cfiscale.concat(carattereControllo);  
        return GetCfiscale();
    }

    
}
