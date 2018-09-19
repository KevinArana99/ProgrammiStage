/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BikeSharing.kevin;

/**
 *
 * @author Kevin
 */
public class Screenscreen 
{
    public static void main(String[] args)
    {
        Splash splash = new Splash();
        Portale p = new Portale();
        splash.setVisible(true);
        splash.setLocationRelativeTo(null);
        splash.pack();
        splash.setVisible(true);
        try
        {
            for(int i = 0;i <= 100;i++)
           {
            Thread.sleep(60);
            splash.CaricamentoText.setText(Integer.toString(i)+"%");
            splash.Barra.setValue(i);
            if(i==100)
            {
               splash.setVisible(false);
               p.setVisible(true);
            }
           }
        }catch(Exception e){}  
    }
}
