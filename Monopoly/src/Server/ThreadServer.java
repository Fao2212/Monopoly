/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ferol
 */
public class ThreadServer extends Thread{//Guarda las referencias a las cuales se comunica al servdior y a los I/O tiene los mensajes
    
    Socket cliente; 
    DataInputStream entrada;
    DataOutputStream salida;
    String nameUser;
    Server servidor;
    //Array de jugadores thread para envio de mensajes y pedido de cambios
    int numeroDeJugador;

    public ThreadServer(Socket cliente, Server servidor, int numeroDeJugador) {
        this.cliente = cliente;
        this.servidor = servidor;
        this.numeroDeJugador = numeroDeJugador;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    
    

    @Override
    public void run() {
        try
    	{
          // inicializa para lectura y escritura con stream de cliente
          entrada=new DataInputStream(cliente.getInputStream());//comunic
          salida=new DataOutputStream(cliente.getOutputStream());//comunic
          // Es el primer read que hace, para el nombre del user
          
          System.out.println("lee el nombre");
          this.setNameUser(entrada.readUTF());
          System.out.println("1. Leyo nombre: " + nameUser);
          // al enemigo
    	}
    	catch (IOException e) {  e.printStackTrace();     }
    }
    
    public void cases(int caso){
        switch(caso){
            
        }
    }
}
