/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author ferol
 */

public abstract class Casilla {
    boolean empty;
    int index;//Puede quitarse si no se necesita
    int tipo;//Especial,Carta,Propiedad

    public boolean isEmpty() {
        return empty;
    }

    public int getIndex() {
        return index;
    }
    
    public abstract void doAction();
    
}

class CasillaPropiedad extends Casilla{
    
    final Propiedad propiedad;

    public CasillaPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    @Override
    public void doAction() {
        getPropiedad();
    }
    
}

class CasillaEspecial extends Casilla{
    
    
    @Override
    public void doAction() {
        //Depende de que hace por pos de casilla hacer un switch
    }
    
    //Hacer todos los metodos especiales 
    
}

class CasillaCarta extends Casilla{


    @Override
    public void doAction() {
        //Sacar una carta y hacer su funcion
    }
     
}