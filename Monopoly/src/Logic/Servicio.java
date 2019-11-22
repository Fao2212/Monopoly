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
class Servicio extends Propiedad implements Serializable{

    public Servicio(String nombre, int precio, int alquiler, int grupoDeColor, int valorDeHipoteca, int tipo,int lugarEnEltablero) {
        super(nombre, precio, alquiler, grupoDeColor, valorDeHipoteca, tipo, lugarEnEltablero);
    }
    //Hacer una tirada de dados para el jugador que caiga en un servicio con ndueno, el servidor envia el cliente abre una pantalla de tiro y envia al servidor el resultado
    //4 veces el dado
    //10 veces el dado
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
    
    public void metodoDeAumento(int dado){
        
    }

    /*@Override
    public int asignarCasa(Edificio edificio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
