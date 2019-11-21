/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Logic.Cartas;
import Logic.Jugador;
import Random.CustomRandom;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import monopoly.Banco;
import monopoly.Propiedad;

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
                if(servidor.maxplayers == servidor.numeroDeConexiones){//Hacer aca todo lo que pasa cuando se conecta el ultimo cliente
                    servidor.ordenEstablecido();
                    servidor.tablero.iniciarJuego();
                    servidor.todosEnGo();
                    servidor.enviarDatosATodos();
                    servidor.releaseThreads();
                }
                else{
                    System.out.println("durmiendo");
                    wait();
                    System.out.println("despierto");
                
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
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
                System.out.println("pos"+player.pos);
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
            case 4:
                System.out.println("Llego a a pasar");
                servidor.tablero.siguienteJugador();
                actualizarInfoCliente();//Deberia ser para todos? falta actualizar las propiedades
                break;
            case 5:
                miTurno();
                break;
            case 6://Aca que haga la consulta enviar que si se puede comprar(Manda a abrir la pantalla de compra) o que tiene que pagar y las acciones
                Propiedad prop = servidor.tablero.casillas[player.pos].doAction();//Desde la pantalla que si le da que si la compra, si no sigue normal luego encargarse de la subasta
                if(prop.propietario == null)
                    salida.writeInt(1);
                else
                    if(prop.propietario == player)
                        salida.writeInt(2);//Cuando es la propiedad de uno mismo
                    else;
                        salida.writeInt(0);
                break;
            case 7:
                boolean puede = Banco.comprarPropiedad(servidor.tablero.casillas[player.pos].doAction(), player);
                if(puede)
                    actualizarInfoCliente();
                else
                    salida.writeInt(17);
                break;
            case 8:
                Propiedad propiedad = servidor.tablero.casillas[player.pos].doAction();
                player.pagarAlquiler(propiedad);
                System.out.println("Se pago "+propiedad.getAlquiler()+"del"+player.nombre+"a"+propiedad.propietario);
                actualizarInfoCliente();
                break;
            case 9:
                System.out.println(player.dinero);
                player.dinero += 200;//Pasa por go
                System.out.println(player.dinero);
                actualizarInfoCliente();//Cuidado aca
                break;
            case 10:
                servidor.borrarPiezaATodos(numeroDeJugador);
                player.enviarALaCarcel();//Cambio de pos y entonces pintar con 0 espacios
                servidor.moverPiezaTodos(0, player.numeroDeJugador, player.pos);//Revisar usar esto en una funcion para saltos
                break;
            case 11:
                int num = CustomRandom.randomRange(0, servidor.tablero.casualidad.length);
                Cartas chance = servidor.tablero.sacarCartaChance(num);
                //Enviar numero
                chance.Action(player);
                actualizarInfoCliente();
                break;
            case 12:
                int numo = CustomRandom.randomRange(0, servidor.tablero.arcaComunal.length);
                Cartas chest = servidor.tablero.sacarCartaChest(numo);
                //Enviar numero
                chest.Action(player);
                actualizarInfoCliente();
                break;
        }
    }
    
    public void enviarInfoCliente() throws IOException{
        Jugador jugadohdelturno = servidor.tablero.jugadores[servidor.tablero.indiceJugadorActual];
        salida.writeInt(15);
        salida.writeInt(player.dinero);
        salida.writeUTF(jugadohdelturno.nombre);
    }
    public void actualizarInfoCliente() throws IOException{//Lo mismo pero con una llamada a cases
        Jugador jugadohdelturno = servidor.tablero.jugadores[servidor.tablero.indiceJugadorActual];
        salida.writeInt(16);
        salida.writeInt(player.dinero);
        salida.writeUTF(jugadohdelturno.nombre); 
    }
    
    public void miTurno() throws IOException{
        System.out.println("Envio"+player+player.turno);
        salida.writeInt(9);
        salida.writeBoolean(player.turno);
        System.out.println("Enviado");
    }
    public void borrarUnEspacio(int numeroDeJugador) throws IOException{
        salida.writeInt(18);
        salida.writeInt(numeroDeJugador);//
    }
}
