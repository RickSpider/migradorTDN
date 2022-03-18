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
import com.migradortdn.model.FormaPago;
import com.migradortdn.model.Locacion;
import com.migradortdn.model.Marca;
import com.migradortdn.model.Ruta;
import com.migradortdn.model.Sucursal;
import com.migradortdn.model.Tipo;
import com.migradortdn.model.TipoCliente;
import com.migradortdn.model.TipoProveedor;
import com.migradortdn.model.UnidadMedida;
import com.migradortdn.model.UnidadNegocio;
import com.migradortdn.model.Vendedor;
import com.migradortdn.model.Zona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BlackSpider
 */
public class DatosProcesar {

    public ArrayList<Vendedor> procesarDatosVendedor(ArrayList<String[]> csvArray, ArrayList<String[]> csvCiudades, boolean supervisor, ArrayList<Vendedor> lSupervisores) {

        ArrayList<Vendedor> lVendedores = new ArrayList<Vendedor>();

        if (csvArray.size() > 0) {

            for (String[] x : csvArray) {

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
                for (String[] c : csvCiudades) {

                    if (c[2].trim().compareTo(x[8].trim()) == 0) {

                        Tipo ciudad = new Tipo();
                        ciudad.setId(Long.parseLong(c[0]));
                        v.setCiudad(ciudad);
                        hayCiudad = true;
                        break;
                    }

                }

                if (!hayCiudad) {

                    Tipo ciudad = new Tipo();
                    ciudad.setId(3545);
                    v.setCiudad(ciudad);

                }

                //seccion locacion
                ArrayList<Locacion> lLocacion = new ArrayList<Locacion>();
                Locacion locacion = new Locacion(1, 1, true);

                UnidadNegocio unidadNegocio = new UnidadNegocio();
                unidadNegocio.setId(1);

                locacion.setUnidadNegocio(unidadNegocio);

                Locacion locacionOri = new Locacion(locacion);

                lLocacion.add(locacionOri);

                v.setLocaciones(lLocacion);
                v.setGrupoVendedor(1);

                if (supervisor) {

                    v.setIsSupervisor(true);

                } else {

                    for (Vendedor s : lSupervisores) {

                        String nombreSupervisor = x[12].replaceAll(",", " ").trim();

                        if (s.getNombresyapellidos().compareTo(nombreSupervisor) == 0) {

                            v.setSupervisor(s);

                        }

                    }

                }

                lVendedores.add(v);
            }

        }

        return lVendedores;
    }

    public ArrayList[] separarVendedores(ArrayList<String[]> csvArray) {

        ArrayList[] out = new ArrayList[2];

        ArrayList<String[]> lSupervisores = new ArrayList<String[]>();
        ArrayList<String[]> lVendedores = new ArrayList<String[]>();

        for (String[] x : csvArray) {

            long codigo = Long.parseLong(x[1].trim());
            long codSupervisor = Long.parseLong(x[11].trim());

            if (codigo == codSupervisor) {

                lSupervisores.add(x);

            } else {

                lVendedores.add(x);

            }

        }

        out[0] = lSupervisores;
        out[1] = lVendedores;

        return out;
    }

    public ArrayList<Vendedor> procesarListaVendedores(String json) {

        ArrayList<String> in = new Gson().fromJson(json, ArrayList.class);

        ArrayList<Vendedor> out = new ArrayList<Vendedor>();

        for (String x : in) {

            Vendedor v = new Gson().fromJson(x, Vendedor.class);

            System.out.println(x);

            //out.add(v);
        }

        return out;

    }

    public ArrayList<Zona> procesarZona(ArrayList<String[]> csvArray) {

        ArrayList<Zona> out = new ArrayList<Zona>();

        for (String[] x : csvArray) {

            Zona z = new Zona();
            z.setZona(x[3].trim());
            z.setDescripcion(x[1].trim() + " - " + x[2].trim() + " - " + x[3].trim());

            out.add(z);
        }

        return out;

    }

    public ArrayList<Ruta> procesarRuta(ArrayList<String[]> csvArray) {

        ArrayList<Ruta> out = new ArrayList<Ruta>();
        Sucursal s = new Sucursal();
        Long id = new Long(1);
        s.setId(id); // sucrusal 1 Central 

        for (String[] x : csvArray) {

            Ruta r = new Ruta();
            r.setNombreRuta(x[2].trim());
            r.setRuta(x[2].trim());
            r.setSucursal(s);

            out.add(r);

        }

        return out;
    }

