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

    public String getConexion() throws MalformedURLException, IOException {

        URL url = new URL(this.link);

        urlConnection = (HttpsURLConnection) url.openConnection();

        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "application/json;charset=iso-8859-1");
        urlConnection.setRequestMethod("POST");
        
        if (this.barerAutenticacion && this.token.length() > 0){
        
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            
        }

        DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
        wr.writeBytes(this.body);
        wr.flush();
        wr.close();

        String linea = "";
        int HttpResult = urlConnection.getResponseCode();
        
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "iso-8859-1"));
            String line = null;
            while ((line = br.readLine()) != null) {
                linea = linea + line;
            }
            br.close();

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
