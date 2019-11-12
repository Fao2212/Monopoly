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
    public Jugador jugador = null;
    public Point pos;                   //iguala a la posicion del inicio
    
    public Ficha(String nombre){
        this.nombre = nombre;
        this.usado = false;
    }

    //se llama cuando se selecciona la ficha, no se si se asigna el jugador aqui
    public void setUsado() {
        this.usado = true;
    }
    
    
}
