/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.model.Cliente;
import com.migradortdn.model.Comprobante;
import com.migradortdn.model.ComprobanteDetalle;
import com.migradortdn.model.MontoImponible;
import com.migradortdn.model.Sucursal;
import com.migradortdn.model.Timbrado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BlackSpider
 */
public class ComprobanteDatosProcesar {

    public ArrayList<Comprobante> procesarDatosComprobante(ArrayList<String[]> csvArrayComprobante, ArrayList<Cliente> lClientes, ArrayList<Timbrado>lTimbrados) throws ParseException {

        ArrayList<Comprobante> out = new ArrayList<Comprobante>();

        for (String[] x : csvArrayComprobante) {
            
            if (x[6].trim().length() == 0){
            
                continue;
                
            }

            Comprobante comp = new Comprobante();

            for (Cliente c : lClientes) {

                if (c.getCodigo().compareTo(x[2].trim()) == 0) {

                    comp.setCliente(c.getId());

                    if (c.getSucursales().size() > 1) {

                        if (x[5].trim().length() > 0) {

                            for (Sucursal s : c.getSucursales()) {

                                if (s.getDescripcion().compareTo(x[5].trim()) == 0) {

                                    comp.setSucursalCliente(s.getId());
                                    break;

                                }

                            }

                        }
                        break;
                    }else{
                    
                        comp.setSucursalCliente(c.getSucursales().get(0).getId());
                        
                    }
                    
                    

                }

            }

            MontoImponible mi = new MontoImponible();
            mi.setTipoImpuesto(3L);
            mi.setBaseImponible(Double.valueOf(x[10].trim()) * -1);
            mi.setPorcentaje(0L);

            ComprobanteDetalle cd = new ComprobanteDetalle();
            cd.setTipo(105L);
            cd.setServicio(2L);
            cd.setTotalItem(Double.valueOf(x[10].trim()) * -1);
            cd.setTotalItemView(cd.getTotalItem() + "");
            cd.setPrecioVenta(Double.valueOf(x[10].trim()) * -1);
            cd.setUltimoPrecioView(cd.getPrecioVenta() + "");
            cd.getMontosImponibles().add(mi);

            comp.getComprobandtedetalle().add(cd);

            MontoImponible mi2 = new MontoImponible();
            mi2.setTipoImpuesto(3L);
            mi2.setTotal(Double.valueOf(x[10].trim()) * -1);
            mi2.setBaseImponible(Double.valueOf(x[10].trim()) * -1);
            mi2.setTotalView(mi2.getTotal() + "");
            mi2.setBaseImponibleView(mi2.getBaseImponible() + "");
            mi2.setValorView("0");

            comp.getMontosImponibles().add(mi2);

            comp.setCambio(1L);
            comp.setMoneda(56L);
            comp.setTipo(4L);
            
            Long timbradoPuntoEmisionId = 0L;
            Long sucursalId = 0L;
            
           Long timbradoNum = Long.parseLong(x[6].trim());
            
            for (Timbrado pv : lTimbrados){

                //if (Objects.equals(pv.getNumeroTimbrado(), timbradoNum) ){
                if (Objects.equals(pv.getNumeroTimbrado(), timbradoNum)){
                    timbradoPuntoEmisionId = pv.getId(); 
                    sucursalId = pv.getSucursal().getId();
                    break;
                    
                }
                
            }
            
            comp.setTimbradoPuntoEmision(timbradoPuntoEmisionId);
            comp.setTipoAplicacion(7459L);
            comp.setDeposito(2L);
            comp.setNumero(x[9].trim());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(x[7].trim());
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            comp.setFecha(sdf2.format(fecha));
            
            comp.setMontoTotal(Double.valueOf(x[10].trim()) * -1);
            comp.setMontoTotalView(comp.getMontoTotal() + "");
            comp.setTotalImpuestos(0.0);

            comp.setLocacion(1L);
            comp.setSucursal(sucursalId);
            
            out.add(comp);

        }

        return out;

    }

}
