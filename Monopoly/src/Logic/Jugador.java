/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import monopoly.Casilla;
import monopoly.Propiedad;
import monopoly.Tablero;

/**
 *
 * @author migue
 */
public class Jugador {
    
    public Color colorPrueba;
    public int dinero;
    public boolean turno;
    public int dadoInicio;
    public int resultado;
    public int numeroDeJugador;//Por orden
    public Tablero tablero;
    public String nombre;
    public ArrayList<Propiedad>propiedades;
    public Cartas [] carta;
    public Ficha ficha = null;
    public Casilla casilla;
    public int pos;
    public boolean carcel;
   
    
    public Jugador(String nombre, Tablero t){
        this.nombre = nombre;
        this.turno = false;
        this.dinero = 1500;
        this.resultado = 0;
        this.numeroDeJugador = numeroDeJugador;
        this.tablero = t;
        this.propiedades = new ArrayList<>();
        this.carta = new Cartas[2];
        this.casilla = tablero.casillas[0];
        this.pos = 0;
        this.carcel = false;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public int lanzarDado(){                                //como es 1 dado, si al lanzar el segundo le da al doble del resultado, lanza otros 2
        this.resultado += new Random().nextInt((6 - 1) + 1) + 1;
        return this.resultado;
    }
    
    public void comprar(Propiedad propiedad){                    
        propiedades.add(propiedad);
        propiedad.propietario = this;
        this.dinero = this.dinero - propiedad.getPrecio();
    }
    
    public int encontrarPropiedad(Propiedad buscar){
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i) == buscar)
                return i;
        }
        return -1;
    }
    
    public void vender(Propiedad propiedad, Jugador cliente, int costo){
        int pos = encontrarPropiedad(propiedad);
        if (pos != -1){
            cliente.propiedades.add(this.propiedades.remove(pos));
            this.dinero = this.dinero + costo;
            cliente.dinero = cliente.dinero - costo;
            
        }
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    
    
    
    //no se si se setea la imagen
    public void siguienteCasilla(){
        if (pos == 39) pos = 0;//Pasar a 0
        this.pos++;
        this.casilla = tablero.casillas[pos];
    }
    
    public void pagarAlquiler(Propiedad p){
        this.dinero = this.dinero - p.getAlquiler();
        p.propietario.dinero = p.propietario.dinero + p.getAlquiler();
    }

    public void setPos(int pos) {
        for (int i = 0; i < pos; i++) {
            this.pos ++;
            if(this.pos > 39)
                this.pos = 0;
            this.casilla = tablero.casillas[this.pos];
        }

    }
    
    public void pagarPorCarcel(){
        this.dinero = this.dinero - 50;
        this.carcel = false;
    }
    
    
    
}
