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
public class FactoryTarjetas {
        public static Cartas guardarCarta(int caso,Cartas carta){
        switch(caso){
            case 1:
                guardarEnArca(carta);
            case 2:
                guardarEnCuriosidad(carta);
                break;
            default:
                System.out.println("Error");
                break;
        }
        return null;
    }
        
   public static void crearNuevosDecks(){
        Cartas chance[]= new Cartas[16];//16 17
        Cartas chest[] = new Cartas[17];
         FileManager.FileManager.writeObject(chance,"CartasChance.txt");
        FileManager.FileManager.writeObject(chance,"CartasChanceRespaldo.txt");
        FileManager.FileManager.writeObject(chest,"CartasChest.txt");
        FileManager.FileManager.writeObject(chest,"CartasChestRespaldo.txt");
   }

    public static void guardarEnArca(Cartas carta) {
        Cartas array[] = cargarCartas(1);
        int pos = siguienteEspacio(array);
        array[pos] = carta;
        FileManager.FileManager.writeObject(array,"CartasChest.txt");
    }

    public static void guardarEnCuriosidad(Cartas carta) {
        Cartas array[] = cargarCartas(2);
        int pos = siguienteEspacio(array);
        array[pos] = carta;
        FileManager.FileManager.writeObject(array,"CartasChance.txt");
    }
    
    public static Cartas[] cargarCartas(int tipo){//Puede ser privado
        if(tipo == 1){
            Cartas array[] = (Cartas[])FileManager.FileManager.readObject("CartasChest.txt");
            for (Cartas carta : array) {
                System.out.println(carta);
            }
            return array;
        }
        else{
            Cartas array[] = (Cartas[])FileManager.FileManager.readObject("CartasChance.txt");
            for (Cartas carta : array) {
                System.out.println(carta);
            }
            return array;
        }
    }
    
    public static int siguienteEspacio(Cartas array[]){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null)
                return i;
        }
        return -1;
    }
}
