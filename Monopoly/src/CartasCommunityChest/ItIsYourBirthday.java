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
public class ItIsYourBirthday extends Cartas{
    
    public ItIsYourBirthday(){
        this.tipo = CommunityChest;
        this.info = "It is your birthday" + "\n" +
                "Collect $10 from every player";
    }
    
    @Override
    public void Action(Jugador jugador){
        for (int i = 0; i < jugador.tablero.jugadores.length; i++) {
            jugador.tablero.jugadores[i].dinero = jugador.tablero.jugadores[i].dinero - 10;
            jugador.dinero = jugador.dinero + 10;
        }
    }
    //recorre array de jugadores les quita 10 y se lo suma a este jugador
}
