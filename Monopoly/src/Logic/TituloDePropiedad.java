/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import monopoly.Edificio;
import monopoly.Propiedad;

/**
 *
 * @author ferol
 */
class TituloDePropiedad extends Propiedad{

    int cantidadDeCasas;
    Edificio casas[];
    Edificio hotel;
    boolean hayHotel;
    
    @Override
    public void aumentarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void comprarCasas(int cantidad){
        
    }
    
    public void comprarHotel(){
        //if cantidad de casas == 4;
    }

    @Override
    public void cobrarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doActionCasas() {
        return cantidadDeCasas;
    }

    @Override
    public int doActionHotel() {
        if (hayHotel) return 1;
        return 0;
    }
    
}
