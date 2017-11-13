/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author Richard
 */
public class DAOMERCADO {
    
        public static ResultSet listaMercado(){
        
        ResultSet rs=null;
        
        try {
        CallableStatement cst = ConexionRichi.getConexion().prepareCall("{call listaMercado}");
        rs = cst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
}
