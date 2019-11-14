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
    
    public Casilla casillas[];
    Edificio casas[];
    Edificio hoteles[];
    Propiedad propiedades[];
    Cartas arcaComunal[];
    Cartas casualidad[];
    ArrayList<Jugador> ordenJugadores[];//Lleva el orden
    public Jugador jugadores[];
    int indiceJugadorActual;
    Integer dadosInicio[];
    int contRepPos;
    Jugador jugadorActual;
    int cantidadDeJugadores = 0;//Aumenta o se asigna
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
        contRepPos = 0;
        casillas = new Casilla[40];
        casas = new Edificio[32];
        hoteles = new Edificio[12];
        propiedades = new Propiedad[22];
        jugadores = new Jugador[3];
       dadosInicio(); 
        
    }
    
    public void dadosInicio(){//Funcion al azar de suma para los dados   cuando ya esten asignadas las posiciones entonces se lanza el dado normal
        dadosInicio = new Integer[12];
        for (int i = 1; i < 13; i++) {
            dadosInicio[i-1] = i;
        }
        CustomRandom.shuffle(dadosInicio);
    }
    
    public void asignarPosJugador(Jugador jugador) {//Se asigna en la conexion y cuando cada uno le de tirar dados muestra el numero que tienen asignado y se muestra el acomodo de las posiciones
        jugador.dadoInicio = dadosInicio[contRepPos++];
    }
    
    public void agregarJugador(Jugador jugador){
        jugadores[cantidadDeJugadores++] = jugador;
    }
    
    public void asignarCasillas(){
        //Aca se cargan las tarjetas y se ponen en sus respectivos campos y se rellenas los array de tarjetas
    }
    
    public void ordenarJugadores(){
        int i, j,n= jugadores.length;
        Jugador tmp;
        for (i=1;i<n;i++){
            for (j=n-1;j>=i;j--){
                if (jugadores[j].dadoInicio > jugadores[j-1].dadoInicio){
                     tmp = jugadores[j];
                     jugadores[j] = jugadores[j-1];
                     jugadores[j-1]=tmp;
                }
            }
        }

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
    
   /* public void preOrden(ArrayList<Jugador> arraylist){//Funcion que compruebe
        
        
        
    }*/
    
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
    
   /* public void escogerOrden(int[] original,int[] temporal){
        
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

    }*/
    
    public void moverPieza(int espacios){
        //Jugador.pieza.pos = pos+espacios;
        for (int i = 0; i < espacios; i++) {
            //Jugador.ficha.pos = pos+espacios;
        }
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
    
    private void imprimirJugadores(){
        for (int i = 0; i < cantidadDeJugadores; i++) {
            System.out.println(jugadores[i].nombre);
        }
    }

}
