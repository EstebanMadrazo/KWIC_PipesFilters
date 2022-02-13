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
public class FiltroEliminar extends Filtro{
    @Override
    protected Object procesar(Object entrada){
        return null;
    }
    
    @Override
    protected Object procesar(Object entrada1, Object entrada2){
        ArrayList<String> palabras = (ArrayList) entrada1;
        ArrayList<String> palabrasVacias = (ArrayList) entrada2;
        int i = 0;
        boolean removido = false;
        while(i < palabras.size()){
            for (int j = 0; j < palabrasVacias.size(); j++) {
                if(palabras.get(i).equals(palabrasVacias.get(j))){
                    palabras.remove(i);
                    removido = true;
                    break;
                }
            }
            if(!removido){
                i++;
            }else{
                removido = false;
            }
        }
        return palabras;
    }
}
