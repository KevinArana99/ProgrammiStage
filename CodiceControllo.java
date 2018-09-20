package com.BikeSharing.kevin;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Kevin
 */
public class CodiceControllo extends CodiceFiscale
{
    char Ccontrollo;
    String cfiscale="";
    
    public CodiceControllo()
    {
        Ccontrollo=' ';
    }   
    public char calcola(String cfiscale)
    {
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
}
