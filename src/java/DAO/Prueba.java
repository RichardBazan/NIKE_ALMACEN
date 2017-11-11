package DAO;
import java.sql.*;
import DTO.*;
public class Prueba {
    public static void main(String[] args) {
  
        //Conexion.getConexion();
        
        /*ResultSet rs = null;
        try {
            rs = DAOPRODUCTO.listarProductos();
            while (rs.next()){
                System.out.println("----> " + rs.getString(2));
            }
        } catch (Exception e) {
        }
  /*
        DTOKBCRACOMPROBANTALMACN dto = new DTOKBCRACOMPROBANTALMACN();
        dto.setNrodoc(12345);
        dto.setTipodoc("B");
        dto.setCodproveedor(1);
        dto.setFecha("2017-11-03");
        dto.setMotivo("jajaja");
        dto.setObservaciones("jejeje");
        dto.setEstado(1);
        dto.setTotal(400);
        
        int res = DAOKBCRACOMPROBANTALMACN.AgregarKbcraComprobantAlmacn(dto);
        System.out.println(res);
        
        */
        
        /*
        DTODTALLECOMPROBANTALMCN DTO = new DTODTALLECOMPROBANTALMCN(1234567,1,30,2);
        int res = DAODTALLECOMPROBANTALMACN.agregarDtalleComprobantAlmacn(DTO);
        System.out.println(res);
                */
    }
    
}
