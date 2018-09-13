/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class Cognome 
{
    //datamember
    private String cognome;
    final int D = 14;
    //attributi
    public Cognome()
    {
        cognome = "";
    }
    public Cognome(String cognome)
    {
        this.setCognome(cognome);
    }
    public String getCognome()
    {
        return cognome;
    }
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    @SuppressWarnings("empty-statement")
    public String calcola(String s)
    {
        char vocali[] = new char[D];
	char consonanti[] = new char[D];
        char vett[] = new char[3];
      // consonanti=DeleteSpace(consonanti);
      // vocali=DeleteSpace(vocali);
                          
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
                             /*
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
                              */
                        
                            for(int i = 0; i < vett.length ;i++)
                            {
                                vett[i] = consonanti[i];
                            }
                        }
  
             
             
             
             
             /*
             
                int m=1;
                int l;
             for(l = 1; l < consonanti.length;l++)
	     {		
		if(consonanti[l] != consonanti[l-1])
		{
                    consonanti[m] = consonanti[l];
                    m++;
                    //  c--;
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
                        for(int i = 0; i < vett.length ;i++)
                        {
                           vett[i] = consonanti[i];
                        }
                        */
                         if(c==3)
                        {
                          consonanti=DeleteSpace(consonanti);
                          vett = consonanti;
                         }
                         if(c < 3)
                        {
                        
                          int k=0;
                          consonanti=DeleteSpace(consonanti);
                          vocali=DeleteSpace(vocali);
                          
                          for( int i=0 ; i < vett.length && i < consonanti.length;i++)
                          {
                              if((Character.isLetter(vett[i])) || !(Character.isSpaceChar(vett[i]))||!(Character.isWhitespace(vett[i])))
                              {
                                    vett[i] = consonanti[i];
                                    k++;
                              }
                               
                          }
                          int i=k;
                          for( int v=0; i < vett.length && v< vocali.length;i++, v++)
                          {
                              if((Character.isLetter(vett[i])))
                              {
                                    vett[i] = vocali[v];
                                    k++;
                                    System.out.println("vett["+ i+"]="+vett[i]);
                                    System.out.println("vocali["+ i +"]="+vocali[v]);
                                    System.out.println("k vale "+ i);
                              }
                          }
                        
                        System.out.println("i vale "+ i);
                        for(;i < vett.length;i++)
                        {
                            System.out.println("sono dentro il for delle x");
                            vett[i] = 'x';
                        }
                        
                           this.setCognome(String.valueOf(vett));
                           return getCognome(); 
                        }
                        
                         
                        
    } 
                         this.setCognome(String.valueOf(vett)); 
                         return getCognome();
   }
    public char[] DeleteSpace(char[] d)
    {
        String a = String.valueOf(d);
        a = a.replace(" ", "");
        d= a.toCharArray();
        return d;
    }
     public static boolean doppie(String str) 
    {
        return (str.matches(".*(.)\\1.*"));
    }
}
