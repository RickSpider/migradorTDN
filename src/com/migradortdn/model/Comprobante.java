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
public class Comprobante {
    
    private Long id;
    private boolean imputarIrpRsp = false;
    private boolean imputarIre = false;
    private boolean imputarIvaGeneral = true;
    private Long moneda;
    private Long cambio;
    private Long cliente;
    private Long sucursalCliente;
    private Long tipoOperacion;
    private Long tipo;
    private String motivoEmision;
    private Long timbradoPuntoEmision;
    private Long tipoAplicacion;
    private String fecha;
    private Long deposito;
    private String numero;
    private  Double montoTotal;
    private String montoTotalView;
    private Double totalImpuestos;
    private Long locacion;
    private Long sucursal;
    
    private ArrayList<ComprobanteDetalle> comprobanteDetalle = new ArrayList<ComprobanteDetalle>();
    private ArrayList<MontoImponible> montosImponibles = new ArrayList<MontoImponible>();
    private FormaPago formaPago;
    
    //seccion proveedor
    
    private Long proveedor;
    private Long sucursalProveedor;
    private Long rubroIva;
    private Long timbradoProveedor;
    private Long grupoCompra;
    private Long fob;
    private Long moneda1;

    private Long proveedorPlazoCuotas;

    public Long getProveedorPlazoCuotas() {
        return proveedorPlazoCuotas;
    }

    public void setProveedorPlazoCuotas(Long proveedorPlazoCuotas) {
        this.proveedorPlazoCuotas = proveedorPlazoCuotas;
    }
    
    

    public Long getProveedor() {
        return proveedor;
    }

    public void setProveedor(Long proveedor) {
        this.proveedor = proveedor;
    }

    public Long getSucursalProveedor() {
        return sucursalProveedor;
    }

    public void setSucursalProveedor(Long sucursalProveedor) {
        this.sucursalProveedor = sucursalProveedor;
    }

    public Long getRubroIva() {
        return rubroIva;
    }

    public void setRubroIva(Long rubroIva) {
        this.rubroIva = rubroIva;
    }

    public Long getTimbradoProveedor() {
        return timbradoProveedor;
    }

    public void setTimbradoProveedor(Long timbradoProveedor) {
        this.timbradoProveedor = timbradoProveedor;
    }

    public Long getGrupoCompra() {
        return grupoCompra;
    }

    public void setGrupoCompra(Long grupoCompra) {
        this.grupoCompra = grupoCompra;
    }

    public Long getFob() {
        return fob;
    }

    public void setFob(Long fob) {
        this.fob = fob;
    }

    public Long getMoneda1() {
        return moneda1;
    }

    public void setMoneda1(Long moneda1) {
        this.moneda1 = moneda1;
    }
    
    
    
    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isImputarIrpRsp() {
        return imputarIrpRsp;
    }

    public void setImputarIrpRsp(boolean imputarIrpRsp) {
        this.imputarIrpRsp = imputarIrpRsp;
    }

    public boolean isImputarIre() {
        return imputarIre;
    }

    public void setImputarIre(boolean imputarIre) {
        this.imputarIre = imputarIre;
    }

    public boolean isImputarIvaGeneral() {
        return imputarIvaGeneral;
    }

    public void setImputarIvaGeneral(boolean imputarIvaGeneral) {
        this.imputarIvaGeneral = imputarIvaGeneral;
    }

    public Long getMoneda() {
        return moneda;
    }

    public void setMoneda(Long moneda) {
        this.moneda = moneda;
    }

    public Long getCambio() {
        return cambio;
    }

    public void setCambio(Long cambio) {
        this.cambio = cambio;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getSucursalCliente() {
        return sucursalCliente;
    }

    public void setSucursalCliente(Long sucursalCliente) {
        this.sucursalCliente = sucursalCliente;
    }

    public Long getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Long tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public String getMotivoEmision() {
        return motivoEmision;
    }

    public void setMotivoEmision(String motivoEmision) {
        this.motivoEmision = motivoEmision;
    }

    public Long getTimbradoPuntoEmision() {
        return timbradoPuntoEmision;
    }

    public void setTimbradoPuntoEmision(Long timbradoPuntoEmision) {
        this.timbradoPuntoEmision = timbradoPuntoEmision;
    }

    public Long getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(Long tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }

    public String getFecha() {
        return  fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getDeposito() {
        return deposito;
    }

    public void setDeposito(Long deposito) {
        this.deposito = deposito;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMontoTotalView() {
        return montoTotalView;
    }

    public void setMontoTotalView(String montoTotalView) {
        this.montoTotalView = montoTotalView;
    }

    public Double getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(Double totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public Long getLocacion() {
        return locacion;
    }

    public void setLocacion(Long locacion) {
        this.locacion = locacion;
    }

    public Long getSucursal() {
        return sucursal;
    }

    public void setSucursal(Long sucursal) {
        this.sucursal = sucursal;
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

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    
    
    
}
