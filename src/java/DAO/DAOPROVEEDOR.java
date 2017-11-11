package DAO;
import java.sql.*;

public class DAOPROVEEDOR {
    
  
    
    public static ResultSet ListarProveedor(){
        ResultSet rs=null;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call listar_proveedor}");
            rs = cst.executeQuery();
        } catch (Exception e) {
           
        }
        return rs;
    }
}
