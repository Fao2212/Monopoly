/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.Componente.Tipo.Armeria;
import java.awt.Point;

/**
 *
 * @author migue
 */
public class Armeria extends Componente{
    private Arma arma;
    
    public Armeria(Point p){
        this.precio = 1500;
        this.vida = 2;
        this.pos = p;
        this.tipo = Armeria;
        this.arma = new Arma();         //en vez de new, hace random y switch para ver el tipo y hace el new del arma (hijo)
    }

    public Arma getArma() {
        return arma;
    }
    
    
    
    
}
