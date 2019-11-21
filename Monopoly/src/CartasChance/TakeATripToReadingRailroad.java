/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartasChance;

import Logic.Cartas;
import static Logic.Cartas.Tipo.Chance;
import Logic.Jugador;

/**
 *
 * @author migue
 */
public class TakeATripToReadingRailroad extends Cartas{
    
    public TakeATripToReadingRailroad() {
        this.tipo = Chance;
        this.info = "Take a trip to Reading Railroad" + "\n" +
                "If you pass Go, collect $200";
    }
    
    @Override
    public void Action(Jugador jugador){
        while (jugador.pos != 5){
            jugador.siguienteCasilla();
            if (jugador.casilla.tipo == 3 && jugador.casilla.doAction().propietario != null){                                             //o el numero de propiedad
                jugador.pagarAlquiler(jugador.casilla.doAction());
            }
            else if (jugador.pos == 0){
                jugador.dinero = jugador.dinero + 200;
            }
        }
                System.out.println(info);
    }
    //se mueve en el tablero hasta llegar al destino
}
