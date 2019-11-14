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
public class MakeGeneralRepairsOnAllYourProperties extends Cartas{
    
    public MakeGeneralRepairsOnAllYourProperties() {
        this.tipo = Chance;
        this.info = "Make general repairs on all your property" + "\n" +
                "For each house pay $25, For each hotel $100";
    }
    
    
    @Override
    public void Action(Jugador jugador){
        for (int i = 0; i < jugador.propiedades.size(); i++) {
            int cantCasas = jugador.propiedades.get(i).doActionCasas();
            while (cantCasas != 0){
                jugador.dinero = jugador.dinero - 25;
            }
            if (jugador.propiedades.get(i).doActionHotel() == 1)
                jugador.dinero = jugador.dinero - 100;
        }
    }
    //recorre el arraylist de propiedades y va pagando
}
