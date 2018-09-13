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
    public Data(int a,int m,int g)
    {
        setData(g,m,a);
    }
    public void setData(int a,int m,int g)
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
    public String calcola(int a,int m,int g,boolean f)
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
        if(f)
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
}

