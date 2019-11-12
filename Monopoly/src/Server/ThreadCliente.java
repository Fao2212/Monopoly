/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import GUI.formPantallaClientePrueba;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ferol
 */
public class ThreadCliente extends Thread{
    
    Socket cliente; 
    DataInputStream entrada;
    DataOutputStream salida;
    formPantallaClientePrueba pantalla;//Este seria el juego con el tablero PINTA SU PROPIO JUEGO
    boolean running;

    public ThreadCliente(DataInputStream entrada, DataOutputStream salida) {
        this.entrada = entrada;
        this.salida = salida;
    }
    
    @Override
    public void run() {
        int opcion;
        while (running) {        
            try {
                opcion = entrada.readInt();
                cases(opcion);
            } catch (IOException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
    
    public void cases(int caso){//Implementar aca todos los mensajes en conjunto con el del servidor
        switch(caso){
            
        }
    }
}
