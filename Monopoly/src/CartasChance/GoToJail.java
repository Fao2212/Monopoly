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
public class GoToJail extends Cartas{
    public GoToJail() {
        this.tipo = Chance;
        this.info = "Go directly to Jail" + "\n" +
                "Do not pass GO, do not collect $200";
    }
    
    @Override
    public void Action(Jugador jugador){
        jugador.setPos(10);
        jugador.carcel = true;
                System.out.println(info);
    }
    //lo pone en el label de la carcel y con sus condiciones
}
