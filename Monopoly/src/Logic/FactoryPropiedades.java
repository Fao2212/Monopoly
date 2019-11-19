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
   
    public static Propiedad crearPropiedad(int caso,String nombre, int precio, int alquiler, int grupoDeColor, int valorDeHipoteca, int tipo, int lugarEnElTablero, int alquileres[],int valorCasa){
        Propiedad propiedad = null;
        switch(caso){
            case 1:
                propiedad = new TituloDePropiedad(nombre, precio, alquiler, grupoDeColor, valorDeHipoteca, tipo, lugarEnElTablero, alquileres, valorCasa);
                break;
            case 2:
                propiedad = new Ferrocarril(nombre, precio, alquiler, grupoDeColor, valorDeHipoteca, tipo, lugarEnElTablero);
                break;
            case 3:
                propiedad = new Servicio(nombre, precio, alquiler, grupoDeColor, valorDeHipoteca, tipo, lugarEnElTablero);
                break;
            default:
                System.out.println("Error");
                break;
        }
        return propiedad;
    }
    
    public static void crearArchivoDePropiedades(){
        Propiedad propiedades[]= new Propiedad[27];
        FileManager.FileManager.writeObject(propiedades,"Propiedades.txt");
        FileManager.FileManager.writeObject(propiedades,"PropiedadesRespaldo.txt");
    }
    
    public static Propiedad[] cargarPropiedades(){//Puede ser privado
        Propiedad array[] = (Propiedad[])FileManager.FileManager.readObject("Propiedades.txt");
        for (Propiedad propiedad : array) {
            System.out.println(propiedad.getNombre());
        }
        return array;
    }
    
    public static Propiedad[] cargarRespaldo(){//Puede ser privado
        Propiedad array[] = (Propiedad[])FileManager.FileManager.readObject("PropiedadesRespaldo.txt");
        for (Propiedad propiedad : array) {
            System.out.println(propiedad.getNombre());
        }
        return array;
    }
    
    public static void guardarPropiedad(int caso,String nombre, int precio, int alquiler, int grupoDeColor, int valorDeHipoteca, int tipo, int lugarEnElTablero, int alquileres[], int valorCasa){
        
        Propiedad array[] = cargarPropiedades();
        Propiedad propiedad = crearPropiedad(caso, nombre, precio, alquiler, grupoDeColor, valorDeHipoteca, tipo, lugarEnElTablero, alquileres,valorCasa);
        int pos = siguienteEspacio(array);
        array[pos] = propiedad;
        FileManager.FileManager.writeObject(array,"Propiedades.txt");
        
    }
    
    public static void guardarRespaldo(Propiedad array[]){
        FileManager.FileManager.writeObject(array,"PropiedadesRespaldo.txt");
    }
    
    public static int siguienteEspacio(Propiedad array[]){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null)
                return i;
        }
        return -1;
    }
    
    public static void editarEspacio(int espacio,int caso,String nombre, int precio, int alquiler, int grupoDeColor, int valorDeHipoteca, int tipo, int lugarEnElTablero, int alquileres[], int valorCasa){
        Propiedad array[] = cargarPropiedades();
        Propiedad propiedad = crearPropiedad(caso, nombre, precio, alquiler, grupoDeColor, valorDeHipoteca, tipo, lugarEnElTablero, alquileres,valorCasa);
        int pos = espacio;
        array[pos] = propiedad;
        FileManager.FileManager.writeObject(array,"Propiedades.txt");
    }
    public static void editarTamano(int nuevoTamano){
        Propiedad array[] = cargarPropiedades();
        Propiedad nuevoArray[] = new Propiedad[nuevoTamano];
        for (int i = 0; i < array.length; i++) {
            nuevoArray[i] = array[i];
        }
        FileManager.FileManager.writeObject(nuevoArray,"Propiedades.txt");
    }
}
