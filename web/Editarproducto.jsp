<%-- 
    Document   : Editarproducto
    Created on : 12-nov-2017, 12:37:40
    Author     : Richard
--%>

<%@page import="DAO.DAOMERCADO"%>
<%@page import="DAO.DAOPRODUCTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javafx.scene.control.RadioButton"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Producto</title>
    </head>

    <body>
            <center>
        <%
String cod=request.getParameter("cod");
String des=request.getParameter("des");
double pre=Double.parseDouble(request.getParameter("pre"));
String talla=request.getParameter("talla");
int idmer=Integer.parseInt(request.getParameter("idmer"));
String mer=request.getParameter("mer");
%> 

 <h1>EDITAR PRODUCTO</h1>
          <form action="SERPRODUCTO" method="post">
            <table>
                <tr><td>Codigo<td><input value="<%=cod%>" name="tcod" readonly>
                <tr><td>Descripcion<td><input value="<%=des%>" name="tdes" required>
                <tr><td>Precio<td><input value="<%=pre%>" name="tpre" required>
                                          <tr><td>Talla<td>  <select name="ttalla">
                                                      <option value="<%=talla%>"><%=talla%></option>
                              <%
                               try{
                                   ResultSet rs = DAOPRODUCTO.listaTalla(); 
                                   while (rs.next()){
                                       %>
                                       <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>   
                                       <%
                                   }
                               }catch(Exception e){
                                  e.getMessage();
                               }   
                                                                
                                  %>
              </select>
                  <tr><td>Mercado<td>  <select name="tmer">
                            <option value="<%=idmer%>"><%=mer%></option>
                              <%
                               try{
                                   ResultSet rs = DAOMERCADO.listaMercado();
                                   while (rs.next()){
                                       %>
                                       <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>   
                                       <%
                                   }
                               }catch(Exception e){
                                   e.getMessage();
                               }   
                                                                
                                  %>
              </select>
                <input type="hidden" name="opc" value="3">  
                <tr><td><input type="submit" VALUE="Editar">        
            </table>
        </form>  
              </center>
    </body>
</html>
