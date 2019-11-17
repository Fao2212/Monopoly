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
public class HospitalFees extends Cartas{

    public HospitalFees() {
        this.tipo = CommunityChest;
        this.info = "Pay hospital" + "\n" +
                "Pay $100";
    }
    
    
    //resta 50
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero - 100;
    }
    
}
