/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.model.Proveedor;
import com.migradortdn.model.TipoProveedor;
import java.util.ArrayList;

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
    
}
