/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import com.google.gson.Gson;
import com.migradortdn.model.AsientoCabecera;
import com.migradortdn.model.AsientoDetalle;
import com.migradortdn.model.Estado;
import com.migradortdn.model.Login;
import com.migradortdn.model.Sucursal;
import com.migradortdn.model.TipoAsiento;
import com.migradortdn.model.Token;
import com.migradortdn.model.TokenConta;
import com.migradortdn.model.UnidadNegocio;
import controlador.AsientoDetalleProcesar;
import controlador.LeeCSV;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BlackSpider
 */
public class MigradorAsientos {
        
        
    public static void main(String[] args) throws IOException {
       /* ConexionHttps con = new ConexionHttps();
        String resultado = "";
        
        con.setLink(Config.HOSTCONTA + "/contabilidad-client-backend/rest/jwt/token");

        Login login = new Login("password","admin", "contamaster$");
        //   Login login = new Login("admin", "admin");

        con.setBody(new Gson().toJson(login));

        resultado = con.getConexion(Config.POST);

        TokenConta rToken = new Gson().fromJson(resultado, TokenConta.class);
        //rToken.setUsername(login.getUsername());
    
        System.out.println(rToken.getToken());
        
        AsientoCabecera ac = new AsientoCabecera();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ac.setFecha(sdf.format(new Date()));
        ac.setTituloasiento("Asiento desde migrado");
        
        Sucursal suc = new Sucursal();
        suc.setId(1L);
        ac.setSucursal(suc);
        
        TipoAsiento ta = new TipoAsiento();
        ta.setId(19L);
        ta.setCodigo("asiento_manual");
        ac.setTipoAsiento(ta);
        
        UnidadNegocio un = new UnidadNegocio();
        un.setId(1L);
        ac.setUnidadNegocio(un);
        
        Estado e = new Estado();
        e.setId(62L);
        ac.setEstado(e);
        
        con = new ConexionHttps();

        con.setLink(Config.HOSTCONTA + Config.ASIENTOCABECERAADD);

        con.setToken(rToken.getToken());
        con.setBarerAutenticacion(true);

        con.setBody(new Gson().toJson(ac));
        System.out.println(new Gson().toJson(ac));
        System.out.println("Resultado: \n"+con.getConexion(Config.POST));
        
        // id 35277
         */
       
       AsientoCabecera asiento = new AsientoCabecera();
       asiento.setId(35277L);
       
       LeeCSV csv = new LeeCSV();
       ArrayList<String[]> asientos = csv.leerArchivo2("datos/asientos/01_enero_2022_maker.csv");
       ArrayList<String[]> centroCostos = csv.leerArchivo2("datos/asientos/Centro_de_Costos.csv");
       ArrayList<String[]> planCuentas = csv.leerArchivo2("datos/asientos/Plan_de_Cuentas.csv");
       
       AsientoDetalleProcesar adp = new AsientoDetalleProcesar();
       
       ArrayList<AsientoDetalle> lDetalles = adp.procesarDetalle(asiento, asientos, centroCostos, planCuentas);
       
       for (int i = 0 ; i<1 ;  i++){
       
           System.out.println(new Gson().toJson(lDetalles.get(i)));
           
       }
       
     
       
      
    }
}
