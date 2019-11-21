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
public class YouAreAssessedForStreetRepairs extends Cartas{
    
    public YouAreAssessedForStreetRepairs(){
        this.tipo = CommunityChest;
        this.info = "You are assessed for street repairs" + "\n" +
                "Pay $40 per house and $115 per hotel you own";
    }
    
    @Override
    public void Action(Jugador jugador){
        for (int i = 0; i < jugador.propiedades.size(); i++) {
            int cantCasas = jugador.propiedades.get(i).doActionCasas();
            while (cantCasas != 0){
                jugador.dinero = jugador.dinero - 40;
            }
            if (jugador.propiedades.get(i).doActionHotel() == 1)
                jugador.dinero = jugador.dinero - 115;
        }
                System.out.println(info);
    }
    //recorre su array de propiedades y le va restando lo que toca
}
