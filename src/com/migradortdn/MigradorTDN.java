/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.migradortdn.model.Cliente;
import com.migradortdn.model.Data;
import com.migradortdn.model.Login;
import com.migradortdn.model.Ruta;
import com.migradortdn.model.TipoCliente;
import com.migradortdn.model.Token;
import com.migradortdn.model.Vendedor;
import com.migradortdn.model.Zona;
import controlador.DatosProcesar;
import controlador.ClienteDatosProcesar;
import controlador.LeeCSV;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BlackSpider
 */
public class MigradorTDN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ProtocolException, IOException {

       LeeCSV csv = new LeeCSV();
       
       boolean zona = false;
       boolean ruta = false;
       boolean vendedor = false;
       boolean tipoCliente = false;
       boolean cliente = true;
       
       

        String[] archivos = {"datos/ciudad.csv", "datos/departamento.csv", "datos/distrito.csv"};

      

        //datos Cliente
        ArrayList<String[]> csvDepartamentos = csv.leerArchivo("datos/departamento.csv");
        ArrayList<String[]> csvCiudades = csv.leerArchivo("datos/ciudad.csv");
        ArrayList<String[]> csvDistritos = csv.leerArchivo("datos/distrito.csv");
        
       

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
        
        if(zona){
            
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/QUALITA_ZONAVIEW_01.csv");
            
            ArrayList<Zona> lZona = dp.procesarZona(csvArray);
            
            for( int i = 0 ; i <  lZona.size() ; i++){
            
                 con = new ConexionHttps();

                con.setLink(Config.HOST + Config.ZONA);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lZona.get(i)));
                System.out.println(new Gson().toJson(lZona.get(i)));
                System.out.println(con.getConexion(Config.POST));
                
            }
            
        }
        
         if(ruta){
            
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/QUALITA_RUTAVIEW_01.csv");
            
            ArrayList<Ruta> lRuta = dp.procesarRuta(csvArray);
            
            for( int i = 0 ; i <  lRuta.size() ; i++){
            
                 con = new ConexionHttps();

                con.setLink(Config.HOST + Config.RUTA);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lRuta.get(i)));
                System.out.println(new Gson().toJson(lRuta.get(i)));
                System.out.println(con.getConexion(Config.POST));
                
            }
            
        }
        
        
        //seccion vendedores
        if (vendedor){
        
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/vendedores/QUALITA_VENDEDORVIEW_01.csv");
            System.out.println("el csvArray Vendedores "+csvArray.size());
            
            ArrayList [] sv = dp.separarVendedores(csvArray);
            
            ArrayList <String []> lSupervisor = sv[0];
            ArrayList <String []> lVendedor = sv[1];
            
            ArrayList<Vendedor> lSupervisores = dp.procesarDatosVendedor(lSupervisor, csvCiudades, true, new ArrayList<Vendedor> ());
            
            for (int i = 0; i < lSupervisores.size(); i++) {
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.VENDEDOR);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lSupervisores.get(i)));
                System.out.println(new Gson().toJson(lSupervisores.get(i)));
                System.out.println(con.getConexion(Config.POST));
            }
            
            //buscar id supervisores
            
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.VENDEDOR + Config.VENDEDORLISTA);
            //System.out.println(con.getLink());
            
           
            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);
             
            con.setBody("");
           
            
           // System.out.println(con.getConexion(false));
           
            Type arrayVen = new TypeToken<ArrayList<Vendedor>>(){}.getType();
            
            ArrayList<Vendedor> lSupervisoresCargados = new Gson().fromJson(con.getConexion(Config.GET),  arrayVen);

            
            
            ArrayList<Vendedor> lVendedores = dp.procesarDatosVendedor(lVendedor, csvCiudades, false, lSupervisoresCargados);
            
            for (int i = 0; i < lVendedor.size() ; i++) {
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.VENDEDOR);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lVendedores.get(i)));
                System.out.println(new Gson().toJson(lVendedores.get(i)));
                System.out.println(con.getConexion(Config.POST));
            }
            
            
            
            
            
        }
        
        
        if(tipoCliente){
            
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/clientes/QUALITA_TIPOCLIENTEVIEW_01.csv");
            
            ArrayList<TipoCliente> lTipocliente = dp.procesarTipoCliente(csvArray);
            
            for( int i = 0 ; i <  lTipocliente.size() ; i++){
            
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.TIPOSCLIENTES);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lTipocliente.get(i)));
                System.out.println(new Gson().toJson(lTipocliente.get(i)));
                System.out.println(con.getConexion(Config.POST));
                
            }
            
        }

        ClienteDatosProcesar cdp = new ClienteDatosProcesar();
        
        //seccion traer listas
        
        //Lista Tipo cliente
        con = new ConexionHttps();

        con.setLink(Config.HOST + Config.TIPOSCLIENTES + Config.TIPOSCLIENTESLISTA);

        con.setToken(rToken.getAccessToken());
        con.setBarerAutenticacion(true);

        con.setBody("");
        
        String json = con.getConexion(Config.GET);
        
        Data dataTipoCliente = new Gson().fromJson( json, Data.class);
        
        Type arrayTC = new TypeToken<List<TipoCliente>>(){}.getType();
            
        ArrayList<TipoCliente> lTipocliente =(new Gson().fromJson( new Gson().toJson(dataTipoCliente.getData()) , arrayTC));
        
        //Lista Zona
        con = new ConexionHttps();

        con.setLink(Config.HOST + Config.ZONA + Config.ZONALISTA);

        con.setToken(rToken.getAccessToken());
        con.setBarerAutenticacion(true);

        con.setBody("");
        
        Data dataZona = new Gson().fromJson(con.getConexion(Config.GET), Data.class);
        
        Type arrayZ = new TypeToken<List<Zona>>(){}.getType();
            
        ArrayList<Zona> lZona =(new Gson().fromJson(new Gson().toJson(dataZona.getData()), arrayZ));
        
        //Lista Ruta
        con = new ConexionHttps();

        con.setLink(Config.HOST + Config.RUTA + Config.RUTALISTA);

        con.setToken(rToken.getAccessToken());
        con.setBarerAutenticacion(true);

        con.setBody("");
        
        Data dataRuta = new Gson().fromJson(con.getConexion(Config.GET), Data.class);
        
        Type arrayR = new TypeToken<List<Ruta>>(){}.getType();
        
        ArrayList<Ruta> lRuta = (new Gson().fromJson(new Gson().toJson(dataRuta.getData()), arrayR));
        
        //Vendedores
        
        con = new ConexionHttps();

            con.setLink(Config.HOST + Config.VENDEDOR + Config.VENDEDORLISTA);
            //System.out.println(con.getLink());
            
           
            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);
             
            con.setBody("");
           
            
           // System.out.println(con.getConexion(false));
           
            Type arrayVen = new TypeToken<ArrayList<Vendedor>>(){}.getType();
            
            ArrayList<Vendedor> lVendedores = new Gson().fromJson(con.getConexion(Config.GET),  arrayVen);
        
        
        
        //seccion clientes
        if(cliente){
            
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/clientes/QUALITA_CLIENTEVIEW_02.csv");
            
            ArrayList<Cliente> lClientes = cdp.procesarDatosClientes(csvArray, csvDepartamentos, csvCiudades, csvDistritos,
                    lVendedores, lZona, lRuta, lTipocliente);

            for (int i = 0; i < 1; i++) {
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.CLIENTE);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lClientes.get(i)));
                System.out.println(new Gson().toJson(lClientes.get(i)));
                System.out.println(con.getConexion(Config.POST));
            }

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
