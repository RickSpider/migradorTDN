/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.migradortdn.model.Cliente;
import com.migradortdn.model.Login;
import com.migradortdn.model.Token;
import com.migradortdn.model.Vendedor;
import controlador.DatosProcesar;
import controlador.LeeCSV;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.ProtocolException;
import java.util.ArrayList;

/**
 *
 * @author BlackSpider
 */
public class MigradorTDNBorrado {
    
     public static void main(String[] args) throws ProtocolException, IOException {

       LeeCSV csv = new LeeCSV();
       
       boolean cliente = false;
       boolean vendedor = true;
     
       

        ConexionHttps con = new ConexionHttps();
        String resultado = "";
        
        DatosProcesar dp = new DatosProcesar();

        con.setLink(Config.HOST + "/qualita-client/rest/login");

        Login login = new Login("admin", "admin");
        //   Login login = new Login("admin", "admin");

        con.setBody(new Gson().toJson(login));

        resultado = con.getConexion(Config.POST);

        Token rToken = new Gson().fromJson(resultado, Token.class);
        rToken.setUsername(login.getUsername());
        
        //seccion vendedores
        if (vendedor){
            
            //buscar id supervisores
            
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.VENDEDOR + Config.VENDEDORLISTA);
            //System.out.println(con.getLink());
            
           
            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);
             
            con.setBody("");
           
            
           // System.out.println(con.getConexion(false));
            
            Type arrayVen = new TypeToken<ArrayList<Vendedor>>(){}.getType();
            
            ArrayList<Vendedor> data = new Gson().fromJson(con.getConexion(Config.GET),  arrayVen);
            
            for (int i = 0; i < data.size() ; i++) {
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.VENDEDOR + "/"+data.get(i).getId());
                
                

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody("");
                
                System.out.println(con.getConexion(Config.DELETE));
            }
            
            
            
            
            
        }

        
        //seccion clientes
        if(cliente){
            
         

        }
        
      
        

        //Logout
        con = new ConexionHttps();
        con.setLink(Config.HOST + "/qualita-client/rest/logout");
        rToken.setRequestToken(null);
        con.setToken(rToken.getAccessToken());
        con.setBarerAutenticacion(true);

        con.setBody(new Gson().toJson(rToken));

        System.out.println(con.getConexion(Config.POST));

        System.out.println((new Gson().toJson(rToken)));

    }
    
}
