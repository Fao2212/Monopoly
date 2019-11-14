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
public class Receive25ConsultancyFee extends Cartas{

    public Receive25ConsultancyFee() {
        this.tipo = CommunityChest;
        this.info = "Receive $25 consultancy fee";
    }
    
    
    //suma 25
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero + 25;
    }
}
