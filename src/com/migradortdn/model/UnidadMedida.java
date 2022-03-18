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
public class UnidadMedida {
    
    private Long id;
    private String descripcion;
    private String abreviatura;
    private Boolean esBase;
    private Boolean dePeso;
    private Boolean permitirDecimales;
    private int cantidad;
    private int csntidadView;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCsntidadView() {
        return csntidadView;
    }

    public void setCsntidadView(int csntidadView) {
        this.csntidadView = csntidadView;
    }
    
    private UnidadMedida unidadContenida;

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Boolean getEsBase() {
        return esBase;
    }

    public void setEsBase(Boolean esBase) {
        this.esBase = esBase;
    }

    public Boolean getDePeso() {
        return dePeso;
    }

    public void setDePeso(Boolean dePeso) {
        this.dePeso = dePeso;
    }

    public Boolean getPermitirDecimales() {
        return permitirDecimales;
    }

    public void setPermitirDecimales(Boolean permitirDecimales) {
        this.permitirDecimales = permitirDecimales;
    }

    public UnidadMedida getUnidadContenida() {
        return unidadContenida;
    }

    public void setUnidadContenida(UnidadMedida unidadContenida) {
        this.unidadContenida = unidadContenida;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEsBase() {
        return esBase;
    }

    public void setEsBase(boolean esBase) {
        this.esBase = esBase;
    }

}
