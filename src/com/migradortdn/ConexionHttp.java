/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import sun.misc.BASE64Encoder;

/**
 *
 * @author BlackSpider
 */
public class ConexionHttp {

    private HttpURLConnection urlConnection = null;
    private boolean barerAutenticacion = false;
    private String token;
    private String link;
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getConexion() throws MalformedURLException, ProtocolException, IOException {

        URL url = new URL(this.link);

        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "application/json;charset=iso-8859-1");
        //urlConnection.setRequestProperty("Accept", "application/json");
        urlConnection.setRequestMethod("POST");
        urlConnection.setUseCaches(false);
        urlConnection.setConnectTimeout(10000);
        urlConnection.setReadTimeout(10000);
        urlConnection.setRequestProperty("charset", "utf-8");

          if (this.barerAutenticacion && this.token.length() > 0){
        
            urlConnection.setRequestProperty("Authorization", "Bearer " + token);
            
        }

        urlConnection.connect();

        OutputStreamWriter osw = new OutputStreamWriter(urlConnection.getOutputStream());
        osw.write(this.body);
        osw.close();

        int HttpResult = urlConnection.getResponseCode();
        String linea = "";
        
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "iso-8859-1"));
            String line = null;
            while ((line = br.readLine()) != null) {
                linea = linea + line;
            }
            br.close();
        }else{
        
            linea = "Error "+HttpResult;
            
        }
        
        urlConnection.disconnect();

        return linea;

    }

    public HttpURLConnection getUrlConnection() {
        return urlConnection;
    }

    public void setUrlConnection(HttpURLConnection urlConnection) {
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

}
