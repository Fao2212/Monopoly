/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import monopoly.Edificio;
import monopoly.Propiedad;

/**
 *
 * @author ferol
 */
class Ferrocarril extends Propiedad implements Serializable{

    public Ferrocarril(String nombre, int precio, int alquiler, int grupoDeColor, int valorDeHipoteca, int tipo,int lugarEnEltablero) {
        super(nombre, precio, alquiler, grupoDeColor, valorDeHipoteca, tipo, lugarEnEltablero);
    }
    //Cuando se compre un ferrocarril verificar cuantos tiene el jugador para aumentarles el alquiler aumenta 25
    @Override
    public void aumentarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cobrarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doActionCasas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doActionHotel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public int asignarCasa(Edificio edificio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
