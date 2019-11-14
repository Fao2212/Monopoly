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
public class IncomeTaxRefund extends Cartas{
    
    public IncomeTaxRefund(){
        this.tipo = CommunityChest;
        this.info = "Income tax refund" + "\n" +
                "Collect $20";
    }
    
    
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero + 20;
    }
    //genera un random de la pos del array de jugadores y le resta 20 y se lo suma a este jugador
}
