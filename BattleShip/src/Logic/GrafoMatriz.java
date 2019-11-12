/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class GrafoMatriz {
    private int max = 20;
    private int [][] matriz = new int [max][max];
    private int cantidadVertices;
    public int [] vertices = new int [max * 10];                        //Nodo
    private boolean [] visitados = new boolean [max];

    public GrafoMatriz() {
        this.cantidadVertices = 0;
        for (int i = 0; i < max; i++) {
            vertices[i] = 0;
            visitados[i] = false;
            for (int j = 0; j < max; j++) {
                matriz[i][j] = 0;
            }
        }
    }
    
    public int[] verificarDisconexo(){
        int cont = 0;
        int [] disconexos = new int[max * 10];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (matriz[i][j] == 0)
                    cont++;
                if (cont == max) {
                    disconexos[i] = vertices[i];
                    System.out.println(vertices[i]);
                }
            }
            cont = 0;
        }
        return disconexos;
    }
    
    public void agregarVertice(int v){
       if (cantidadVertices < max && indexOfVertice(v) == -1){
            vertices[cantidadVertices] = v;
            cantidadVertices++;
       }
    }
    
    
    public int indexOfVertice(int v){                           //Componente v
        for (int i = 0; i < cantidadVertices; i++) {
            if (vertices[i] == v)
                return i;
        }
        return -1;
    }
    
    public void agregarArista(int origen, int destino, int peso){
        int orig = indexOfVertice(origen);
        int dest = indexOfVertice(destino);

        if (orig != -1 && dest != -1)
        {
            matriz[dest][orig] = peso;
            matriz[orig][dest] = peso;                            //en caso de ser no dirigido
        }
    }
    
    public void borrarVertice (int dato){
        for (int i = 0; i < (max * 10); i++) {
            if (vertices[i] == dato)
                vertices[i] = 0;
        }
    }
    
    public int getVert(int vert){
        for (int i = 0; i < (max * 10); i++) {
            if (vertices[i] == vert)
                return vertices[i];
        }
        return -1;
    }
    
    
    public void borrarArista(int origen, int destino){
        int orig = getVert(origen);
        int dest = getVert(destino);
        if (orig != -1 && dest != -1){
            matriz[orig][dest] = 0;
        }
    }  
    
    public boolean visitadoVertice(int dato){
        int vert = getVert(dato);
        return false;               //aqui ocupo con el nodo
    }
    
    public void visitarVertice(int dato){
        Nodo tmp = null; //vertices.buscar(dato);
        if (tmp != null)
            tmp.visitado = true;     
    }
    
    
    

    void limpiarVisitados(){
        for (int i=0; i < cantidadVertices;i++)
            visitados[i] = false;
    }  
    
    
    
    public void imprimir(){
        System.out.print(" \t");
        for (int i = 0; i < cantidadVertices; i++) {
            System.out.print(vertices[i]+"\t");
        }

        System.out.println("\n");

        for (int i = 0; i < cantidadVertices; i++) {
            System.out.print(vertices[i]+"\t");
            for (int j = 0; j < cantidadVertices; j++) {
                
                System.out.print(matriz[i][j]+ "\t");
            }
            System.out.println("\n");
        }
    }
    
    public int minVertex (int [] distanciasCortas) {
        int x = 999999;
        int y = -1;
        for (int i = 0; i < cantidadVertices; i++) {
            System.out.println(distanciasCortas[i] + "   ");
            if (!visitados[i] && distanciasCortas[i] < x) {
                y = i;
                x = distanciasCortas[i];
            }
        }
        System.out.println("min: " + y + "  valor = " + x );
        return y;
    } 
    
    public int[] dijkstra(int v) {
        limpiarVisitados();
        int [] distanciasCortas = new int [max];
        int node = indexOfVertice(v);
        visitados[node] = true;
        distanciasCortas[node] = 0;
        for (int i = 1; i < cantidadVertices; i++) {
            if (matriz[i][node] != 0) 
                distanciasCortas[i] = matriz[i][node];
            else 
                distanciasCortas[i] = 999999;
        }
        for (int i = 0; i < (cantidadVertices - 1); i++){
            int next = minVertex(distanciasCortas);
            visitados[next] = true;
            //
            for (int j = 0; j < cantidadVertices; j++) {
                int d = distanciasCortas[next] + matriz[j][next];
                if (distanciasCortas[j] > d && matriz[j][next] > 0) {
                    distanciasCortas[j] = distanciasCortas[next] + matriz[j][next];
                }
            }
        }

        for (int i = 0; i < cantidadVertices; i++)
            System.out.print(distanciasCortas[i]+"   ");
        
        System.out.print("\n");

        return distanciasCortas;
    }
    
    
    public void warshall_floyd(){
        int cn = cantidadVertices;
        int [][] path = new int [max][max];
        for (int i = 0; i < cn; i++) {
            for (int j = 0; j < cn; j++) {
                if (matriz[i][j] > 0)
                    path[i][j] = matriz[i][j];
                else if (i==j)
                    path[i][j] = 0;
                else 
                    path[i][j] = 9999;
            }
        }

        for(int i = 0; i < cn; i++)
        {
                System.out.println("\n");;
                for (int j = 0; j < cn; j++)
                   System.out.println(path[i][j]+"\t");
                
        }
        System.out.println("\n");

        for(int k = 0; k < cn; k++)
            for(int i = 0; i < cn; i++)
                for(int j = 0; j < cn; j++){
                    int dt = path[i][k] + path[k][j];
                    if(path[i][j] > dt)
                    {
                        path[i][j] = dt;
                    }
                }
        for(int i = 0; i < cn; i++){
                System.out.println("\n");;
                for (int j = 0; j < cn; j++)
                   System.out.println(path[i][j]+"\t");
        }

    }

    public int getCantidadVertices() {
        return cantidadVertices;
    }
    
    
    
}
