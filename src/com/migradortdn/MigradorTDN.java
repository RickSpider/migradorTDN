/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migradortdn;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.migradortdn.model.Cliente;
import com.migradortdn.model.Comprobante;
import com.migradortdn.model.Data;
import com.migradortdn.model.FormaPago;
import com.migradortdn.model.Login;
import com.migradortdn.model.Marca;
import com.migradortdn.model.Producto;
import com.migradortdn.model.Proveedor;
import com.migradortdn.model.PuntoVenta;
import com.migradortdn.model.Ruta;
import com.migradortdn.model.Timbrado;
import com.migradortdn.model.TimbradoPuntoEmision;
import com.migradortdn.model.TipoCliente;
import com.migradortdn.model.TipoProveedor;
import com.migradortdn.model.Token;
import com.migradortdn.model.UnidadMedida;
import com.migradortdn.model.Vendedor;
import com.migradortdn.model.Zona;
import controlador.DatosProcesar;
import controlador.ClienteDatosProcesar;
import controlador.ComprobanteDatosProcesar;
import controlador.LeeCSV;
import controlador.ProductoDatosProcesar;
import controlador.ProveedorDatosProcesar;
import controlador.TimbradoDatosProcesar;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.ProtocolException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BlackSpider
 */
public class MigradorTDN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ProtocolException, IOException, ParseException {

       LeeCSV csv = new LeeCSV();
       
       boolean zona = false;
       boolean ruta = false;
       boolean vendedor = false;
       boolean tipoCliente = false;
       boolean formaPago = false;
       boolean cliente = false;
       boolean tipoProveedor = false;
       boolean proveedor = false;
       boolean unidadMedidaBase = false;
       boolean unidadMedida = false;
       boolean marca = false;
       boolean producto = false;
       boolean timbrado = false;
       boolean comprbanteNTCCliente = false;
       boolean comprbanteVentaCliente = false;
       

       String[] archivos = {"datos/ciudad.csv", "datos/departamento.csv", "datos/distrito.csv"};

        //datos Cliente
        ArrayList<String[]> csvDepartamentos = csv.leerArchivo("datos/departamento.csv");
        ArrayList<String[]> csvCiudades = csv.leerArchivo("datos/ciudad.csv");
        ArrayList<String[]> csvDistritos = csv.leerArchivo("datos/distrito.csv");

        ConexionHttps con = new ConexionHttps();
        String resultado = "";
        
        DatosProcesar dp = new DatosProcesar();

        con.setLink(Config.HOST + "/qualita-client/rest/login");

        Login login = new Login("admin", "saricmaster$");
        //   Login login = new Login("admin", "admin");

        con.setBody(new Gson().toJson(login));

        resultado = con.getConexion(Config.POST);

        Token rToken = new Gson().fromJson(resultado, Token.class);
        rToken.setUsername(login.getUsername());
        
