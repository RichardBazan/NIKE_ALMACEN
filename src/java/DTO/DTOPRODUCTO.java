
package DTO;

public class DTOPRODUCTO {
    
    private int id;
    private String descripcion;
    private double precio;
    private double igv;
    private double tafifa;
    private int stock;
    private String talla;
    private int idmercado;
    private String mercado;

    public DTOPRODUCTO() {
    }

    public DTOPRODUCTO(int id, String descripcion, double precio, double igv, double tafifa, int stock, String talla, int idmercado, String mercado) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.igv = igv;
        this.tafifa = tafifa;
        this.stock = stock;
        this.talla = talla;
        this.idmercado = idmercado;
        this.mercado = mercado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTafifa() {
        return tafifa;
    }

    public void setTafifa(double tafifa) {
        this.tafifa = tafifa;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getIdmercado() {
        return idmercado;
    }

    public void setIdmercado(int idmercado) {
        this.idmercado = idmercado;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    
    
    
}
   
