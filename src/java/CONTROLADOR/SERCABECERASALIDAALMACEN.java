package CONTROLADOR;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import DTO.*;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
import javax.swing.*;

public class SERCABECERASALIDAALMACEN extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //SESION
        HttpSession ses = request.getSession();
       
        //CABECERA
        if (Integer.parseInt(request.getParameter("opcion"))==1 || Integer.parseInt(request.getParameter("opcion"))==2){
        if (Integer.parseInt(request.getParameter("opcion"))==1){
            String codsalida = request.getParameter("codsalida");
            ses.setAttribute("codsalida",codsalida);
            String pagina = "./ListaSalidas.jsp";
            response.sendRedirect(pagina);
        }else if(Integer.parseInt(request.getParameter("opcion"))==2){
            int codsalida = Integer.parseInt(request.getParameter("codsalida"));
            int res = DAOCABECERASALIDAALMACEN.EliminarSalida(codsalida);
            if (res>0){
                ses.setAttribute("MSJERESULTADOELIMINARSALIDA","REGISTROS ELIMINADOS CORRECTAMENTE.");
            }
            else{
                ses.setAttribute("MSJERESULTADOELIMINARSALIDA","OCURRIÓ ALGO, REGISTROS NO ELIMINADOS.");
            }
            response.sendRedirect("./ListaSalidas.jsp");
        }
            } else{
        int res=0;
        String tipo_doc = request.getParameter("cbtipodocumento");
        int nro_doc = Integer.parseInt(request.getParameter("txtndocumento"));
        String fecha = request.getParameter("txtfecha");
        String motivo = request.getParameter("txtmotivo");
        String observaciones = request.getParameter("txtobservaciones");
       
        //JOptionPane.showMessageDialog(null,tipo_doc+"-"+nro_doc+"-"+fecha+"-"+motivo+"-"+observaciones);
            
        DTOCABECERASALIDAALMACEN dtocabeceraalmacen = new DTOCABECERASALIDAALMACEN();
        dtocabeceraalmacen.setTipodoc(tipo_doc);
        dtocabeceraalmacen.setNrodoc(nro_doc);
        dtocabeceraalmacen.setFecha(fecha);
        dtocabeceraalmacen.setMotivo(motivo);
        dtocabeceraalmacen.setObservaciones(observaciones);
        res+= DAOCABECERASALIDAALMACEN.AgregarCabeceraSalidaAlmacen(dtocabeceraalmacen) ;
        
      
        //DETALLE
        
        int cantFilasProducto = Integer.parseInt(request.getParameter("txtnroregistros"));
        
        int cod_salida = 0;
            try {
                ResultSet rs = DAOCABECERASALIDAALMACEN.CodigoSalidaAutogenerado();
                if (rs.next()){
                 cod_salida= rs.getInt(1);
                }
            } catch (Exception e) {
            }
        
        
        for (int i=1;i<=cantFilasProducto;i++){
        int codprod = Integer.parseInt(request.getParameter("txtcodigo"+String.valueOf(i)));
        int cantidad = Integer.parseInt(request.getParameter("txtcantidad"+String.valueOf(i)));
        DTODETALLESALIDAALMACEN dtodetallesalidaalmacen = new DTODETALLESALIDAALMACEN(cod_salida, codprod, cantidad);
        res+=DAODETALLESALIDAALMACEN.AgregarDetalleSalidaAlmacen(dtodetallesalidaalmacen);
        }
        
        if (res==cantFilasProducto+1){
            ses.setAttribute("MSJERESULTADOGUARDARSALIDA","REGISTROS INGRESADOS CORRECTAMENTE.");
        }else{
            ses.setAttribute("MSJERESULTADOGUARDARSALIDA","OCURRIÓ ALGO, REGISTROS NO INGRESADOS.");
        }
             
        response.sendRedirect("./Registro_Salida.jsp");  
      
        }
        
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
