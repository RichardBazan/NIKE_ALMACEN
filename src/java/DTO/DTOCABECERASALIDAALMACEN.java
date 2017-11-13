package DTO;
public class DTOCABECERASALIDAALMACEN {
    private int codsalida;
    private String tipodoc;
    private int nrodoc;
    private String fecha;
    private String motivo,observaciones;

    public DTOCABECERASALIDAALMACEN() {
    }

    public DTOCABECERASALIDAALMACEN(int codsalida, String tipodoc, int nrodoc, String fecha, String motivo, String observaciones) {
        this.codsalida = codsalida;
        this.tipodoc = tipodoc;
        this.nrodoc = nrodoc;
        this.fecha = fecha;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    public int getCodsalida() {
        return codsalida;
    }

    public void setCodsalida(int codsalida) {
        this.codsalida = codsalida;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public int getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(int nrodoc) {
        this.nrodoc = nrodoc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    
    
    
}
