
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn.aprobacion;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import com.migradortdn.ConexionHttps;
import com.migradortdn.Config;
import com.migradortdn.model.ComprobanteID;
import com.migradortdn.model.Data;
import com.migradortdn.model.Login;
import com.migradortdn.model.Token;
import controlador.DatosProcesar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author BlackSpider
 */
public class AprobarComprobanteCompra {
    
     public static Queue<Long> cola = new LinkedList<>();
    
     public static void main(String[] args) throws IOException{
         
        ConexionHttps con = new ConexionHttps();
        String resultado = "";

        con.setLink(Config.HOST + "/qualita-client/rest/login");

        Login login = new Login("admin", "saricmaster$");

        con.setBody(new Gson().toJson(login));

        resultado = con.getConexion(Config.POST);

        Token rToken = new Gson().fromJson(resultado, Token.class);
        rToken.setUsername(login.getUsername());
         
        System.out.println("Lista de Comprobantes");

        con = new ConexionHttps();

        con.setLink(Config.HOST + Config.COMPROBANTECOMPRA + Config.COMPROBANTECOMPRALISTA);

        con.setToken(rToken.getAccessToken());
        con.setBarerAutenticacion(true);

        con.setBody("");

        Data dataComprobanteCompra = new Gson().fromJson(con.getConexion(Config.GET), Data.class);

        Type arrayComp = new TypeToken<List<ComprobanteID>>() {
        }.getType();

        ArrayList<ComprobanteID> lComprobantesCompra = (new Gson().fromJson(new Gson().toJson(dataComprobanteCompra.getData()), arrayComp));
        System.out.println("tamaño Comprobante " + lComprobantesCompra.size());
         
        for (int i = 0; i<lComprobantesCompra.size(); i++){
         
            cola.add(new Long(lComprobantesCompra.get(i).getId()));
             
        }
        
        System.out.println("tamaño de cola "+cola.size());
        
        int hilos = 40;
        
        for (int i = 0 ; i < hilos ; i++ ){
     
            Hilo hilo = new Hilo("Hilo"+i, rToken.getAccessToken(), Config.APROBARCOMPRA);
  
            Thread th = new Thread(hilo);
         
            th.start();
        }
        
      
         
     }
    
}
