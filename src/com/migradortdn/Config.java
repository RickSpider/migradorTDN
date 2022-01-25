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
    public static String ZONALISTA = "/datatables?view=ZonaList&draw=3&columns[0][data]=id&columns[0][name]=Código Interno&columns[0][searchable]=true&columns[0][orderable]=true&columns[0][search][value]=&columns[0][search][regex]=false&columns[0][type]=string&columns[1][data]=codigo&columns[1][name]=Código&columns[1][searchable]=true&columns[1][orderable]=true&columns[1][search][value]=&columns[1][search][regex]=false&columns[1][type]=string&columns[2][data]=zona&columns[2][name]=Zona&columns[2][searchable]=true&columns[2][orderable]=true&columns[2][search][value]=&columns[2][search][regex]=false&columns[2][type]=string&columns[3][data]=descripcion&columns[3][name]=Descripción&columns[3][searchable]=true&columns[3][orderable]=true&columns[3][search][value]=&columns[3][search][regex]=false&columns[3][type]=string&columns[4][data]=ciudad.descripcion&columns[4][name]=Ciudad&columns[4][searchable]=true&columns[4][orderable]=true&columns[4][search][value]=&columns[4][search][regex]=false&columns[4][type]=string&columns[5][data]=departamento.descripcion&columns[5][name]=Departamento&columns[5][searchable]=true&columns[5][orderable]=true&columns[5][search][value]=&columns[5][search][regex]=false&columns[5][type]=string&columns[6][data]=activo&columns[6][name]=Activo&columns[6][searchable]=true&columns[6][orderable]=true&columns[6][search][value]=&columns[6][search][regex]=false&columns[6][type]=combo&columns[7][data]=&columns[7][name]=&columns[7][searchable]=false&columns[7][orderable]=false&columns[7][search][value]=&columns[7][search][regex]=false&columns[7][type]=string&order[0][column]=0&order[0][dir]=desc&start=0&length=-1&search[value]=&search[regex]=false&rangeSeparator=~";
    
    //Rutas
    public static String RUTA = "/qualita-client/rest/rutas";
    public static String RUTALISTA = "/datatables?view=RutaList&draw=3&columns[0][data]=id&columns[0][name]=Código&columns[0][searchable]=true&columns[0][orderable]=true&columns[0][search][value]=&columns[0][search][regex]=false&columns[0][type]=string&columns[1][data]=nombreRuta&columns[1][name]=Nombre Ruta&columns[1][searchable]=true&columns[1][orderable]=true&columns[1][search][value]=&columns[1][search][regex]=false&columns[1][type]=string&columns[2][data]=ruta&columns[2][name]=Ruta&columns[2][searchable]=true&columns[2][orderable]=true&columns[2][search][value]=&columns[2][search][regex]=false&columns[2][type]=string&columns[3][data]=sucursal.nombre&columns[3][name]=Sucursal&columns[3][searchable]=true&columns[3][orderable]=true&columns[3][search][value]=&columns[3][search][regex]=false&columns[3][type]=string&columns[4][data]=activo&columns[4][name]=Activo&columns[4][searchable]=true&columns[4][orderable]=true&columns[4][search][value]=&columns[4][search][regex]=false&columns[4][type]=combo&columns[5][data]=&columns[5][name]=&columns[5][searchable]=false&columns[5][orderable]=false&columns[5][search][value]=&columns[5][search][regex]=false&columns[5][type]=string&order[0][column]=0&order[0][dir]=desc&start=0&length=-1&search[value]=&search[regex]=false&rangeSeparator=~";
    
    //VENDEDORES
    public static String VENDEDOR = "/qualita-client/rest/vendedores";
    public static String VENDEDORLISTA = "?search=%7B%22type%22:%22and%22,%22filters%22:%5B%7B%22path%22:%22vendedor%22,%22equals%22:true%7D,%7B%22path%22:%22activo%22,%22equals%22:true%7D%5D%7D&view=BaseForm";

}