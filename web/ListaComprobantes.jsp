
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.*,java.sql.*" %>
<%!
int nrodoc;
ResultSet rs;
%> 
<%
    HttpSession ses = request.getSession();
    ses.setAttribute("MSJERESULTADOGUARDARCOMPROBANT",null);
    if (ses.getAttribute("nrodoc")!=null){
        nrodoc= Integer.parseInt(ses.getAttribute("nrodoc").toString());
    }else{
        nrodoc=0;
    }
    ses.setAttribute("nrodoc",null);
    
    if (request.getParameter("txtnrodocumento")!=null){
    int auxnrodoc = Integer.parseInt(request.getParameter("txtnrodocumento"));
    if (auxnrodoc!=0){
        rs = DAOKBCRACOMPROBANTALMACN.ComprobantesNroDocumento(auxnrodoc);
    }else{
        rs=DAOKBCRACOMPROBANTALMACN.ListarComprobantes();
    }
    auxnrodoc=0;
    }else{
        rs=DAOKBCRACOMPROBANTALMACN.ListarComprobantes();
    }
    %>
    
<html>
    <script type="text/javascript">
         function alerta(msje){
                      alert(msje);
                  }
    </script>
    <%
    if (ses.getAttribute("MSJERESULTADOELIMINARCOMPROBANT")!=null){
        String msje = ses.getAttribute("MSJERESULTADOELIMINARCOMPROBANT").toString();
    %>
    <body onload="alerta('<%=msje%>')">
    <%
    ses.setAttribute("MSJERESULTADOELIMINARCOMPROBANT",null);
    }else{
    %>
    <body>
    <%
    }
    %>
    <center>
        <h2>LISTA DE COMPROBANTES</h2>
        <a href="Registro_Comprobante.jsp">RETORNAR</a>
        </center>
    <br>
    <form method="post" action="#">
    <fieldset>
        <legend>Busqueda de comprobante por nro. de documento</legend>
        <h4>NRO. DOCUMENTO</h4>&nbsp;<input type="number" id="txtnrodocumento" name="txtnrodocumento" value="0">
        &nbsp;
        <input type="submit" value="BUSCAR" name="btnbuscar" id="btnbuscar">
    </fieldset>
    </form>
    <br>
        <form>
            <table border="1">
                <tr><th>NRO DOC<th>TIPO DOC<th>PROVEEDOR<th>FECHA<th>SUBTOTAL<th>IGV<th>TOTAL<th>MOTIVO<th>OBSERVACIONES<th>ESTADO
                        <%
                            
                            while (rs.next()){
                                %>
                <tr><td><%=rs.getString(1)%>
                    <td><%=rs.getString(2)%>
                    <td><%=rs.getString(3)%>
                    <td><%=rs.getString(4)%>
                    <td><%=rs.getString(5)%>
                    <td><%=rs.getString(6)%>
                    <td><%=rs.getString(7)%>
                    <td><%=rs.getString(8)%>
                    <td><%=rs.getString(9)%>
                        <%
                        if (rs.getInt(10)==1){
                        %>
                    <td>PENDIENTE
                        <%
                        }
                        else{  
                        %>
                    <td>NO PENDIENTE
                        <%
                        }
                        %>
                    <td><a href="SERKBCRACOMPROBANTALMCN?opcion=1&nrodoc=<%=rs.getInt(1)%>"><input type="button" value="VER DETALLES" id="btnverdetalles" name="btnverdetalles"></a>
                    <td><a href="SERKBCRACOMPROBANTALMCN?opcion=2&nrodoc=<%=rs.getInt(1)%>"><input type="button" value="ELIMINAR" id="btneliminar" name="btneliminar"></a>
                                <%
                            }
                            %>
            </table>
        </form>
            <center>
            <h2>DETALLES DE COMPROBANTE - <%=nrodoc%> -</h2>
            </center>
            <form>
            <table border="1">
                <tr><th>NRO DOC<th>PRODUCTO<th>TARIFA<th>CANTIDAD
                        <%
                            ResultSet rs2 = DAODTALLECOMPROBANTALMACN.DetallesComprobante(nrodoc);
                            while (rs2.next()){
                                %>
                <tr><td><%=rs2.getString(1)%>
                    <td><%=rs2.getString(2)%>
                    <td><%=rs2.getString(3)%>
                    <td><%=rs2.getString(4)%>
                                <%
                            }
                            %>
            </table>
        </form>
            
    </body>
</html>
