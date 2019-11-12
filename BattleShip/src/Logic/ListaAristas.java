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
class Arista {
    //componente
    int dato;
    private int peso;
    public Arista siguiente;

    public Arista(int dato, int peso) {
        this.peso = peso;
        this.dato = dato;
        this.siguiente = null;
    }

    public int getPeso() {
        return peso;
    }
    
}

public class ListaAristas{
    public Arista primerNodo;
    public Arista ultimoNodo;
    
    public ListaAristas(){
        this.primerNodo = null;
        this.ultimoNodo = null;
    }
    
    
    public void insertarAlInicio (int dato, int peso){
        if (primerNodo == null){
            primerNodo = new Arista(dato, peso);
            ultimoNodo = primerNodo;          
        }
        else{
            Arista nuevo = new Arista(dato, peso);
            nuevo.siguiente = primerNodo;
            primerNodo = nuevo; 
        }
    }
    
    
    public Arista borrarAlInicio(){
        if (primerNodo == null){
            return null;
        }
        else{
            Arista borrado = primerNodo;     
            primerNodo = primerNodo.siguiente;
            borrado.siguiente = null;
            return borrado;
        }
    }
    
   public void imprimir(){
        Arista tmp = primerNodo;
        while (tmp != null){
            System.out.println(tmp.dato + "  ");
            tmp = tmp.siguiente;
        }
    }
    
    
    public void insertarAlFinal (int dato, int peso){
        if (primerNodo == null){
            primerNodo = new Arista(dato, peso);
            ultimoNodo = primerNodo;            
        }
        else{
            Arista nuevo = new Arista(dato, peso);
            ultimoNodo.siguiente = nuevo;
            ultimoNodo = nuevo;
        }
    }
    
    
    
    public boolean vacia(){
        if (primerNodo == null)
            return true;
        else
            return false;     
    }
    
    
    public Arista borrarAlFinal(){
        if (vacia())
            return null;
        else if (primerNodo.siguiente == null){
            Arista actual = primerNodo;
            primerNodo = ultimoNodo = null;
            return actual;
        }
        else {
            Arista actual = primerNodo;
            while (actual.siguiente.siguiente != null)
              actual = actual.siguiente; 
            Arista tmp = ultimoNodo;
            ultimoNodo = actual;
            actual.siguiente = null;
            return tmp;
        }
    }
    
    
    public int largo(){
        int contador = 0;
        Arista tmp = primerNodo;
        while (tmp != null){
            contador++;
            tmp = tmp.siguiente;
        }
        return contador;
    }
    
    
    
   public Arista buscar(int valor){
       Arista tmp = primerNodo;
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
        else if (pos == 0){
            borrarAlInicio();
        }
        else {
            Arista actual = primerNodo;
            for (int i=1; i < pos && actual.siguiente != null;i++)
                actual=actual.siguiente;
            if (actual.siguiente == null) {
                 borrarAlFinal();
            }
            else{
                Arista tmp = actual.siguiente;
                actual.siguiente = actual.siguiente.siguiente;
                tmp.siguiente = null;
            }
        }
    }
   
   
   public int posicion(int valor){
        int pos = 0;
        Arista  tmp = primerNodo;
        while (tmp != null){
            if (tmp.dato == valor)
                return pos;
            pos++;
            tmp = tmp.siguiente;      
        }       
        return -1;
    }
    
    
}
