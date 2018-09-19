/**
 *
 * @author Kevin
 */
package com.BikeSharing.kevin;
import java.util.Random;
public class Utente extends Persona
{
    String cfiscale;
    String password;
    int MAX_ACCESSI;
    int n_accessi;
    public Utente()
    {
        super();
        cfiscale=password="";
    }
    public Utente(String cognome, String nome, int gg, int mm, int aaaa, char sesso, String luogoDiNascita,String LuogoDiResidenza,String cfiscale,String password)
    {
        super(cognome,nome,gg,mm,aaaa,sesso,luogoDiNascita,LuogoDiResidenza);
        this.Set(cfiscale, password);
    }
    public void Destroy(Utente u)
    {
        u = null;
    }
    public void setCfiscale(String cfiscale)
    {
        this.cfiscale = cfiscale;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void Set(String cfiscale,String password)
    {
        this.setCfiscale(cfiscale);
        this.setPassword(password);
    }
    public String getCfiscale()
    {
        return cfiscale;
    }
    public String getPassword()
    {
        return password;
    }
    public String[] Get()
    {
        String[] c = new String[2];
        c[1] = cfiscale;
        c[2] = password;
        return c;
    }
    public String Accesso()
    {
        String code="";
        if(n_accessi <= MAX_ACCESSI)
        {
             n_accessi++;
            char a[] = new char[8];
             a[0] = (char) this.getRandomNumberInRange(65,90);//A-Z
             a[1] = (char) this.getRandomNumberInRange(48,57);//0-9
             a[2] = (char) this.getRandomNumberInRange(97,122);//a-z
             a[3] = (char) this.getRandomNumberInRange(48,57);//0-9
             a[4] = (char) this.getRandomNumberInRange(65,90);//A-Z
             a[5] = (char) this.getRandomNumberInRange(48,57);//0-9
             a[6] = (char) this.getRandomNumberInRange(97,122);//a-z
             a[7] = (char) this.getRandomNumberInRange(48,57);//0-9
        code = String.valueOf(a);
        }
        else
        {
            code="Hai raggiunto il limite massimo dei accessi";
        }
        return code;
    }
    public void CheckUtente()
    {
       if(super.getLuogoDiResidenza().equals("MONZA"))
       {
           if(super.GetEta() >= 65)
           {
               MAX_ACCESSI = 60;
           }
           else
           {
               MAX_ACCESSI = 30;
           }
       }
       else
       {
           if(super.GetEta() >= 65)
           {
               MAX_ACCESSI = 60;
           }
           else
           {
               MAX_ACCESSI = 5;
           }
       }
    }
    public int getMaxAccessi()
    {
        return MAX_ACCESSI;
    }
    private int getRandomNumberInRange(int min,int max)
    {
        if(min >= max)
        {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max-min) + 1 )+ min;
    }
}


