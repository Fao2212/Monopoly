/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartasChance;

import Logic.Cartas;
import static Logic.Cartas.Tipo.Chance;

/**
 *
 * @author migue
 */
public class YourBuildingLoanMatures extends Cartas{

    public YourBuildingLoanMatures() {
        this.tipo = Chance;
        this.info = "Your building loan matures" + "\n" +
                "Receive $150";
    }
    
    //suma 150
    @Override
    public void Action(){
        this.jugador.dinero = this.jugador.dinero + 150;
    }
    
    
}
