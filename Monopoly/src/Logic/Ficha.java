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
public class Ficha {
    public ImageIcon imagen;
    public String nombre;
    private boolean usado;
    //public Jugador jugador = null;
    //public int pos = 0;
    
    //no se si recibe ImageIcon
    public Ficha(String nombre){
        this.nombre = nombre;
        this.usado = false;
    }

    //se llama cuando se selecciona la ficha, no se si se asigna el jugador aqui
    public void setUsado() {
        this.usado = true;
    }
    
    //no se si se setea la imagen
    /*public void siguienteCasilla(int destino){
        if (pos != destino)
            pos++;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }*/
    
    
}
