/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

import java.util.ArrayList;


/**
 *
 * @author Esteban Madrazo
 */
public class FiltroMinusculas extends Filtro{
    @Override
    protected Object procesar(Object entrada){
        ArrayList<String> palabras = (ArrayList) entrada;
        for (int i = 0; i < palabras.size(); i++) {
            palabras.set(i, palabras.get(i).toLowerCase());
        }
        
        return palabras;
    }
    
    @Override
    protected Object procesar(Object entrada1, Object entrada2){
        return null;
    }
}
