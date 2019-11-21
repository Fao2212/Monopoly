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
public class GoToJail extends Cartas{
    
    public GoToJail(){
        this.tipo = CommunityChest;
        this.info = "Go directly to jail" + "\n" +
                "Do not pass Go, Do not collect $200";
    }
    
    @Override
    public void Action(Jugador jugador){
        jugador.setPos(10);
        jugador.carcel = true;
                System.out.println(info);
    }
    //lo pone en la carcel y las condiciones de carcel
}
