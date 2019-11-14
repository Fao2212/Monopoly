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
public class GetOutOfJailFree extends Cartas{
    public Jugador jugador = null;
    //elimina condiciones de carcel
    public GetOutOfJailFree() {
        this.tipo = Chance;
        this.info = "Get out of Jail Free" + "\n" +
                "This card may be kept until needed, or traded/sold";
    }
    
    //cuando sale la carta se la asigna al jugador
    public void asignarPersona(Jugador j){
        this.jugador = j;
    }
    
    
    @Override
    public void Action(Jugador jugador){
        jugador.carcel = false;
    }
    
}
