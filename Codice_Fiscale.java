/**
 *
 * @author Kevin
 */
package com.BikeSharing.kevin;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@SuppressWarnings("FieldNameHidesFieldInSuperclass")
public class Codice_Fiscale 
{
    private String cfiscale;
    final private String CSVFILE = "/Users/Kevin/Documents/Codici_Catastali.csv";
    final private int D = 20;
    public Codice_Fiscale()
    {
        cfiscale = "";
    }
    public Codice_Fiscale(String cfiscale)
    {
        this.cfiscale = cfiscale;
    }
    public String GetCfiscale()
    {
        return cfiscale;     
    }
    @SuppressWarnings("empty-statement")
    public String CalcolaNome(String s) 
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
              
                         boolean doppia;
                         
                        if(c>3)
                        { 
                          String appoggio = String.valueOf(consonanti);
                          doppia = doppie(appoggio);
                          if (doppia=false)
                          {
                              
                              int k=1;
                              int l;
			for(l = 1; l < consonanti.length;l++)
			{		
					if(consonanti[l] != consonanti[l-1])
					{
						consonanti[k] = consonanti[l];
                                                k++;
                                         }
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
                         
                          for(int i = 0; i < vett.length;i++)
                          {
                              vett[i] = consonanti[i];
                          }
                          }
                          else
                          {
                            
                            for (int i =0; i< consonanti.length;i++)
                            {
                                if(i==1)
                                {
                                    consonanti[i]= ' ';
                                    String a = String.valueOf(consonanti);
                                    a = a.replace(" ", "");
                                    consonanti = a.toCharArray();
                                 }
                         
                            }
                            for(int i = 0; i < vett.length ;i++)
                            {
                                vett[i] = consonanti[i];
                            }
                        }
                        }
                      if(c==3)
                      {
                         
                          consonanti=DeleteSpace(consonanti);
                          vett = consonanti;
                      }
                        if(c < 3)
                        {
                        
                          consonanti=DeleteSpace(consonanti);
                          vocali=DeleteSpace(vocali);
                          int k=0;
                          for( int i=0 ; i < vett.length && i < consonanti.length;i++)
                          {
                              if((!Character.isSpaceChar(vett[i]))||(!Character.isWhitespace(vett[i])))
                              {
                                    vett[i] = consonanti[i];
                                    k++;
                              }
                               
                          }
                          int i=k;
                             for( int v=0; i < vett.length && v< vocali.length;i++, v++)
                          {
                              if((!Character.isSpaceChar(vett[i]))||(!Character.isWhitespace(vett[i])))
                              {
                                    vett[i] = vocali[v];
                                    k++;
                              }
                          }
                        
                           
                         
                        for(;i < vett.length;i++)
                        {
                            vett[i] = 'x';
                        }
                           return String.valueOf(vett);
                          
                        }
                         return String.valueOf(vett);
        
    
}
    public String CalcolaCognome(String s)
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
        consonanti=DeleteSpace(consonanti);
             vocali=DeleteSpace(vocali);
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
                        boolean doppia;
                        if(c>3)
                        { 
                            String appoggio = String.valueOf(consonanti);
                            doppia = doppie(appoggio);
                          if (doppia)
                          {
                              int k=1;
                              int l;
                            for(l = 1; l < consonanti.length;l++)
                            {		
				if(consonanti[l] != consonanti[l-1])
				{
					consonanti[k] = consonanti[l];
                                        k++;
                                }
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
                         
                          for(int i = 0; i < vett.length;i++)
                          {
                              vett[i] = consonanti[i];
                          }
                          }
                          else
                          {
                            for(int i = 0; i < vett.length ;i++)
                            {
                                vett[i] = consonanti[i];
                            }
                        }
                          
                    }
                         if(c==3)
                        {
                          consonanti=DeleteSpace(consonanti);
                          vett = consonanti;
                         }
                         
                         
                              if(c < 3)
                        {
                        
                          consonanti=DeleteSpace(consonanti);
                          vocali=DeleteSpace(vocali);
                          int k=0;
                          for( int i=0 ; i < vett.length && i < consonanti.length;i++)
                          {
                              if((!Character.isSpaceChar(vett[i]))||(!Character.isWhitespace(vett[i])))
                              {
                                    vett[i] = consonanti[i];
                                    k++;
                              }
                               
                          }
                          int i=k;
                             for( int v=0; i < vett.length && v< vocali.length;i++, v++)
                          {
                              if((!Character.isSpaceChar(vett[i]))||(!Character.isWhitespace(vett[i])))
                              {
                                    vett[i] = vocali[v];
                                    k++;
                              }
                          } 
                        for(;i < vett.length;i++)
                        {
                            vett[i] = 'x';
                        }
                           return String.valueOf(vett); 
                        }
                         return String.valueOf(vett);                   
    }
    public String CalcolaData(int a,int m,int g,char s)
    {
        String vett = "";
         //ANNO
        char cifre[] = new char[2];
        cifre[0] = String.valueOf(a).toCharArray()[2];
        cifre[1] = String.valueOf(a).toCharArray()[3];
        vett = vett.concat(String.valueOf(cifre));
        //MESE      
        Map mesi  = new HashMap();
        mesi.put(1,'A');
        mesi.put(2,'B');
        mesi.put(3,'C');
        mesi.put(4,'D');
        mesi.put(5,'E');
        mesi.put(6,'H');
        mesi.put(7,'L');
        mesi.put(8,'M');
        mesi.put(9,'P');
        mesi.put(10,'R');
        mesi.put(11,'S');
        mesi.put(12,'T');
        if(mesi.containsKey(m))
            vett = vett.concat(String.valueOf(mesi.get(m)));
         System.out.println(vett);
          //GIORNO
        if(s=='f'||s=='F')
        {
            g=g+40;
            String giorno = Integer.toString(g);
            vett = vett.concat(giorno);
            System.out.println(vett);
        }
        else
        {
            if (g < 10)
            {
               vett=vett.concat("0");
               String giorno = Integer.toString(g);
              vett = vett.concat(giorno);
            }
            else
            {
              String giorno = Integer.toString(g);
              vett = vett.concat(giorno);
            }
        }
        return String.valueOf(vett);
    }
    public String CalcolaCodiceCatastale(String s)
    {      
       String csvFile = "/Users/Kevin/Documents/Codici_Catastali.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        String codCom = s.toUpperCase();
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
      return codCom;
    }
    public char CalcolaCodiceControllo(String cfiscale)
    {
        char Ccontrollo;
       String cf = cfiscale;
       int val=0,p=0;
       int t[] = {1,0,5,7,9,13,15,17,19,21,1,0,5,7,9,13,15,17,19,21,2,4,18,20,11,3,6,8,12,14,16,10,22,25,24,23};
       Map <Character, Integer> Table = new HashMap<>();
       Map <Integer, Character> Resto = new HashMap<>();
       for(int i = 0,v=48;i < 10 || v < 58;i++,v++){Table.put((char)v,i);}
       for(int i = 0,v=65;i < 26 || v < 90;i++,v++){Table.put((char)v,i);}
       for(int i = 1;i < 14;i+=2){val = Table.get(cf.charAt(i))+ val;}
       for(int k=48;p < t.length && k < 58;p++,k++){Table.replace((char)k,t[p]);}
       for(int k=65;p < t.length && k < 91;p++,k++){Table.replace((char)k,t[p]);}
       for(int i = 0;i < 15;i+=2){val = Table.get(cf.charAt(i))+val;}
       val = val%26; 
        for(int k=65,i=0;k < 91 && i < 26;i++,k++){Resto.put(i,(char)k);}
        Ccontrollo = Resto.get(val);
        return Ccontrollo;
    }
    private boolean doppie(String str) 
    {
        return (str.matches(".*(.)\\1.*"));
    }
    public void Destroy(Codice_Fiscale u)
    {
        u = null;
    }
    private char[] DeleteSpace(char[] d)
    {
        String a = String.valueOf(d);
        a = a.replace(" ", "");
        d= a.toCharArray();
        return d;
    }
    public String Calcola(String cognome, String nome, int gg, int mm, int aaaa, char sesso, String luogoDiNascita)
    {  
        cfiscale = cfiscale.concat(this.CalcolaCognome(cognome));
        cfiscale = cfiscale.concat(this.CalcolaNome(nome));
        cfiscale = cfiscale.concat(this.CalcolaData(gg,mm,aaaa,sesso));
        cfiscale = cfiscale.concat(this.CalcolaCodiceCatastale(luogoDiNascita));
        cfiscale=cfiscale.toUpperCase();
        cfiscale = cfiscale.concat(String.valueOf(this.CalcolaCodiceControllo(cfiscale)));
        return GetCfiscale();
    }    
     public boolean SetControlloValidità (String cfiscale)
    {
        char[] cv = cfiscale.toCharArray();
        if(cv.length==16)
        {
             cfiscale = String.valueOf(cv);
             return true;
        }
        else
        {
             return false;
        }
    }
    public boolean[] check(String codice_fiscale)
    {
        char[] codicefiscale = new char[16];
        codicefiscale = codice_fiscale.toCharArray();
        boolean controllo[] = new boolean[7];
        for(int k=0;k<controllo.length;k++)controllo[k]=true;
        if((!Character.isLetter(codicefiscale[0]))||(!Character.isLetter(codicefiscale[1]))||(!Character.isLetter(codicefiscale[2])))
        {controllo[0] = false;}
        else{controllo[0] = true;}
        if((!Character.isLetter(codicefiscale[3]))||(!Character.isLetter(codicefiscale[4]))||(!Character.isLetter(codicefiscale[5])))
        {controllo[1] = false;}
        else{controllo[1] = true;}
        int a;
        System.out.println("String.valueOf(codicefiscale).charAt(6) : "+String.valueOf(codicefiscale).charAt(6));
        System.out.println("String.valueOf(codicefiscale).charAt(8) : "+String.valueOf(codicefiscale).charAt(7));
        if(Character.isDigit(String.valueOf(codicefiscale).charAt(6))&& Character.isDigit(String.valueOf(codicefiscale).charAt(7)))
        {
           a = Integer.valueOf(String.valueOf(codicefiscale).substring(6, 7));
          System.out.println("if del anno, a vale "+a);
          if(Integer.valueOf(a) < 0 || Integer.valueOf(a) > 99){controllo[2]=false;}
         else{controllo[2]=true;System.out.println("else del anno, a vale "+a);}
        }
         else{controllo[2] = false;}
         char vett[] ={'A','B','C','D','E','H','L','M','P','R','S','T'};
        for (int j=0; j<vett.length; j++)
        {
          if(codicefiscale[8]!=vett[j])
          {
             controllo[3] = false;
          } 
          else
          { 
              controllo[3] = true;
              break;
          }   
        }
    int b; 
    if(Character.isDigit(String.valueOf(codicefiscale).charAt(9))&&Character.isDigit(String.valueOf(codicefiscale).charAt(10)))
    {
        b = Integer.valueOf(String.valueOf(codicefiscale).substring(9, 11));
        if(Integer.valueOf(b) < 0 || Integer.valueOf(b) > 71){controllo[4]=false;}
        else{controllo[4]=true;}
    }
    else
    {
        controllo[4] = false;
    }
        String s= String.valueOf(codicefiscale).substring(11, 15);
        if(trova(codicefiscale,s)==false)
        {  
            controllo[5] = false;
        }
        else
        {
            controllo[5] = true;
        }
        char ccontrollo,ccontrollo1;
        ccontrollo = codicefiscale[15];
        String appoggio = String.valueOf(codicefiscale).substring(0, codicefiscale.length-1);
        ccontrollo1 = this.CalcolaCodiceControllo(appoggio);
      if(ccontrollo!=ccontrollo1)
     {
         System.out.println("Codice di controllo errato");
         controllo[6] = false;
     }
     else
     {
         System.out.println("Codice di controllo giusto");
         controllo[6] = true;
     }
      return controllo;
 }     
    public boolean trova(char[] codicefiscale,String s)
    {
        boolean trovato= false;
        System.out.println(String.valueOf(codicefiscale).substring(11, 15));
        if(Character.isDigit(String.valueOf(codicefiscale).charAt(11))||Character.isLetter(String.valueOf(codicefiscale).charAt(12))||Character.isLetter(String.valueOf(codicefiscale).charAt(13))||Character.isLetter(String.valueOf(codicefiscale).charAt(14)))
        {
            trovato = false;
        }
        else
        {
        String csvFile = "C:\\Users\\Kevin\\Desktop\\programmi stage\\Codici_Catastali.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
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
                if((s.equals(country[1])))
               {
                  trovato = true; 
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
        }
      return trovato;
    }   
}
