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
public class Producto {
 
    private Long id;
    private int estado = 17;
    private int claseProducto = 2;
    private ArrayList<CodigoBarras> codigosBarras = new ArrayList<CodigoBarras>();
    private CodigoBarras codigoBarrasPrincipal;
    private ArrayList<Object>atributos = new ArrayList<Object>();
    private String nombre;
    private Long lineaProducto;
    private Long marca;
    private ArrayList<Long>tiposImpuesto= new ArrayList<Long>();
    private Long criterioControl;
    private boolean controlarFechaVencimiento = false;
    private ArrayList<Long>proveedores = new ArrayList<Long>();
    private Long proveedorPrincipal;
    private long proveedorSucursal;
    private ArrayList<Long> locaciones = new ArrayList<Long>();
    private Long unidadMedidaBase;
    private ArrayList<Long> unidadesMedida = new ArrayList<Long>();
    private boolean controlStock = true;
    private boolean esProductoImportacion = false;
    private boolean incluirEnOrdenesCompra = true;
    private boolean itemCompra = true;
    private boolean itemVenta = true;
    
    private Long presentacion;
    private Long unidadMedidaContenida; 
    private int contenido;

    public Long getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Long presentacion) {
        this.presentacion = presentacion;
    }

    public Long getUnidadMedidaContenida() {
        return unidadMedidaContenida;
    }

    public void setUnidadMedidaContenida(Long unidadMedidaContenida) {
        this.unidadMedidaContenida = unidadMedidaContenida;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }
   
    
    
    public boolean isControlStock() {
        return controlStock;
    }

    public void setControlStock(boolean controlStock) {
        this.controlStock = controlStock;
    }

    public boolean isEsProductoImportacion() {
        return esProductoImportacion;
    }

    public void setEsProductoImportacion(boolean esProductoImportacion) {
        this.esProductoImportacion = esProductoImportacion;
    }

    public boolean isIncluirEnOrdenesCompra() {
        return incluirEnOrdenesCompra;
    }

    public void setIncluirEnOrdenesCompra(boolean incluirEnOrdenesCompra) {
        this.incluirEnOrdenesCompra = incluirEnOrdenesCompra;
    }

    public boolean isItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(boolean itemCompra) {
        this.itemCompra = itemCompra;
    }

    public boolean isItemVenta() {
        return itemVenta;
    }

    public void setItemVenta(boolean itemVenta) {
        this.itemVenta = itemVenta;
    }
    
    

    public Long getUnidadMedidaBase() {
        return unidadMedidaBase;
    }

    public void setUnidadMedidaBase(Long unidadMedidaBase) {
        this.unidadMedidaBase = unidadMedidaBase;
    }

    public ArrayList<Long> getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(ArrayList<Long> unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getClaseProducto() {
        return claseProducto;
    }

    public void setClaseProducto(int claseProducto) {
        this.claseProducto = claseProducto;
    }

    public ArrayList<CodigoBarras> getCodigosBarras() {
        return codigosBarras;
    }

    public void setCodigosBarras(ArrayList<CodigoBarras> codigosBarras) {
        this.codigosBarras = codigosBarras;
    }

    public CodigoBarras getCodigoBarrasPrincipal() {
        return codigoBarrasPrincipal;
    }

    public void setCodigoBarrasPrincipal(CodigoBarras codigoBarrasPrincipal) {
        this.codigoBarrasPrincipal = codigoBarrasPrincipal;
    }

  

    public ArrayList<Object> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<Object> atributos) {
        this.atributos = atributos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getLineaProducto() {
        return lineaProducto;
    }

    public void setLineaProducto(Long lineaProducto) {
        this.lineaProducto = lineaProducto;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long marca) {
        this.marca = marca;
    }

    public ArrayList<Long> getTiposImpuesto() {
        return tiposImpuesto;
    }

    public void setTiposImpuesto(ArrayList<Long> tiposImpuesto) {
        this.tiposImpuesto = tiposImpuesto;
    }

    public Long getCriterioControl() {
        return criterioControl;
    }

    public void setCriterioControl(Long criterioControl) {
        this.criterioControl = criterioControl;
    }

    public boolean isControlarFechaVencimiento() {
        return controlarFechaVencimiento;
    }

    public void setControlarFechaVencimiento(boolean controlarFechaVencimiento) {
        this.controlarFechaVencimiento = controlarFechaVencimiento;
    }

    public ArrayList<Long> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Long> proveedores) {
        this.proveedores = proveedores;
    }

    public Long getProveedorPrincipal() {
        return proveedorPrincipal;
    }

    public void setProveedorPrincipal(Long proveedorPrincipal) {
        this.proveedorPrincipal = proveedorPrincipal;
    }

    public long getProveedorSucursal() {
        return proveedorSucursal;
    }

    public void setProveedorSucursal(long proveedorSucursal) {
        this.proveedorSucursal = proveedorSucursal;
    }

    public ArrayList<Long> getLocaciones() {
        return locaciones;
    }

    public void setLocaciones(ArrayList<Long> locaciones) {
        this.locaciones = locaciones;
    }
    
    
    
}
