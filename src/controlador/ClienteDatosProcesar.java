/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.Config;
import com.migradortdn.model.Cliente;
import com.migradortdn.model.Tipo;
import com.migradortdn.model.TipoCliente;
import java.util.ArrayList;

/**
 *
 * @author blackspider
 */
public class ClienteDatosProcesar {
    
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
                Long id = new Long(2);
                tipoCliente.setId(id);
                cliente.setTipoCliente(tipoCliente);

                Tipo tipoPersona = new Tipo();
                tipoPersona.setId(354);
                cliente.setTipoPersona(tipoPersona);

                Tipo tipoOperacion = new Tipo();
                tipoOperacion.setId(473);
                cliente.setTipoOperacion(tipoOperacion);

                //seccion cargada 24/01/2022
                
                cliente.setCondicionVenta(x[8].trim());
                cliente.setCodigo(x[1].trim());
                
                
                
                lClientes.add(cliente);

            }

        }
        
        return lClientes;

    }
    
}
