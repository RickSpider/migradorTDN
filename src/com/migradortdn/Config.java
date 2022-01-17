/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

/**
 *
 * @author BlackSpider
 */
public class Config {
    
    //metodos de envio
    
    public static int POST = 1;
    public static int GET = 2;
    public static int DELETE = 3;
    
    //Datos host y servicio
    public static String HOST = "https://testsaric.sistematdn.com.py:8443";
    public static String CLIENTE = "/qualita-client/rest/clientes";
        
    // Tipo de Documento
    public static long IDRUC = 357;
    public static long IDCED = 356;
    public static long IDOT = 7420;
    
    //
    
    //VENDEDORES
    public static String VENDEDOR = "/qualita-client/rest/vendedores";
    public static String VENDEDORLISTA = "?search=%7B%22type%22:%22and%22,%22filters%22:%5B%7B%22path%22:%22vendedor%22,%22equals%22:true%7D,%7B%22path%22:%22activo%22,%22equals%22:true%7D%5D%7D&view=BaseForm";

}