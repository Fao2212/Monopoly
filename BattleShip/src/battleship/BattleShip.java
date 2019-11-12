/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import Logic.Grafo;
import Logic.GrafoMatriz;

/**
 *
 * @author migue
 */
public class BattleShip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        GrafoMatriz g1 = new GrafoMatriz();
        g1.agregarVertice(10);
        g1.agregarVertice(20);
        g1.agregarVertice(30);
        g1.agregarVertice(40);
        g1.agregarVertice(50);
        g1.agregarVertice(60);
        
        g1.agregarArista(g1.vertices[0], g1.vertices[1],7);
        g1.agregarArista(g1.vertices[1], g1.vertices[0],7);
        g1.agregarArista(g1.vertices[0], g1.vertices[2],9);
        g1.agregarArista(g1.vertices[2], g1.vertices[0],9);
        g1.agregarArista(g1.vertices[0], g1.vertices[5],14);
        g1.agregarArista(g1.vertices[5], g1.vertices[0],14);
        g1.agregarArista(g1.vertices[1], g1.vertices[2],10);
        g1.agregarArista(g1.vertices[2], g1.vertices[1],10);
        g1.agregarArista(g1.vertices[1], g1.vertices[3],15);
        g1.agregarArista(g1.vertices[3], g1.vertices[1],15);
        g1.agregarArista(g1.vertices[2], g1.vertices[3],11);
        g1.agregarArista(g1.vertices[3], g1.vertices[2],11);
        g1.agregarArista(g1.vertices[2], g1.vertices[5],2);
        g1.agregarArista(g1.vertices[5], g1.vertices[2],2);
        g1.agregarArista(g1.vertices[3], g1.vertices[4],6);
        g1.agregarArista(g1.vertices[4], g1.vertices[3],6);
        g1.agregarArista(g1.vertices[5], g1.vertices[4],9);
        g1.agregarArista(g1.vertices[4], g1.vertices[5],9);   
        g1.verificarDisconexo();
        g1.imprimir();
        
        
        

      //  g1.dijkstra(10);
        //g1.warshall_floyd();
    }
    
}
