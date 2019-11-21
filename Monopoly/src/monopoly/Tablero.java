/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import Logic.Cartas;
import Logic.FactoryPropiedades;
import Logic.FactoryTarjetas;
import Logic.Jugador;
import Random.CustomRandom;
import java.awt.Color;
import java.util.StringTokenizer;

/**
 *
 * @author ferol
 */
public class Tablero {
    
    public Casilla casillas[];
    Edificio casas[];
    Edificio hoteles[];
    Propiedad propiedades[];
    public Cartas arcaComunal[];
    public Cartas casualidad[];
    public Jugador jugadores[];
    public Color colores[] = {Color.red,Color.blue,Color.orange,Color.green,Color.CYAN,Color.yellow,Color.red};
    public int indiceJugadorActual;
    Integer dadosInicio[];
    int contRepPos;
    Jugador jugadorActual;
    int cantidadDeJugadores = 0;//Aumenta o se asigna
    int maxJugadores;
    public final static int POSICIONES_CHANCE[] = {7,22,36};
    public final static int POSICIONES_COMUNNITY[] = {2,17,33};
    public final static int POSICIONES_FERROCARRILES[] = {5,15,25,35};
    public final static int POSICIONES_SERVICIOS[] = {12,28};
    public final static int VISITANDO_CARCEL = 10;
    public final static int IMPUESTOS[] = {4,38};
    public final static int POSICIONESESPECIALES[] = {0,10,20,30,4,38};
    public final static int FREE_PARK = 20;
    public final static int CARCEL = 30;
    public final static int GO = 0;
    int cartaActualChance = 0;
    int cartaActualChest = 0;
    

    public Tablero() {
        
        indiceJugadorActual = 0;
        contRepPos = 0;
        casillas = new Casilla[40];
        casas = new Edificio[32];
        hoteles = new Edificio[12];
        propiedades = new Propiedad[28];
       dadosInicio(); 
       asignarCasillas();

    }
    
    
    public Cartas sacarCartaChance(int num){//Luego mejorar a que sea un shuffle con un array de Integer que sea el que saque las pos
        return casualidad[num];
    }
    
    public Cartas sacarCartaChest(int num){
        return arcaComunal[num];
    }
    
    public void asignarUnColorAlJugadorPrueba(Jugador jugador){
        jugador.colorPrueba = colores[jugador.numeroDeJugador];
        System.out.println(jugador.colorPrueba);
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
        jugadores = new Jugador[maxJugadores];
    }
    
    public void dadosInicio(){//Funcion al azar de suma para los dados   cuando ya esten asignadas las posiciones entonces se lanza el dado normal
        dadosInicio = new Integer[12];
        for (int i = 1; i < 13; i++) {
            dadosInicio[i-1] = i;
        }
        CustomRandom.shuffle(dadosInicio);
    }
    
    public void asignarPosJugador(Jugador jugador) {//Se asigna en la conexion y cuando cada uno le de tirar dados muestra el numero que tienen asignado y se muestra el acomodo de las posiciones
        jugador.dadoInicio = dadosInicio[contRepPos++];//Se tiene que mandar su numero
        System.out.println(jugador.numeroDeJugador);
    }
    
    public void agregarJugador(Jugador jugador){
        System.out.println("cantidadDeJugadores"+cantidadDeJugadores);
        jugadores[cantidadDeJugadores++] = jugador;
        System.out.println("cantidadDeJugadores2 "+cantidadDeJugadores);
        jugador.numeroDeJugador = cantidadDeJugadores-1;//Esto es temporal, en el momento de el juego se hace despues de ordenarlos
        asignarPosJugador(jugador);
        asignarUnColorAlJugadorPrueba(jugador);
        System.out.println(jugadores[1]);
    }
    
    public void asignarCasillas(){
        //Aca se cargan las tarjetas y se ponen en sus respectivos campos y se rellenas los array de tarjetas
        Propiedad prop[] = FactoryPropiedades.cargarPropiedades();
        this.propiedades = prop;
        for (Propiedad propiedad: prop) {
            Casilla casilla = new CasillaPropiedad(propiedad,1,propiedad.lugarEnElTablero);
            casillas[propiedad.lugarEnElTablero] = casilla;
            System.out.println(propiedad.lugarEnElTablero+propiedad.nombre);
        }
        for (Edificio casa : casas) {
            casa = new Edificio(0);
        }
        for (Edificio hotel : hoteles){
            hotel = new Edificio(1);
        }
        this.arcaComunal = FactoryTarjetas.cargarCartas(1);
        this.casualidad = FactoryTarjetas.cargarCartas(2);
        
        casillas[0] = new CasillaEspecial(GO, 2);
        casillas[10] = new CasillaEspecial(VISITANDO_CARCEL, 2);
        casillas[20] = new CasillaEspecial(FREE_PARK, 2);
        casillas[30] = new CasillaEspecial(CARCEL, 2);
        casillas[4] = new CasillaEspecial(4, 2);
        casillas[38] = new CasillaEspecial(38, 2);
        
        casillas[2] = new CasillaCarta(2, 3);
        casillas[7] = new CasillaCarta(7, 3);
        casillas[17] = new CasillaCarta(17, 3);
        casillas[22] = new CasillaCarta(22, 3);
        casillas[33] = new CasillaCarta(33, 3);
        casillas[36] = new CasillaCarta(36, 3);
        
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
        for(int k = 0;i<jugadores.length;i++){
            jugadores[k].numeroDeJugador = k+1;
        }
    }
    
    public void iniciarJuego(){
        setPrimerJugador();
    }
    
    public void setPrimerJugador(){
        jugadores[0].setTurno(true);
    }
    
    public void siguienteJugador(){
        
        jugadores[indiceJugadorActual].setTurno(false);
        indiceJugadorActual++;
        System.out.println("CantidadDe Jugadores"+cantidadDeJugadores);
        System.out.println("IndiceJugador"+indiceJugadorActual);
        if (indiceJugadorActual == cantidadDeJugadores) {
            indiceJugadorActual = 0;
        }
        jugadores[indiceJugadorActual].setTurno(true);
        
    }
    
    public void setJugadorActual(){
        jugadorActual = jugadores[indiceJugadorActual];
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
        int dado = CustomRandom.randomRange(1, 7);
        return dado;
    }
    
    public int lanzarDados(){//Manejar cuando se repiten
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
