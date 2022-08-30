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
public class AsientoDetalle {
    
    //linea t
    //transaccion u
    
    private AsientoCabecera asientoContable;
    private CentroCosto centroCostos;
    private CuentaContable cuentaContable;
    private Sucursal sucursal;
    private TipoDetalleAsiento tipoDetalle;
    
    private double debe;
    private String descripcionlinea;
    private String descripciontransaccion;
    private double haber;

    public AsientoCabecera getAsientoContable() {
        return asientoContable;
    }

    public void setAsientoContable(AsientoCabecera asientoContable) {
        this.asientoContable = asientoContable;
    }

    public CentroCosto getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(CentroCosto centroCostos) {
        this.centroCostos = centroCostos;
    }

    public CuentaContable getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(CuentaContable cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public TipoDetalleAsiento getTipoDetalle() {
        return tipoDetalle;
    }

    public void setTipoDetalle(TipoDetalleAsiento tipoDetalle) {
        this.tipoDetalle = tipoDetalle;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public String getDescripcionlinea() {
        return descripcionlinea;
    }

    public void setDescripcionlinea(String descripcionlinea) {
        this.descripcionlinea = descripcionlinea;
    }

    public String getDescripciontransaccion() {
        return descripciontransaccion;
    }

    public void setDescripciontransaccion(String descripciontransaccion) {
        this.descripciontransaccion = descripciontransaccion;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }
 
    
}
