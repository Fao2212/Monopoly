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
public class AdvanceTokenToNearestUtility extends Cartas{
    public AdvanceTokenToNearestUtility() {
        this.tipo = Chance;
        this.info = "Advance token to nearest Utility" + "\n" +
                "If unowned, you may buy it from the Bank" + "\n" +
                "If owned, throw dice and pay owner a total 10 times the amount thrown";
    }
    
    
    @Override
    public void Action(Jugador jugador){
        while (jugador.pos != 5 && jugador.pos != 15 && jugador.pos != 25 && jugador.pos != 35){                //no se cuales son
            jugador.siguienteCasilla();
            if (jugador.casilla.tipo == 3 && jugador.casilla.doAction().propietario != null){                                             //o el numero de propiedad
                jugador.pagarAlquiler(jugador.casilla.doAction());
            }
        }
        if (jugador.casilla.doAction().propietario != null){
            int alquiler = jugador.lanzarDado() * 10;
            jugador.dinero = jugador.dinero - alquiler;
            jugador.casilla.doAction().propietario.dinero = jugador.casilla.doAction().propietario.dinero + alquiler;
        }
    }
}
