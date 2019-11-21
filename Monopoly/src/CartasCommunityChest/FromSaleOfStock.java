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
public class FromSaleOfStock extends Cartas{

    public FromSaleOfStock() {
        this.tipo = CommunityChest;
        this.info = "From sale of stock you get $45";
    }
    
    //suma 50
    @Override
    public void Action(Jugador jugador){
        jugador.dinero = jugador.dinero + 45;
                System.out.println(info);
    }
    
}
