/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Richard
 */
public class ConexionRichi {
    
    public static Connection getConexion(){
    //oracle
    /*
    String Driver="oracle.jdbc.driver.OracleDriver";
    String URL="jdbc:oracle:thin:@localhost:1521:XE";
    String user="system";
    String password="system";
    // conexion con  mysql
    /*
     String Driver = "com.mysql.jdbc.Driver";
     String URL = "jdbc:mysql://localhost:3306/tienda";
     String user = "root";
     String password = "root";
    */
    //conexion con sql server 
      String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
      String URL = "jdbc:sqlserver://192.168.1.6:1433;dataBaseName=BD_NIKE";
      String user = "jason";
      String password = "12";
          
     Connection cn=null;   
     try{
        Class.forName(Driver);
       cn = DriverManager.getConnection(URL,user,password);
       System.out.print("Conexion OK");
     }catch(Exception ex){
         System.out.print(ex.getMessage());
     }
      return cn;     
    }
    
}
