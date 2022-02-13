/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Esteban Madrazo
 */
public class FiltroPalabras extends Filtro{
    
    @Override
    protected Object procesar(Object entrada){
        ArrayList<String> lineas = (ArrayList) entrada;
        ArrayList<String> palabras = new ArrayList<>();
        for (int i = 0; i < lineas.size(); i++) {
            String[] palabra;
            palabra = lineas.get(i).split(" ");
            palabras.addAll(Arrays.asList(palabra));
        }
        return palabras;
    }
    
    @Override
    protected Object procesar(Object entrada1, Object entrada2){
        return null;
    }
}
