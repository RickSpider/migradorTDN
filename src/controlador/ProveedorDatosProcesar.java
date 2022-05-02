/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.migradortdn.model.Comprobante;
import com.migradortdn.model.ComprobanteDetalle;
import com.migradortdn.model.MontoImponible;
import com.migradortdn.model.Proveedor;
import com.migradortdn.model.PuntoEmision;
import com.migradortdn.model.Sucursal;
import com.migradortdn.model.TimbradoProveedor;
import com.migradortdn.model.TipoProveedor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BlackSpider
 */
public class ProveedorDatosProcesar {
    
    public ArrayList<Proveedor> procesarDatosProveedores (ArrayList<String[]> csvArray, ArrayList<TipoProveedor> lTipoProveedor){
    
        ArrayList <Proveedor> out = new ArrayList<Proveedor>();
        
        if (csvArray.size() > 0) {
        
              for (String[] x : csvArray) {
              
                  Proveedor p = new Proveedor();
                  
                  p.setNombre(x[2].toString().trim());
                  p.setNombreFantasia(x[2].toString().trim());
                  p.setDireccion(x[5].toString().trim());
                  
                  if (x[7].toString().trim().length() > 0){
                    p.setTelefono(x[7].toString().trim());
                  }
               
                  p.getTipoDocumento().setId(31);
                  p.setNumeroDocumento(x[4].toString().trim());
                  p.getClaseProveedor().setId(116L); // siempre local
                  
                  if (x[4].toString().trim().length() < 10){
                  
                      //fisco
                       p.getTipoPersona().setId(36);
                  }else {
                  
                       //juridico
                      p.getTipoPersona().setId(37);
                      
                  }
                  
                  if (x[3].toString().trim().length() > 0){
                  
                      String tipoProveedor = x[3].toString().trim();
                      
                      for (TipoProveedor x1 : lTipoProveedor){
                      
                          if (x1.getDescripcion().compareTo(tipoProveedor)==0){
                          
                              p.setTipoProveedor(x1);
                              
                          }
                          
                      }
                      
                      
                      
                  }
                  
                  
                  
                  out.add(p);
              }
            
        }        
        
        return out;
    }
    
    public  ArrayList<Proveedor> procesarSucursalProveedor(ArrayList<String[]> csvArray, ArrayList<Proveedor>lProveedores){
    
        ArrayList<Proveedor> out = new ArrayList<Proveedor>();
        
        for (String[] x : csvArray){
        
            String [] numeracion = x[9].trim().split("-");
            String numeroDocumento = x[2].trim();
            
            Proveedor prov = null;
            
            boolean encontroEstablecimiento = false;   
            boolean encontroPuntoEmision = false;
            
          
            for (Proveedor p : lProveedores){
                //System.out.println(p.getId());
                if (p.getNumeroDocumento().compareTo(numeroDocumento)==0){
                                        
                    encontroEstablecimiento = false;   
                    encontroPuntoEmision = false;
                    
                    for (Sucursal s : p.getSucursales()){
                    
                        if (s.getCodigoEstablecimiento().compareTo(numeracion[0].trim())==0){
                            
                            encontroEstablecimiento = true;
                            
                            for (PuntoEmision pe : s.getPuntosEmisionSucursal()){
                            
                                if (pe.getPuntoEmision().compareTo(numeracion[1].trim())==0){
                                
                                    encontroPuntoEmision = true;
                                    break;
                                    
                                }
                                
                            }
                            
                            if (!encontroPuntoEmision){
                            
                                PuntoEmision pe = new PuntoEmision();
                                pe.setPuntoEmision(numeracion[1].trim());
                                s.getPuntosEmisionSucursal().add(pe);
                                
                                prov = p;
                                break;
                                
                            }
                            
                           
         
                            
                        }
                        
                        if (encontroEstablecimiento){
                            
                            break;
                        }
                        
                    }
                    
                    if (!encontroEstablecimiento){
                    
                        Sucursal suc = new Sucursal();
                        suc.setCodigoEstablecimiento(numeracion[0]);
                        suc.setDescripcion("suc" + numeracion[0]);
                        
                        suc.setPuntosEmisionSucursal(new ArrayList<PuntoEmision>());
                        PuntoEmision pe = new PuntoEmision();
                        pe.setPuntoEmision(numeracion[1]);
                        suc.getPuntosEmisionSucursal().add(pe);
                        
                        p.getSucursales().add(suc);
                        prov = p;
                        break;
                                                
                    }else{
                    
                        break;
                        
                    }
                    
                }
                
            }
            
            if (prov != null){
             
                out.add(prov);
                 
            }else{
            
                if (!encontroEstablecimiento && !encontroPuntoEmision){
                
                    System.out.println("Prov no encontrado "+x[2].trim()+" "+x[3]);
                    
                }
                
            }
            
        }
         
        return out;
        
    }
    
