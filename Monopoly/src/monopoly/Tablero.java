/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import Random.CustomRandom;

/**
 *
 * @author ferol
 */
public class Tablero {
    
    Casilla casillas[];
    Edificio casas[];
    Edificio hoteles[];
    Propiedad propiedades[];
    Carta arcaComunal[];
    Carta casualidad[];
    //Se crea el banco todas las casas todas las propiedades todas las tarjetas
    //Setear las reglas como los metodos poner contadores para la cantidad de cartas que quedan en las barajas
    Jugador jugadores[];//Lleva el orden
    int indiceJugadorActual;
    Jugador jugadorActual;
    final int POSICIONES_CHANCE[];
    final int POSICIONES_COMUNNITY[];
    final int POSICIONES_FERROCARRILES[];
    final int POSICIONES_SERVICIOS;
    final int VISITANDO_CARCEL;
    final int IMPUESTOS[];
    final int FREE_PARK;
    final int CARCEL;
    final int GO;
    

    public Tablero() {
        
        indiceJugadorActual = 0;
        casillas = new Casilla[40];
        casas = new Edificio[32];
        hoteles = new Edificio[12];
        propiedades = new Propiedad[22];
        
    }
    
    public void asignarCasillas(){
        
    }
    
    public void iniciarJuego(){
        
    }
    
    public void siguienteJugador(){
        
        jugadorActual = jugadores[indiceJugadorActual];
        if(indiceJugadorActual < jugadores.length)
            indiceJugadorActual++;
        else
            indiceJugadorActual = 0;
        
    }
    
    public Jugador[] escogerOrden(Jugador jugador){
        //Manejar con dos listas
        //Espera a que todos los jugadores lancen el dado y va anadiendo a un array
        //Cuando ya tiraron todos los jugadores se ordena el array o se hace una lista se sacan y quedan solo los repetidos
        //Se crea otro array donde se guardan las posiciones, si se repetia alguna se vuelve a pedir que tiren los dados
        //Pero solo para los repetidos mientras los otros tienen puesto esperando jugadores
        //Cuando este todo listo se devuelve la lista ordenada
        //Y es la que se usa para el orden de los turnos
        return new Jugador[2];//Cambiar
    }
    
    public void moverPieza(int espacios){
        //Jugador.pieza.pos = pos+espacios;
        //O un for que lo vaya moviendo 1 por uno hasta que llegue a espacios
    }
    
    public void venderPropiedad(Propiedad propiedad,Jugador jugador){
        Banco.comprarPropiedad();
    }
    
    public void hipotecarPropiedad(){
        
    }
    
    public void pagarVuelta(){
        
    }
    
    public void comprarCasa(){
        
    }
    
    public void comprarHotel(){
        
    }
    
    public int lanzarDado(){
        int dado = CustomRandom.randomRange(1, 6);
        return dado;
    }
    
    public int lanzarDados(){
        return lanzarDado()+lanzarDado();
    }
    
    public void accionCasilla(Casilla casilla){
        casilla.doAction();
    }
    
    public void enviarALaCarcel(/*Jugador*/){
        
    }
    
    public void levantarHipoteca(/*Propiedad*/){
        
    }
}
