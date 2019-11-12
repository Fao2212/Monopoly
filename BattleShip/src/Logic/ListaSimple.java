/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author migue
 */
class Nodo{
    //componente
    int dato;
    public ListaAristas aristas;
    public boolean visitado;
    public Nodo siguiente;

    public Nodo(/*componente*/int dato) {
        //componente = componente;
        this.dato = dato;
        this.aristas = new ListaAristas();
        this.visitado = false;
        this.siguiente = null;
    }
}


public class ListaSimple {
    public Nodo primerNodo;
    public Nodo ultimoNodo;
    
    public ListaSimple(){
        this.primerNodo = null;
        this.ultimoNodo = null;
    }
    
    public void insertarAlInicio (int dato){
        if (primerNodo == null){
            primerNodo = new Nodo(/*dato*/dato);
            ultimoNodo = primerNodo; 
        }
        else{
            Nodo nuevo = new Nodo(/*dato*/dato);
            nuevo.siguiente = primerNodo;
            primerNodo = nuevo; 
        }
    }
    
    public Nodo borrarAlInicio(){
        if (primerNodo == null){
            return null;
        }
        else{
            Nodo borrado = primerNodo;     
            primerNodo = primerNodo.siguiente;
            borrado.siguiente = null;
            return borrado;
        }
    }
    
    public void insertarAlFinal (int dato){
        if (primerNodo == null){
            primerNodo = new Nodo(/*dato*/dato);
            ultimoNodo = primerNodo;              
        }
        else{
            Nodo nuevo = new Nodo(/*dato*/dato);
            ultimoNodo.siguiente = nuevo;
            ultimoNodo = nuevo;
        }
    }
    
    public Nodo borrarAlFinal(){
        if (vacia())
            return null;
        else if (primerNodo.siguiente == null){
            Nodo actual = primerNodo;
            primerNodo = ultimoNodo = null;
            return actual;
        }
        else {
            Nodo actual = primerNodo;
            while (actual.siguiente.siguiente != null)
                actual = actual.siguiente; 
            Nodo tmp = ultimoNodo;
            ultimoNodo = actual;
            actual.siguiente = null;
            return tmp;
        }
    }
    
    
    
    
    public boolean vacia(){
        if (primerNodo == null)
            return true;
        else
            return false;     
    }
    
    public Nodo buscar(int valor){
        Nodo tmp = primerNodo;
        while (tmp != null){
            if (tmp.dato == valor)
                return tmp;
            tmp = tmp.siguiente;      
        }   
        return null;
    }
    
    public void borrarEnPosicion(int pos){
        if (vacia())
        { }
        else
            if (pos == 0){
                borrarAlInicio();     
            }
        else {
            Nodo actual = primerNodo;
            for (int i=1; i < pos && actual.siguiente != null;i++)
                actual=actual.siguiente;
            if (actual.siguiente == null){
                 borrarAlFinal();
            }
            else{
                Nodo tmp = actual.siguiente;
                actual.siguiente = actual.siguiente.siguiente;
                tmp.siguiente = null;
            }
        }
    }
    
    public int posicion(int valor){
        int pos = 0;
        Nodo tmp = primerNodo;
        while (tmp != null){
            if (tmp.dato == valor)
                return pos;
             pos++;
             tmp = tmp.siguiente;      
        }     
        return -1;
    }
    
    
    public Nodo desencolar(){
        if (primerNodo == null){
            return null;
        }
        else{
            Nodo borrado = primerNodo;     
            primerNodo = primerNodo.siguiente;
            borrado.siguiente = null;
            return borrado;
        }
    }
    
    
    public void encolar (int dato){
        if (primerNodo == null){
            primerNodo = new Nodo(dato);
            ultimoNodo = primerNodo;               
        }
        else{
            Nodo nuevo = new Nodo(dato);
            ultimoNodo.siguiente = nuevo;
            ultimoNodo = nuevo;
        }
    }
}
