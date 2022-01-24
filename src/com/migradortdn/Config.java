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
    
    // Tipo Cliente
    public static String TIPOSCLIENTES = "/qualita-client/rest/tiposclientes";
    public static String TIPOSCLIENTESLISTA = "/datatables?view=BaseList&draw=3&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=C%C3%B3digo&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B0%5D%5Btype%5D=string&columns%5B1%5D%5Bdata%5D=descripcion&columns%5B1%5D%5Bname%5D=Descripci%C3%B3n&columns%5B1%5D%5Bsearchable%5D=true&columns%5B1%5D%5Borderable%5D=true&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B1%5D%5Btype%5D=string&columns%5B2%5D%5Bdata%5D=&columns%5B2%5D%5Bname%5D=&columns%5B2%5D%5Bsearchable%5D=false&columns%5B2%5D%5Borderable%5D=false&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B2%5D%5Btype%5D=string&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=desc&start=0&length=-1&search%5Bvalue%5D=&search%5Bregex%5D=false&rangeSeparator=~";
    
    //Zonas
    public static String ZONA = "/qualita-client/rest/zonas";
    
    //Rutas
    public static String RUTA = "/qualita-client/rest/rutas";
    
    //VENDEDORES
    public static String VENDEDOR = "/qualita-client/rest/vendedores";
    public static String VENDEDORLISTA = "?search=%7B%22type%22:%22and%22,%22filters%22:%5B%7B%22path%22:%22vendedor%22,%22equals%22:true%7D,%7B%22path%22:%22activo%22,%22equals%22:true%7D%5D%7D&view=BaseForm";

}