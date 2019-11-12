/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author ferol
 */
public class Banco {
    
   public static void pagarAJugador(Jugador jugador,int cantidad){
       //jugador.sumarDinero(cantidad);
   } 
   
   public static void cobrarAJugador(Jugador jugador,int cantidad){
       //jugador.restarDinero(cantidad);
       //SI NO SE PUEDE COBRAR QUE PASA
       //comprobarDineroDeJugador(jugador,cantidad);
       //Dar opciones para vender propiedades u otras cosas
   } 
   
   public static void cobrarATodos(int cantidad){//Este en  jugadr
       //for(int i = 0; i<jugadores.lenght;i++){
       //   Banco.cobrarAJugador(jugadores[i],cantidad);
   }
   
   public static void pagarAtodos(int cantidad){
       //for(int i = 0; i<jugadores.lenght;i++){
       //   Banco.pagarAJugador(jugadores[i],cantidad);
   }
   
   public static boolean comprobarDineroDeJugador(Jugador jugador,int cantidad){
       if(true/*jugador.dinero >= cantidad*/)
            return true;
       else
           return false;
   }
   
   public static void comprarPropiedad(Propiedad propiedad,Jugador jugador){//El jugador tambien tiene que tener uno de estos 
       if(comprobarDineroDeJugador(jugador,propiedad.precio))//Return un boolean para dar el mensaje de que no pudo comprar
           cobrarAJugador(jugador,propiedad.precio);
   }
   
   public static void hipotecarPropiedad(/*Propiedad y jugador*/){
       //Propiedad estado hipotecada
       //Se da el dinero al jugaddor
       //
   }
   
   public static void subastarPropiedad(){
       //Avisa a todos los jugadores que una propiedad no se quizo comprar (OfrecerPropiedad())
       //Da la opcion de que todos voten o pasen
       //La consigue el que pague mas
   }
   
}
