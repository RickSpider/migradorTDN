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
public class Sucursal {
    
    private Long id;
    private String nombre;
    
    private String codigoSucursal;
    private String descripcion;
    private String telefono;
   //private String ciudad;
    
    private Tipo ciudad;
    
    
    private Zona zona;
    private Ruta ruta;
    private Tipo pais;
    private Tipo departamento;
    private Tipo distrito;
    private String direccion;
    private Vendedor vendedor;
    
    private Long gln;
    
    private String ubicacionGeografica = "";

    private boolean activo = true;
    private UnidadNegocio unidadNegocio;
    private Sucursal sucursal;

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
    
    
    //Esto es para Proveedor
    private String codigoEstablecimiento;
    private ArrayList<PuntoEmision> puntosEmisionSucursal;
    
    
    public String getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(String codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public ArrayList<PuntoEmision> getPuntosEmisionSucursal() {
        return puntosEmisionSucursal;
    }

    public void setPuntosEmisionSucursal(ArrayList<PuntoEmision> puntosEmisionSucursal) {
        this.puntosEmisionSucursal = puntosEmisionSucursal;
    }

    
    
    //end 

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tipo getCiudad() {
        return ciudad;
    }

    public void setCiudad(Tipo ciudad) {
        this.ciudad = ciudad;
    }
    
    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Tipo getPais() {
        return pais;
    }

    public void setPais(Tipo pais) {
        this.pais = pais;
    }

    public Tipo getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Tipo departamento) {
        this.departamento = departamento;
    }

    public Tipo getDistrito() {
        return distrito;
    }

    public void setDistrito(Tipo distrito) {
        this.distrito = distrito;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Long getGln() {
        return gln;
    }

    public void setGln(Long gln) {
        this.gln = gln;
    }
    
    
    
}
