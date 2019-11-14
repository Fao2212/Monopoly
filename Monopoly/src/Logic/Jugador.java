/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Random;

/**
 *
 * @author migue
 */
public class Jugador {
    public int dinero;
    public boolean turno;
    public int dadoInicio;
    //tablero
    public String nombre;
    //array de propiedades o q en propiedades tengan un jugador
    public int resultado;
    int numeroDeJugador;
    
    public Jugador(String nombre,int numeroDeJugador){//recibe tablero
        this.nombre = nombre;
        this.turno = false;
        this.dinero = 1500;
        this.resultado = 0;
        this.numeroDeJugador = numeroDeJugador;
    }
    
    public int lanzarDado(){
        this.resultado = new Random().nextInt((12 - 2) + 1) + 2;
        return this.resultado;
    }
    
    public void comprar(int propiedad){                      //los int son Propiedad(clase)
        //arrayPropiedad.add(propiedad);
        //propiedad.persona = this;
        //this.dinero = this.dinero - propiedad.dinero;
    }
    
    //recorrer tablero hasta llegar a posicion deseada
}
