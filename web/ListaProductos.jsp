<%@page import="DTO.DTOPRODUCTO"%>
<%@page import="DAO.DAOPRODUCTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Productos</title>
    </head>
    <body>
    <center>
        <h1>LISTA DE PRODUCTOS</h1>

        <table border="1">
            <tr><td>Descripción</td><td>Tarifa</td><td>Stock</td><td>Talla</td>
                <td>Mercado</td><td>Eliminar</td><td>Editar</td>  <%
    DAOPRODUCTO  obj=new DAOPRODUCTO();
    for(DTOPRODUCTO   p:obj.listaProductos()){
      %>
            <tr><td><%=p.getDescripcion()%></td><td><%=p.getTafifa()%></td>
                <td><%=p.getStock()%></td><td><%=p.getTalla()%></td>
                <td><%=p.getMercado()%></td><td><a href="SERPRODUCTO?opc=2&cod=<%=p.getId()%>">Eliminar</a></td>
                <td><a href="EditarProducto.jsp?cod=<%=p.getId()%>">Editar</a>   
      <%}%>
        </table>
        </center>
    </body>
</html>
