
package DTO;

public class DTOPRODUCTO {
    
    private int id;
    private String descripcion;
    private double tafifa;
    private int stock;
    private String talla;
    private String mercado;

    public DTOPRODUCTO() {
    }

    public DTOPRODUCTO(int id, String descripcion, double tafifa, int stock, String talla, String mercado) {
        this.id = id;
        this.descripcion = descripcion;
        this.tafifa = tafifa;
        this.stock = stock;
        this.talla = talla;
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

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }
 
}
