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
public class PayPoorTaxOf15 extends Cartas{

    public PayPoorTaxOf15() {
        this.tipo = Chance;
        this.info = "Pay poor tax of $15";
    }
    
    //resta 15
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero - 15;
    }
    
    
}
