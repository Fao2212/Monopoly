/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

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
public class ThreadServer extends Thread{
    
    Socket cliente; 
    DataInputStream entrada;
    DataOutputStream salida;
    String nameUser;
    Server servidor;
    int numeroDeJugador;
    boolean running;
    Jugador player;

    public ThreadServer(Socket cliente, Server servidor, int numeroDeJugador) {
        
        this.running = true;
        this.cliente = cliente;
        this.servidor = servidor;
        this.numeroDeJugador = numeroDeJugador;
        
    }

    public Jugador getPlayer() {
        return player;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
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
          this.setNameUser(entrada.readUTF());
          System.out.println("1. Leyo nombre: " + nameUser);
          this.player = new Jugador(nameUser,servidor.tablero);//Agregar algo para unir al cliente
          servidor.tablero.agregarJugador(player);
    	}
    	catch (IOException e) {  e.printStackTrace();     }
        //Un ciclo mas para escoger el orden
        int opcion;
        
        while (running) {        
            try {
                System.out.println("esperando");
                opcion = entrada.readInt();
                System.out.println(opcion);
                System.out.println("enviado");
                cases(opcion);
            } catch (IOException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public void cases(int caso) throws IOException{
        switch(caso){
            case 1:
                salida.writeInt(4);
                int dados =servidor.tablero.lanzarDado();
                System.out.println(dados);
                salida.writeInt(dados);
                //Mover ficha
                break;
            case 2:
                String mensaje = entrada.readUTF();
                servidor.pantalla.textServidor.setText("Mensaje recibido "+mensaje);
                for (int i = 0; i < servidor.threadClientes.size(); i++) {//Excluir al que envia el mensaje
                    if(servidor.threadClientes.get(i)!= this){
                        servidor.escribirMensaje(mensaje, servidor.threadClientes.get(i));
                        System.out.println("entro");
                    }
                }
                break;
            case 3://Enviar todos los que haya todas las veces luego hacer el orden
                salida.writeInt(6);
                salida.writeInt(player.dadoInicio);
                servidor.lanzamientos++;
                System.out.println("Prueba:"+servidor.lanzamientos);
                break;
        }
    }
}
