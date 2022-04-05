/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn.model;

import java.util.ArrayList;

/**
 *
 * @author BlackSpider
 */
public class Timbrado {
    
    private Long id;
    private Boolean activo = true;
    private String fechaDesde;
    private String fechaHasta;
    private Long numeroTimbrado;
    //private Long sucursal;
    private Sucursal sucursal;
    private ClaseTimbrado claseTimbrado;

    public ClaseTimbrado getClaseTimbrado() {
        return claseTimbrado;
    }

    public void setClaseTimbrado(ClaseTimbrado claseTimbrado) {
        this.claseTimbrado = claseTimbrado;
    }

    
    
    private ArrayList<TimbradoPuntoEmision> timbradoPuntoEmision;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Long getNumeroTimbrado() {
        return numeroTimbrado;
    }

    public void setNumeroTimbrado(Long numeroTimbrado) {
        this.numeroTimbrado = numeroTimbrado;
    }

   /* public Long getSucursal() {
        return sucursal;
    }

    public void setSucursal(Long sucursal) {
        this.sucursal = sucursal;
    }*/

    public ArrayList<TimbradoPuntoEmision> getTimbradoPuntoEmision() {
        return timbradoPuntoEmision;
    }

    public void setTimbradoPuntoEmision(ArrayList<TimbradoPuntoEmision> timbradoPuntoEmision) {
        this.timbradoPuntoEmision = timbradoPuntoEmision;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

  
    
}
