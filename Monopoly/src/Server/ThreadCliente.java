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
    boolean empezado;

    public ThreadCliente(DataInputStream entrada, DataOutputStream salida, formTablero pantalla) {
        this.running = true;
        this.pantalla = pantalla;
        this.pantalla.setThread(this);
        this.entrada = entrada;
        this.salida = salida;
        this.empezado = true;
    }
    
    @Override
    public void run() {
        int opcion;
        
        /*while(running){
            if(empezado==false)
                break;
        }*/
        
        while (running) {        
            try {
                System.out.println("antes");
                opcion = entrada.readInt();
                System.out.println("despues");
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
                break;
            case 2:
                System.out.println("Mensaje a recibir");
                String mensaje = entrada.readUTF();
                pantalla.textCliente.setText(pantalla.textCliente.getText() +mensaje);
                break;
            case 3:    
                salida.writeInt(2);
                mensaje = pantalla.txtChat.getText();
                salida.writeUTF(mensaje);
                pantalla.textCliente.setText(pantalla.textCliente.getText() + mensaje);
                pantalla.txtChat.setText("");//No dejar enviar si el mensaje va vacio
                break;
                //Manejar las desconexiones del usuarios
                //Arreglar los mensajes agregar nombre y hora y espacio
            case 4:
                int dado = entrada.readInt();
                pantalla.textCliente.setText(pantalla.textCliente.getText()+String.valueOf(dado));
                break;
            case 5:
                break;
            default:
                System.out.println("error");
        }
    }
    
}
