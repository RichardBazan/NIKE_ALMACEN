package DAO;
import DTO.DTOPRODUCTO;
import DTO.DTOTALLA;
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
            CallableStatement cst=ConexionRichi.getConexion().prepareCall("{call listaProductos}");
            rs = cst.executeQuery();
                        while(rs.next()){
                DTOPRODUCTO p=new DTOPRODUCTO(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9));
                lista.add(p);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
        }
    
    public void Eliminar(int cod){
        
        try{
           CallableStatement st=ConexionRichi.getConexion().prepareCall("{call eliminarProducto(?)}");
           st.setInt(1,cod);
           st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }   
      }
    
      public void Adiciona(DTOPRODUCTO p){
   try{
    CallableStatement st=ConexionRichi.getConexion().prepareCall
        ("{call agregarProducto(?,?,?,?)}");
    st.setString(1,p.getDescripcion());
    st.setDouble(2, p.getPrecio());
    st.setString(3, p.getTalla());
    st.setInt(4,p.getIdmercado());
    st.executeUpdate();
   }catch(Exception ex){
   ex.printStackTrace();
   }   
  }
      
    public static ResultSet listaTalla(){
        
        ResultSet rs=null;
        
        try {
        CallableStatement cst = ConexionRichi.getConexion().prepareCall("{call listaTalla}");
        rs = cst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
      public void EditarProducto(DTOPRODUCTO p){
   try{
    CallableStatement st=ConexionRichi.getConexion().prepareCall
        ("{call editarProducto(?,?,?,?,?)}");
    st.setInt(1,p.getId() );
    st.setString(2,p.getDescripcion());
    st.setDouble(3, p.getPrecio());
    st.setString(4, p.getTalla());
    st.setInt(5,p.getIdmercado());
    st.executeUpdate();
   }catch(Exception ex){
   ex.printStackTrace();
   }   
  }
    
    }

