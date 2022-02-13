/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Esteban Madrazo
 */
public class FiltroLineas extends Filtro{
    @Override
    protected Object procesar(Object entrada){
        String ruta = (String) entrada;
        ArrayList<String> palabras = new ArrayList<>();
        File archivo = null;
        FileReader lectorArchivo = null;
        BufferedReader lectorBufer = null;
        try {
            archivo = new File (ruta);
            if (!archivo.exists()) {
                System.out.println("El archivo no existe");
            }
            String linea;
            lectorArchivo = new FileReader (archivo);
            lectorBufer = new BufferedReader(lectorArchivo);
            while((linea=lectorBufer.readLine())!=null){
                palabras.add(linea);
            }
        }//FIN DEL TRY//FIN DEL TRY
        catch(IOException e){
            System.out.println(e);
        }
        finally{
            try{ //el bloque finally se ejecuta siempre, por eso, si se cierra el fichero
                if( lectorArchivo != null){ //al final del primer try, y ha dado un error antes, pasaría
                    lectorArchivo.close(); //al 1er catch y luego saldría, dejándolo abierto. Es conveniente
                } //cerrarlo aquí, comprobando que no sea -por un error anterior, como
            }catch (IOException e){ // no tener permisos de lectura o que no exista - de valor null.
            }
        }
        
        return palabras;
    }
    
    @Override
    protected Object procesar(Object entrada1, Object entrada2){
        return null;
    }
}
