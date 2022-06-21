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
public class Producto1 {

    private Long id;
    // private int estado = 17;
    // private int claseProducto = 1;
    private ArrayList<CodigoBarras> codigosBarras = new ArrayList<CodigoBarras>();
    // private CodigoBarras codigoBarrasPrincipal;
    private ArrayList<Object> atributos = new ArrayList<Object>();
    private String nombre;
    //private Long lineaProducto;
    //private Long marca;
    // private ArrayList<Long>tiposImpuesto= new ArrayList<Long>();
    // private Long criterioControl;
    private boolean controlarFechaVencimiento = false;
    private ArrayList<Long> proveedores = new ArrayList<Long>();
    // private Long proveedorPrincipal;
    private long proveedorSucursal;
    private ArrayList<Long> locaciones = new ArrayList<Long>();
    private UnidadMedida unidadMedidaBase;
    private ArrayList<Long> unidadesMedida = new ArrayList<Long>();
    private boolean controlStock = true;
    private boolean esProductoImportacion = false;
    private boolean incluirEnOrdenesCompra = true;
    private boolean itemCompra = true;
    private boolean itemVenta = true;

    //private Long presentacion;
    // private Long unidadMedidaContenida; 
    // private int contenido;
    private Double conversion;
    private Double contenido;
    private String contenidoView;

    private Double pesoUnidadBase;
    private Double pesoUnidadPresentacion;

    public Double getConversion() {
        return conversion;
    }

    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }

    public Double getContenido() {
        return contenido;
    }

    public void setContenido(Double contenido) {
        this.contenido = contenido;
    }

    public String getContenidoView() {
        return contenidoView;
    }

    public void setContenidoView(String contenidoView) {
        this.contenidoView = contenidoView;
    }

    public Double getPesoUnidadBase() {
        return pesoUnidadBase;
    }

    public void setPesoUnidadBase(Double pesoUnidadBase) {
        this.pesoUnidadBase = pesoUnidadBase;
    }

    public Double getPesoUnidadPresentacion() {
        return pesoUnidadPresentacion;
    }

    public void setPesoUnidadPresentacion(Double pesoUnidadPresentacion) {
        this.pesoUnidadPresentacion = pesoUnidadPresentacion;
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

    public UnidadMedida getUnidadMedidaBase() {
        return unidadMedidaBase;
    }

    public void setUnidadMedidaBase(UnidadMedida unidadMedidaBase) {
        this.unidadMedidaBase = unidadMedidaBase;
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

    public ArrayList<CodigoBarras> getCodigosBarras() {
        return codigosBarras;
    }

    public void setCodigosBarras(ArrayList<CodigoBarras> codigosBarras) {
        this.codigosBarras = codigosBarras;
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
