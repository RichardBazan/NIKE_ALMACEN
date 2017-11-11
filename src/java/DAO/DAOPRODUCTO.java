package DAO;
import DTO.DTOPRODUCTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DAOPRODUCTO {
    
    //JASON
    
    public static ResultSet comboProductos(){
        
        ResultSet rs=null;
        
        try {
        CallableStatement cst = Conexion.getConexion().prepareCall("{call listarProductos}");
        rs = cst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    
    //Richard
    
    public List<DTOPRODUCTO> listaProductos(){
                List<DTOPRODUCTO> lista=new ArrayList();
                ResultSet rs=null;
        try{
            CallableStatement cst=Conexion.getConexion().prepareCall("{call listaProductos}");
            rs = cst.executeQuery();
                        while(rs.next()){
                DTOPRODUCTO p=new DTOPRODUCTO(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6));
                lista.add(p);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
        }
    
    public void Eliminar(int cod){
        
        try{
           CallableStatement st=Conexion.getConexion().prepareCall("{call eliminarProducto(?)}");
           st.setInt(1,cod);
           st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
    }

