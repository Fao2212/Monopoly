/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartasCommunityChest;

import Logic.Cartas;
import static Logic.Cartas.Tipo.CommunityChest;
import Logic.Jugador;

/**
 *
 * @author migue
 */
public class AdvanceToGo extends Cartas{
    public AdvanceToGo(){
        this.tipo = CommunityChest;
        this.info = "Advance to Go" + "\n" +
                "Collect $200";
    }
    
    //suma 200
    @Override
    public void Action(Jugador jugador){
        while (jugador.pos != 0){
            jugador.siguienteCasilla();
            if (jugador.casilla.tipo == 3 && jugador.casilla.doAction().propietario != null){                                             //o el numero de propiedad
                jugador.pagarAlquiler(jugador.casilla.doAction());
            }
        }
        jugador.dinero = jugador.dinero + 200;
    }
}
