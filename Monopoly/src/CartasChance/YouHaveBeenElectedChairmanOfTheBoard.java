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
public class YouHaveBeenElectedChairmanOfTheBoard extends Cartas{
    
    public YouHaveBeenElectedChairmanOfTheBoard() {
        this.tipo = Chance;
        this.info = "You have been elected Chairman of the Board" + "\n" +
                "Pay each player $50";
    }
    
    @Override
    public void Action(Jugador jugador){
        for (int i = 0; i < jugador.tablero.jugadores.length; i++) {
            jugador.dinero = jugador.dinero - 50;
            jugador.tablero.jugadores[i].dinero = jugador.tablero.jugadores[i].dinero + 50;
        }
    }
    //recorre el array de jugadores y les da 50 mientras se lo resta al jugador de la carta
}
