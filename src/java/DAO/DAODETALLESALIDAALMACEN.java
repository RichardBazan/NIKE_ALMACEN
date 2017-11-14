package DAO;
import java.sql.*;
import DTO.*;

public class DAODETALLESALIDAALMACEN {
    
    public static int AgregarDetalleSalidaAlmacen(DTODETALLESALIDAALMACEN dtodetallesalidaalmacen){
        int res = 0;
        try {
        CallableStatement cst = Conexion.getConexion().prepareCall("{call AgregarDetalleSalidaAlmacen(?,?,?)}");
        cst.setInt(1,dtodetallesalidaalmacen.getCod_salida());
        cst.setInt(2,dtodetallesalidaalmacen.getId_producto());
        cst.setInt(3,dtodetallesalidaalmacen.getCantidad());
        res = cst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static ResultSet DetallesSalida(int codsalida){
        ResultSet rs = null;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call DetallesSalida(?)}");
            cst.setInt(1,codsalida);
            rs = cst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
