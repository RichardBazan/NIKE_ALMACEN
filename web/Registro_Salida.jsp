
<%@page import="DAO.*,javax.swing.*,java.sql.*" %>
<html>
       <%
             HttpSession ses = request.getSession();
             ses.setAttribute("MSJERESULTADOELIMINARSALIDA",null);
             if (ses.getAttribute("MSJERESULTADOGUARDARSALIDA")!=null){
                 String msje = ses.getAttribute("MSJERESULTADOGUARDARSALIDA").toString();
      %>
    
      <body onload="alerta('<%=msje%>')">
      <%
      ses.setAttribute("MSJERESULTADOGUARDARSALIDA",null);
             }else{
                 %>
                <body>
                    <%
             }
              %>
  
        <%-- JAVASCRIPT --%>
              <script type="text/javascript">
                  
                  function alerta(msje){
                      alert(msje);
                  }
                                                              
              function contarFilasTablaProductos(){
                  var tabla = document.getElementById("tablaProductos");
                  var txtnumregistros = document.getElementById("txtnroregistros");
                  txtnumregistros.value = tabla.rows.length-1;
              }
                  
              function agregarFilaTablaProductos() {
              var tabla = document.getElementById("tablaProductos");
              var aux = tabla.rows.length; 
              var fila = tabla.insertRow(aux);
              var columna1 = fila.insertCell(0);
              var columna2 = fila.insertCell(1);
              var columna3 = fila.insertCell(2);
              var columna4 = fila.insertCell(3);
              
              var cbdescripcion = document.getElementById("cbproductos"); 
              var productoselect = cbdescripcion.options[cbdescripcion.selectedIndex].text;
            
              var txtcodigo = document.createElement("INPUT");
              txtcodigo.setAttribute("name","txtcodigo"+aux.toString());
              txtcodigo.setAttribute("id","txtcodigo"+aux.toString());
              txtcodigo.setAttribute("type","text");
              txtcodigo.setAttribute("value",cbdescripcion.value.toString());
              txtcodigo.setAttribute("style","width: 6em;");
              txtcodigo.readOnly=true;
              //alert(cbdescripcion.value.toString());
              
              var txtdescripcion = document.createElement("INPUT");
              txtdescripcion.setAttribute("type","text");
              txtdescripcion.setAttribute("name","txtdescripcion"+aux.toString());
              txtdescripcion.setAttribute("id","txtdescripcion"+aux.toString());
              txtdescripcion.setAttribute("size","52");
              txtdescripcion.setAttribute("value",productoselect);
              txtdescripcion.readOnly=true;
                                     
              var txtcantidad = document.createElement("INPUT");
              txtcantidad.setAttribute("type","number");
              txtcantidad.setAttribute("name","txtcantidad"+aux.toString());
              txtcantidad.setAttribute("id","txtcantidad"+aux.toString());
              txtcantidad.setAttribute("style","width: 7.1em;");
              txtcantidad.value = 0;
     
              //txtcantidad.setAttribute("onblur",calcularTotal());
              //txtcantidad.onblur = calcularTotal();
              
              var btneliminar = document.createElement("INPUT");
              btneliminar.setAttribute("type","button");
              btneliminar.setAttribute("value","ELIMINAR"); 
              btneliminar.setAttribute("name","btneliminar"+aux.toString());
              btneliminar.setAttribute("id","btneliminar"+aux.toString());
              btneliminar.setAttribute("onclick","eliminarFilaTablaProductos(" + aux.toString() + ")");
              //btneliminar.setAttribute("value","eliminarFilaTablaProductos(" + aux.toString() + ")");
              
              columna1.appendChild(txtcodigo);
              columna2.appendChild(txtdescripcion);
              columna3.appendChild(txtcantidad);
              columna4.appendChild(btneliminar);
              contarFilasTablaProductos();
             
              }
                 
              function eliminarFilaTablaProductos(indice){
                  var tabla = document.getElementById("tablaProductos");
                  var txttotal = document.getElementById("txttotal");
                  
                  if (tabla.rows.length>1){
                  tabla.deleteRow(indice);
                  var i;
                  for (i=1;i<=tabla.rows.length-indice;i++){
                      var btnaux = document.getElementById("btneliminar"+(indice+i).toString());
                      var txtcodigo = document.getElementById("txtcodigo"+(indice+i).toString());
                      var txtdescripcion = document.getElementById("txtdescripcion"+(indice+i).toString());
                      var txtcantidad = document.getElementById("txtcantidad"+(indice+i).toString());
                      
                      btnaux.setAttribute("onclick","eliminarFilaTablaProductos(" + (indice+i-1).toString() + ")");
                      btnaux.setAttribute("name","btneliminar"+(indice+i-1).toString());
                      btnaux.setAttribute("id","btneliminar"+(indice+i-1).toString());
                      
                      txtcodigo.setAttribute("name","txtcodigo"+(indice+i-1).toString());
                      txtcodigo.setAttribute("id","txtcodigo"+(indice+i-1).toString());
                      
                      txtdescripcion.setAttribute("name","txtdescripcion"+(indice+i-1).toString());
                      txtdescripcion.setAttribute("id","txtdescripcion"+(indice+i-1).toString());
                                                                
                      txtcantidad.setAttribute("name","txtcantidad"+(indice+i-1).toString());
                      txtcantidad.setAttribute("id","txtcantidad"+(indice+i-1).toString());
                  }
                  }
                  contarFilasTablaProductos();
              }
              </script>      
              
              <%-- JAVASCRIPT --%>
              
    <center>
        <h2>REGISTRO SALIDA ALMACÉN</h2>
        <a href="ListaSalidas.jsp">VER TOTAL REGISTROS</a>&nbsp;&nbsp;&nbsp;&nbsp; 
        <a href="MenuAlmacen.jsp">VOLVER AL MENU</a>
    </center>
    <form id="form1" method="post" action="SERCABECERASALIDAALMACEN?opcion=0">
                <fieldset>
     <legend>Datos de la salida</legend>
     <table>
         <tr><td>Codigo<td>  <input type="text" name="txtcodigo" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AUTOGENERADO" readonly>
                  
             <td>&nbsp;&nbsp;&nbsp;
                          Tipo de Documento&nbsp;&nbsp;<select name="cbtipodocumento" id="cbtipodocumento">
                              <option selected>  --- SELECCIONAR --- </option>
                              <option value="B">BOLETA</option>    
                              <option value="F">FACTURA</option>    
                          </select>
                  <tr><td>&nbsp;
                  <tr><td>N°Documento<td>  <input type="text" name="txtndocumento" required>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fecha
                          &nbsp;
                          <input type="date" name="txtfecha">
                  <tr><td>&nbsp;
                  <tr><td>Motivo
                      <td><textarea name="txtmotivo" rows="3" cols="40"></textarea>
                  <tr><td>&nbsp;
                  <tr><td>Observaciones
                      <td><textarea name="txtobservaciones" rows="3" cols="40"></textarea>
                          <tr><td>&nbsp;
                          </table>
                           </fieldset>
              <br>
              <select name="cbproductos" id="cbproductos">
                  <option selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----SELECCIONAR-----</option>
                              <%
                               try{
                                   ResultSet rsProductos = DAOPRODUCTO.comboProductos();
                                   while (rsProductos.next()){
                                       %>
                  <option value="<%=rsProductos.getString(1)%>"><%=rsProductos.getString(2).toUpperCase()+" TALLA "+rsProductos.getString(3)%></option>   
                                       <%
                                   }
                               }catch(Exception e){
                                   
                               }   
                                                                
                                  %>
              </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%--
        <a href="Agregarproducto.jsp"><input type="button" value="AGREGAR PRODUCTO"></a>
        --%>
        <input type="button" value="AGREGAR PRODUCTO" onclick="agregarFilaTablaProductos()">
        &nbsp;&nbsp;
        <br>
        <br>
            <table border="1" id="tablaProductos" >
                <tr><th>CODIGO<th>DESCRIPCION<th>CANTIDAD  
            </table>
        <h5>NRO REGISTROS: <input type="text" size="3" id="txtnroregistros" name="txtnroregistros" value="0" readonly><br><br>
                <center>
                    <input type="submit" value="GUARDAR SALIDA">
                </center>
    </form>
                 </body>
</html>
