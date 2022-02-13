/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

/**
 *
 * @author Esteban Madrazo
 */
public abstract class Filtro {
    private Filtro siguiente;
    
    protected abstract Object procesar(Object entrada);
    protected abstract Object procesar(Object entrada1, Object entrada2);
    
    public Object ejecutar(Object entrada) {
        Object valor = procesar(entrada);
        if( this.siguiente != null ) valor = this.siguiente.ejecutar(valor);
        return valor;
    }
    
    public Object ejecutar(Object entrada1, Object entrada2){
        Object valor = procesar(entrada1,entrada2);
        if( this.siguiente != null ) valor = this.siguiente.ejecutar(valor);
        return valor;
    }

    public void registrar(Filtro filtroSiguiente) {
        if ( this.siguiente == null ) this.siguiente = filtroSiguiente;
        else this.siguiente.registrar(filtroSiguiente);
    }
}
