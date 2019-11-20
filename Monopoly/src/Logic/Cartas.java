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
    
    
    
    
    public void Action(Jugador jugador){};
    
    
}
