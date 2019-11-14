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
public class GetOutOfJailFree extends Cartas{
    public Jugador jugador = null;
    //elimina cond de carcel
    
    public GetOutOfJailFree(){
        this.tipo = CommunityChest;
        this.info = "Get Out of Jail Free" + "\n" +
                "This card may be kept until needed or sold/traded";
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