        if(zona){
            System.out.println("Cargando zona");
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
              System.out.println("Cargando Ruta");
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
             System.out.println("Cargando Vendedor");
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
              System.out.println("Cargando TipoCliente");
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
        
        //foma de pago (Condicion)
        
        if (formaPago){
        
             System.out.println("Cargando formaPago (CONDICION)");
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/QUALITA_CONDICIONVTA_01.csv");
            
            ArrayList<FormaPago> lFormaPago = dp.procesarFormaPago(csvArray);
            
            for( int i = 0 ; i <  lFormaPago.size() ; i++){
            
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.FORMAPAGO);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lFormaPago.get(i)));
                System.out.println(new Gson().toJson(lFormaPago.get(i)));
                System.out.println(con.getConexion(Config.POST));
                
            }
            
            
        }
        
        con = new ConexionHttps();

        con.setLink(Config.HOST + Config.FORMAPAGO + Config.FORMAPAGOLISTA);
            //System.out.println(con.getLink());
            
           
        con.setToken(rToken.getAccessToken());
        con.setBarerAutenticacion(true);
             
        con.setBody("");
           
            
           // System.out.println(con.getConexion(false));
           
        String jsonFp = con.getConexion(Config.GET);
           
        Data dataFomaPago = new Gson().fromJson( jsonFp, Data.class);
        
        Type arrayFP = new TypeToken<List<FormaPago>>(){}.getType();
            
        ArrayList<FormaPago> lTiposPagos =(new Gson().fromJson( new Gson().toJson(dataFomaPago.getData()) , arrayFP));
        
        //seccion clientes
        if(cliente){
            
            ArrayList<String[]> csvArrayCoordenadas = csv.leerArchivo("datos/clientes/Coordenadas_clientes.csv");
            
            System.out.println("Cargando cliente");
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/clientes/QUALITA_CLIENTEVIEW_22032022.csv");
            
            ArrayList<Cliente> lClientes = cdp.procesarDatosClientes(csvArray, csvDepartamentos, csvCiudades, csvDistritos,
                    lVendedores, lZona, lRuta, lTipocliente, lTiposPagos, csvArrayCoordenadas);

            for (int i = 0; i < lClientes.size() ; i++) { //retail 3086
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.CLIENTE);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lClientes.get(i)));
                System.out.println(new Gson().toJson(lClientes.get(i)));
                
                System.out.println(con.getConexion(Config.POST));
              
                //System.out.println(new Gson().toJson(lClientes.get(i)));
            }

        }
        
        if (tipoProveedor){
        
            System.out.println("Cargando Tipo Proveedor");
            
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/proveedor/QUALITA_TIPOPROVEEDOR_01.csv");
            
            ArrayList<TipoProveedor> lTipoProveedor = dp.procesarTipoProveedor(csvArray);
            
             for( int i = 0 ; i <  lTipoProveedor.size() ; i++){
            
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.TIPOSPROVEEDORES);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lTipoProveedor.get(i)));
                System.out.println(new Gson().toJson(lTipoProveedor.get(i)));
                System.out.println(con.getConexion(Config.POST));
                
            }
            
        }
        
        con = new ConexionHttps();

        con.setLink(Config.HOST + Config.TIPOSPROVEEDORES + Config.TIPOSPROVEEDORESLISTA);

        con.setToken(rToken.getAccessToken());
        con.setBarerAutenticacion(true);

        con.setBody("");
        
        Data dataTipoProveedores = new Gson().fromJson( con.getConexion(Config.GET), Data.class);
        
        Type arrayTP = new TypeToken<List<TipoProveedor>>(){}.getType();
            
        ArrayList<TipoProveedor> lTipoProveedor =(new Gson().fromJson( new Gson().toJson(dataTipoProveedores.getData()) , arrayTP));
      
        if (proveedor){
        
            System.out.println("Cargando Proveedor");
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/proveedor/QUALITA_PROVEEDORVIEW_01.csv");
            
            ProveedorDatosProcesar pdp = new ProveedorDatosProcesar();
            
            ArrayList<Proveedor> lProveedor = pdp.procesarDatosProveedores(csvArray, lTipoProveedor);

            for (int i = 1444; i < lProveedor.size(); i++) {
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.PROVEEDOR);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lProveedor.get(i)));
                System.out.println(new Gson().toJson(lProveedor.get(i)));
                System.out.println(con.getConexion(Config.POST));
            }

            
        }
        
        //Seccion UnidadMedida
        
        ArrayList<String[]> csvArrayProducto = csv.leerArchivo("datos/producto/QUALITA_PRODUCTOSVIEW_07042022.csv");
        
        if (unidadMedidaBase){
            
            System.out.println("Cargando Unidad Medida Base");
            
            
        
            List<UnidadMedida> lUnidadBase = dp.procesarUnidadMedidaBase(csvArrayProducto);
            
            for (int i = 0; i<lUnidadBase.size();i++){
            
                 con = new ConexionHttps();

                con.setLink(Config.HOST + Config.UNIDADMEDIDA);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lUnidadBase.get(i)));
                System.out.println(new Gson().toJson(lUnidadBase.get(i)));
                System.out.println(con.getConexion(Config.POST));
                
            }

        }
        
        if (unidadMedida){
        
            System.out.println("Cargando Unidad Medida");
            
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.UNIDADMEDIDA + Config.UNIDADMEDIDALISTABASE);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody("");

            Data dataUndBase = new Gson().fromJson( con.getConexion(Config.GET), Data.class);

            Type arrayUND = new TypeToken<List<UnidadMedida>>(){}.getType();
               
            ArrayList<UnidadMedida> lUnidadMedidaBase =(new Gson().fromJson( new Gson().toJson(dataUndBase.getData()) , arrayUND));
            
            ArrayList<UnidadMedida> lUndM = dp.procesarUnidadMedida(csvArrayProducto, lUnidadMedidaBase);
            
            for (int i = 0; i<lUndM.size();i++){
                
                /*UnidadMedida mm = lUndM.get(i);
            
                System.out.println(mm.getDescripcion() +" "+ mm.getUnidadContenida().getDescripcion()+" " +mm.getCantidad() );*/
                
                 con = new ConexionHttps();

                con.setLink(Config.HOST + Config.UNIDADMEDIDA);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lUndM.get(i)));
                System.out.println(new Gson().toJson(lUndM.get(i)));
                System.out.println(con.getConexion(Config.POST));
                
            }
            
            
            /*for (UnidadMedida x : lUnidadMedidaBase){
            
                System.out.println(x.getDescripcion());
                
            }*/
            
        }
        
        if (marca){
        
            System.out.println("Cargando Unidad Medida");
            
            ArrayList<Marca> lMarca = dp.procesarMarca(csvArrayProducto);
            
            for (int i = 0; i<lMarca.size();i++){
            
               // System.out.println(lMarca.get(i).getDescripcion());
               
                 con = new ConexionHttps();

                con.setLink(Config.HOST + Config.MARCA);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lMarca.get(i)));
                System.out.println(new Gson().toJson(lMarca.get(i)));
                System.out.println(con.getConexion(Config.POST));
                
                
            }
                       
            
        }
        
        if (producto){
            
            ArrayList<String[]> csvArrayLinea = csv.leerArchivo("datos/producto/prd_linea_producto06042022.csv");
            
            // proveedor
            
            System.out.println("Lista Proveedor");
            
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.PROVEEDOR + Config.PROVEEDORLISTA);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody("");

            Data dataProveedor = new Gson().fromJson( con.getConexion(Config.GET), Data.class);

            Type arrayP = new TypeToken<List<Proveedor>>(){}.getType();
               
            ArrayList<Proveedor> lProveedor =(new Gson().fromJson( new Gson().toJson(dataProveedor.getData()) , arrayP));
            System.out.println("tamaño proveedor "+lProveedor.size() );
            //unidad medida base
            
            System.out.println("Unidad Medida Base");
            
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.UNIDADMEDIDA + Config.UNIDADMEDIDALISTABASE);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody("");

            Data dataUndBase = new Gson().fromJson( con.getConexion(Config.GET), Data.class);

            Type arrayUNDbase= new TypeToken<List<UnidadMedida>>(){}.getType();
               
            ArrayList<UnidadMedida> lUnidadMedidaBase =(new Gson().fromJson( new Gson().toJson(dataUndBase.getData()) , arrayUNDbase));
            
            // unidad medida
            
            System.out.println("Unidad Medida");
             
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.UNIDADMEDIDA + Config.UNIDADMEDIDALISTA);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody("");

            Data dataUnd = new Gson().fromJson( con.getConexion(Config.GET), Data.class);

            Type arrayUND = new TypeToken<List<UnidadMedida>>(){}.getType();
               
            ArrayList<UnidadMedida> lUnidadMedida =(new Gson().fromJson( new Gson().toJson(dataUnd.getData()) , arrayUND));
            
            System.out.println("Unidad Medida size "+lUnidadMedida.size());
            
            // marca
            
            System.out.println("Marca");            
            
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.MARCA + Config.MARCALISTA);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody("");

            Data dataMarca = new Gson().fromJson( con.getConexion(Config.GET), Data.class);

            Type arrayM = new TypeToken<List<Marca>>(){}.getType();
               
            ArrayList<Marca> lMarca =(new Gson().fromJson( new Gson().toJson(dataMarca.getData()) , arrayM));
        
            //Producto
            ProductoDatosProcesar pdp = new ProductoDatosProcesar();
            ArrayList<Producto> lProducto = pdp.procesarDatosProducto(csvArrayProducto, csvArrayLinea, lProveedor, lUnidadMedidaBase
            , lUnidadMedida, lMarca);
            
            for (int i = 0; i<lProducto.size() ;i++){
             
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.PRODUCTO);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lProducto.get(i)));
                System.out.println(new Gson().toJson(lProducto.get(i)));
                System.out.println(con.getConexion(Config.POST));
                 
                 
             }
            
        }
        
        if (timbrado){
            
             ArrayList<String[]> csvArray = csv.leerArchivo("datos/comprobante/QUALITA_TIMBRADOVENTAS_11042022.csv");
        
            System.out.println("Puntos de venta");
             
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.PUNTOVENTA + Config.PUNTOVENTALISTA);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody("");
            
            Data<PuntoVenta> dataPV = new Gson().fromJson(  con.getConexion(Config.GET), Data.class);

            Type arrayPV = new TypeToken<List<PuntoVenta>>(){}.getType();
               
            ArrayList<PuntoVenta> lPuntoVenta =(new Gson().fromJson( new Gson().toJson(dataPV.getData()) , arrayPV));
            
            System.out.println("lPunto de venta size "+lPuntoVenta.size());
            
            TimbradoDatosProcesar tdp = new TimbradoDatosProcesar();
            
            ArrayList <Timbrado> lTimbradosNTC =  tdp.procesarTimbrado(csvArray, lPuntoVenta);//42 L es tipo nota de credito
            
            for (int i = 0; i<lTimbradosNTC.size() ;i++){
             
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.TIMBRADOEMPRESA);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lTimbradosNTC.get(i)));
                System.out.println(new Gson().toJson(lTimbradosNTC.get(i)));
                System.out.println(con.getConexion(Config.POST));
                 
                 
             }
          
            
        }
        
      
            
          
            
            //timbrados
            
            System.out.println("Timbrado Empresa");
            
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.TIMBRADOEMPRESA + Config.TIMBRADOEMPRESALISTA);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody("");
            
            //System.out.println(con.getConexion(Config.GET));

            Data dataTimbrado = new Gson().fromJson( con.getConexion(Config.GET), Data.class);

            Type arrayT = new TypeToken<List<Timbrado>>(){}.getType();
               
            ArrayList<Timbrado> lTimbrados =(new Gson().fromJson( new Gson().toJson(dataTimbrado.getData()) , arrayT));
            System.out.println("tamaño Timbrado "+lTimbrados.size() );
            
            //Sigue timbrado
            
            
            ArrayList<Timbrado> lTimbradosObj = new ArrayList<Timbrado>();
            for (Timbrado t : lTimbrados){
            
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.TIMBRADOEMPRESA + "/"+t.getId() +Config.TIMBRADOEMPRESAGET);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody("");
               
                Timbrado x = new Gson().fromJson( con.getConexion(Config.GET), Timbrado.class);
                
                lTimbradosObj.add(x);
                
            }
            
            // Locaciones
            System.out.println("Locaciones");
            ArrayList<String[]> csvLocacion = csv.leerArchivo("datos/comprobante/gnr_locacion.csv");
             
            // cliente
            
            System.out.println("Lista Cliente");
            
            con = new ConexionHttps();

            con.setLink(Config.HOST + Config.CLIENTE + Config.CLIENTELISTA);

            con.setToken(rToken.getAccessToken());
            con.setBarerAutenticacion(true);

            con.setBody("");

            Data dataCliente = new Gson().fromJson( con.getConexion(Config.GET), Data.class);

            Type arrayC = new TypeToken<List<Cliente>>(){}.getType();
               
            ArrayList<Cliente> lCliente =(new Gson().fromJson( new Gson().toJson(dataCliente.getData()) , arrayC));
            System.out.println("tamaño Cliente "+lCliente.size() );
            
        if (comprbanteNTCCliente){
                
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/comprobante/QUALITA_SALDOSNCR_01.csv");
            
            ComprobanteDatosProcesar cmdp = new ComprobanteDatosProcesar();
            
            ArrayList<Comprobante> lComprobanteNTCC = cmdp.procesarDatosComprobante(csvArray, lCliente, lTimbradosObj, csvLocacion, 4L);
            
            
            for (int i = 0; i<lComprobanteNTCC.size() ;i++){
             
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.COMPROBANTEVENTA);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lComprobanteNTCC.get(i)));
                System.out.println(new Gson().toJson(lComprobanteNTCC.get(i)));
                System.out.println(con.getConexion(Config.POST));
                 
                 
             }
            
           
            
        }
        
        
        if (comprbanteVentaCliente){
        
            ArrayList<String[]> csvArray = csv.leerArchivo("datos/comprobante/QUALITA_SALDOSCLIENTES_07042022.csv");
            
            ComprobanteDatosProcesar cmdp = new ComprobanteDatosProcesar();
            
            ArrayList<Comprobante> lComprobanteVENTACliente = cmdp.procesarDatosComprobante(csvArray, lCliente, lTimbradosObj, csvLocacion, 3L);
            
            
            for (int i = 0; i<1 ;i++){
             
                con = new ConexionHttps();

                con.setLink(Config.HOST + Config.COMPROBANTEVENTA);

                con.setToken(rToken.getAccessToken());
                con.setBarerAutenticacion(true);

                con.setBody(new Gson().toJson(lComprobanteVENTACliente.get(i)));
                System.out.println(new Gson().toJson(lComprobanteVENTACliente.get(i)));
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
