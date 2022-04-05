/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.model.ClaseTimbrado;
import com.migradortdn.model.PuntoEmision;
import com.migradortdn.model.PuntoVenta;
import com.migradortdn.model.Sucursal;
import com.migradortdn.model.Timbrado;
import com.migradortdn.model.TimbradoPuntoEmision;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BlackSpider
 */
public class TimbradoDatosProcesar {
    
    public ArrayList<Timbrado> procesarTimbrado( ArrayList<String[]> csvArray, ArrayList<PuntoVenta> lPuntoVenta, Long tipoComprobante) throws ParseException{
    
        ArrayList<Timbrado> out = new ArrayList<Timbrado>();
        
        for (String[] x : csvArray){
            
            Timbrado timbrado = new Timbrado();
            
            Long numeroTimbrado =  (long) Double.parseDouble(x[4].trim().replace(",", "."));
            
            if (numeroTimbrado < 9999999 || numeroTimbrado > 100000000){
            
                continue;
                
            }
            
            timbrado.setNumeroTimbrado(numeroTimbrado);
        
            int cs = (int) Double.parseDouble(x[2].trim().replace(",", "."));
            int pm = (int) Double.parseDouble(x[3].trim().replace(",", "."));
            
            String codigoSucursal = "";
            String puntoEmision ="";
            
            if (cs < 10){
            
                codigoSucursal = "00"+cs;
                
            }
            
            if (cs >= 10 && cs <100){
            
                codigoSucursal = "0"+cs;
                
            }
            
            if (cs >=100){
            
                codigoSucursal = ""+cs;
                
            }
            
              if (pm < 10){
            
                puntoEmision = "00"+pm;
                
            }
            
            if (pm >= 10 && pm <100){
            
                puntoEmision = "0"+pm;
                
            }
            
            if (pm >=100){
            
                puntoEmision = ""+pm;
                
            }
            
            Sucursal sucursal = null;
            Long puntoEmisionId = 0L;
            
            for (PuntoVenta pv : lPuntoVenta){
            
                
                
                if (pv.getCodigoSucursal().compareTo(codigoSucursal) == 0){
                
                    //System.out.println("Entre en el primer if");
                    
                    sucursal = pv.getSucursal();
                
                    for (PuntoEmision pe : pv.getPuntosEmision()){
                        
                       /* System.out.println("Este es el PE "+pe.getNumero());
                        System.out.println("Este es el puntoEmision "+puntoEmision);*/
                        
                        if (pe.getNumero().compareTo(puntoEmision)==0){
                            
                          System.out.println("entre en el segundo if");
                        
                          puntoEmisionId = pe.getId();
                          
                          
                          break;
                        }
                        
                    }
                    
                    if (puntoEmisionId > 0 && sucursal!= null){
                    
                        break;
                        
                    }
                    
                }
                
            }
            
            timbrado.setSucursal(sucursal);
           
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDesde = sdf.parse(x[8].trim());
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            timbrado.setFechaDesde(sdf2.format(fechaDesde));
            
            Date fechaHasta = sdf.parse(x[9].trim());
            timbrado.setFechaHasta(sdf2.format(fechaHasta));
            
            ClaseTimbrado ct = new ClaseTimbrado();
            ct.setId(308L);
            timbrado.setClaseTimbrado(ct);
            
            timbrado.setTimbradoPuntoEmision(new ArrayList<TimbradoPuntoEmision>());
            TimbradoPuntoEmision tpe = new TimbradoPuntoEmision();
            tpe.setPuntoEmisionVenta(puntoEmisionId);
            tpe.setTipoComprobante(tipoComprobante);
            tpe.setNumeroInicial((long) Double.parseDouble(x[6].trim().replace(",", ".")));
            tpe.setNumeroFinal((long) Double.parseDouble(x[7].trim().replace(",", ".")));
            timbrado.getTimbradoPuntoEmision().add(tpe);
            
            out.add(timbrado);
        }
        
        
        
        return out;
    }
    
}
