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
public class AdvanceTokenToNearestRailroad extends Cartas{
    
    public AdvanceTokenToNearestRailroad() {
        this.tipo = Chance;
        this.info = "Advance token to the nearest Railroad" + "\n" +
                "Pay owner twice the rental";
    }
    
    
    @Override
    public void Action(Jugador jugador){
        while (jugador.pos != 5 && jugador.pos != 15 && jugador.pos != 25 && jugador.pos != 35){
            jugador.siguienteCasilla();
            if (jugador.casilla.tipo == 3 && jugador.casilla.doAction().propietario != null){                                             //o el numero de propiedad
                jugador.pagarAlquiler(jugador.casilla.doAction());
            }
        }
        if (jugador.casilla.doAction().propietario != null){
            jugador.pagarAlquiler(jugador.casilla.doAction());
            jugador.pagarAlquiler(jugador.casilla.doAction());
        }
    }
    //recorre tablero hasta llegar a un railroad, si jugador != null tira dados y le paga el resultado * 10, sino puede comprarlo
}
