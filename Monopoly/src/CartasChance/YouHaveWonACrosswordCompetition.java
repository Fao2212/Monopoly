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
public class YouHaveWonACrosswordCompetition extends Cartas{

    public YouHaveWonACrosswordCompetition() {
        this.tipo = Chance;
        this.info = "You have won a crossword competition" + "\n" +
                "Collect $100";
    }
    
    //suma 100
    @Override
    public void Action(){
        this.jugador.dinero = this.jugador.dinero + 100;
    }
    
}
