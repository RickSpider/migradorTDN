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
public class MontoImponible {
    
    private Long tipoImpuesto;
    private Double total;
    private Double baseImponible;
    private Long porcentaje;
    private Double valor = 0.0;
    private String totalView;
    private String baseImponibleView;
    private String valorView;

    public Long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Long porcentaje) {
        this.porcentaje = porcentaje;
    }

    
    
    
    public Long getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(Long tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(Double baseImponible) {
        this.baseImponible = baseImponible;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTotalView() {
        return totalView;
    }

    public void setTotalView(String totalView) {
        this.totalView = totalView;
    }

    public String getBaseImponibleView() {
        return baseImponibleView;
    }

    public void setBaseImponibleView(String baseImponibleView) {
        this.baseImponibleView = baseImponibleView;
    }

    public String getValorView() {
        return valorView;
    }

    public void setValorView(String valorView) {
        this.valorView = valorView;
    }

    
    
}
