/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.Config;
import com.migradortdn.model.Cliente;
import com.migradortdn.model.Ruta;
import com.migradortdn.model.Sucursal;
import com.migradortdn.model.Tipo;
import com.migradortdn.model.TipoCliente;
import com.migradortdn.model.Vendedor;
import com.migradortdn.model.Zona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blackspider
 */
public class ClienteDatosProcesar {

    public ArrayList<Cliente> procesarDatosClientes(
            ArrayList<String[]> csvArray, ArrayList<String[]> csvDepartamentos,
            ArrayList<String[]> csvCiudades, ArrayList<String[]> csvDistritos,
            List<Vendedor> lVendedor, List<Zona> lZona, List<Ruta> lRuta, List<TipoCliente> lTipoCliente) {

        ArrayList<Cliente> lClientes = new ArrayList<Cliente>();

        if (csvArray.size() > 0) {

            for (String[] x : csvArray) {

                if (x[2].trim().length() == 0) {

                    Cliente cliente = new Cliente();

                    cliente.setActivo(true);
                    cliente.setCorreo("");
                    cliente.setDireccion(x[7].trim());
                    cliente.setNombre(x[5].trim());

                    Tipo tipoTipoDocumento = new Tipo();
                    tipoTipoDocumento.setId(93);
                    Tipo tipoDocumento = new Tipo();
                    //tipoDocumento.setTipoTipo(tipoTipoDocumento);

                    tipoDocumento.setId(Config.IDRUC);

                    /*if (x[3].trim().compareTo("RUC") == 0) {
                    tipoDocumento.setId(Config.IDRUC);
                //}

                if (x[3].trim().compareTo("CED") == 0) {
                    tipoDocumento.setId(Config.IDCED);
                }

                if (x[3].trim().compareTo("OT") == 0) {
                    tipoDocumento.setId(Config.IDOT);
                }*/
                    cliente.setTipoDocumento(tipoDocumento);
                    cliente.setNumero(x[4].trim());

                    cliente.setTelefono(x[6].trim());

                    Tipo pais = new Tipo();
                    pais.setId(7344);
                    cliente.setPais(pais);

                    for (String[] d : csvDepartamentos) {

                        if (d[2].compareTo(x[10].trim()) == 0) {

                            Tipo departamento = new Tipo();
                            departamento.setId(Long.parseLong(d[0]));
                            cliente.setDepartamento(departamento);
                            break;
                        }

                    }

                    for (String[] c : csvCiudades) {

                        if (c[2].compareTo(x[11].trim()) == 0) {

                            Tipo ciudad = new Tipo();
                            ciudad.setId(Long.parseLong(c[0]));
                            cliente.setCiudad(ciudad);
                            break;
                        }

                    }

                    if (x[14].trim().length() > 0) {

                        for (TipoCliente tc : lTipoCliente) {

                            if (tc.getDescripcion().compareTo(x[14].trim()) == 0) {

                                cliente.setTipoCliente(tc);

                                break;
                            }

                        }

                    }

                    /*TipoCliente tipoCliente = new TipoCliente();
                Long id = new Long(2);
                tipoCliente.setId(id);
                cliente.setTipoCliente(tipoCliente);*/
                    if (x[4].trim().length() < 11) {

                        Tipo tipoPersona = new Tipo();
                        tipoPersona.setId(354);
                        cliente.setTipoPersona(tipoPersona);

                    } else {

                        Tipo tipoPersona = new Tipo();
                        tipoPersona.setId(355);
                        cliente.setTipoPersona(tipoPersona);

                    }

                    Tipo tipoOperacion = new Tipo();
                    tipoOperacion.setId(473);
                    cliente.setTipoOperacion(tipoOperacion);

                    cliente.setCondicionVenta(x[8].trim());
                    cliente.setCodigo(x[1].trim());

                    Sucursal matriz = new Sucursal();
                    matriz.setDescripcion("Matriz");
                    matriz.setCodigoSucursal("001");
                    matriz.setCiudad(x[11].trim());
                    matriz.setDireccion(x[7].trim());
                    matriz.setTelefono(cliente.getTelefono());
                    matriz.setPais(pais);
                    matriz.setDepartamento(cliente.getDepartamento());

                    if (x[12].trim().length() > 0) {

                        for (Zona z : lZona) {

                            if (z.getZona().compareTo(x[12].trim()) == 0) {

                                matriz.setZona(z);
                                break;
                            }

                        }

                    }

                    if (x[13].trim().length() > 0) {

                        for (Ruta r : lRuta) {

                            if (r.getNombreRuta().compareTo(x[13].trim()) == 0) {

                                matriz.setRuta(r);
                                break;
                            }

                        }

                    }

                    if (x[16].trim().length() > 0) {

                        for (Vendedor v : lVendedor) {

                            String vendedor = x[16].trim().replaceAll(",", " ");

                            if (v.getNombresyapellidos().compareTo(vendedor) == 0) {

                                matriz.setVendedor(v);
                                break;
                            }

                        }

                    }

                    cliente.getSucursales().add(matriz);

                    //seccion buscar sucursales
                    int c = 2;
                    for (String[] x2 : csvArray) {

                        if (x2[2].trim().length() > 0) {

                            String codigo = x2[1].trim();
                            if (codigo.compareTo(cliente.getCodigo()) == 0) {

                                Sucursal sucursal = new Sucursal();
                                sucursal.setDescripcion(x2[5].trim());

                                if (c < 10) {

                                    sucursal.setCodigoSucursal("00" + c);

                                }

                                if (c >= 10 && c < 100) {

                                    sucursal.setCodigoSucursal("0" + c);

                                }

                                if (c >= 100) {

                                    sucursal.setCodigoSucursal("" + c);

                                }

                                c = c + 1;

                                sucursal.setCiudad(x2[11].trim());
                                sucursal.setDireccion(x2[7].trim());
                                sucursal.setTelefono(cliente.getTelefono());
                                sucursal.setPais(pais);

                                if (x2[12].trim().length() > 0) {

                                    for (Zona z : lZona) {

                                        if (z.getZona().compareTo(x2[12].trim()) == 0) {

                                            sucursal.setZona(z);
                                            break;
                                        }

                                    }

                                }

                                if (x2[13].trim().length() > 0) {

                                    for (Ruta r : lRuta) {

                                        if (r.getNombreRuta().compareTo(x2[13].trim()) == 0) {

                                            sucursal.setRuta(r);
                                            break;
                                        }

                                    }

                                }

                                if (x2[16].trim().length() > 0) {

                                    for (Vendedor v : lVendedor) {

                                        String vendedor = x2[16].trim().replaceAll(",", " ");

                                        if (v.getNombresyapellidos().compareTo(vendedor) == 0) {

                                            sucursal.setVendedor(v);
                                            break;
                                        }

                                    }

                                }

                                for (String[] d : csvDepartamentos) {

                                    if (d[2].compareTo(x2[10].trim()) == 0) {

                                        Tipo departamento = new Tipo();
                                        departamento.setId(Long.parseLong(d[0]));
                                        sucursal.setDepartamento(departamento);
                                        break;
                                    }

                                }

                                cliente.getSucursales().add(sucursal);

                                

                            }

                        }

                    }

                    lClientes.add(cliente);

                }

            }

        }

        return lClientes;

    }

}
