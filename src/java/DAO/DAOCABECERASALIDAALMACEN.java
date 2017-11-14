package DAO;
import DTO.*;
import java.sql.*;
public class DAOCABECERASALIDAALMACEN {
    public static int AgregarCabeceraSalidaAlmacen(DTOCABECERASALIDAALMACEN dtocabecerasalidalmacen){
        int res = 0;
        try {
CallableStatement cst = Conexion.getConexion().prepareCall("{call AgregarCabeceraSalidaAlmacen(?,?,?,?,?)}");
cst.setString(1,dtocabecerasalidalmacen.getTipodoc());
cst.setInt(2,dtocabecerasalidalmacen.getNrodoc());
cst.setString(3,dtocabecerasalidalmacen.getFecha());
cst.setString(4, dtocabecerasalidalmacen.getMotivo());
cst.setString(5, dtocabecerasalidalmacen.getObservaciones());
res = cst.executeUpdate();
        } catch (Exception e) {
        }
        return res;
    }
    
    public static ResultSet CodigoSalidaAutogenerado(){
        ResultSet rs = null;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call CodigoSalidaAutogenerado}");
            rs = cst.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
    
    public static ResultSet ListarSalidas(){
        ResultSet rs = null;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call ListaSalidas}");
            rs = cst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public static int EliminarSalida(int codsalida){
        int res=0;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call EliminarSalida(?)}");
            cst.setInt(1,codsalida);
            res = cst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public static ResultSet SalidaCodSalida(int codsalida){
        ResultSet rs = null;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call SalidaCodSalida(?)}");
            cst.setInt(1, codsalida);
            rs = cst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
