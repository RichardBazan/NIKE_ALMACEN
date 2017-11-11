package DTO;

public class DTODTALLECOMPROBANTALMCN {
private int nro_doc,id_producto;    
private double tarifa;
private int cantidad;    

    public DTODTALLECOMPROBANTALMCN() {
    }

    public DTODTALLECOMPROBANTALMCN(int nro_doc, int id_producto, double tarifa, int cantidad) {
        this.nro_doc = nro_doc;
        this.id_producto = id_producto;
        this.tarifa = tarifa;
        this.cantidad = cantidad;
    }

    public int getNro_doc() {
        return nro_doc;
    }

    public void setNro_doc(int nro_doc) {
        this.nro_doc = nro_doc;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
