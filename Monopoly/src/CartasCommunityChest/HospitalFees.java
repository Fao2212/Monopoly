/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartasCommunityChest;

import Logic.Cartas;
import static Logic.Cartas.Tipo.CommunityChest;

/**
 *
 * @author migue
 */
public class HospitalFees extends Cartas{

    public HospitalFees() {
        this.tipo = CommunityChest;
        this.info = "Hospital Fees" + "\n" +
                "Pay $50";
    }
    
    
    //resta 50
    @Override
    public void Action(){
        this.jugador.dinero = this.jugador.dinero - 50;
    }
    
}
