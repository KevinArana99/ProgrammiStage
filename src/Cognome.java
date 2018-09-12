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
    public String calcola(String s)
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
                            this.setCognome(String.valueOf(vett));
                            return getCognome();
    }   
}
