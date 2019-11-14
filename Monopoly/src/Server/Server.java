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
import monopoly.Tablero;

/**
 *
 * @author ferol
 */
public class Server {
    
    ServerSocket socket;
    formPantallaServidorPrueba pantalla;
    Socket[] clientes;
    ArrayList<ThreadServer> threadClientes;
    ArrayList<ThreadCliente> threadClientesClientes;
    boolean running;
    int maxplayers;
    Tablero tablero;//Asociar jugador-cliente
    boolean selected;

    public Server() {
        
        running = true;
        selected = true;
        threadClientes = new ArrayList<ThreadServer>();
        threadClientesClientes = new ArrayList<ThreadCliente>();
        tablero = new Tablero();
        iniciarPantalla();
        serverRunning();
        
    }
    
    public static void main(String[] args) {
        new Server();
    }
    
    public void serverRunning(){
        
        while (selected) {   
            System.out.println("asd");
            if (selected == false) {
                System.out.println("p");
                break;
            }
        }
        
        try {
            socket = new ServerSocket(35557);
            clientes = new Socket[maxplayers];

            System.out.println ("Esperando cliente ... ");

            int i = 0;

            while(i<maxplayers){//Cambiar por la cantidad de jugadores con que se inicia el serbvidor
                
                clientes[i] = socket.accept();
                System.out.println ("Conectado con cliente de " + 
                clientes[i].getInetAddress()+":"+
                clientes[i].getPort());
                ThreadServer thread = new ThreadServer(clientes[i],this,i);
                thread.start();
                threadClientes.add(thread);
                i++;
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
            pantalla.setServidor(this);
    }
    
    public void escribirMensaje(String mensaje, ThreadServer server) throws IOException{
        server.salida.writeInt(2);
        server.salida.writeUTF(mensaje);
    }
    
    public void imprimirJugadores(){
        for (int i = 0; i < threadClientes.size(); i++) {
            System.out.println(threadClientes.get(i).getPlayer().nombre);
        }
    }
    
    public void cantidadDeJugadores(){
        maxplayers = (int)pantalla.spinnerJugadores.getValue();
        tablero.setMaxJugadores(maxplayers);
        selected = false;
    }
    
}
