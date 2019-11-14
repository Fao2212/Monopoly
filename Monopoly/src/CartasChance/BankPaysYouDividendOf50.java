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
public class BankPaysYouDividendOf50 extends Cartas{
    public BankPaysYouDividendOf50() {
        this.tipo = Chance;
        this.info = "Bank pays you dividend of $50";
    }
    
    
    
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero + 50;                       //no se lo de dividend
    }
}
