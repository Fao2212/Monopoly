/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import Logic.Jugador;
import javax.swing.ImageIcon;

/**
 *
 * @author ferol
 */
public abstract class Propiedad {//Preguntar la mejor manera de ver si es hipotecable
    
    String nombre;//Calle 
    int precio;
    int alquiler;
    public Jugador propietario = null;
    //enum Clasificacion
    /*enum+calle a la que pertenece + color*/int grupoDeColor;
    int valorDeHipoteca;
    ImageIcon imagen;
    int tipo;
    boolean hipotecada;
    
    public abstract void aumentarAlquiler();
    public abstract void cobrarAlquiler();

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getGrupoDeColor() {
        return grupoDeColor;
    }

    public int getValorDeHipoteca() {
        return valorDeHipoteca;
    }
    
    public abstract int doActionCasas();
    public abstract int doActionHotel();
    
}


