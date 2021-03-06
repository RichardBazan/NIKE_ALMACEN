package CONTROLADOR;

import DAO.DAOPRODUCTO;
import DTO.DTOPRODUCTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class SERPRODUCTO extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
               int op=Integer.parseInt(request.getParameter("opc"));
        DAOPRODUCTO obj=new DAOPRODUCTO();
           if(op==1){
    DTOPRODUCTO p=new DTOPRODUCTO();
    p.setDescripcion(request.getParameter("tdes"));
    p.setPrecio(Double.parseDouble(request.getParameter("tpre")));
    p.setTalla(request.getParameter("ttalla"));
    p.setIdmercado(Integer.parseInt(request.getParameter("tmer")));
    obj.Adiciona(p);
    JOptionPane.showMessageDialog(null,"El producto se agregó correctamente");
    
   }
    if(op==2){
      int cod=Integer.parseInt(request.getParameter("cod"));
      
      int dialogButton=JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar este producto?","Alerta", JOptionPane.YES_NO_OPTION);
      if(dialogButton == JOptionPane.YES_OPTION){
      obj.Eliminar(cod); 
      }
    } 
    
       if(op==3){
    DTOPRODUCTO p=new DTOPRODUCTO();
    p.setId(Integer.parseInt(request.getParameter("tcod")));
    p.setDescripcion(request.getParameter("tdes"));
    p.setPrecio(Double.parseDouble(request.getParameter("tpre")));
    p.setTalla(request.getParameter("ttalla"));
    p.setIdmercado(Integer.parseInt(request.getParameter("tmer")));
    obj.EditarProducto(p);
        JOptionPane.showMessageDialog(null,"El producto se editó correctamente");
   }
    
       String pag="/ListaProductos.jsp";
       getServletContext().getRequestDispatcher(pag).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
