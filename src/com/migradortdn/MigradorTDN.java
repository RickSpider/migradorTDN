/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import com.google.gson.Gson;
import com.migradortdn.model.Cliente;
import com.migradortdn.model.Login;
import com.migradortdn.model.Token;
import com.migradortdn.model.Tipo;
import com.migradortdn.model.TipoCliente;
import com.opencsv.CSVReader;
import controlador.ClienteProcesar;
import controlador.LeeCSV;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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

        String[] archivos = {"datos/ciudad.csv", "datos/departamento.csv", "datos/distrito.csv"};

        ArrayList<String[]> csvArray = csv.leerArchivo("fichero.csv");

        //datos Cliente
        ArrayList<String[]> csvDepartamentos = csv.leerArchivo("datos/departamento.csv");
        ArrayList<String[]> csvCiudades = csv.leerArchivo("datos/ciudad.csv");
        ArrayList<String[]> csvDistritos = csv.leerArchivo("datos/distrito.csv");
        
        ClienteProcesar cp = new ClienteProcesar();
        ArrayList<Cliente> lClientes = cp.procesarDatosClientes(csvArray, csvDepartamentos, csvCiudades, csvDistritos);

        ConexionHttps con = new ConexionHttps();
        String resultado = "";

        con.setLink(Config.HOST + "/qualita-client/rest/login");

        Login login = new Login("admin", "admin");
        //   Login login = new Login("admin", "admin");

        con.setBody(new Gson().toJson(login));

        resultado = con.getConexion();

        Token rToken = new Gson().fromJson(resultado, Token.class);
        rToken.setUsername(login.getUsername());

        for (int i = 0; i < 1; i++) {
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.CLIENTE);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody(new Gson().toJson(lClientes.get(i)));
            System.out.println(new Gson().toJson(lClientes.get(i)));
            System.out.println(con.getConexion());
        }

        //Logout
        con = new ConexionHttps();
        con.setLink(Config.HOST + "/qualita-client/rest/logout");
        rToken.setRequestToken(null);
        con.setToken(rToken.getAccessToken());
        con.setBarerAutenticacion(true);

        con.setBody(new Gson().toJson(rToken));

        System.out.println(con.getConexion());

        System.out.println((new Gson().toJson(rToken)));

    }

}
