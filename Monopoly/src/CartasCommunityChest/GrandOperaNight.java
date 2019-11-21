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
public class GrandOperaNight extends Cartas{
    
    public GrandOperaNight(){
        this.tipo = CommunityChest;
        this.info = "Grand Opera Night" + "\n" +
                "Collect $50 from every player for opening night seats";
    }
    
    @Override
    public void Action(Jugador jugador){
        for (int i = 0; i < jugador.tablero.jugadores.length; i++) {
            jugador.tablero.jugadores[i].dinero = jugador.tablero.jugadores[i].dinero - 50;
            jugador.dinero = jugador.dinero + 50;
                    System.out.println(info);
        }
    }
    //recorre array de jugadores y les quita 50 mientras se lo suma al de la carta
}
