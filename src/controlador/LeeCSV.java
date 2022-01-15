/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.opencsv.CSVReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author BlackSpider
 */
public class LeeCSV {

    public ArrayList<String[]> leerArchivo(String pathArtchivo) throws IOException {

        ArrayList<String[]> csvArray = new ArrayList<String[]>();
        CSVReader reader = null;
        
        try {

            csvArray = new ArrayList<String[]>();

            reader = new CSVReader(new InputStreamReader(new FileInputStream(pathArtchivo), StandardCharsets.UTF_8));
            String[] nextLine = null;

            reader.readNext(); // elimina la cabecera

            while ((nextLine = reader.readNext()) != null) {
                csvArray.add(nextLine);

            }

        } catch (Exception e) {

            System.out.println("Error al Leer el archivo CSV");

        } finally {

            if (null != reader) {
                reader.close();
            }

        }
        
        return csvArray;

    }

}
