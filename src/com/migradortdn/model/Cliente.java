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

    private Boolean activo = true;
   
    private List<Object[]> sucursales;

    private List<Object[]> contactos;
  
    private Tipo pais;
   
    private Tipo departamento;
  
    private Tipo distrito;
  
    private Tipo ciudad;
   
    private Tipo tipoTransferencia;

    private Tipo tipoOperacion;
    
    private String Codigo;
    
    private int saldoCuentaCliente = 0;
    private int entregaRemisiones = 0;
    private int SaldoCredito = 0;
    private int pedidosVenta= 0;
    private int chequeCartera = 0;
    
    private String saldocuentaClienteView = "0";
    private String entregaRemisionesView = "0";
    private String saldoCreditoView = "0";
    private String pedidosVentaView = "0";
    private String cequeCarteraView = "0";
    
    private Boolean controlarLimiteCredito = true;
    
    private String condicionVenta;
    
    private String limiteCreditoView = "0";
    private int limiteCredito = 0;
    private String diasToleranciaView = "0";
    private int diasTolerancia = 0;

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

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public int getSaldoCuentaCliente() {
        return saldoCuentaCliente;
    }

    public void setSaldoCuentaCliente(int saldoCuentaCliente) {
        this.saldoCuentaCliente = saldoCuentaCliente;
    }

    public int getEntregaRemisiones() {
        return entregaRemisiones;
    }

    public void setEntregaRemisiones(int entregaRemisiones) {
        this.entregaRemisiones = entregaRemisiones;
    }

    public int getSaldoCredito() {
        return SaldoCredito;
    }

    public void setSaldoCredito(int SaldoCredito) {
        this.SaldoCredito = SaldoCredito;
    }

    public int getPedidosVenta() {
        return pedidosVenta;
    }

    public void setPedidosVenta(int pedidosVenta) {
        this.pedidosVenta = pedidosVenta;
    }

    public int getChequeCartera() {
        return chequeCartera;
    }

    public void setChequeCartera(int chequeCartera) {
        this.chequeCartera = chequeCartera;
    }

    public String getSaldocuentaClienteView() {
        return saldocuentaClienteView;
    }

    public void setSaldocuentaClienteView(String saldocuentaClienteView) {
        this.saldocuentaClienteView = saldocuentaClienteView;
    }

    public String getEntregaRemisionesView() {
        return entregaRemisionesView;
    }

    public void setEntregaRemisionesView(String entregaRemisionesView) {
        this.entregaRemisionesView = entregaRemisionesView;
    }

    public String getSaldoCreditoView() {
        return saldoCreditoView;
    }

    public void setSaldoCreditoView(String saldoCreditoView) {
        this.saldoCreditoView = saldoCreditoView;
    }

    public String getPedidosVentaView() {
        return pedidosVentaView;
    }

    public void setPedidosVentaView(String pedidosVentaView) {
        this.pedidosVentaView = pedidosVentaView;
    }

    public String getCequeCarteraView() {
        return cequeCarteraView;
    }

    public void setCequeCarteraView(String cequeCarteraView) {
        this.cequeCarteraView = cequeCarteraView;
    }

    public Boolean getControlarLimiteCredito() {
        return controlarLimiteCredito;
    }

    public void setControlarLimiteCredito(Boolean controlarLimiteCredito) {
        this.controlarLimiteCredito = controlarLimiteCredito;
    }

    public String getCondicionVenta() {
        return condicionVenta;
    }

    public void setCondicionVenta(String condicionVenta) {
        this.condicionVenta = condicionVenta;
    }

    public String getLimiteCreditoView() {
        return limiteCreditoView;
    }

    public void setLimiteCreditoView(String limiteCreditoView) {
        this.limiteCreditoView = limiteCreditoView;
    }

    public int getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getDiasToleranciaView() {
        return diasToleranciaView;
    }

    public void setDiasToleranciaView(String diasToleranciaView) {
        this.diasToleranciaView = diasToleranciaView;
    }

    public int getDiasTolerancia() {
        return diasTolerancia;
    }

    public void setDiasTolerancia(int diasTolerancia) {
        this.diasTolerancia = diasTolerancia;
    }

    
    
}
