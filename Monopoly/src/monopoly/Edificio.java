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
public class Edificio {
    Jugador propietario;
    Casilla lugar;
    private final int tipo;//Depende de si es casa o es hotel Cambiar por un enum

  public Edificio(int tipo) {
        this.tipo = tipo;
        this.lugar = null;
        this.propietario = null;
    }

    public int getTipo() {
        return tipo;
    }
    
}
