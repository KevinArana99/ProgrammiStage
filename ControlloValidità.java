package com.BikeSharing.kevin;

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
 * @author Kevin
 */
public class ControlloValidità
{
    private char[] codicefiscale = new char [16];
    String s;
    public ControlloValidità()
    {
        codicefiscale=null;
    }
    public boolean SetControlloValidità (char [] cv)
    {
        if(cv.length==16)
        {
             codicefiscale = cv;
             return true;
        }
        else
        {
             return false;
        }
    }
    public boolean[] calcola()
    {
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
        s= String.valueOf(codicefiscale).substring(11, 15);
        if(trova()==false)
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
        CodiceControllo cc= new CodiceControllo();
        ccontrollo1 = cc.calcola(appoggio);
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
    public boolean trova()
    {
        boolean trovato= false;
        if((Character.isDigit(codicefiscale[11]))||(Character.isLetter(codicefiscale[12]))||(Character.isLetter(codicefiscale[13]))||(Character.isLetter(codicefiscale[14])))
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
               // System.out.println("Comune : " + country[0] + " , Codice catastale : " + country[1]);
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
