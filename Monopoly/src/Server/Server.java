/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import GUI.formPantallaServidorPrueba;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author ferol
 */
public class Server {
    
    ServerSocket socket;
    formPantallaServidorPrueba pantalla;
    Socket[] clientes;
    ArrayList<ThreadServer> threadClientes;
    boolean running;

    public Server() {//Un thread para cada cliente con su respectivo outpu y input se deja con un while true usar un bool
        running = true;
        threadClientes = new ArrayList<ThreadServer>();
        iniciarPantalla();
        serverRunning();
    }
    
    public static void main(String[] args) {
        new Server();
    }
    
    public void serverRunning(){//Inicia los thread de los clientes
        try {
            socket = new ServerSocket(35557);
            clientes = new Socket[3];

            System.out.println ("Esperando cliente ... ");

            int i = 0;

            while(i<3){//Cambiar por la cantidad de jugadores con que se inicia el serbvidor
                
                clientes[i] = socket.accept();
                System.out.println ("Conectado con cliente de " + 
                clientes[i].getInetAddress()+":"+
                clientes[i].getPort());
                ThreadServer thread = new ThreadServer(clientes[i],this,i);
                thread.start();
                threadClientes.add(thread);
            }
            
            while (running) {            
            
            }
            
        } catch (IOException ex) {
            System.out.println("EXCEP:"+ex.getMessage());
        }
       
    }
    public void iniciarPantalla(){
            pantalla = new formPantallaServidorPrueba();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pantalla.setVisible(true);
            }
        });
    }
    
}
