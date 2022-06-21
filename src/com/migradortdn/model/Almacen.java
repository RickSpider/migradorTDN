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
public class Almacen {
    
    private Long id;
    private String descripcion;
    private String abreviatura;
    private Boolean activo;
    private Sucursal sucursal;
    private Clase clase;
    private Boolean habilitadoVenta;
    private Boolean usar_diibit;

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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Boolean getHabilitadoVenta() {
        return habilitadoVenta;
    }

    public void setHabilitadoVenta(Boolean habilitadoVenta) {
        this.habilitadoVenta = habilitadoVenta;
    }

    public Boolean getUsar_diibit() {
        return usar_diibit;
    }

    public void setUsar_diibit(Boolean usar_diibit) {
        this.usar_diibit = usar_diibit;
    }
    
    
    
}
