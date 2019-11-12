/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author migue
 */
public class Arma {
    public enum Tipo{
        Torpedo, Multi_Shot, Bomba, Trumpedo
    }
    
    protected Tipo tipo;
    

    public Tipo getTipo() {
        return tipo;
    }
    
    
    public void disparo(int x, int y) {}
}
