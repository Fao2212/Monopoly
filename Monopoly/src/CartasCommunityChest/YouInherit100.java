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
public class YouInherit100 extends Cartas{

    public YouInherit100() {
        this.tipo = CommunityChest;
        this.info = "You inherit $100";
    }
    
    
    //suma 100
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero + 100;
                System.out.println(info);
    }
    
}
