<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <body>
    <center>
        <h2>REGISTRO SALIDA ALMACÉN</h2>
    </center>
        <form>
                <fieldset>
     <legend>Datos de la salida</legend>
     <table>
                  <tr><td>Codigo<td>  <input type="text" name="txtcodigo" required>
                  <tr><td>&nbsp;
                  <tr><td>N°Documento<td>  <input type="text" name="txtndocumento" required>
                  <tr><td>&nbsp;
                  <tr><td>Motivo
                      <td><textarea name="txtmotivo" rows="3" cols="40"></textarea>
                  <tr><td>&nbsp;
                  <tr><td>Observaciones
                      <td><textarea name="txtobservaciones" rows="3" cols="40"></textarea>
                          <tr><td>&nbsp;
                          </table>
                           </fieldset>
    <center>
        <br>
    <a href="AgregarproductoSALIDA.jsp"><input type="button" value="AGREGAR PRODUCTO"></a>
    <br><br>
    </center>
            <table border="1">
                <tr><th>DESCRIPCIÓN<th>TARIFA<th>IGV<th>STOCK<th>TALLA<th>ESTADO<th>MERCADO
            </table>
            <br><br>
                <center>
                <input type="submit" value="GUARDAR SALIDA">   
                </center>
    </form>
    </body>
</html>
