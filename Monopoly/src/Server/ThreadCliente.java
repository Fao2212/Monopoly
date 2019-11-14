/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import GUI.formPantallaClientePrueba;
import GUI.formTablero;
import Logic.Jugador;
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
    formTablero pantalla;//Este seria el juego con el tablero PINTA SU PROPIO JUEGO
    boolean running;

    public ThreadCliente(DataInputStream entrada, DataOutputStream salida, formTablero pantalla) {
        this.running = true;
        this.pantalla = pantalla;
        this.pantalla.setThread(this);
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
    
    public void cases(int caso) throws IOException{//Implementar aca todos los mensajes en conjunto con el del servidor
        switch(caso){
            case 1:
                salida.writeInt(1);
                System.out.println("omn");
                pantalla.textCliente.setText(pantalla.textCliente.getText()+String.valueOf(entrada.readInt()));
                System.out.println("do");
                break;
            case 2:
                String mensaje = entrada.readUTF();
                pantalla.textCliente.setText(pantalla.textCliente.getText() +mensaje);
                break;
            case 3:    
                salida.writeInt(2);
                mensaje = pantalla.txtChat.getText();
                salida.writeUTF(mensaje);
                pantalla.textCliente.setText(pantalla.textCliente.getText() + mensaje);
                pantalla.txtChat.setText("");//No dejar enviar si el mensaje va vacio
                //Manejar las desconexiones del usuarios
                //Arreglar los mensajes agregar nombre y hora y espacio
        }
    }
    
}
