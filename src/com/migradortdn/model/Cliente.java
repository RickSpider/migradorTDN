/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn.model;

import java.util.List;

/**
 *
 * @author BlackSpider
 */
public class Cliente {

    private Long id;
   
    private String nombre;
    
    private Tipo tipoPersona;
   
    private String numero;
   
    private String telefono;

    private Tipo tipoDocumento;
    
    private String direccion;
    
    private String correo;
   
    private TipoCliente tipoCliente;

    private Boolean activo;
   
    private List<Object[]> sucursales;

    private List<Object[]> contactos;
  
    private Tipo pais;
   
    private Tipo departamento;
  
    private Tipo distrito;
  
    private Tipo ciudad;
   
    private Tipo tipoTransferencia;

    private Tipo tipoOperacion;

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

    public Tipo getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Tipo tipoPersona) {
        this.tipoPersona = tipoPersona;
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

    public Tipo getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Tipo tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<Object[]> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Object[]> sucursales) {
        this.sucursales = sucursales;
    }

    public List<Object[]> getContactos() {
        return contactos;
    }

    public void setContactos(List<Object[]> contactos) {
        this.contactos = contactos;
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

    public Tipo getCiudad() {
        return ciudad;
    }

    public void setCiudad(Tipo ciudad) {
        this.ciudad = ciudad;
    }

    public Tipo getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(Tipo tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    public Tipo getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Tipo tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    
    
}
