    package DAO;
import java.sql.*;
import DTO.*;
public class DAOKBCRACOMPROBANTALMACN {

    public static int AgregarKbcraComprobantAlmacn(DTOKBCRACOMPROBANTALMACN dtokbcracomprobantalmacn){
        int res = 0;
        try {
CallableStatement cst = Conexion.getConexion().prepareCall("{call AgregarKbcraComprobantAlmacn(?,?,?,?,?,?,?,?,?,?)}");
cst.setInt(1, dtokbcracomprobantalmacn.getNrodoc());
cst.setString(2,dtokbcracomprobantalmacn.getTipodoc());
cst.setInt(3,dtokbcracomprobantalmacn.getCodproveedor());
cst.setString(4,dtokbcracomprobantalmacn.getFecha());
cst.setDouble(5, dtokbcracomprobantalmacn.getSubtotal());
cst.setDouble(6, dtokbcracomprobantalmacn.getIgv());
cst.setDouble(7, dtokbcracomprobantalmacn.getTotal());
cst.setString(8, dtokbcracomprobantalmacn.getMotivo());
cst.setString(9, dtokbcracomprobantalmacn.getObservaciones());
cst.setInt(10,dtokbcracomprobantalmacn.getEstado());
res = cst.executeUpdate();
        } catch (Exception e) {
        }
        return res;
    }
    
    public static ResultSet ListarComprobantes(){
        ResultSet rs = null;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call ListarComprobantes}");
            rs = cst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public static int EliminarComprobante(int nrodoc){
        int res=0;
        try {
            CallableStatement cst = Conexion.getConexion().prepareCall("{call EliminarComprobante(?)}");
            cst.setInt(1,nrodoc);
            res = cst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
