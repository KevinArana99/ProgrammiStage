
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vubi
 */
public class LuogoDiNascita {
     private String lnas;
     
      public LuogoDiNascita()
    {
        lnas="";
    }
     public LuogoDiNascita(String lns )
    {
       setLuogoDiNascita(lns);        
    }
    public void setLuogoDiNascita( String lns)
    {
        lnas= lns;
    }
    
    public String calcola (String a)
        {
            
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
      return codCom;
        }
    
    
}
