/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.Componente.Tipo.Fuente;
import java.awt.Point;

/**
 *
 * @author migue
 */
public class FuenteDeEnergia extends Componente{
    public FuenteDeEnergia(Point p){
        this.pos = p;
        this.precio = 12000;
        this.vida = 4;
        this.tipo = Fuente;
    }
    
    public void setDisconexos(GrafoMatriz gm){
        for (int i = 0; i < gm.getCantidadVertices(); i++) {
            //recorre el array de vertices y les hace setvisible
        }
    }
    
}
