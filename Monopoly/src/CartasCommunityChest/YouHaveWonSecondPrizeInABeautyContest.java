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
public class YouHaveWonSecondPrizeInABeautyContest extends Cartas{
    
    public YouHaveWonSecondPrizeInABeautyContest(){
        this.tipo = CommunityChest;
        this.info = "You have won second prize in a beauty contest" + "\n" +
                "Collect $10";
    }
    
    
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero + 10;
                System.out.println(info);
    }
    //no se si es a uno random
}
