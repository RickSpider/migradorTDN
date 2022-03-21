/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.model.CodigoBarras;
import com.migradortdn.model.Marca;
import com.migradortdn.model.Producto;
import com.migradortdn.model.Proveedor;
import com.migradortdn.model.UnidadMedida;
import java.util.ArrayList;

/**
 *
 * @author BlackSpider
 */
public class ProductoDatosProcesar {

    public ArrayList<Producto> procesarDatosProducto(ArrayList<String[]> csvArrayProducto, ArrayList<String[]> csvArrayLinea, ArrayList<Proveedor> lProveedor, ArrayList<UnidadMedida> lUnidadMedidaBase, ArrayList<UnidadMedida> lUnidadMedida, ArrayList<Marca> lMarca) {
        
        ArrayList<Producto> out = new ArrayList<Producto>();
        
        for (String[] x : csvArrayProducto){
            
            Producto p = new Producto();
            boolean encontro = false;
            
            for (Producto x1 : out){
            
                if (x1.getNombre().compareTo(x[1].trim())==0){
                    
                    p = x1;
                    encontro = true;
                    break;
                    
                }
                
            }
            
            if (encontro){
            
                
                for (UnidadMedida u : lUnidadMedida ){

                     if (u.getDescripcion().compareTo(x[16].toString().trim().toUpperCase()) == 0
                            && u.getCantidad() == ((int) Double.parseDouble(x[17].toString().replace(",", ".")))
                            && u.getUnidadContenida().getDescripcion().toString().compareTo(x[15].toString().trim().toUpperCase()) == 0) {

                       p.getUnidadesMedida().add(u.getId());

                       break;
                    }

                }
                
                continue;
            }
           
            
            p.setNombre(x[1].trim());
            p.getLocaciones().add(1L);
            
            int impuesto = (int) Double.parseDouble(x[5].trim().replace(",", "."));
            
            switch (impuesto){
            
                case 5 : {
                     p.getTiposImpuesto().add(2L);
                    break;
                }
                
                case 10 :{
                     p.getTiposImpuesto().add(1L);
                     break;
                }
                
            }
            
            p.setCodigoBarrasPrincipal(new CodigoBarras());
            p.getCodigoBarrasPrincipal().setCodigoBarras(x[11]);
            p.getCodigosBarras().add(p.getCodigoBarrasPrincipal());
            
            int stocklote = (int) Double.parseDouble(x[14].trim());
            switch(stocklote){
                
                case 0:{
                    p.setCriterioControl(128L);
                    break;
                }
                
                
                case 1:{
                    p.setCriterioControl(21L);
                    break;
                }
            
            
            }
            
            for (Marca m : lMarca){
            
                if (m.getDescripcion().compareTo(x[8].trim().toUpperCase())==0){
                
                    p.setMarca(m.getId());
                    break;
                }
                
            }
            
            for (UnidadMedida ub : lUnidadMedidaBase){
            
                if (ub.getDescripcion().compareTo(x[15].trim().toUpperCase()) == 0){
                
                    p.setUnidadMedidaBase(ub.getId());
                    p.getUnidadesMedida().add(ub.getId());
                    break;
                }                
                
            }
            
            for (UnidadMedida u : lUnidadMedida ){
            
                 if (u.getDescripcion().compareTo(x[16].toString().trim().toUpperCase()) == 0
                        && u.getCantidad() == ((int) Double.parseDouble(x[17].toString().replace(",", ".")))
                        && u.getUnidadContenida().getDescripcion().toString().compareTo(x[15].toString().trim().toUpperCase()) == 0) {

                   p.getUnidadesMedida().add(u.getId());
                 
                   break;
                }
                
            }
            
            for (Proveedor prov : lProveedor){
            
                if (prov.getNumeroDocumento().compareTo(x[9].trim())==0){
                    
                    p.setProveedorPrincipal(prov.getId());
                    p.setProveedorSucursal(prov.getId());
                    p.getProveedores().add(prov.getId());
                
                    break;
                }
                
            }
            
            for (String[] s : csvArrayLinea){
            
                if (s[4].trim().toUpperCase().contains(x[3].trim().toUpperCase())){
                
                    int linea = (int) Double.parseDouble(s[0].toString().trim());
                    
                    p.setLineaProducto(new Long(linea));
                    
                    break;
                    
                }
                
            }
            
            
            out.add(p);
            
            
        }
        
        return out;
    }
    
}