    public ArrayList<TimbradoProveedor> procesarTimbradoProveedor(ArrayList<String[]> csvArray, ArrayList<Proveedor>lProveedores) throws ParseException{
    
        ArrayList<TimbradoProveedor> out = new ArrayList<TimbradoProveedor>();
        
        for (String [] x : csvArray){
        
            boolean encontro = false;
            
            for (TimbradoProveedor tp : out){
            
                if (tp.getNumero().compareTo(x[6].trim())==0){
                
                    encontro = true;
                    break;
                }
                
            }
            
            if (encontro){
            
                continue;
                
            }
            
            Proveedor prov = null;
            
            for (Proveedor p : lProveedores){
            
                if (p.getNumeroDocumento().compareTo(x[2].trim())==0){
                
                    prov = p;
                    break;
                }
                
            }        
            
            if (prov == null){
                
                System.out.println("Prov no encontrado "+x[2].trim()+" "+x[3].trim());
            
                continue;
                
            }
           
            
            TimbradoProveedor tProv = new TimbradoProveedor();
            
            tProv.setNumero(x[6].trim());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDesde = sdf.parse(x[14].trim());
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            tProv.setFechaDesde(sdf2.format(fechaDesde));
            
            Date fechaHasta =  sdf.parse(x[15].trim());
            tProv.setFechaHasta(sdf2.format(fechaHasta));
            
           /* tProv.setFechaDesde(x[14].trim());
            tProv.setFechaHasta(x[15].trim());*/
            tProv.setProveedor(prov);
            
            String[] codFactura= x[9].trim().split("-");
            
            for (Sucursal s : prov.getSucursales()){
            
                if (s.getCodigoEstablecimiento().compareTo(codFactura[0])==0){
                
                    tProv.setSucursalProveedor(s);
                    
                }
                
            }
            
            out.add(tProv);
            
        }
        
        return out;
        
    }
    
     public  ArrayList<Comprobante> procesarComprobanteProveedor(ArrayList<String[]> csvArray, 
             ArrayList<TimbradoProveedor> lTimbradosProveedor,ArrayList<Proveedor>lProveedores) throws ParseException{
     
        ArrayList<Comprobante> out = new ArrayList();
         
        
        for (String[] x : csvArray ){

            
            //proveedor
            Comprobante comp = new Comprobante();
            Proveedor prov = null;
            
            for (Proveedor p : lProveedores){
             
                if (p.getNumeroDocumento().compareTo(x[2].trim()) == 0){
                
                    prov = p;
                    break;
                }
                
            }
            
            if (prov == null){
            
                continue;
                
            }
            
            comp.setProveedor(prov.getId());
            
            
            //sucursal
            String [] numFactura = x[9].trim().split("-");
            
            for (Sucursal s : prov.getSucursales()){
            
                if (s.getCodigoEstablecimiento().compareTo(numFactura[0])==0){
                
                    comp.setSucursalProveedor(s.getId());
                    
                }
                
            }
            
            //timbrado
            
            for (TimbradoProveedor tp : lTimbradosProveedor){
            
                
                
                    if (tp.getNumero().compareTo(x[6].trim())==0){
                    
                        comp.setTimbradoProveedor(tp.getId());
                        
                        break;
                        
                    }                  
                    
                
                
            }
            
            //fecha
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(x[7].trim());
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            comp.setFecha(sdf2.format(fecha));
            
            //numero de factura
            comp.setNumero(x[9].trim());
            
            //montosImponibles
            //excento 3l
            //10 1L
            //5 2L
            
            Double saldo = Double.valueOf(x[10].trim());
            
            MontoImponible mi2 = new MontoImponible();
            
            Long iva = Long.parseLong(x[13].trim());
            
            if (iva.longValue() == 0){
            
                mi2.setTipoImpuesto(3L);
                
            }
            
            if (iva.longValue() == 10){
            
                mi2.setTipoImpuesto(1L);
                
            }
            
             if (iva.longValue() == 5){
            
                mi2.setTipoImpuesto(2L);
                
            }
            
            
            mi2.setTotal(saldo);
            mi2.setBaseImponible(saldo);
            mi2.setTotalView(mi2.getTotal() + "");
            mi2.setBaseImponibleView(mi2.getBaseImponible() + "");
            mi2.setValorView("0");

            comp.getMontosImponibles().add(mi2);

            //
            comp.setGrupoCompra(6L);
            comp.setTipo(3L);
            comp.setMontoTotal(saldo);
            comp.setFob(0L);
            comp.setLocacion(1L);
            
            comp.setProveedorPlazoCuotas(Long.parseLong(x[16].trim()));
            
            //moneda 
            
            if (x[1].trim().compareTo("Gs")==0){
            
                comp.setMoneda1(56L);
                comp.setCambio(1L);
                
            }
            
            if (x[1].trim().compareTo("U$S")==0){
            
                comp.setMoneda1(57L);
                comp.setCambio(Long.parseLong(x[0].trim()));
                
            }
            
            //detalle
            
            // 3L excento
            // 1L iva10
            // 2L iva5
            
            MontoImponible mi = new MontoImponible();
          
            
             if (iva.longValue() == 0){
            
                mi.setTipoImpuesto(3L);
                
            }
            
            if (iva.longValue() == 10){
            
                mi.setTipoImpuesto(1L);
                
            }
            
             if (iva.longValue() == 5){
            
                mi.setTipoImpuesto(2L);
                
            }
            
            mi.setBaseImponible(saldo);
            mi.setPorcentaje(0L);

            ComprobanteDetalle cd = new ComprobanteDetalle();
            
            cd.setTipo(105L);
            
            if (iva.longValue() == 0){
            
                  cd.setServicio(440L);
            }
            
            if (iva.longValue() == 10){
            
                  cd.setServicio(442L);
                
            }
            
             if (iva.longValue() == 5){
            
                cd.setServicio(441L);
                
            }
           
            cd.setTotalItem(saldo);
            cd.setTotalItemView(cd.getTotalItem() + "");
            cd.setPrecioVenta(saldo);
            cd.setUltimoPrecio(saldo);
            cd.setUltimoPrecioView(cd.getPrecioVenta() + "");
            cd.getMontosImponibles().add(mi);

            comp.getComprobanteDetalle().add(cd);
            
            out.add(comp);
             
        }        
         
        return out;
         
     }
    
    
}
