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
public class GoBackThreeSpaces extends Cartas{
    public GoBackThreeSpaces() {
        this.tipo = Chance;
        this.info = "Go Back Three Spaces";
    }
    
    
    @Override
    public void Action(Jugador jugador){
        jugador.pos = jugador.pos - 3;
        jugador.casilla = jugador.tablero.casillas[jugador.pos];
                System.out.println(info);
    }
    //la pos le resta x o y
}
