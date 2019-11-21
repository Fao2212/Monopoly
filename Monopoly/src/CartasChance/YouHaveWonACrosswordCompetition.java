/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartasChance;

import Logic.Cartas;
import static Logic.Cartas.Tipo.Chance;
import Logic.Jugador;

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
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero + 100;
                System.out.println(info);
    }
    
}
