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
public class Grafo {
    public ListaSimple vertices;
    
    public Grafo(){
        this.vertices = new ListaSimple();
    }
    
    public void insertarVertice(int d){
        Nodo tmp = vertices.buscar(d);
        if (tmp == null){
            vertices.insertarAlFinal(d);
        }
        else{
            System.out.println("El nodo " + d + "ya existe");    
        }
    } 
    
    
    public void insertarArista(int origen, int destino, int peso){
            Nodo tmp = vertices.buscar(origen);
            Nodo tmpDest = vertices.buscar(destino);
            if (tmp != null){
                if (tmpDest != null){     
                    Arista arista = tmp.aristas.buscar(destino);
                    if (arista == null){
                        tmp.aristas.insertarAlFinal(destino, peso);           
                    }
                      else{
                        System.out.println("Arista ya existe");    
                    }
                }
                else{
                    System.out.println("Destino no existe");    
                } 
            }
            else{
                System.out.println("Nodo origen no existe");    
            }
    }
    
    
    public void imprimir (){
        Nodo tmp = vertices.primerNodo;
        while (tmp != null){
            System.out.print(tmp.dato +": ");
            tmp.aristas.imprimir();
            System.out.print("\n"); 
            tmp = tmp.siguiente; 
        }  
        System.out.print("\n");
    }
    
    public void borrarArista(int origen, int destino){
        Nodo tmp = vertices.buscar(origen);     
        if (tmp != null){
            int posA = tmp.aristas.posicion(destino);
            if (posA > -1){
                tmp.aristas.borrarEnPosicion(posA);
                System.out.println("Eliminada arista " + origen + " - " + destino);         
            }
            else{  }           
        }     
    }   
    
    
    
    public void borrarVertice (int dato){
        int posV = vertices.posicion(dato);
        if (posV > -1){  
            Nodo tmp = vertices.primerNodo;
            while (tmp != null){
              borrarArista(tmp.dato, dato);//el componente
              tmp = tmp.siguiente;      
            }    
            vertices.borrarEnPosicion(posV);
        }
        else{
            System.out.println("Vertice no existe");    
        }
    }
       
    
    public void visitarVertice(int dato){
        Nodo tmp = vertices.buscar(dato);
        if (tmp != null)
            tmp.visitado = true;     
    }

    public boolean visitadoVertice(int dato){
        Nodo tmp = vertices.buscar(dato);
        if (tmp != null)
            return tmp.visitado;
        else
            return false;     
    }
    
    
    
    public void limpiarVisitados(){
        Nodo tmp = vertices.primerNodo;
        while (tmp != null){
           tmp.visitado = false;
           tmp = tmp.siguiente;      
        }     
    }
    
    
    public void visitarAdyacentes(int nodo){
        visitarVertice(nodo);
        System.out.println(nodo + " - ") ;     
        Nodo tmp = vertices.buscar(nodo);
         if (tmp != null){
            Arista actual = tmp.aristas.primerNodo;
            while (actual!=null){
              // si no esta visitado
                if (visitadoVertice(actual.dato)==false){
                    visitarAdyacentes(actual.dato);
                }

                actual = actual.siguiente;      
            }        
        }     
    }
    
    
    public void profundidad(){
        Nodo tmp = vertices.primerNodo;
        while (tmp != null){
            if (tmp.visitado == false)
                visitarAdyacentes(tmp.dato);
            
            tmp = tmp.siguiente;
        }
        limpiarVisitados();
    }
    
    
    public void anchura(Nodo v){
        System.out.println(v.dato + "  ") ;
        visitarVertice(v.dato);
        ListaSimple cola = new ListaSimple();
        Arista aristaTmp = v.aristas.primerNodo;
        while(aristaTmp != null){
            cola.encolar(aristaTmp.dato);
            visitarVertice(aristaTmp.dato);
            aristaTmp = aristaTmp.siguiente;                
        }
        while(cola.primerNodo !=null){
            Nodo actual = cola.desencolar();
            visitarVertice(actual.dato);
            System.out.println(actual.dato + "  ");
            Nodo nodoCola = vertices.buscar(actual.dato);
            aristaTmp = nodoCola.aristas.primerNodo;
            while (aristaTmp != null){
                if (visitadoVertice(aristaTmp.dato) == false) {
                    visitarVertice(aristaTmp.dato);
                    cola.encolar(aristaTmp.dato);                       
                }     
                aristaTmp = aristaTmp.siguiente;
            }
        }
        limpiarVisitados();     
    }
    
}
