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
public class Vendedor {
    
    private String nombres;
    private String apellidos;
    private String numero;
    private String telefono;
    private String direccion;
    private boolean activo = true;
    private boolean isSupervisor = true;
    private long grupoVendedor;
    
    private Tipo ciudad;
    private Tipo tipoDocumento;
    
    private ArrayList<Locacion> locaciones;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(boolean isSupervisor) {
        this.isSupervisor = isSupervisor;
    }

    public long getGrupoVendedor() {
        return grupoVendedor;
    }

    public void setGrupoVendedor(long grupoVendedor) {
        this.grupoVendedor = grupoVendedor;
    }

    public Tipo getCiudad() {
        return ciudad;
    }

    public void setCiudad(Tipo ciudad) {
        this.ciudad = ciudad;
    }

    public Tipo getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Tipo tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public ArrayList<Locacion> getLocaciones() {
        return locaciones;
    }

    public void setLocaciones(ArrayList<Locacion> locaciones) {
        this.locaciones = locaciones;
    }
    
    
}
