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
    int numeroDeConexiones;
    int lanzamientos;

    public Server() throws InterruptedException {
        
        running = true;
        selected = true;
        threadClientes = new ArrayList<ThreadServer>();
        threadClientesClientes = new ArrayList<ThreadCliente>();
        tablero = new Tablero();
        iniciarPantalla();
        serverRunning();
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Server();
    }
    
    public void serverRunning() throws InterruptedException{
        
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

            numeroDeConexiones = 0;

            while(numeroDeConexiones<maxplayers){//Cambiar por la cantidad de jugadores con que se inicia el serbvidor
                
                clientes[numeroDeConexiones] = socket.accept();
                System.out.println ("Conectado con cliente de " + 
                clientes[numeroDeConexiones].getInetAddress()+":"+
                clientes[numeroDeConexiones].getPort());
                ThreadServer thread = new ThreadServer(clientes[numeroDeConexiones],this,numeroDeConexiones);
                thread.start();
                threadClientes.add(thread);
                numeroDeConexiones++;
            }

            todosConectaos();
            
            lanzamientos = 0;
            
            System.out.println("lklkl");
            //Funcion iniciar juego
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
    
    public void todosConectaos() throws IOException{
        for (int i = 0; i < threadClientes.size(); i++) {
            threadClientes.get(i).salida.writeInt(5);
        }
    }
    
    public void ordenEstablecido() throws IOException{//Se repite
        tablero.ordenarJugadores();
        for (int j = 0; j < threadClientes.size(); j++) {
            for (int i = 0; i < threadClientes.size(); i++) {
                if(threadClientes.get(i).player == tablero.jugadores[i]){
                    System.out.println(i);
                    threadClientes.get(i).salida.writeInt(7);
                    threadClientes.get(i).salida.writeInt(i+1);
                }

            }
        }
    }
    //Indicar de quien es el turno y mover la ficha correspondiente
    public void moverPiezaTodos(int dados) throws IOException{
        for (int i = 0; i < threadClientes.size(); i++) {
            threadClientes.get(i).salida.writeInt(4);
            threadClientes.get(i).salida.writeInt(dados);
        }
    }
    
    public void releaseThreads(){
        for(ThreadServer thread: threadClientes){
            synchronized(thread){
                thread.notify();
            }
        }
    }
}
