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
    public void run() {//Por alguna parte de aqui un wait para esperar jugadores
        try
    	{
          entrada=new DataInputStream(cliente.getInputStream());
          salida=new DataOutputStream(cliente.getOutputStream());
          this.setNameUser(entrada.readUTF());
          System.out.println("1. Leyo nombre: " + nameUser);
          this.player = new Jugador(nameUser,servidor.tablero);
          servidor.tablero.agregarJugador(player);
    	}
    	catch (IOException e) {  e.printStackTrace();     }
        synchronized(this){
            try {
                if(servidor.maxplayers == servidor.numeroDeConexiones){
                    servidor.releaseThreads();
                }
                else{
                    System.out.println("durmiendo");
                    wait();
                    System.out.println("despierto");
                
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int opcion;
        
        while (running) {        
            try {
                opcion = entrada.readInt();
                System.out.println(opcion);
                cases(opcion);
            } catch (IOException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public void cases(int caso) throws IOException, InterruptedException{//Enviar QUien hace cada accion
        switch(caso){
            case 1:
                int dados =servidor.tablero.lanzarDado();
                servidor.moverPiezaTodos(dados,numeroDeJugador,player.pos);
                player.setPos(dados);
                System.out.println(dados);
                break;
            case 2:
                String mensaje = entrada.readUTF();
                servidor.pantalla.textServidor.setText("Mensaje recibido "+mensaje);
                for (int i = 0; i < servidor.threadClientes.size(); i++) {//Excluir al que envia el mensaje
                    if(servidor.threadClientes.get(i)!= this){
                        servidor.escribirMensaje(mensaje, servidor.threadClientes.get(i));
                    }
                }
                break;
            case 3://Enviar todos los que haya todas las veces luego hacer el orden
                salida.writeInt(6);
                salida.writeInt(player.dadoInicio);
                servidor.lanzamientos++;
                synchronized(this){//Convertir esto en una funcion con parametros enteros para la condicion
                    if (servidor.lanzamientos<servidor.maxplayers) {
                        wait();
                    }
                    else{
                        servidor.releaseThreads();
                        servidor.ordenEstablecido();
                    }
                }
                break;
        }
    }
    
    public void enviarInfoCliente(){
        //Enviar un caso con el numeroDeJugador
        //Recibir caso con  esta funcion
    }
    
   
}
