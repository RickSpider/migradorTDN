/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.migradortdn.Config;
import com.migradortdn.model.Cliente;
import com.migradortdn.model.Locacion;
import com.migradortdn.model.Tipo;
import com.migradortdn.model.TipoCliente;
import com.migradortdn.model.UnidadNegocio;
import com.migradortdn.model.Vendedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BlackSpider
 */
public class DatosProcesar {

    public ArrayList<Cliente> procesarDatosClientes(ArrayList<String[]> csvArray, ArrayList<String[]> csvDepartamentos,ArrayList<String[]> csvCiudades,ArrayList<String[]> csvDistritos) {

        ArrayList<Cliente> lClientes = new ArrayList<Cliente>();

        if (csvArray.size() > 0) {

            for (String[] x : csvArray) {

                Cliente cliente = new Cliente();

                cliente.setActivo(true);
                cliente.setCorreo("");
                cliente.setDireccion(x[7].trim());
                cliente.setNombre(x[5].trim());

                Tipo tipoTipoDocumento = new Tipo();
                tipoTipoDocumento.setId(93);
                Tipo tipoDocumento = new Tipo();
                //tipoDocumento.setTipoTipo(tipoTipoDocumento);

                if (x[3].trim().compareTo("RUC") == 0) {
                    tipoDocumento.setId(Config.IDRUC);
                }

                if (x[3].trim().compareTo("CED") == 0) {
                    tipoDocumento.setId(Config.IDCED);
                }

                if (x[3].trim().compareTo("OT") == 0) {
                    tipoDocumento.setId(Config.IDOT);
                }

                cliente.setTipoDocumento(tipoDocumento);
                cliente.setNumero(x[4].trim());

                cliente.setTelefono(x[6].trim());

                Tipo pais = new Tipo();
                pais.setId(7344);
                cliente.setPais(pais);
                
                
                for (String[] d : csvDepartamentos){
                
                    if (d[2].compareTo(x[10].trim())==0){
                    
                        Tipo departamento = new Tipo();
                        departamento.setId(Long.parseLong(d[0]));
                        cliente.setDepartamento(departamento);
                        break;
                    }
                    
                }
                
                for (String[] c : csvCiudades){
                
                    if (c[2].compareTo(x[11].trim())==0){
                    
                        Tipo ciudad = new Tipo();
                        ciudad.setId(Long.parseLong(c[0]));
                        cliente.setCiudad(ciudad);
                        break;
                    }
                    
                }
                
                
                
                

                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(2);
                cliente.setTipoCliente(tipoCliente);

                Tipo tipoPersona = new Tipo();
                tipoPersona.setId(354);
                cliente.setTipoPersona(tipoPersona);

                Tipo tipoOperacion = new Tipo();
                tipoOperacion.setId(473);
                cliente.setTipoOperacion(tipoOperacion);

                lClientes.add(cliente);

            }

        }
        
        return lClientes;

    }
    
    public ArrayList<Vendedor> procesarDatosVendedor(ArrayList<String[]> csvArray, ArrayList<String[]> csvCiudades, boolean supervisor ,ArrayList<Vendedor> lSupervisores){
        
        ArrayList<Vendedor> lVendedores = new ArrayList<Vendedor>();
        
        if (csvArray.size() > 0){
        
            for (String [] x : csvArray){
            
                //ID;CODIGO;NOMBRE;APELLIDO;DOCTIPO;DOCUMENTO;CELULAR;DIRECCION;CIUDAD;CODSUC;NOMBRESUC;CODSUPERVISOR;NOMBRESUPERVISOR

                Vendedor v = new Vendedor();

                v.setNombres(x[2].trim());
                v.setApellidos(x[3].trim());
                
                Tipo tipoDocumento = new Tipo();
                
                if (x[4].trim().compareTo("CED") == 0) {
                    tipoDocumento.setId(Config.IDCED);
                }

                if (x[4].trim().compareTo("OT") == 0) {
                    tipoDocumento.setId(Config.IDOT);
                }
                
                v.setTipoDocumento(tipoDocumento);
                
                v.setNumero(x[5].trim());
                v.setTelefono(x[6].trim());
                
                v.setDireccion(x[7].trim());
                
                //Seccion ciudad, si la ciudad no encuntra pone default San Lorenzo
                boolean hayCiudad = false;
                for (String[] c : csvCiudades){
                
                    if (c[2].trim().compareTo(x[8].trim())==0){
                    
                        Tipo ciudad = new Tipo();
                        ciudad.setId(Long.parseLong(c[0]));
                        v.setCiudad(ciudad);
                        hayCiudad = true;
                        break;
                    }
                    
                }
                
                if (!hayCiudad){
                
                    Tipo ciudad = new Tipo();
                    ciudad.setId(3545);
                    v.setCiudad(ciudad);
                
                }
                
                //seccion locacion
                ArrayList<Locacion> lLocacion = new ArrayList<Locacion>();
                Locacion locacion = new Locacion(1,1,true);
                
                UnidadNegocio unidadNegocio = new UnidadNegocio();
                unidadNegocio.setId(1);
                
                locacion.setUnidadNegocio(unidadNegocio);
                
                Locacion locacionOri = new Locacion(locacion);
                
                lLocacion.add(locacionOri);
                
                v.setLocaciones(lLocacion);
                v.setGrupoVendedor(1);
                
                if (supervisor){
                
                    v.setIsSupervisor(true);
                    
                }else{
                
                    for (Vendedor s : lSupervisores){
                    
                        String nombreSupervisor = x[12].replaceAll(",", " ").trim();
                        
                        if (s.getNombresyapellidos().compareTo(nombreSupervisor) == 0){
                            
                            v.setSupervisor(s);
                            
                        }
                        
                    }
                    
                }
                
                lVendedores.add(v);
            }
        
        }
        
        return lVendedores;
    }
    
    public ArrayList [] separarVendedores( ArrayList<String[]> csvArray ){
    
        ArrayList [] out = new ArrayList[2];
        
        ArrayList<String[]> lSupervisores = new ArrayList<String[]>();
        ArrayList<String[]> lVendedores = new ArrayList<String[]>();
               
        
        for ( String[] x : csvArray ){
        
            long codigo = Long.parseLong(x[1].trim());
            long codSupervisor = Long.parseLong(x[11].trim());
            
            if (codigo == codSupervisor){
            
                lSupervisores.add(x);
                
            
            }else{
            
                lVendedores.add(x);
                
            }
            
            
        }
        
        out[0] = lSupervisores;
        out[1] = lVendedores;
        
        return out;
    }
    
    public ArrayList<Vendedor> procesarListaVendedores(String json){
    
        ArrayList<String> in = new Gson().fromJson(json, ArrayList.class);
        
        ArrayList<Vendedor> out = new ArrayList<Vendedor>();
    
        for (String x : in){
        
            Vendedor v = new Gson().fromJson(x, Vendedor.class);
            
            System.out.println(x);
            
            //out.add(v);
            
        }
        
        
        return out;
        
    }   
    
  
    
}
