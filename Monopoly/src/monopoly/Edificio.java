/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import javax.swing.ImageIcon;

/**
 *
 * @author ferol
 */
public class Edificio {
    //Jugador propietario;
    //Casilla o Propiedad a la que pertenece
    private final ImageIcon imagen;//Se suben las dos imagenes de casa y hotel
    private final int tipo;//Depende de si es casa o es hotel Cambiar por un enum

    public Edificio(ImageIcon imagen, int tipo) {
        this.imagen = imagen;
        this.tipo = tipo;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public int getTipo() {
        return tipo;
    }
    
}
