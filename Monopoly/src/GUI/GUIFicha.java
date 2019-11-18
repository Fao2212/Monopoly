/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ferol
 */
public class GUIFicha {
    public JLabel label;
    boolean empty;

    public GUIFicha() {
        empty = true;
        label = new JLabel();
        label.setText("");
        label.setSize(16, 16);
    }

    boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    
    
}
