/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.swing.ImageIcon;

/**
 *
 * @author migue
 */
public class Cartas {
    public Jugador jugador = null;
    public String info;
    public ImageIcon imagen;
    
    public enum Tipo{
        Chance, CommunityChest
    }
    
    public Tipo tipo;
    
    
    //cuando sale la carta se la asigna al jugador
    public void asignarPersona(Jugador j){
        this.jugador = j;
    }
    
    public void Action(){};
    
    
}
