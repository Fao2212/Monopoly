/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import CartasChance.AdvanceToGo;
import Logic.Cartas;
import Logic.FactoryPropiedades;


/**
 *
 * @author migue
 */
public class Monopoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FactoryPropiedades.guardarRespaldo(FactoryPropiedades.cargarPropiedades());
    }
    
}
