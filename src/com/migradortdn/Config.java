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
    public static String CLIENTELISTA = "/datatables?view=BaseList&draw=22&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=Codigo&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B0%5D%5Btype%5D=string&columns%5B1%5D%5Bdata%5D=tipoPersona.descripcion&columns%5B1%5D%5Bname%5D=Tipo%20de%20persona&columns%5B1%5D%5Bsearchable%5D=true&columns%5B1%5D%5Borderable%5D=true&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B1%5D%5Btype%5D=string&columns%5B2%5D%5Bdata%5D=nombre&columns%5B2%5D%5Bname%5D=Nombre%2FRaz%C3%B3n%20Social%20&columns%5B2%5D%5Bsearchable%5D=true&columns%5B2%5D%5Borderable%5D=true&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B2%5D%5Btype%5D=string&columns%5B3%5D%5Bdata%5D=tipoDocumento.descripcion&columns%5B3%5D%5Bname%5D=Tipo%20de%20documento&columns%5B3%5D%5Bsearchable%5D=true&columns%5B3%5D%5Borderable%5D=true&columns%5B3%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B3%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B3%5D%5Btype%5D=string&columns%5B4%5D%5Bdata%5D=numero&columns%5B4%5D%5Bname%5D=N%C3%BAmero%20de%20documento&columns%5B4%5D%5Bsearchable%5D=true&columns%5B4%5D%5Borderable%5D=true&columns%5B4%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B4%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B4%5D%5Btype%5D=string&columns%5B5%5D%5Bdata%5D=direccion&columns%5B5%5D%5Bname%5D=Direcci%C3%B3n&columns%5B5%5D%5Bsearchable%5D=true&columns%5B5%5D%5Borderable%5D=true&columns%5B5%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B5%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B5%5D%5Btype%5D=string&columns%5B6%5D%5Bdata%5D=correo&columns%5B6%5D%5Bname%5D=Correo%20electr%C3%B3nico&columns%5B6%5D%5Bsearchable%5D=true&columns%5B6%5D%5Borderable%5D=true&columns%5B6%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B6%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B6%5D%5Btype%5D=string&columns%5B7%5D%5Bdata%5D=numero&columns%5B7%5D%5Bname%5D=Tel%C3%A9fono&columns%5B7%5D%5Bsearchable%5D=true&columns%5B7%5D%5Borderable%5D=true&columns%5B7%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B7%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B7%5D%5Btype%5D=string&columns%5B8%5D%5Bdata%5D=tipoCliente.descripcion&columns%5B8%5D%5Bname%5D=Tipo%20Cliente&columns%5B8%5D%5Bsearchable%5D=true&columns%5B8%5D%5Borderable%5D=true&columns%5B8%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B8%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B8%5D%5Btype%5D=string&columns%5B9%5D%5Bdata%5D=activo&columns%5B9%5D%5Bname%5D=Activo&columns%5B9%5D%5Bsearchable%5D=true&columns%5B9%5D%5Borderable%5D=true&columns%5B9%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B9%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B9%5D%5Btype%5D=combo&columns%5B10%5D%5Bdata%5D=&columns%5B10%5D%5Bname%5D=&columns%5B10%5D%5Bsearchable%5D=false&columns%5B10%5D%5Borderable%5D=false&columns%5B10%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B10%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B10%5D%5Btype%5D=string&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=desc&start=0&length=-1&search%5Bvalue%5D=&search%5Bregex%5D=false&rangeSeparator=~";    
    
    // Tipo de Documento
    public static long IDRUC = 357;
    public static long IDCED = 356;
    public static long IDOT = 7420;
    
    // Tipo Cliente
    public static String TIPOSCLIENTES = "/qualita-client/rest/tiposclientes";
    public static String TIPOSCLIENTESLISTA = "/datatables?view=BaseList&draw=3&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=C%C3%B3digo&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B0%5D%5Btype%5D=string&columns%5B1%5D%5Bdata%5D=descripcion&columns%5B1%5D%5Bname%5D=Descripci%C3%B3n&columns%5B1%5D%5Bsearchable%5D=true&columns%5B1%5D%5Borderable%5D=true&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B1%5D%5Btype%5D=string&columns%5B2%5D%5Bdata%5D=&columns%5B2%5D%5Bname%5D=&columns%5B2%5D%5Bsearchable%5D=false&columns%5B2%5D%5Borderable%5D=false&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B2%5D%5Btype%5D=string&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=desc&start=0&length=-1&search%5Bvalue%5D=&search%5Bregex%5D=false&rangeSeparator=~";
    
    //Zonas
    public static String ZONA = "/qualita-client/rest/zonas";
    public static String ZONALISTA = "/datatables?view=ZonaList&draw=3&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=C%C3%B3digo%20Interno&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B0%5D%5Btype%5D=string&columns%5B1%5D%5Bdata%5D=codigo&columns%5B1%5D%5Bname%5D=C%C3%B3digo&columns%5B1%5D%5Bsearchable%5D=true&columns%5B1%5D%5Borderable%5D=true&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B1%5D%5Btype%5D=string&columns%5B2%5D%5Bdata%5D=zona&columns%5B2%5D%5Bname%5D=Zona&columns%5B2%5D%5Bsearchable%5D=true&columns%5B2%5D%5Borderable%5D=true&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B2%5D%5Btype%5D=string&columns%5B3%5D%5Bdata%5D=descripcion&columns%5B3%5D%5Bname%5D=Descripci%C3%B3n&columns%5B3%5D%5Bsearchable%5D=true&columns%5B3%5D%5Borderable%5D=true&columns%5B3%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B3%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B3%5D%5Btype%5D=string&columns%5B4%5D%5Bdata%5D=ciudad.descripcion&columns%5B4%5D%5Bname%5D=Ciudad&columns%5B4%5D%5Bsearchable%5D=true&columns%5B4%5D%5Borderable%5D=true&columns%5B4%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B4%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B4%5D%5Btype%5D=string&columns%5B5%5D%5Bdata%5D=departamento.descripcion&columns%5B5%5D%5Bname%5D=Departamento&columns%5B5%5D%5Bsearchable%5D=true&columns%5B5%5D%5Borderable%5D=true&columns%5B5%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B5%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B5%5D%5Btype%5D=string&columns%5B6%5D%5Bdata%5D=activo&columns%5B6%5D%5Bname%5D=Activo&columns%5B6%5D%5Bsearchable%5D=true&columns%5B6%5D%5Borderable%5D=true&columns%5B6%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B6%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B6%5D%5Btype%5D=combo&columns%5B7%5D%5Bdata%5D=&columns%5B7%5D%5Bname%5D=&columns%5B7%5D%5Bsearchable%5D=false&columns%5B7%5D%5Borderable%5D=false&columns%5B7%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B7%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B7%5D%5Btype%5D=string&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=desc&start=0&length=-1&search%5Bvalue%5D=&search%5Bregex%5D=false&rangeSeparator=~";
    //Rutas
    public static String RUTA = "/qualita-client/rest/rutas";
    public static String RUTALISTA = "/datatables?view=RutaList&draw=3&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=C%C3%B3digo&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B0%5D%5Btype%5D=string&columns%5B1%5D%5Bdata%5D=nombreRuta&columns%5B1%5D%5Bname%5D=Nombre%20Ruta&columns%5B1%5D%5Bsearchable%5D=true&columns%5B1%5D%5Borderable%5D=true&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B1%5D%5Btype%5D=string&columns%5B2%5D%5Bdata%5D=ruta&columns%5B2%5D%5Bname%5D=Ruta&columns%5B2%5D%5Bsearchable%5D=true&columns%5B2%5D%5Borderable%5D=true&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B2%5D%5Btype%5D=string&columns%5B3%5D%5Bdata%5D=sucursal.nombre&columns%5B3%5D%5Bname%5D=Sucursal&columns%5B3%5D%5Bsearchable%5D=true&columns%5B3%5D%5Borderable%5D=true&columns%5B3%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B3%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B3%5D%5Btype%5D=string&columns%5B4%5D%5Bdata%5D=activo&columns%5B4%5D%5Bname%5D=Activo&columns%5B4%5D%5Bsearchable%5D=true&columns%5B4%5D%5Borderable%5D=true&columns%5B4%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B4%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B4%5D%5Btype%5D=combo&columns%5B5%5D%5Bdata%5D=&columns%5B5%5D%5Bname%5D=&columns%5B5%5D%5Bsearchable%5D=false&columns%5B5%5D%5Borderable%5D=false&columns%5B5%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B5%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B5%5D%5Btype%5D=string&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=desc&start=0&length=-1&search%5Bvalue%5D=&search%5Bregex%5D=false&rangeSeparator=~";
    //VENDEDORES
    public static String VENDEDOR = "/qualita-client/rest/vendedores";
    public static String VENDEDORLISTA = "?search=%7B%22type%22:%22and%22,%22filters%22:%5B%7B%22path%22:%22vendedor%22,%22equals%22:true%7D,%7B%22path%22:%22activo%22,%22equals%22:true%7D%5D%7D&view=BaseForm";
    
    //Tipo Proveedor
    public static String TIPOSPROVEEDORES ="/qualita-client/rest/tiposproveedores";
    public static String TIPOSPROVEEDORESLISTA = "/datatables?view=BaseList&draw=8&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=C%C3%B3digo&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B0%5D%5Btype%5D=string&columns%5B1%5D%5Bdata%5D=descripcion&columns%5B1%5D%5Bname%5D=Descripci%C3%B3n&columns%5B1%5D%5Bsearchable%5D=true&columns%5B1%5D%5Borderable%5D=true&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B1%5D%5Btype%5D=string&columns%5B2%5D%5Bdata%5D=&columns%5B2%5D%5Bname%5D=&columns%5B2%5D%5Bsearchable%5D=false&columns%5B2%5D%5Borderable%5D=false&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B2%5D%5Btype%5D=string&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=desc&start=0&length=-1&search%5Bvalue%5D=&search%5Bregex%5D=false&rangeSeparator=~";
   
    //Proveedor
    public static String PROVEEDOR ="/qualita-client/rest/proveedores";
    

    //Foma Pago
    public static String FORMAPAGO ="/qualita-client/rest/formapago";
    public static String FORMAPAGOLISTA = "/datatables?view=FormaPagoList&draw=3&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=C%C3%B3digo&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B0%5D%5Btype%5D=string&columns%5B1%5D%5Bdata%5D=descripcion&columns%5B1%5D%5Bname%5D=Descripci%C3%B3n&columns%5B1%5D%5Bsearchable%5D=true&columns%5B1%5D%5Borderable%5D=true&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B1%5D%5Btype%5D=string&columns%5B2%5D%5Bdata%5D=clase.descripcion&columns%5B2%5D%5Bname%5D=Tipo&columns%5B2%5D%5Bsearchable%5D=true&columns%5B2%5D%5Borderable%5D=true&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B2%5D%5Btype%5D=string&columns%5B3%5D%5Bdata%5D=utilizarEnCobros&columns%5B3%5D%5Bname%5D=Utilizar%20en%20Cobros&columns%5B3%5D%5Bsearchable%5D=true&columns%5B3%5D%5Borderable%5D=true&columns%5B3%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B3%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B3%5D%5Btype%5D=combo&columns%5B4%5D%5Bdata%5D=&columns%5B4%5D%5Bname%5D=&columns%5B4%5D%5Bsearchable%5D=false&columns%5B4%5D%5Borderable%5D=false&columns%5B4%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B4%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B4%5D%5Btype%5D=string&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=desc&start=0&length=-1&search%5Bvalue%5D=&search%5Bregex%5D=false&rangeSeparator=~";
            
}