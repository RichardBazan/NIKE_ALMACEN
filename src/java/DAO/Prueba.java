package DAO;
import java.sql.*;
import DTO.*;
public class Prueba {
    public static void main(String[] args) {
  
        //Conexion.getConexion();
    /*
        ResultSet rs = null;
        try {
            rs = DAOCABECERASALIDAALMACEN.CodigoSalidaAutogenerado();
            while (rs.next()){
                System.out.println("----> " + rs.getString(1));
            }
        } catch (Exception e) {
        }
  */
        DTODETALLESALIDAALMACEN dto = new DTODETALLESALIDAALMACEN(1,1,1000);
        int res = DAODETALLESALIDAALMACEN.AgregarDetalleSalidaAlmacen(dto);
       
        
        /*
        DTODTALLECOMPROBANTALMCN DTO = new DTODTALLECOMPROBANTALMCN(1234567,1,30,2);
        int res = DAODTALLECOMPROBANTALMACN.agregarDtalleComprobantAlmacn(DTO);
                */
        System.out.println(res);
                
    }
    
}
