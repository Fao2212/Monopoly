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
class TituloDePropiedad extends Propiedad implements Serializable{

    int cantidadDeCasas;
    Edificio casas[];
    Edificio hotel;
    boolean hayHotel;
    int alquileres[];
    int precioDeEdificio;

    public TituloDePropiedad(String nombre, int precio, int alquiler, int grupoDeColor, int valorDeHipoteca, int tipo,int lugarEnEltablero,int alquileres[],int valorCasa) {
        super(nombre, precio, alquiler, grupoDeColor, valorDeHipoteca, tipo, lugarEnEltablero);
        casas = new Edificio[4];
        hotel = null;
        hayHotel = false;
        this.alquileres = alquileres;
        precioDeEdificio = valorCasa;
    }
    
    //Aumenta si tiene todas las propiedades y dependiendo de las casas que posea
    @Override
    public void aumentarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void comprarCasas(int cantidad){
        
    }
    
    public void comprarHotel(){
        if( cantidadDeCasas == 4)
            System.out.println("compra hotel");
        else
            System.out.println("No hay suf casas");
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
