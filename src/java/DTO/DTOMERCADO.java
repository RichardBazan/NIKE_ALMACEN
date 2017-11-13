/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Richard
 */
public class DTOMERCADO {
    
   private int idMercado;
   private String mercado;

    public DTOMERCADO() {
    }

    public DTOMERCADO(int idMercado, String mercado) {
        this.idMercado = idMercado;
        this.mercado = mercado;
    }

    public int getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(int idMercado) {
        this.idMercado = idMercado;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }
   
   
    
}
