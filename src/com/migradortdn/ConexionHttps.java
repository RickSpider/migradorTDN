/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author BlackSpider
 */
public class ConexionHttps {

    private HttpsURLConnection urlConnection = null;
    private boolean barerAutenticacion = false;
    private String token;
    private String link;
    private String body;

    public String getConexion(int metodo) throws MalformedURLException, IOException {

        URL url = new URL(this.link);

        urlConnection = (HttpsURLConnection) url.openConnection();

         urlConnection.setDoOutput(true);     
       
        
        if (metodo == Config.POST){
            
              
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=iso-8859-1");
            urlConnection.setRequestMethod("POST");
            
            
            
        }
        
        if (metodo == Config.GET){
           
            
           // urlConnection.setRequestProperty("accept", "application/json; text/plain; */*");        
            //urlConnection.setRequestProperty("Content-Type", "application/json");
            //urlConnection.setRequestProperty("Content-length", "1520");
            
            urlConnection.setRequestMethod("GET");
            
        }
        
        if (metodo == Config.DELETE){
        
             urlConnection.setRequestMethod("DELETE");
            
        }
        
       
        
        if (this.barerAutenticacion && this.token.length() > 0){
        
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            
        }
        
        if ( this.body.length() > 0){
        
            DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
            wr.writeBytes(this.body);
            wr.flush();
            wr.close();
            
        }
        

        String linea = "";
        int HttpResult = urlConnection.getResponseCode();
        
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            
            System.out.println(HttpResult);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "iso-8859-1"));
            String line = "";
            while ((line = br.readLine()) != null) {
                linea = linea + line;
            }
            br.close();

        } else {
        
            System.out.println("HttpResult CODE"+HttpResult);
            
            
            
        }
        urlConnection.disconnect();
       // System.out.println(linea);
       
       return linea;
       
    }

    public HttpsURLConnection getUrlConnection() {
        return urlConnection;
    }

    public void setUrlConnection(HttpsURLConnection urlConnection) {
        this.urlConnection = urlConnection;
    }

    public boolean isBarerAutenticacion() {
        return barerAutenticacion;
    }

    public void setBarerAutenticacion(boolean barerAutenticacion) {
        this.barerAutenticacion = barerAutenticacion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
