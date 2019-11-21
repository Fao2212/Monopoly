/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import Logic.Jugador;

/**
 *
 * @author ferol
 */

public abstract class Casilla {
    
    boolean empty;
    boolean asignada;
    int cantidadDeFichas;
    int index;//Puede quitarse si no se necesita
    public int tipo;//Especial,Carta,Propiedad

    public Casilla(int index, int tipo) {
        this.empty = this.asignada =  false;
        this.index = index;
        this.tipo = tipo;
    }

    
    
    public boolean isEmpty() {
        return empty;
    }

    public int getIndex() {
        return index;
    }
    
    public abstract Propiedad doAction();
    
}

class CasillaPropiedad extends Casilla{
    
    final Propiedad propiedad;

    public CasillaPropiedad(Propiedad propiedad, int index, int tipo) {
        super(index, tipo);
        this.propiedad = propiedad;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    @Override
    public Propiedad doAction() {
            return getPropiedad();//Se da la opcion de comprar y si no se pone en subasta
    }
    
}

class CasillaEspecial extends Casilla{

    public CasillaEspecial(int index, int tipo) {
        super(index, tipo);
    }
    
    @Override
    public Propiedad doAction() {
        //Depende de que hace por pos de casilla hacer un switch
        System.out.println("especial");
        return null;
    }
    
    //Hacer todos los metodos especiales 
    public void irALaCarcel(Jugador jugador){
        //tablero.enviaralacarcel
    }
    public void cobrarImpuestos(Jugador jugador,int cantidad){
        Banco.cobrarAJugador(jugador, cantidad);
    }
    public void GO(Jugador jugador){
        Banco.pagarAJugador(jugador, 200);
    }
    
}

class CasillaCarta extends Casilla{

    public CasillaCarta(int index, int tipo) {
        super(index, tipo);
    }

    @Override
    public Propiedad doAction() {
        //Sacar una carta y hacer su funcion
        System.out.println("tarjeta");
        return null;
    }
    
    public void sacarCarta(){//Crear una nueva propiedad sin nada y usar uno de sus valores para enviar enteros
        //Se saca la primera carta y se aplica su efecto
    }
     
}