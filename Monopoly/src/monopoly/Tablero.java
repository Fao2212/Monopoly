/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import Logic.Cartas;
import Logic.Jugador;
import Random.CustomRandom;
import java.util.ArrayList;

/**
 *
 * @author ferol
 */
public class Tablero {
    
    Casilla casillas[];
    Edificio casas[];
    Edificio hoteles[];
    Propiedad propiedades[];
    Cartas arcaComunal[];
    Cartas casualidad[];
    int dadosInicio;
    int dadosMalvados[] = new int[100];
    int contadorDeDados = 0;
    ArrayList<Jugador> ordenJugadores[];//Lleva el orden
    Jugador jugadores[];
    int indiceJugadorActual;
    Jugador jugadorActual;
    int cantidadDeJugadores = 0;
    int maxPlayers;
    final static int POSICIONES_CHANCE[] = {7,22,36};
    final static int POSICIONES_COMUNNITY[] = {2,17,33};
    final static int POSICIONES_FERROCARRILES[] = {5,15,25,35};
    final static int POSICIONES_SERVICIOS[] = {12,28};
    final static int VISITANDO_CARCEL = 10;
    final static int IMPUESTOS[] = {4,38};
    final static int FREE_PARK = 20;
    final static int CARCEL = 30;
    final static int GO = 0;
    //contadores para los decks
    

    public Tablero() {
        
        indiceJugadorActual = 0;
        casillas = new Casilla[40];
        casas = new Edificio[32];
        hoteles = new Edificio[12];
        propiedades = new Propiedad[22];
        
    }
    
    
    //Servidor crea un array y el jugador al seleccionar su pieza se le muestra el que le toco, se hace un linkeo de la pos del arry con el jugador segun orden de entrada o selec de pieza
    //Sabiendo las pos del array se asigna los no repetidos a una pos se les muestra esperando jugaores a los demas
    //Se vuelve a pedir que los repetidos lanzen el dado
    
    public void asignarPosJugador() {
        
    }
    
    public void agregarJugador(Jugador jugador){
        //Cuado hace conexion se da al jugador su numero y se recibe su pieza
        jugadores[cantidadDeJugadores++] = jugador;
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
    
    public void preOrden(ArrayList<Jugador> arraylist){//Funcion que compruebe
        
            dadosInicio = arraylist.size();
            int[] array = new int[dadosInicio] ;
            for (int i = 0; i < dadosInicio; i++) {
                array[i] = lanzarDados();
            }
            
            escogerOrden(array, array);
        
    }
    
    public int mayor(int[] array){
        int mayor = -1;
            for(int i = 0;i<array.length;i++){
                if(array[i]>mayor)
                    mayor = array[i];
            }
            return mayor;
    }
    
    public boolean seRepite(int numero,int[] array){
        int contador = 0;
         for(int i = 0;i<array.length;i++){
             if(array[i]==numero)
                 contador++;
            }
         if(contador == 1)
             return false;
         else
             return true;
    }
    
    public int cantidadDeRepeticiones(int numero,int[]array){
        int contador = 0;
         for(int i = 0;i<array.length;i++){
             if(array[i]==numero)
                 contador++;
            }
         return contador;
    }
    
    public void escogerOrden(int[] original,int[] temporal){
        
        int mayor = mayor(temporal);
        if(seRepite(mayor, temporal)){
            int rep = cantidadDeRepeticiones(mayor, temporal);
            int[] array = new int[rep];
            for (int i = 0; i < rep; i++) {//Referencias de jugador que tengan un array inicial
                array[i] = lanzarDados();//para el array del jugador que muestre el numero que salio  
            }
            
            mayor = mayor(array);
            if(seRepite(mayor, array)){
            
            }
            

        }
        else{
            asignarPosJugador();
        }

    }
    
    public void moverPieza(int espacios){
        //Jugador.pieza.pos = pos+espacios;
        //O un for que lo vaya moviendo 1 por uno hasta que llegue a espacios
    }
    
    public void venderPropiedad(Propiedad propiedad,Jugador jugador){
        //Banco.comprarPropiedad();
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
