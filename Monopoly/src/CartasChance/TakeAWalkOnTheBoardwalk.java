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
public class TakeAWalkOnTheBoardwalk extends Cartas{
    
    public TakeAWalkOnTheBoardwalk() {
        this.tipo = Chance;
        this.info = "Take a walk on the Boardwalk";
    }
    
    
    @Override
    public void Action(Jugador jugador){
        while (jugador.pos != 39){                                                              //no se si es este
            jugador.siguienteCasilla();
            if (jugador.casilla.tipo == 3 && jugador.casilla.doAction().propietario != null){                                             //o el numero de propiedad
                jugador.pagarAlquiler(jugador.casilla.doAction());
            }
        }
                System.out.println(info);
    }
    //se mueve hasta el destino
}
