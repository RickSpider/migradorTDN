/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn.model;

/**
 *
 * @author BlackSpider
 */
public class TimbradoPuntoEmision {

    private Long id;
    private Long numeroFinal;
    private Long numeroInicial;
    private PuntoEmision puntoEmisionVenta;
    private TipoComprobante tipoComprobante;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(Long numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public Long getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(Long numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public PuntoEmision getPuntoEmisionVenta() {
        return puntoEmisionVenta;
    }

    public void setPuntoEmisionVenta(PuntoEmision puntoEmisionVenta) {
        this.puntoEmisionVenta = puntoEmisionVenta;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

   
    
    
    
}
