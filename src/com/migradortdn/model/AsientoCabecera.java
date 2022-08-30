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
public class AsientoCabecera {
    
    private Long id;    
    private TipoAsiento tipoAsiento;
    private UnidadNegocio unidadNegocio;
    private Sucursal sucursal;
    private Estado estado;
    private String fecha;
    private String tituloasiento;
    
    private Long numero;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(TipoAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public UnidadNegocio getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(UnidadNegocio unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTituloasiento() {
        return tituloasiento;
    }

    public void setTituloasiento(String tituloasiento) {
        this.tituloasiento = tituloasiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
