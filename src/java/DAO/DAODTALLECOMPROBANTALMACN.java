/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import DTO.*;
/**
 *
 * @author Jason
 */
public class DAODTALLECOMPROBANTALMACN {

    public static int agregarDtalleComprobantAlmacn(DTODTALLECOMPROBANTALMCN dtodtallecomprobantalmacn){
        int res = 0;
        try {
        CallableStatement cst = Conexion.getConexion().prepareCall("{call agregarDtalleComprobantAlmacn(?,?,?,?)}");
        cst.setInt(1,dtodtallecomprobantalmacn.getNro_doc());
        cst.setInt(2,dtodtallecomprobantalmacn.getId_producto());
        cst.setDouble(3,dtodtallecomprobantalmacn.getTarifa());
        cst.setInt(4,dtodtallecomprobantalmacn.getCantidad());
        res = cst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static ResultSet DetallesComprobante(int nrodoc){
        ResultSet rs = null;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call DetallesComprobante(?)}");
            cst.setInt(1, nrodoc);
            rs = cst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
