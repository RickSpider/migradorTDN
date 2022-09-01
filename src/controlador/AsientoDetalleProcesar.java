/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.model.AsientoCabecera;
import com.migradortdn.model.AsientoDetalle;
import com.migradortdn.model.CentroCosto;
import com.migradortdn.model.CuentaContable;
import com.migradortdn.model.Sucursal;
import com.migradortdn.model.TipoDetalleAsiento;
import java.util.ArrayList;

/**
 *
 * @author BlackSpider
 */
public class AsientoDetalleProcesar {
    
    public  ArrayList <AsientoDetalle> procesarDetalle(ArrayList<AsientoCabecera> lcabeceras, ArrayList<String[]> asientos, ArrayList<String[]> centroCostosQualita, ArrayList<String[]> planCuentas ){
        
        ArrayList <AsientoDetalle> lDetalles = new ArrayList<AsientoDetalle>();
        
        for (String [] x : asientos){
        
            AsientoDetalle detalle = new AsientoDetalle();
            //detalle.setAsientoContable(asiento);
            
            for (AsientoCabecera ac : lcabeceras){
            
                Long numero = Long.parseLong(x[2]);
                if (numero.longValue() == ac.getNumero().longValue()){
                    detalle.setAsientoContable(ac);
                    break;
                }
                
            }
            
            if (x[9].length() == 0){
                
                System.out.println("Sin Sucursal para "+x[2]+" "+x[6]+" "+x[7]+" "+x[10]);
            
                continue;
            }
            
            int sucursalID = Integer.parseInt(x[22]);
            
            switch(sucursalID){
            
                case 1:{
                    // San Lorenzo Matriz
                    Sucursal sucursal = new Sucursal();
                    sucursal.setId(1l);
                    detalle.setSucursal(sucursal);
                    break;
                }
                
                 case 2:{
                    //encarnacion
                    Sucursal sucursal = new Sucursal();
                    sucursal.setId(2l);
                    detalle.setSucursal(sucursal);
                    break;
                }
                
                case 3:{
                    //coronel oviedo
                    Sucursal sucursal = new Sucursal();
                    sucursal.setId(3l);
                    detalle.setSucursal(sucursal);
                    break;
                }
                
                case 4:{
                    // los pinos
                    Sucursal sucursal = new Sucursal();
                    sucursal.setId(4l);
                    detalle.setSucursal(sucursal);
                    break;
                }                
                
                case 5:{
                    //colonia
                    Sucursal sucursal = new Sucursal();
                    sucursal.setId(5l);
                    detalle.setSucursal(sucursal);
                    break;
                }
                
                case 6:{
                    //san ignacio
                    Sucursal sucursal = new Sucursal();
                    sucursal.setId(6l);
                    detalle.setSucursal(sucursal);
                    break;
                }
                
            }
            
            if (detalle.getSucursal() == null){
                System.out.println("No encontre Sucursal para "+x[2]+" "+x[6]+" "+x[7]+" "+x[10]);
                continue;
                
            }
            
           /* if (x[11].length() == 0){
            
                System.out.println("Sin Centro de costos "+x[2]+" "+x[6]+" "+x[7]+" "+x[10]);
                continue;
                
            }*/
            
            for (String [] y : centroCostosQualita){

                if (x[24].compareTo(y[1])==0){
                    
                    CentroCosto cc = new CentroCosto();
                    cc.setId(Long.parseLong(y[0]));
                    detalle.setCentroCostos(cc);
                    
                    break;
                }
                
            }
            
           /* if (detalle.getCentroCostos() == null){
            
               // System.out.println("No encontre centro para "+x[2]+" "+x[6]+" "+x[7]+" "+x[10]);
                
                continue;
                
            }*/
            
            if (x[17].length() > 0){
            
                TipoDetalleAsiento tda = new TipoDetalleAsiento();
                tda.setId(7550);
                
                detalle.setTipoDetalle(tda);
                detalle.setDebe(Double.parseDouble(x[17].replace(",", ".")));
            }
            
            if (x[18].length() > 0){
            
                TipoDetalleAsiento tda = new TipoDetalleAsiento();
                tda.setId(7546);
                
                detalle.setTipoDetalle(tda);
                detalle.setHaber(Double.parseDouble(x[18].replace(",", ".")));
                
            }
                
            for (String[] z : planCuentas){
            
                if (x[6].compareTo(z[0]) == 0){
                    
                    if (z[4].compareTo("#N/D")==0){
                        System.out.println("Cuenta no aplica encontrada "+x[6]);
                        break;
                    }               
                    CuentaContable cc = new CuentaContable();
                    cc.setId(Long.parseLong(z[4]));
                    detalle.setCuentaContable(cc);
                    break;
                }
            }
            
            /*if (detalle.getCentroCostos() == null){
            
               // System.out.println("No Cuenta para "+x[2]+" "+x[6]+" "+x[7]+" "+x[10]);
                
                continue;
                
            }*/
        
            detalle.setDescripciontransaccion(x[20]);
            detalle.setDescripcionlinea(x[19]);
            
            lDetalles.add(detalle);
        }
        
        return lDetalles;
        
    }
    
}
