/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import com.google.gson.Gson;
import com.migradortdn.model.AsientoCabecera;
import com.migradortdn.model.AsientoDetalle;
import controlador.AsientoCabeceraProcesar;
import controlador.AsientoDetalleProcesar;
import controlador.LeeCSV;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author BlackSpider
 */
public class MigradorAsientos {
        
        
    public static void main(String[] args) throws IOException {
      
       
       AsientoCabecera asiento = new AsientoCabecera();
       asiento.setId(35277L);
       
       LeeCSV csv = new LeeCSV();
       ArrayList<String[]> asientos = csv.leerArchivo2("datos/asientos/01_enero_2022_maker.csv");
       //ArrayList<String[]> centroCostos = csv.leerArchivo2("datos/asientos/Centro_de_Costos.csv");
       ArrayList<String[]> planCuentas = csv.leerArchivo2("datos/asientos/Plan_de_Cuentas.csv");
       ArrayList<String[]> centroCostosQualita = csv.leerArchivo("datos/asientos/centroCostosQualita.csv");
       
       AsientoCabeceraProcesar acp = new AsientoCabeceraProcesar();
       
       ArrayList<AsientoCabecera> lcabeceras = acp.procesar(asientos);
       
       AsientoDetalleProcesar adp = new AsientoDetalleProcesar();
       
       for (int i = 0 ; i<1 ;  i++){
       
           System.out.println(new Gson().toJson(lcabeceras.get(i)));
           
       }
       
      ArrayList<AsientoDetalle> lDetalles = adp.procesarDetalle(asiento, asientos, centroCostosQualita, planCuentas);
       
       for (int i = 0 ; i<1 ;  i++){
       
           System.out.println(new Gson().toJson(lDetalles.get(i)));
           
       }
       
     
       
      
    }
}
