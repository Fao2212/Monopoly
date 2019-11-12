/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author migue
 */
public class Componente {
    public ImageIcon imagen;
    protected Point pos;
    protected int precio;
    protected int vida;
    public enum Tipo{
        Templo, Mercado, Armeria, Mina, Conector, Fuente, Remolino
    }
    
    protected Tipo tipo;

    public Point getPos() {
        return pos;
    }

    public int getPrecio() {
        return precio;
    }

    public int getVida() {
        return vida;
    }

    public void disminuirVida() {
        this.vida = this.vida - 1;
    }
    //el label atacado, con la vida ya disminuida del ataque
    public void explotar(MyLabel label){//referencia al tablero con los componentes para recorrer la parte de explosion
        //si label.vida = 0, hace disminuir vida para que quede con -1 y tenga cond de parada, hace esto, si no nada
        for (int i = label.componente.pos.y - 2; i < label.componente.pos.y + 3; i++) {
            for (int j = label.componente.pos.x - 2; j < label.componente.pos.x + 3; j++) {
                //si tablero.label[i][j].componente != null
                //label[i][j].disminuirvida
                //pregunta si el label[i][j].componente.vida = 0 explotar(label[i][j]) (recursivo)
            }
        }
    }
    
    
}
