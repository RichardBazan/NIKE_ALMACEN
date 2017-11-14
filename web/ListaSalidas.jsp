
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.*,java.sql.*" %>
<%!
int codsalida;
ResultSet rs;
%> 
<%
    HttpSession ses = request.getSession();
    ses.setAttribute("MSJERESULTADOGUARDARSALIDA",null);
    if (ses.getAttribute("codsalida")!=null){
        codsalida= Integer.parseInt(ses.getAttribute("codsalida").toString());
    }else{
        codsalida=0;
    }
    ses.setAttribute("codsalida",null);
    
    if (request.getParameter("txtnrodocumento")!=null){
    int auxnrodoc = Integer.parseInt(request.getParameter("txtnrodocumento"));
    if (auxnrodoc!=0){
        rs = DAOCABECERASALIDAALMACEN.SalidaCodSalida(auxnrodoc);
    }else{
        rs=DAOCABECERASALIDAALMACEN.ListarSalidas();
    }
    auxnrodoc=0;
    }else{
        rs=DAOCABECERASALIDAALMACEN.ListarSalidas();
    }
    %>
    
<html>
    <script type="text/javascript">
         function alerta(msje){
                      alert(msje);
                  }
    </script>
    <%
    if (ses.getAttribute("MSJERESULTADOELIMINARSALIDA")!=null){
        String msje = ses.getAttribute("MSJERESULTADOELIMINARSALIDA").toString();
    %>
    <body onload="alerta('<%=msje%>')">
    <%
    ses.setAttribute("MSJERESULTADOELIMINARSALIDA",null);
    }else{
    %>
    <body>
    <%
    }
    %>
    <center>
        <h2>LISTA DE SALIDAS</h2>
        <a href="Registro_Salida.jsp">RETORNAR</a>
        </center>
    <br>
    <form method="post" action="#">
    <fieldset>
        <legend>Busqueda de salida por nro. de documento</legend>
        <h4>NRO. DOCUMENTO</h4>&nbsp;<input type="number" id="txtnrodocumento" name="txtnrodocumento" value="0">
        &nbsp;
        <input type="submit" value="BUSCAR" name="btnbuscar" id="btnbuscar">
    </fieldset>
    </form>
    <br>
        <form>
            <table border="1">
                <tr><th>CODIGO SALIDA<th>TIPO DOC<th>NRO DOC<th>FECHA<th>MOTIVO<th>OBSERVACIONES
                        <%
                            
                            while (rs.next()){
                                %>
                <tr><td><%=rs.getString(1)%>
                    <td><%=rs.getString(2)%>
                    <td><%=rs.getString(3)%>
                    <td><%=rs.getString(4)%>
                    <td><%=rs.getString(5)%>
                    <td><%=rs.getString(6)%>
                    <td><a href="SERCABECERASALIDAALMACEN?opcion=1&codsalida=<%=rs.getInt(1)%>"><input type="button" value="VER DETALLES" id="btnverdetalles" name="btnverdetalles"></a>
                    <td><a href="SERCABECERASALIDAALMACEN?opcion=2&codsalida=<%=rs.getInt(1)%>"><input type="button" value="ELIMINAR" id="btneliminar" name="btneliminar"></a>
                                <%
                            }
                            %>
            </table>
        </form>
            <center>
            <h2>DETALLES DE SALIDA - <%=codsalida%> -</h2>
            </center>
            <form>
            <table border="1">
                <tr><th>NRO DOC<th>PRODUCTO<th>CANTIDAD
                        <%
                            ResultSet rs2 = DAODETALLESALIDAALMACEN.DetallesSalida(codsalida);
                            while (rs2.next()){
                                %>
                <tr><td><%=rs2.getString(1)%>
                    <td><%=rs2.getString(2)%>
                    <td><%=rs2.getString(3)%>
                                <%
                            }
                            %>
            </table>
        </form>
            
    </body>
</html>
