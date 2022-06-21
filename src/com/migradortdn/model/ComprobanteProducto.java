/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BlackSpider
 */
public class ComprobanteProducto {
    
    private Long compra;
    private boolean imputarIvaGeneral = false;
    private Long moneda1;
    private Long grupoCompra = 5L;
    private double montoTotal;
    private String montoTotalView;
    private Long deposito;
    private Long proveedor;
    private Long timbradoProveedor;
    private Long sucursalProveedor;
    private String numero;
    private Long rubroIva;
    private Long tipo;
    private Long cambio;
    private Long locacion;
    private String fecha;
    
   
    
    private ArrayList<MontoImponible> montosImponibles = new ArrayList<MontoImponible>();
    private ArrayList<ComprobanteDetalle> comprobanteDetalle = new ArrayList<ComprobanteDetalle>();

    public Long getCompra() {
        return compra;
    }

    public void setCompra(Long compra) {
        this.compra = compra;
    }

    public boolean isImputarIvaGeneral() {
        return imputarIvaGeneral;
    }

    public void setImputarIvaGeneral(boolean imputarIvaGeneral) {
        this.imputarIvaGeneral = imputarIvaGeneral;
    }

    public Long getMoneda1() {
        return moneda1;
    }

    public void setMoneda1(Long moneda1) {
        this.moneda1 = moneda1;
    }

    public Long getGrupoCompra() {
        return grupoCompra;
    }

    public void setGrupoCompra(Long grupoCompra) {
        this.grupoCompra = grupoCompra;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMontoTotalView() {
        return montoTotalView;
    }

    public void setMontoTotalView(String montoTotalView) {
        this.montoTotalView = montoTotalView;
    }

    public Long getDeposito() {
        return deposito;
    }

    public void setDeposito(Long deposito) {
        this.deposito = deposito;
    }

    public Long getProveedor() {
        return proveedor;
    }

    public void setProveedor(Long proveedor) {
        this.proveedor = proveedor;
    }

    public Long getTimbradoProveedor() {
        return timbradoProveedor;
    }

    public void setTimbradoProveedor(Long timbradoProveedor) {
        this.timbradoProveedor = timbradoProveedor;
    }

    public Long getSucursalProveedor() {
        return sucursalProveedor;
    }

    public void setSucursalProveedor(Long sucursalProveedor) {
        this.sucursalProveedor = sucursalProveedor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getRubroIva() {
        return rubroIva;
    }

    public void setRubroIva(Long rubroIva) {
        this.rubroIva = rubroIva;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public Long getCambio() {
        return cambio;
    }

    public void setCambio(Long cambio) {
        this.cambio = cambio;
    }

    public Long getLocacion() {
        return locacion;
    }

    public void setLocacion(Long locacion) {
        this.locacion = locacion;
    }

    public String getFecha() {
        
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<MontoImponible> getMontosImponibles() {
        return montosImponibles;
    }

    public void setMontosImponibles(ArrayList<MontoImponible> montosImponibles) {
        this.montosImponibles = montosImponibles;
    }

    public ArrayList<ComprobanteDetalle> getComprobanteDetalle() {
        return comprobanteDetalle;
    }

    public void setComprobanteDetalle(ArrayList<ComprobanteDetalle> comprobanteDetalle) {
        this.comprobanteDetalle = comprobanteDetalle;
    }

   
    
    
}
