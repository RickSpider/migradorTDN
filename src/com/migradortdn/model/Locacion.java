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
public class Locacion {
    
    
    private Locacion locacion;
    
    private Long id;
    private Long sucursal;
    private Boolean check;
    private UnidadNegocio unidadNegocio;
    
    public Locacion (Locacion locacion){
    
        this.locacion = locacion;
        
    }

    public Locacion(long id, long sucursal, boolean check) {
        this.id = id;
        this.sucursal = sucursal;
        this.check = check;
    }

    public Locacion getLocacion() {
        return locacion;
    }

    public void setLocacion(Locacion locacion) {
        this.locacion = locacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSucursal() {
        return sucursal;
    }

    public void setSucursal(Long sucursal) {
        this.sucursal = sucursal;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public UnidadNegocio getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(UnidadNegocio unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

   
    

   
}
