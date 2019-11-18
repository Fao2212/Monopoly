/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import GUI.GUIFicha;
import GUI.GUITablero;
import GUI.formPantallaClientePrueba;
import GUI.formTablero;
import Logic.Jugador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import GUI.customLabel;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;

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
    public Color colores[] = {Color.red,Color.blue,Color.orange,Color.green,Color.CYAN,Color.yellow,Color.red};
    int numeroDeJugador;
    int maxPlayers;
    GUIFicha lastTile;

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
        
        while (running) {        
            try {
                System.out.println("antes");
                opcion = entrada.readInt();
                System.out.println(opcion);
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
                /*if(empezado){//Escogiendo orden 
                    salida.writeInt(3);
                    //Se tiene que bloquear el boton a que solo se pueda tocar una vez
                    //empezado = false; bloquear cuando todos esten el servidor envia a desbloquear los demas botones
                    break;
                }   */
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
                int jug = entrada.readInt();
                int posi = entrada.readInt();
                System.out.println("TiroDeDado"+dado);
                movimientoDePieza(dado,jug,posi);
                break;
            case 5:
                pantalla.jugadoresListos();
                break;
            case 6:
                entrada.readInt();//Recibe el numero que le toco para el orden
                System.out.println("recibo numero");
                break;
            case 7:
                numeroDeJugador = entrada.readInt();//Tengo que cambiar el numero de jugador
                System.out.println(numeroDeJugador);
                maxPlayers = entrada.readInt();
                System.out.println("recibo pos");
                empezado = false;
                break;
            case 8:
                ponerPiezaEnGo();
                break;
            default:
                System.out.println("error");
        }
        
        
        
    }
    
    public void movimientoDePieza(int espacios,int piezaJugador,int posActual){//Ver en que posicion de la matruz esta
        //Al salir del go buscar la pieza del que tira el dado y borrarla de entre todas las disponibles
        if(posActual == 0){
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if(pantalla.tableroGrafico.casillas[0].fichas[i][j].label.getBackground()==colores[i])
                        pantalla.tableroGrafico.despintarLabel(pantalla.tableroGrafico.casillas[0].fichas[i][j]);
                }
            }
        }
        else
            pantalla.tableroGrafico.despintarLabel(lastTile);
        for (int i = posActual; i <= posActual+espacios; i++) {//Actualizar tablero logico 
            if(i == 40)
                i = 0;
            GUIFicha tile = pantalla.tableroGrafico.siguienteEspacio(pantalla.tableroGrafico.casillas[i]);
            pantalla.tableroGrafico.pintarLabel(tile,piezaJugador);//Aqui va la pos actual
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(i != posActual+espacios)
                pantalla.tableroGrafico.despintarLabel(tile);
            else
                lastTile = tile;
        }
    
    }
    
    public void ponerPiezaEnGo(){
        int cont = 0;
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 3; j++) {
                if(cont < maxPlayers)
                    pantalla.tableroGrafico.pintarLabel(pantalla.tableroGrafico.casillas[0].fichas[i][j], cont);
                cont++;
            }
        }
    }
    
    public void setClienteInfo(){
        //Nombre dinero propiedades en 0 
    }
    public void actualizarClienteInfo(){
        //actualiza propiedades posiciones
    }
    
   /* public boolean miTurno(){
        
    }*/
}
    

