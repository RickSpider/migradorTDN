/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn.aprobacion;

import com.migradortdn.ConexionHttps;
import com.migradortdn.Config;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BlackSpider
 */
public class Hilo implements Runnable {

    private String hilo;
    private String token;
    private int tipo;

    public Hilo(String hilo, String token, int tipo) {

        this.hilo = hilo;
        this.token = token;
        this.tipo = tipo;
    }

    private synchronized Long getDato() {

        if (tipo == Config.APROBARVENTA){
        
             return AprobarComprobanteVenta.cola.poll();
            
        }
        
     
        
        return AprobarComprobanteCompra.cola.poll();

    }

    @Override
    public void run() {

        Long x = this.getDato();

        ConexionHttps con;

        while (x != null) {
            
                String link = "";
            
                if (tipo == Config.APROBARVENTA){
                
                    link = Config.HOST + Config.COMPROBANTEVENTAAPROBAR + x;
                    
                }
                
                if (tipo == Config.APROBARCOMPRA){
                
                    link = Config.HOST + Config.COMPROBANTECOMPRAAPROBAR + x;
                    
                }

               
              
                con = new ConexionHttps();
              
                System.out.println(this.hilo + " = " +link);
                
                con.setLink(link);
                
                con.setToken(token);
                con.setBarerAutenticacion(true);
                
                con.setBody("");
            
            try {
                //System.out.println(this.hilo + " - " + x);
                
              
                
                System.out.println(con.getConexion(Config.PUT) + " - " + x);
                
               
            } catch (IOException ex) {
                System.out.println("Fallo el hilo "+this.hilo+" - "+x);
            }
            
            
            x = this.getDato();
            
           /*  System.out.println(x);
             x = this.getDato();*/
        }

        System.out.println("fin " + hilo);

    }

}
