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
public abstract class Propiedad {//Preguntar la mejor manera de ver si es hipotecable
    
    String nombre;//Calle 
    int precio;
    int alquiler;
    Jugador propietario;
    //enum Clasificacion
    /*enum+calle a la que pertenece + color*/int grupoDeColor;
    int valorDeHipoteca;
    ImageIcon imagen;
    int tipo;//Segun se instancie se le asigna su tipo
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
    
    
}

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
    
}

class Ferrocarril extends Propiedad{

    @Override
    public void aumentarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cobrarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

class Servicio extends Propiedad{

    @Override
    public void aumentarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cobrarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
