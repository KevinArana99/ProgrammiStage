import java.util.HashMap;
import java.util.Map;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class Data
{
    private int g,m,a;
    public Data()
    {
        g=m=a=0;
    }
    public Data(int g,int m,int a)
    {
        setData(g,m,a);
    }
    public void setData(int g,int m,int a)
    {
        this.g = g;
        this.m = m;
        this.a = a;
    }
    public int[] getData()
    {
        int v[] = new int[3];
        v[0] = g;
        v[1] = m;
        v[2] = a;
        return v;
    }
    public String calcola(int g,int m,int a,boolean f)
    {
        String vett="";
        //GIORNO
        if(f)
        {
            g+=40;
            this.g = g;
            String giorno = Integer.toString(g);
            char codGiorno[]=new char[2];
            codGiorno[0]=giorno.charAt(2);
            codGiorno[1]=giorno.charAt(3);
            vett = vett.concat(String.valueOf(codGiorno));
        }
        this.g = g;
        vett = vett.concat(String.valueOf((char)g));
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
       
        //ANNO
        String anno = Integer.toString(a);
        char codAnno[]=new char[2];
        codAnno[0]=anno.charAt(2);
        codAnno[1]=anno.charAt(3);
        vett = vett.concat(String.valueOf(codAnno));
        return String.valueOf(vett);
    }
}

