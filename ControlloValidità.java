import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author vubi
 */
public class ControlloValidità {
    
    private char[] codicefiscale = new char [16];
    String s;
    
    public ControlloValidità()
    {
        codicefiscale=null;
    }
    public void ControlloValidità (char [] cv)
    {
    codicefiscale=cv;
    }
    public boolean calcola()
    {
       
        int i=0;
    for(; i<6;i++){
        if(!Character.isAlphabetic(codicefiscale[i]))
            return false;
    }
    for(;i<8;i++){
        if(!Character.isDigit(codicefiscale[i]))
            return false;
    }
    char vett[] ={'A','B','C','D','E','H','L','M','P','R','S','T'};
    for (int j=0; j<vett.length; j++)
    {
        if(codicefiscale[i]!=vett[j])
            return false;
    }
      for(;i<12;i++){
        if(!Character.isDigit(codicefiscale[i]) )
            return false;
      }
      s= String.valueOf(codicefiscale).substring(12, 15);
      
      if(!trova())return false;
      
      char ccontrollo,ccontrollo1;
      
      ccontrollo= codicefiscale[16];
      String appoggio = String.valueOf(codicefiscale).substring(1, codicefiscale.length-1);
      CodiceControllo cc= new CodiceControllo();
      ccontrollo1 = cc.calcola(appoggio);
     if(ccontrollo!=ccontrollo1)
     {
         return false;
     }
      return true;
     
    }
    
    
    
    
    public boolean trova()
    {
          String csvFile = "/Users/vubi/Desktop/anno 5/stage/Codici_Catastali.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
       String[] country;
       boolean trovato= false;
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
               if(s.equals(country[1]))
               {
                  trovato=true;
                 
               }else
               {
                   trovato=false;
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
      
      return trovato;
        }
    
}


            
    

