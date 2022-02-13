/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;


import Filtros.*;
import Tuberias.Tuberia;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Esteban Madrazo
 */
public class Ejecutar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo del texto");
        String rutaTexto = teclado.nextLine() + ".txt";
        
        System.out.println("Ingrese el nombre del archivo de las palabras vacias");
        String rutaPalabrasVacias = teclado.nextLine() + ".txt";
        
        //tuberia para obtener las palabras del texto
        Tuberia tuberiaTexto = new Tuberia();
        tuberiaTexto.registrar(new FiltroLineas());
        tuberiaTexto.registrar(new FiltroPalabras());
        tuberiaTexto.registrar(new FiltroMinusculas());
        
        //tuberia tuberia para obterner las palabras vacias
        Tuberia tuberiaPalabrasVacias = new Tuberia();
        tuberiaPalabrasVacias.registrar(new FiltroLineas());
        tuberiaPalabrasVacias.registrar(new FiltroPalabras());
        tuberiaPalabrasVacias.registrar(new FiltroMinusculas());
        
        //tuberia para obtener el resultado KIWIC
        Tuberia KIWIC = new Tuberia();
        KIWIC.registrar(new FiltroEliminar());
        KIWIC.registrar(new FiltroKIWIC());
        
       Object palabras = tuberiaTexto.ejecutar(rutaTexto);
       Object palabrasVacias = tuberiaPalabrasVacias.ejecutar(rutaPalabrasVacias);
        
        System.out.println("\n");
        ArrayList<String> resultados = (ArrayList) KIWIC.ejecutar(palabras,palabrasVacias);
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }
    }
    
}
