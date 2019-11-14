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
    int dadosInicio;
    int dadosMalvados[] = new int[100];
    int contadorDeDados = 0;
    ArrayList<Jugador> ordenJugadores[];//Lleva el orden
    public Jugador jugadores[];
    int indiceJugadorActual;
    Jugador jugadorActual;
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
            
            int mayor = mayor(array);//Que esta parte se otra funcion que se repita con el mismo array
            if(seRepite(mayor, array)){
                for (int i = 0; i < cantidadDeRepeticiones(mayor, array); i++) {//Referencias de jugador que tengan un array inicial
                    lanzarDados();//para el array del jugador
                    //Al mayor se saca de la lista y al menor tambien y se le asigna sus posiciones
                    
                }
                
            }
            else{
                //Saca de la lista
            }
            
            preOrden(arraylist);
        //agregar todos a los dados miedo 

        
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
    
    
    public Jugador[] escogerOrden(){//Crea un array con lanzadas de dados simuladas y espera hasta que todos los jugadores toquen lanzar dados
        //cuando ya todos esten llama a este metodo
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
