/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BikeSharing.kevin;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Kevin
 */
public class MyConnection 
{
    public static Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&useJDBCComplicantTimezoneShift=true&useLegacyDateTimeCode=false&serverTimezone=UTC","root","");
            System.out.println("connessione con il driver jdbc..");
        }catch(Exception e)
        {
            System.out.println("Errore di connessione con il driver jdbc..");
            System.out.println(e.getMessage());
        }
        return con;
    }
}
