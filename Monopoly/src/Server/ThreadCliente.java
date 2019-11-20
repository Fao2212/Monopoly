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
    public boolean tirarDados;
    public boolean turno;
    public Color colores[] = {Color.red,Color.blue,Color.orange,Color.green,Color.CYAN,Color.yellow,Color.red};
    int numeroDeJugador;
    int maxPlayers;
    GUIFicha lastTile;
    int tirosInicio;

    public ThreadCliente(DataInputStream entrada, DataOutputStream salida, formTablero pantalla) {
        this.running = true;
        this.pantalla = pantalla;
        this.pantalla.setThread(this);
        this.entrada = entrada;
        this.salida = salida;
        this.empezado = true;
        this.tirosInicio = 0;
        this.tirarDados = true;
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
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
    
    
    public void cases(int caso) throws IOException, InterruptedException{//Implementar aca todos los mensajes en conjunto con el del servidor
        switch(caso){
            case 1:
                /*if(empezado){//Escogiendo orden 
                    salida.writeInt(3);
                    //Se tiene que bloquear el boton a que solo se pueda tocar una vez
                    //empezado = false; bloquear cuando todos esten el servidor envia a desbloquear los demas botones
                    break;
                }   */
                System.out.println("pido turno");
                miTurno();
                System.out.println("recibo turno");
                if(turno){//Aqui yo meto la funcion de la accion
                    if (tirarDados) {
                        salida.writeInt(1);
                        tirarDados = false;
                    }
                    else
                        System.out.println("Dados Lanzados");
                }
                else
                    System.out.println("No es mi turno");
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
                System.out.println("Posi"+posi);
                movimientoDePieza(dado,jug,posi);
                if(jug == this.numeroDeJugador){
                    cases(11);
                }
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
            case 9:
                leerTurno();
                break;
            case 10:
                pasarTurno();
                break;
            case 11:
                conseguirAccion();
                break;
            default:
                System.out.println("error");
        }
        
        
        
    }
    //Enemiga propia
    public void movimientoDePieza(int espacios,int piezaJugador,int posActual){
        
        int movimiento = espacios;
        int nuevaPos = posActual + espacios;
        
        if(nuevaPos > 39){
            nuevaPos = nuevaPos - 40;
        }
        
        if(tirosInicio<maxPlayers){
        //Movimiento Inicial bugeado
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if(pantalla.tableroGrafico.casillas[0].fichas[i][j].label.getBackground()==colores[piezaJugador]){
                        pantalla.tableroGrafico.despintarLabel(pantalla.tableroGrafico.casillas[0].fichas[i][j]);
                        tirosInicio++;
                    }
                }
            }
            for (int i = posActual; movimiento >= 0; i++) {
                GUIFicha tile = pantalla.tableroGrafico.siguienteEspacio(pantalla.tableroGrafico.casillas[i]);
                pantalla.tableroGrafico.pintarLabel(tile,piezaJugador);
                try {
                          sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(i != posActual+espacios)
                pantalla.tableroGrafico.despintarLabel(tile);
            movimiento--;
            }
        }
        //MovimientoNormal
        else{
            for (int i = posActual;movimiento >= 0; i++) {
                if(i > 39){
                    i = posActual = 0;
                }
                for (int k = 0; k < 2; k++) {
                    for (int j = 0; j < 3; j++) {
                        if(pantalla.tableroGrafico.casillas[posActual].fichas[k][j].label.getBackground()==colores[piezaJugador]){
                            pantalla.tableroGrafico.despintarLabel(pantalla.tableroGrafico.casillas[posActual].fichas[k][j]);
                            i = posActual += 1;
                            if(i > 39){
                                i = posActual = 0;
                            }
                            movimiento -= 1;
                        }
                    }
                }
                GUIFicha tile = pantalla.tableroGrafico.siguienteEspacio(pantalla.tableroGrafico.casillas[i]);
                pantalla.tableroGrafico.pintarLabel(tile,piezaJugador);
                try {
                          sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(i != nuevaPos)
                pantalla.tableroGrafico.despintarLabel(tile);
            movimiento--;
            }
        }
    }
    
    public void conseguirAccion() throws IOException{//Que el server le envie a todos pero que solo cambie los datos del jugador
        
        salida.writeInt(6);
        
    }
    
    public void Accion(int opcion){//Recibe un entero y segun el caso le da opciones al cliente carga las imagenes que estan en pantalla
        //si es compra se pregunta si quiere comprar o no la foto y se manda la opcion al tablero actualizando las propiedades del jugador
        //Si es carta nada mas se escoge la foto y se alpica la funcion respectiva con el suffle
        //Si es especial se aplica la accion respectiva y se cambia lo que se tenga que cambiar del jugador en carcel se tiene que tener un booleano 
        //Aca para saber si lo puede usar o no
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
    
    public void setClienteInfo() throws IOException{//Podria enviar todo el player
        this.turno = entrada.readBoolean();//Turno
        pantalla.labelDinero.setText(String.valueOf(entrada.readInt()));//Dinero
        pantalla.labelTurno.setText(entrada.readUTF());//Nombre del jugador del turno actual
        //Propiedades
        //Casas
    }
    public void actualizarClienteInfo(){
        //actualiza propiedades posiciones
    }
    
    public void miTurno() throws IOException, InterruptedException{
        salida.writeInt(5);
        synchronized(this){
            wait();
        }
    }
    
    public void leerTurno() throws IOException{
        System.out.println("Entre");
        this.turno = entrada.readBoolean();
        synchronized(this){
            notify();//Cuando recibe libera
        }
    }
    
    public void pasarTurno() throws IOException{
        turno = false;
        tirarDados = true;
        System.out.println("Intento pasar");
        salida.writeInt(4);
        System.out.println("Paso");
    }
}
    

