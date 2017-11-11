package DTO;

public class DTOKBCRACOMPROBANTALMACN {
    private int nrodoc;
    private String tipodoc;
    private int codproveedor;
    private String fecha;
    private double subtotal,igv,total;
    private String motivo,observaciones;
    private int estado;

    public DTOKBCRACOMPROBANTALMACN() {
    }

    public DTOKBCRACOMPROBANTALMACN(int nrodoc, String tipodoc, int codproveedor, String fecha, double subtotal, double igv, double total, String motivo, String observaciones, int estado) {
        this.nrodoc = nrodoc;
        this.tipodoc = tipodoc;
        this.codproveedor = codproveedor;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.motivo = motivo;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(int nrodoc) {
        this.nrodoc = nrodoc;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public int getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(int codproveedor) {
        this.codproveedor = codproveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
}
