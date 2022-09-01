/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import com.google.gson.Gson;
import com.migradortdn.model.AsientoCabecera;
import com.migradortdn.model.AsientoDetalle;
import com.migradortdn.model.Login;
import com.migradortdn.model.TokenConta;
import controlador.AsientoCabeceraProcesar;
import controlador.AsientoDetalleProcesar;
import controlador.LeeCSV;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author BlackSpider
 */
public class MigradorAsientos {

    public static void main(String[] args) throws IOException, ParseException {

        ConexionHttps con = new ConexionHttps();

        con.setLink(Config.HOSTCONTA + "/contabilidad-client-backend/rest/jwt/token");
        Login login = new Login("password", "admin", "contamaster$");
        //   Login login = new Login("admin", "admin");
        con.setBody(new Gson().toJson(login));
        String resultado = con.getConexion(Config.POST);
        TokenConta rToken = new Gson().fromJson(resultado, TokenConta.class);
        //rToken.setUsername(login.getUsername());

        System.out.println(rToken.getToken());

        LeeCSV csv = new LeeCSV();
        ArrayList<String[]> asientos = csv.leerArchivo2("datos/asientos/enero_2022_v5.csv");
        //ArrayList<String[]> centroCostos = csv.leerArchivo2("datos/asientos/Centro_de_Costos.csv");
        ArrayList<String[]> planCuentas = csv.leerArchivo2("datos/asientos/Plan_de_Cuentas.csv");
        ArrayList<String[]> centroCostosQualita = csv.leerArchivo2("datos/asientos/centroCostosQualita.csv");

        AsientoCabeceraProcesar acp = new AsientoCabeceraProcesar();

        ArrayList<AsientoCabecera> lcabeceras = acp.procesar(asientos);

        AsientoDetalleProcesar adp = new AsientoDetalleProcesar();
        System.out.println(lcabeceras.size());
        for (int i = 0; i < lcabeceras.size(); i++) {

            //System.out.println(new Gson().toJson(lcabeceras.get(i)));
            con = new ConexionHttps();
            con.setLink(Config.HOSTCONTA + Config.ASIENTOCABECERAADD);
            con.setToken(rToken.getToken());
            con.setBarerAutenticacion(true);
            con.setBody(new Gson().toJson(lcabeceras.get(i)));
            //System.out.println(new Gson().toJson(lcabeceras.get(i)));
            String postCabeceraRespuesta = con.getConexion(Config.POST);
           // System.out.println("Resultado: " + postCabeceraRespuesta);

            lcabeceras.get(i).setId(new Gson().fromJson(postCabeceraRespuesta, AsientoCabecera.class).getId());
            System.out.println(new Gson().toJson(lcabeceras.get(i)));
            System.out.println(i);

        }

        System.out.println(lcabeceras.size());

        ArrayList<AsientoDetalle> lDetalles = adp.procesarDetalle(lcabeceras, asientos, centroCostosQualita, planCuentas);
        System.out.println(lDetalles.size());
        for (int i = 0; i < lDetalles.size(); i++) {

            System.out.println(new Gson().toJson(lDetalles.get(i)));

            con = new ConexionHttps();
            con.setLink(Config.HOSTCONTA + Config.ASIENTODETALLEADD);
            con.setToken(rToken.getToken());
            con.setBarerAutenticacion(true);
            con.setBody(new Gson().toJson(lDetalles.get(i)));
            //System.out.println(new Gson().toJson(lcabeceras.get(i)));
            String postDetalleRespuesta = con.getConexion(Config.POST);
            //System.out.println("Resultado: "+postDetalleRespuesta);

            //lcabeceras.get(i).setId(new Gson().fromJson(resultado, AsientoCabecera.class).getId());
            System.out.println(i);
        }
         
       
      
    }
}
