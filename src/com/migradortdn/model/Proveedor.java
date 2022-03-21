/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BlackSpider
 */
public class Proveedor {
    
    private Long id;
    
    private ClaseProveedor claseProveedor = new ClaseProveedor(); //116
    
    private boolean controlTimbradoNumeracion = true;
    
    private String direccion;
    
    private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();

    private List<Object[]> contactos = new ArrayList<Object[]>();
    
    private String nombre;
    
    private String nombreFantasia;
    
    private String numeroDocumento;
    
    private String telefono;
    
    private Tipo tipoDocumento = new Tipo();
    
    private Tipo tipoPersona = new Tipo();
    
    private TipoProveedor tipoProveedor;
    
    private boolean activo = true;
    
    private Tipo pais = null;
    
    private boolean calcularRetencion = true;

    public Tipo getPais() {
        return pais;
    }

    public void setPais(Tipo pais) {
        this.pais = pais;
    }

    public boolean isCalcularRetencion() {
        return calcularRetencion;
    }

    public void setCalcularRetencion(boolean calcularRetencion) {
        this.calcularRetencion = calcularRetencion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClaseProveedor getClaseProveedor() {
        return claseProveedor;
    }

    public void setClaseProveedor(ClaseProveedor claseProveedor) {
        this.claseProveedor = claseProveedor;
    }

    public boolean isControlTimbradoNumeracion() {
        return controlTimbradoNumeracion;
    }

    public void setControlTimbradoNumeracion(boolean controlTimbradoNumeracion) {
        this.controlTimbradoNumeracion = controlTimbradoNumeracion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public List<Object[]> getContactos() {
        return contactos;
    }

    public void setContactos(List<Object[]> contactos) {
        this.contactos = contactos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tipo getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Tipo tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Tipo getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Tipo tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public TipoProveedor getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(TipoProveedor tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }
    
    
}
