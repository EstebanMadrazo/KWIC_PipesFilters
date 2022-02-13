/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Esteban Madrazo
 */
public class FiltroKIWIC extends Filtro{
    @Override
    protected Object procesar(Object entrada){
        ArrayList<String> palabras = (ArrayList) entrada;
        String resultado = null;
        ArrayList<String> resultados = new ArrayList<>();
        Queue<String> cola = new LinkedList<>();
        for (int i = palabras.size()-1; i >= 0; i--) {
            cola.offer(palabras.get(i));
        }
        for (int i = 0; i < palabras.size(); i++) {
            for (int j = 0; j < palabras.size(); j++) {
                if(j == 0){
                    resultado = cola.peek();
                    cola.offer(cola.poll());
                }else{
                    resultado = cola.peek() + " " + resultado;
                    cola.offer(cola.poll());
                }
            }
            cola.offer(cola.poll());
            
            resultados.add(resultado);
        }  
        return resultados;
    }
    
    @Override
    protected Object procesar(Object entrada1, Object entrada2){
        return null;
    }
}
