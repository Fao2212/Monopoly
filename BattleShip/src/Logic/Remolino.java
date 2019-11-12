/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.Componente.Tipo.Remolino;
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author migue
 */
public class Remolino extends Componente{
    
    public Remolino(Point p){
        this.pos = p;
        this.vida = -2;
        this.precio = 0;
        this.tipo = Remolino;
    }
    
    
}
