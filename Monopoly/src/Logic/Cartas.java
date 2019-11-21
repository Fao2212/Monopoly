/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author migue
 */
public class Cartas implements Serializable{
    public String info;
    public ImageIcon imagen;
    
    public enum Tipo{
        Chance, CommunityChest
    }
    
    public Tipo tipo;
    
    //Hacer una preugnta de si el dinero guardado como una variable es diferente del dinero
    //Si la posicion cambio 
    //O si ahora la tarjeta tiene una persona y se devuelve un numero segun la opcion
    
    
    
    public void Action(Jugador jugador){};
    
    
}
