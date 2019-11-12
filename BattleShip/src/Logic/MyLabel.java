/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.Componente.Tipo.Fuente;
import static Logic.Componente.Tipo.Remolino;
import javax.swing.JLabel;

/**
 *
 * @author migue
 */
public class MyLabel {
    public JLabel label;
    private boolean empty;
    public Componente componente;
    
    public MyLabel(){
        this.label = new JLabel();
        this.label.setOpaque(true);
        this.label.setText("");
        this.empty = true;
        this.componente = null;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    
    public boolean isRemolino(){
        if (componente.tipo == Remolino) 
            return true;
        return false;
    }
    
    
    public Componente isFuente(){
        if (componente.tipo == Fuente && componente.vida <= 0)
            return componente;
        return null;
    }
    
}