    public ArrayList<TipoCliente> procesarTipoCliente(ArrayList<String[]> csvArray) {

        ArrayList<TipoCliente> out = new ArrayList<TipoCliente>();

        for (String[] x : csvArray) {

            TipoCliente tc = new TipoCliente();
            tc.setDescripcion(x[2].trim());

            out.add(tc);
        }

        return out;

    }

    public ArrayList<TipoProveedor> procesarTipoProveedor(ArrayList<String[]> csvArray) {

        ArrayList<TipoProveedor> out = new ArrayList<TipoProveedor>();

        for (String[] x : csvArray) {

            TipoProveedor tp = new TipoProveedor();
            tp.setDescripcion(x[1].trim());

            out.add(tp);
        }

        return out;
    }

    public ArrayList<FormaPago> procesarFormaPago(ArrayList<String[]> csvArray) {

        ArrayList<FormaPago> out = new ArrayList<FormaPago>();

        for (String[] x : csvArray) {

            FormaPago fp = new FormaPago();
            fp.setDescripcion(x[1].trim());
            fp.setCodigo(x[1].toString().trim());
            fp.setCantidadCuotas(Integer.parseInt(x[2].toString()));
            fp.setPlazoDias(Integer.parseInt(x[3].toString()));
            fp.setDescripcionAbreviada(x[1].trim());
            fp.getClase().setId(7552L); // clase referencias
            out.add(fp);
        }

        return out;
    }

    public ArrayList<UnidadMedida> procesarUnidadMedidaBase(ArrayList<String[]> csvArray) {

        ArrayList<UnidadMedida> out = new ArrayList<UnidadMedida>();

        ArrayList<String> base = new ArrayList<>();

        for (String[] x : csvArray) {

            boolean existe = false;
            for (String s : base) {

                if (x[15].toString().trim().toUpperCase().compareTo(s) == 0) {

                    existe = true;
                    break;
                }

            }

            if (!existe) {

                base.add(x[15].toString().trim().toUpperCase());

            }

        }

        for (String x : base) {

            UnidadMedida m = new UnidadMedida();
            m.setEsBase(true);
            m.setAbreviatura(x);
            m.setDescripcion(x);

            out.add(m);
        }

        return out;

    }

    public ArrayList<UnidadMedida> procesarUnidadMedida(ArrayList<String[]> csvArray, ArrayList<UnidadMedida> lUnidadMedidaBase) {

        ArrayList<UnidadMedida> out = new ArrayList<UnidadMedida>();

        for (String[] x : csvArray) {

            boolean existe = false;

            for (UnidadMedida um : out) {

                if (um.getDescripcion().compareTo(x[16].toString().trim().toUpperCase()) == 0
                        && um.getCantidad() == ((int) Double.parseDouble(x[17].toString().replace(",", ".")))
                        && um.getUnidadContenida().getDescripcion().toString().compareTo(x[15].toString().trim().toUpperCase()) == 0) {

                    existe = true;
                }

            }

            if (!existe) {

                if (x[16].toString().trim().length() > 0) {

                    UnidadMedida u = new UnidadMedida();
                    u.setDescripcion(x[16].toString().trim().toUpperCase());
                    u.setAbreviatura(x[16].toString().trim().toUpperCase());
                    double cantidad = Double.parseDouble(x[17].toString().replace(",", "."));
                    u.setCantidad(((int) cantidad));

                    for (UnidadMedida x1 : lUnidadMedidaBase) {

                        if (x1.getDescripcion().compareTo(x[15].toString().trim().toUpperCase()) == 0) {

                            u.setUnidadContenida(x1);

                            break;

                        }

                    }

                    out.add(u);

                }
            }
        }

        return out;

    }
    
    public ArrayList<Marca> procesarMarca(ArrayList<String[]> csvArray) {

        ArrayList<Marca> out = new ArrayList<Marca>();

        ArrayList<String> base = new ArrayList<>();

        for (String[] x : csvArray) {

            boolean existe = false;
            for (String s : base) {

                if (x[8].toString().trim().toUpperCase().compareTo(s) == 0) {

                    existe = true;
                    break;
                }

            }

            if (!existe) {

                base.add(x[8].toString().trim().toUpperCase());

            }

        }

        for (String x : base) {
            
            if (x.length()>0){
            
                Marca m = new Marca();
                m.setDescripcion(x);
                out.add(m);
                
            }

           
        }

        return out;

    }

}
