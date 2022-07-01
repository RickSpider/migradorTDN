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
            
                System.out.println("encontro wey");
                
                for (UnidadMedida u : lUnidadMedida ){

                     /*if (u.getDescripcion().compareTo(x[16].toString().trim().toUpperCase()) == 0
                            && u.getCantidad() == ((int) Double.parseDouble(x[17].toString().replace(",", ".")))
                            && u.getUnidadContenida().getDescripcion().toString().compareTo(x[15].toString().trim().toUpperCase()) == 0) {
*/
                     
                int cant = (int) Double.parseDouble(x[17].toString().replace(",", "."));
            
                if (u.getDescripcion().compareTo(x[16].toString().trim().toUpperCase()+cant) == 0
                       // && u.getCantidad() == ((int) Double.parseDouble(x[17].toString().replace(",", ".")))
                        && u.getCantidad() == cant
                        && u.getUnidadContenida().getDescripcion().toString().compareTo(x[15].toString().trim().toUpperCase()) == 0) {
                     
                       p.getUnidadesMedida().add(u.getId());
                       
                       if (p.getConversion() < cant){
                       
                           p.setPresentacion(u.getId());
                           p.setConversion(Double.parseDouble(x[17].toString().replace(",", ".")));
                           p.setPesoUnidadBase(p.getContenido());
                           p.setPesoUnidadPresentacion(p.getConversion()*p.getPesoUnidadBase());
                           
                       }

                       break;
                    }

                }
                
                
                
                continue;
            }
           
            
            p.setNombre(x[1].trim());
            
            if (x[19].trim().compareTo("3")==0){
            
                p.getLocaciones().add(1L);
                p.getLocaciones().add(7L);
                p.getLocaciones().add(9L);
            }
            
            if (x[19].trim().compareTo("1")==0){
            
                 p.getLocaciones().add(7L);
                
            }
            
           
            
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
            
            String codigoBarra = "";
            
            if (x[11].trim().length() > 0){
        
                codigoBarra = x[11].trim();
                
            }else{
            
                codigoBarra = x[0].trim();
                
            }
              
            p.setCodigoBarrasPrincipal(new CodigoBarras());
            p.getCodigoBarrasPrincipal().setCodigoBarras(codigoBarra);
            p.getCodigosBarras().add(p.getCodigoBarrasPrincipal());
            
            
            if (x[18].trim().compareTo("T")==0){
            
                p.setEsProductoImportacion(true);
                
            }
            
            
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
                
                int cant = (int) Double.parseDouble(x[17].toString().replace(",", "."));
            
                 if (u.getDescripcion().compareTo(x[16].toString().trim().toUpperCase()+cant) == 0
                       // && u.getCantidad() == ((int) Double.parseDouble(x[17].toString().replace(",", ".")))
                        && u.getCantidad() == cant
                        && u.getUnidadContenida().getDescripcion().toString().compareTo(x[15].toString().trim().toUpperCase()) == 0) {
                     
                    

                 
                   
                   if (u.getDescripcion().compareTo("UNIDAD1")!=0){
                     
                        p.getUnidadesMedida().add(u.getId());
                   
                   }
                   p.setPresentacion(u.getId());
                   p.setConversion((double) cant);
                 
                 
                   break;
                }
                
            }
            
            for (Proveedor prov : lProveedor){
            
                if (prov.getNumeroDocumento().compareTo(x[9].trim())==0){
                    
                    p.setProveedorPrincipal(prov.getId());
                    p.setProveedorSucursal(prov.getSucursales().get(0).getId());
                    p.getProveedores().add(prov.getId());
                
                    break;
                }
                
            }
            
            System.out.println("csvProducto = "+x[3].trim());
            
            for (String[] s : csvArrayLinea){
            
                String lienea = x[3].trim().replace("FRACC.", "FRACCIONADO").replace("PROD.", "PROD ").replace("GATOS", "GATO");
                
                if (s[4].trim().toUpperCase().contains(lienea.toUpperCase())){
                
                    int linea = (int) Double.parseDouble(s[0].toString().trim());
                    
                    p.setLineaProducto(new Long(linea));
                    
                    break;
                    
                }
                
            }
            
            
             for (UnidadMedida ub : lUnidadMedidaBase){
            
                if (ub.getDescripcion().compareTo("kilogramos") == 0){
                
                    p.setUnidadMedidaContenida(ub.getId());
                    System.out.println("para el contenido"+ x[13]);
                    p.setContenido( Double.valueOf(x[13].trim().replace(",", "."))/1000);
                   
                    break;
                }                
                
            }

            System.out.println(p.getNombre());
            
            System.out.println("Conversion "+p.getConversion());
            System.out.println("Contenido "+p.getContenido());
                        
           // double mult = p.getConversion()*p.getContenido();
            
            //System.out.println("antes de multiplicar "+mult);
             
            p.setPesoUnidadBase(p.getContenido());
            p.setPesoUnidadPresentacion(p.getConversion()*p.getPesoUnidadBase());
            
            out.add(p);
            
            
        }
        
        return out;
    }
    
}
