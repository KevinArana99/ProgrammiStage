/**
 *
 * @author Kevin
 */
package com.BikeSharing.kevin;
import java.util.Calendar;
/**
 *
 * @author Kevin
 */
public abstract class Persona 
{
   private String nome,cognome;
   private int eta;
   private int gg,mm,aaaa;
   private char sesso;
   private String luogoDiNascita;
   private String LuogoDiResidenza;
    protected Persona()
    {
      this.cognome=this.nome=this.luogoDiNascita="";
      this.gg=mm=aaaa=eta=0;
    }
    protected Persona(String cognome, String nome, int gg, int mm, int aaaa, char sesso, String luogoDiNascita,String LuogoDiResidenza)
    {
       Set(cognome,nome,gg,mm,aaaa,sesso,luogoDiNascita,LuogoDiResidenza);        
    }
    protected void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    public void Destroy(Persona u)
    {
        u = null;
    }
    protected void setNome(String nome)
    {
        this.nome = nome;
    }
    protected void setGG(int gg)
    {
        this.gg = gg;
    }
    protected void setMM(int mm)
    {
        this.mm = mm;
    }
    protected void setLuogoDiResidenza(String LuogoDiResidenza)
    {
        LuogoDiResidenza = LuogoDiResidenza.toUpperCase();
        this.LuogoDiResidenza = LuogoDiResidenza;
    }
     protected String getLuogoDiResidenza()
    {
        return LuogoDiResidenza;
    }
    protected void setAAAA(int aaaa)
    {
        this.aaaa = aaaa;
    }
    protected void setluogoDiNascita(String LuogoDiNascita)
    {
        this.luogoDiNascita = luogoDiNascita;
    }
    protected String GetCognome()
    {
        return cognome;
    }
    protected String GetNome()
    {
        return nome;
    }
    protected int [] GetData()
    {
        int vett[];
        vett = new int [3];
        vett[0]=gg;
        vett[1]=mm;
        vett[2]=aaaa;
        return vett;
    }
    protected char GetSesso()
    {
        return sesso;
    }
    protected String GetLuogo()
    {
    return luogoDiNascita;
    }
    protected int GetEta()
    {
       eta = Calendar.YEAR - eta;
       return eta;
    }
    protected boolean Set(String cognome, String nome, int gg, int mm, int aaaa, char sesso, String luogoDiNascita, String LuogoDiResidenza)
    {
        setCognome(cognome);
        setNome(nome);
        setGG(gg);
        setMM(mm);
        setAAAA(aaaa);
        setluogoDiNascita(luogoDiNascita);
        setLuogoDiResidenza(LuogoDiResidenza);
        if(Character.isUpperCase(sesso)){return false;}else{this.sesso = sesso;return true;}   
    }
}
