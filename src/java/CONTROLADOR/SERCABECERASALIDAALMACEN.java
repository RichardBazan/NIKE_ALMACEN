package CONTROLADOR;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import DTO.*;
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
            String nrodoc = request.getParameter("nrodoc");
            ses.setAttribute("nrodoc",nrodoc);
            String pagina = "./ListaComprobantes.jsp";
            response.sendRedirect(pagina);
        }else if(Integer.parseInt(request.getParameter("opcion"))==2){
            int nrodoc = Integer.parseInt(request.getParameter("nrodoc"));
            int res = DAOKBCRACOMPROBANTALMACN.EliminarComprobante(nrodoc);
            if (res>0){
                ses.setAttribute("MSJERESULTADOELIMINARCOMPROBANT","REGISTROS ELIMINADOS CORRECTAMENTE.");
            }
            else{
                ses.setAttribute("MSJERESULTADOELIMINARCOMPROBANT","OCURRIÓ ALGO, REGISTROS NO ELIMINADOS.");
            }
            response.sendRedirect("./ListaComprobantes.jsp");
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
        
       /*
        //DETALLE
        
        int cantFilasProducto = Integer.parseInt(request.getParameter("txtnroregistros"));
        
        for (int i=1;i<=cantFilasProducto;i++){
        int codprod = Integer.parseInt(request.getParameter("txtcodigo"+String.valueOf(i)));
        double tarifa = Double.parseDouble(request.getParameter("txttarifa"+String.valueOf(i)));
        int cantidad = Integer.parseInt(request.getParameter("txtcantidad"+String.valueOf(i)));
        DTODTALLECOMPROBANTALMCN dtodtallecomprobantalmacn = new DTODTALLECOMPROBANTALMCN(nro_doc,codprod, tarifa, cantidad);
        res+=DAODTALLECOMPROBANTALMACN.agregarDtalleComprobantAlmacn(dtodtallecomprobantalmacn);
        }
        
        if (res==cantFilasProducto+1){
            ses.setAttribute("MSJERESULTADOGUARDARCOMPROBANT","REGISTROS INGRESADOS CORRECTAMENTE.");
        }else{
            ses.setAttribute("MSJERESULTADOGUARDARCOMPROBANT","OCURRIÓ ALGO, REGISTROS NO INGRESADOS.");
        }
             
        response.sendRedirect("./Registro_Comprobante.jsp");  
        */
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
