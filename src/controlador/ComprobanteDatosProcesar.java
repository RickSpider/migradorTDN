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
import com.migradortdn.model.TimbradoPuntoEmision;
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

    public ArrayList<Comprobante> procesarDatosComprobante(ArrayList<String[]> csvArrayComprobante,
            ArrayList<Cliente> lClientes, ArrayList<Timbrado>lTimbrados, ArrayList<String[]> csvArrayLocacion, Long tipoComprobante) throws ParseException {

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
                    
                    if (comp.getSucursalCliente() == null){
                    
                        comp.setSucursalCliente(c.getSucursales().get(0).getId());
                        
                    }  

                }

            }

            MontoImponible mi = new MontoImponible();
            mi.setTipoImpuesto(3L);
            
            Double saldo = Double.valueOf(x[10].trim());
            
            if (tipoComprobante.longValue() == 4L){
            
                saldo = saldo*-1;
                
            }
            
            mi.setBaseImponible(saldo);
            mi.setPorcentaje(0L);

            ComprobanteDetalle cd = new ComprobanteDetalle();
            cd.setTipo(105L);
            cd.setServicio(415L);
            cd.setTotalItem(saldo);
            cd.setTotalItemView(cd.getTotalItem() + "");
            cd.setPrecioVenta(saldo);
            cd.setUltimoPrecioView(cd.getPrecioVenta() + "");
            cd.getMontosImponibles().add(mi);

            comp.getComprobanteDetalle().add(cd);

            MontoImponible mi2 = new MontoImponible();
            mi2.setTipoImpuesto(3L);
            mi2.setTotal(saldo);
            mi2.setBaseImponible(saldo);
            mi2.setTotalView(mi2.getTotal() + "");
            mi2.setBaseImponibleView(mi2.getBaseImponible() + "");
            mi2.setValorView("0");

            comp.getMontosImponibles().add(mi2);

            comp.setCambio(1L);
            comp.setMoneda(56L);
            comp.setTipo(tipoComprobante); // 4 NOTA DE CREDITO 3 FACTURA credito
            
            Long timbradoPuntoEmisionId = 0L;
            Long sucursalId = 0L;
            
           Long timbradoNum = Long.parseLong(x[6].trim());
           
            //System.out.println("andes del ciclo el timbrado es :"+timbradoNum);
            
            for (Timbrado pv : lTimbrados){
                
               // System.out.println("timbrado viene "+pv.getNumeroTimbrado());

                if (pv.getNumeroTimbrado() == timbradoNum.longValue() ){
                //if (Objects.equals(pv.getNumeroTimbrado(), timbradoNum)){
                    //timbradoPuntoEmisionId = pv.getId(); 
                    System.out.println("el timbrado macheado es  "+pv.getNumeroTimbrado());

                    for (TimbradoPuntoEmision tpe : pv.getTimbradoPuntoEmision()){
                        
                        System.out.println(tpe.getId());
                        System.out.println(tpe.getTipoComprobante().getDescripcion());
                        System.out.println(tpe.getTipoComprobante().getId());
                        
                        Long comprobanteID = 0L;
                        
                        // 41 factura
                        // 42 nota credito
                        
                        if (tipoComprobante.longValue() == 3){
                        
                            comprobanteID = 41L;
                            
                        }
                        
                         if (tipoComprobante.longValue() == 4){
                        
                            comprobanteID = 42L;
                            
                        }
                        
                        if (tpe.getTipoComprobante().getId().longValue() == comprobanteID.longValue()){
                        
                            System.out.println("Encontre comprobante tipo igual");
                            timbradoPuntoEmisionId = tpe.getId();
                            break;
                            
                        }
                        
                    }
                  
                    //System.out.println("el timbrado :"+pv.getNumeroTimbrado()+" "+timbradoNum);
                    //System.out.println();
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
            
            comp.setMontoTotal(saldo);
            comp.setMontoTotalView(comp.getMontoTotal() + "");
            comp.setTotalImpuestos(0.0);

            //comp.setLocacion(1L);
            
            for (String[] s : csvArrayLocacion){
            
                
                
                if (s[1].trim().compareTo(String.valueOf(sucursalId.longValue()))==0){
                
                    if (s[2].trim().compareTo("1") == 0){
                    
                        comp.setLocacion(Long.parseLong(s[0].trim()));
                        
                        break;
                        
                    }
                    
                }
                
            }
            
            comp.setSucursal(sucursalId);
            
            out.add(comp);

        }

        return out;

    }

}
