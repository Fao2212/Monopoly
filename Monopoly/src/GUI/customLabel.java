/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import monopoly.Tablero;

/**
 *
 * @author ferol
 */
public abstract class customLabel {
    int numeroDeCasilla;
    int dimensionx;
    int dimensiony;
    public GUIFicha fichas[][];
    public GUIEdificio edificios[];
    public abstract void rotar();
    JLabel label;
    public void addFichaGrid(int pox,int poy){
        JPanel panelficha = new JPanel(new GridLayout(2, 3));
        panelficha.setBackground(new Color(0, 0, 0, 0));
        panelficha.setBounds(pox, poy, 60, 70);
        label.add(panelficha);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                GUIFicha ficha = fichas[i][j] = new GUIFicha();
                panelficha.add(ficha.label);
            }
        }
    }
    public void addFichaGridH(int pox,int poy){
        JPanel panelficha = new JPanel(new GridLayout(2, 3));
        panelficha.setBounds(pox, poy, 70, 60);
        panelficha.setBackground(new Color(0, 0, 0, 0));
        label.add(panelficha);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                GUIFicha ficha = fichas[i][j] = new GUIFicha();
                panelficha.add(ficha.label);
            }
        }
    }
    
    public void addCasasGrid(int pox,int poy){
        JPanel panelficha = new JPanel(new GridLayout(4, 0));
       panelficha.setBackground(new Color(0, 0, 0, 0));
        panelficha.setBounds(pox, poy, 60, 20);
        label.add(panelficha);
        for (int i = 0; i < 4; i++) {
                GUIEdificio edificio = edificios[i] = new GUIEdificio();
                panelficha.add(edificio.label);
        } 
    }
    public void addCasasGridH(int pox,int poy){
        JPanel panelficha = new JPanel(new GridLayout(4, 0));
        panelficha.setBackground(new Color(0, 0, 0, 0));
        panelficha.setBounds(pox, poy, 20, 60);
        label.add(panelficha);
        for (int i = 0; i < 4; i++) {
                GUIEdificio edificio = edificios[i] = new GUIEdificio();
                panelficha.add(edificio.label);
        } 
    }
}

class customLabelCasillaHorizontal extends customLabel{

    public customLabelCasillaHorizontal(int numeroDeCasilla) {
        this.numeroDeCasilla = numeroDeCasilla;
        this.dimensionx = 90;
        this.dimensiony = 58;
        this.fichas = new GUIFicha[2][3];
        this.edificios = new GUIEdificio[4];
        label = new JLabel();
        label.setText("");
    }
    //90x60

    @Override
    public void rotar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

class customLabelCasillaVertical extends customLabel{

    public customLabelCasillaVertical(int numeroDeCasillas) {
        this.numeroDeCasilla = numeroDeCasillas;
        this.dimensionx = 60;
        this.dimensiony = 90;
        this.fichas = new GUIFicha[2][3];
        this.edificios = new GUIEdificio[4];
        label = new JLabel();
        label.setText("");
    }

    
    
    @Override
    public void rotar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //60x90
}

class customLabelCasillaEspecial extends customLabel{

    public customLabelCasillaEspecial(int numeroDeCaillas) {
        this.numeroDeCasilla = numeroDeCaillas;
        this.dimensionx = 90;
        this.dimensiony = 90;
        this.fichas = new GUIFicha[2][3];
        this.edificios = new GUIEdificio[4];
        label = new JLabel();
        label.setText("");
    }

    
    @Override
    public void rotar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //90x90
}

