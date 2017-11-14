<%-- 
    Document   : Agregarproductos
    Created on : 12-nov-2017, 11:00:19
    Author     : Richard
--%>

<%@page import="DAO.DAOMERCADO"%>
<%@page import="DAO.DAOPRODUCTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Producto</title>
    </head>
    <body>
    <center>
        <h1>REGISTRO DE PRODUCTO</h1>
          <form action="SERPRODUCTO" method="post">
            <table>
                <tr><td>Descripcion<td><input name="tdes" required>
                <tr><td>Precio<td><input name="tpre" required>
                  <tr><td>Talla<td>  <select name="ttalla">
                              <option>-----SELECCIONAR-----</option>
                              <%
                               try{
                                   ResultSet rs = DAOPRODUCTO.listaTalla();
                                   while (rs.next()){
                                       %>
                                       <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>   
                                       <%
                                   }
                               }catch(Exception e){
                                   
                               }   
                                                                
                                  %>
              </select>
                  <tr><td>Mercado<td>  <select name="tmer">
                              <option>-----SELECCIONAR-----</option>
                              <%
                               try{
                                   ResultSet rs = DAOMERCADO.listaMercado();
                                   while (rs.next()){
                                       %>
                                       <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>   
                                       <%
                                   }
                               }catch(Exception e){
                                   
                               }   
                                                                
                                  %>
              </select>
                <input type="hidden" name="opc" value="1">        
                <tr><td><input type="submit" VALUE="Guardar">        
            </table>
        </form>  
              </center>
    </body>
</html>
