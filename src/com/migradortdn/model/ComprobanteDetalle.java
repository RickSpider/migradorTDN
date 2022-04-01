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
public class ComprobanteDetalle {
    
    private Long tipo;
    private Long servicio;
    private Long producto;
    private int cantidad = 1;
    private double totalItem;
    private String cantidadView = "1";    
    private String totalItemView;
    private double precioVenta;
    private String precioVentaView = "0,00";
    private int descuento = 0;
    private String descuentoView = "0";
    private String ultimoPrecioView;
    
    private ArrayList<MontoImponible> montosImponibles = new ArrayList<MontoImponible>();

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public Long getServicio() {
        return servicio;
    }

    public void setServicio(Long servicio) {
        this.servicio = servicio;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(double totalItem) {
        this.totalItem = totalItem;
    }

    public String getCantidadView() {
        return cantidadView;
    }

    public void setCantidadView(String cantidadView) {
        this.cantidadView = cantidadView;
    }

    public String getTotalItemView() {
        return totalItemView;
    }

    public void setTotalItemView(String totalItemView) {
        this.totalItemView = totalItemView;
    }

    

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getPrecioVentaView() {
        return precioVentaView;
    }

    public void setPrecioVentaView(String precioVentaView) {
        this.precioVentaView = precioVentaView;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getDescuentoView() {
        return descuentoView;
    }

    public void setDescuentoView(String descuentoView) {
        this.descuentoView = descuentoView;
    }

    public String getUltimoPrecioView() {
        return ultimoPrecioView;
    }

    public void setUltimoPrecioView(String ultimoPrecioView) {
        this.ultimoPrecioView = ultimoPrecioView;
    }

    public ArrayList<MontoImponible> getMontosImponibles() {
        return montosImponibles;
    }

    public void setMontosImponibles(ArrayList<MontoImponible> montosImponibles) {
        this.montosImponibles = montosImponibles;
    }

    
    
}
