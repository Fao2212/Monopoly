/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import monopoly.Propiedad;

/**
 *
 * @author ferol
 */
public class FactoryPropiedades {
   
    public Propiedad crearPropiedad(int caso){
        Propiedad propiedad = null;
        switch(caso){
            case 1:
                propiedad = new TituloDePropiedad();
                break;
            case 2:
                propiedad = new Ferrocarril();
                break;
            case 3:
                propiedad = new Servicio();
                break;
            default:
                System.out.println("Error");
                break;
        }
        return propiedad;
    }
    
}
