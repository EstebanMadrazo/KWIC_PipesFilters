/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tuberias;

import Filtros.Filtro;

/**
 *
 * @author Esteban Madrazo
 */
public class Tuberia {
    private Filtro raiz;
    
    public Object ejecutar(Object entrada) {
        return this.raiz.ejecutar(entrada);
    }
    
    public Object ejecutar(Object entrada1, Object entrada2){
        return this.raiz.ejecutar(entrada1,entrada2);
    }
    
    public Tuberia registrar(Filtro filtro) {
        if ( this.raiz == null ) this.raiz = filtro;
        else this.raiz.registrar(filtro);
        
        return this;
    }
}
