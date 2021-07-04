/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author zuagu
 */
public class ModelProcesarCartera {

    public static String lista_archivos() {
        File dir = new File("C:\\Users\\Public");
        String[] ficheros = dir.list();
        JSONArray listArchivos = new JSONArray();

        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            for (int x = 0; x < ficheros.length; x++) {
                listArchivos.add(ficheros[x]);
//                System.out.println(ficheros[x]);
            }
        }
        return listArchivos.toJSONString();

    }

    public static String eliminar_archivo(String nombre_archivo) {

        String filePath = "C:\\Users\\Public\\" + nombre_archivo;
        File storeFile = new File(filePath);
        System.out.println(filePath);
        
        JSONObject response = new JSONObject();

        if (storeFile.delete()) {
            response.put("message", "El fichero ha sido borrado satisfactoriamente");
        } else {
            response.put("message", "El fichero no puede ser borrado");
        }
        
        return response.toJSONString();

    }
    
    public static String procesar_cartera() {

        String command = "py C:\\Users\\Public\\hola.py";
        String result = "hola";
        try {
            
            
            Runtime.getRuntime().exec(command);
                    
//            Scanner scan = new Scanner(Runtime.getRuntime().exec(command).getInputStream());
//            
////            String res = scan.hasNext() ? scan.next() : "";
//            
//            while (scan.hasNext()) {
//                System.out.println( scan.next() );
//                result += scan.next();
//            }
            
        } catch (IOException ex) {
            Logger.getLogger(ModelProcesarCartera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

}
