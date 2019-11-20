/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import Logic.Jugador;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author ferol
 */
public abstract class Propiedad implements Serializable{//Preguntar la mejor manera de ver si es hipotecable
    
    String nombre;
    int precio;
    int alquiler;
    public Jugador propietario = null;
    int grupoDeColor;
    int lugarEnElTablero;
    int valorDeHipoteca;
    ImageIcon imagen;
    int tipo;
    boolean hipotecada;

    public Propiedad(String nombre, int precio, int alquiler, int grupoDeColor, int valorDeHipoteca, int tipo,int lugarEnElTablero) {
        this.nombre = nombre;
        this.precio = precio;
        this.alquiler = alquiler;
        this.grupoDeColor = grupoDeColor;
        this.valorDeHipoteca = valorDeHipoteca;
        this.tipo = tipo;
        this.hipotecada = false;
        this.lugarEnElTablero = lugarEnElTablero;
    }
    
    
    
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


