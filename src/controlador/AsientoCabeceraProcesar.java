/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.model.AsientoCabecera;
import com.migradortdn.model.Estado;
import com.migradortdn.model.Sucursal;
import com.migradortdn.model.TipoAsiento;
import com.migradortdn.model.UnidadNegocio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author blackspider
 */
public class AsientoCabeceraProcesar {

    public ArrayList<AsientoCabecera> procesar(ArrayList<String[]> datos) throws ParseException {

        ArrayList<AsientoCabecera> out = new ArrayList<AsientoCabecera>();

        for (String[] x : datos) {

            boolean existe = false;
            
            //System.out.println(x[2]);
            
            Long numero = Long.parseLong(x[2]);
            for (AsientoCabecera y : out){
                
                if (y.getNumero().longValue() == numero.longValue() ){
                
                    existe = true;
                    
                }
                
            }
            
            if (existe){
            
                continue;
                
            }
            
            AsientoCabecera ac = new AsientoCabecera();

                ac.setNumero(numero);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = x[0].replace("0:00", "").trim();
                ac.setFecha(new SimpleDateFormat("yyyy-MM-dd'T'23:59:59.000'Z'").format(format.parse(fecha)));

                Estado e = new Estado();
                e.setId(62l);
                ac.setEstado(e);

                TipoAsiento ta = new TipoAsiento();
                ta.setId(19L);
                ta.setCodigo("asiento_manual");
                ac.setTipoAsiento(ta);

                Sucursal sucursal = new Sucursal();
                sucursal.setId(1l);
                ac.setSucursal(sucursal);

                UnidadNegocio un = new UnidadNegocio();
                un.setId(2L);
                ac.setUnidadNegocio(un);
                
                ac.setTituloasiento("Migracion asiento " + numero);
                
                out.add(ac);

        }

        return out;

    }

}
