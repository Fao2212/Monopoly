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
public class HolidayFundMatures extends Cartas{

    public HolidayFundMatures() {
        this.tipo = CommunityChest;
        this.info = "Holiday Fund matures" + "\n" +
                "Receive $100";
    }
    
    //suma 100
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero + 100;
    }
    
    
}
