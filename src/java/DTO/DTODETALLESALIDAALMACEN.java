package DTO;
public class DTODETALLESALIDAALMACEN {
private int cod_salida,id_producto;    
private int cantidad;

    public DTODETALLESALIDAALMACEN() {
    }

    public DTODETALLESALIDAALMACEN(int cod_salida, int id_producto, int cantidad) {
        this.cod_salida = cod_salida;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public int getCod_salida() {
        return cod_salida;
    }

    public void setCod_salida(int cod_salida) {
        this.cod_salida = cod_salida;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
