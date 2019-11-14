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
public class AdvanceToStCharlesPlace extends Cartas{
    
    public AdvanceToStCharlesPlace() {
        this.tipo = Chance;
        this.info = "Advance to St. Charles Place" + "\n" +
                "If you pass Go, collect $200";
    }
    
    
    @Override
    public void Action(Jugador jugador){
        while (jugador.pos != 16){                                      //no estoy seguro si es, no aparece el nombre en el tablero
            jugador.siguienteCasilla();
            if (jugador.casilla.tipo == 3 && jugador.casilla.doAction().propietario != null){                                             //o el numero de propiedad
                jugador.pagarAlquiler(jugador.casilla.doAction());
            }
            else if (jugador.pos == 0){
                jugador.dinero = jugador.dinero + 200;
            }
        }
    }
    //va recorriendo los labels hasta llegar al destino, si pasa por el inicio suma 200
}
