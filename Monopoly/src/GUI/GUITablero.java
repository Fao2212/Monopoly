/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author ferol
 */
public class GUITablero {
    public customLabel[] casillas;
    JLabel tablero;
    int posx,posy;
    int xpos1;
    int ypos1;

    public GUITablero(JLabel tablero) {
        
        this.tablero = tablero;
        setearTablero();
    }
    
    public GUIFicha siguienteEspacio(customLabel casilla){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (casilla.fichas[i][j].isEmpty()) {
                    GUIFicha label =casilla.fichas[i][j];
                    return label;
                }
            }
        }
        return null;
    }
    
    public void pintarLabel(GUIFicha casilla){//Primero con el background luego con iconos
        casilla.label.setBackground(Color.red);
        casilla.setEmpty(false);
        casilla.label.repaint();
    }
    
    public void despintarLabel(GUIFicha casilla){
        casilla.label.setBackground(new Color(0, 0, 0, 0));
        casilla.setEmpty(true);
        casilla.label.repaint();
    }
    
    public void setearTablero(){
        casillas = new customLabel[40];
        xpos1 =0;
        ypos1 = 90;
        posx = 610;
        posy = 700;
        setCasillasVertical();
        setCasillasHorizontal();
        setCasillasbVerticaleslizqDer();
        setCasillasHorizontaizqDer();
    }
    
    public void setCasillasVertical(){
        int suma;
        for (int i = 0; i < 11; i++) {
            if(i == 0 || i == 10){
                casillas[i] = new customLabelCasillaEspecial(i);
                suma = 90;
            }
            else{
                casillas[i] = new customLabelCasillaVertical(i);
                suma = 58;
            }
            final customLabel tile = casillas[i];
            tile.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                System.out.println(tile.numeroDeCasilla+tile.toString());
            }});
            
            if(i == 0)
                suma = 0;
            xpos1 += suma;
            tile.addFichaGrid(0,20);
            tile.addCasasGrid(0, 0);
            tile.label.setBounds(posx-xpos1,posy-ypos1, tile.dimensionx, tile.dimensiony);
            tablero.add(tile.label);
        }
    }
    
    public void setCasillasHorizontal(){
        for (int i = 11; i < 20; i++){
            casillas[i] = new customLabelCasillaHorizontal(i);
            final customLabel tile = casillas[i];
            tile.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                System.out.println(tile.numeroDeCasilla+tile.toString());
            }});
            
            ypos1 += tile.dimensiony;
            tile.addFichaGridH(0, 0);
            tile.addCasasGridH(70, 0);
            tile.label.setBounds(posx-xpos1,posy-ypos1 , tile.dimensionx, tile.dimensiony);
            tablero.add(tile.label);
        }
    }
    public void setCasillasbVerticaleslizqDer(){
        int suma;
        for (int i = 20; i < 31; i++) {
            if(i == 20 || i == 30){
                casillas[i] = new customLabelCasillaEspecial(i);
                suma = 90;
            }
            else{
                casillas[i] = new customLabelCasillaVertical(i);
                suma = 58;
            }
            final customLabel tile = casillas[i];
            tile.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                System.out.println(tile.numeroDeCasilla+tile.toString());
            }});
            
            if(i == 20)
                suma = 0;
            if (i == 21) {
                suma = 90;
            }
            if (i == 30) {
                suma = 58;
            }
            xpos1 -= suma;
            tile.addFichaGrid(0,0);
            tile.addCasasGrid(0, 70);
            tile.label.setBounds(610-xpos1,0, tile.dimensionx, tile.dimensiony);
            tablero.add(tile.label);
        }
    }
    public void setCasillasHorizontaizqDer(){
        for (int i = 31; i < 40; i++){
            casillas[i] = new customLabelCasillaHorizontal(i);
            final customLabel tile = casillas[i];
            tile.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                System.out.println(tile.numeroDeCasilla+tile.toString());
            }});
           
            tile.label.setBounds(610-xpos1,700-ypos1,tile.dimensionx,tile.dimensiony);
            tile.addCasasGridH(0, 0);
            tile.addFichaGridH(20, 0);
            ypos1-=tile.dimensiony;
            tablero.add(tile.label);
        }
    }
}
