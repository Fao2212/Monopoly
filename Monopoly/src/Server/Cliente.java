/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import GUI.formTablero;
import GUI.inicioCliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author ferol
 */
public class Cliente {//Solamente pinta la pantalla

   Socket socket;
    formTablero pantallaTablero;
    inicioCliente pantallaInicio;
   DataInputStream entrada;
   DataOutputStream salida;
   String nombre;
   //Jugador
   //Referencia a figura

    public Cliente()
     {
         iniciarPantalla();
     }
    

     public static void main (String [] args)
     {
         new Cliente();
     }
     
         public void iniciarPantalla(){
             
            pantallaInicio = new inicioCliente();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pantallaInicio.setVisible(true);
            }
        });
            pantallaInicio.setCliente(this);
    }
         
    public void iniciarPantallaTablero(){
        pantallaTablero = new formTablero();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pantallaTablero.setVisible(true);
            }
        });
    }
         
    public void conexion(){
      try {
          
         socket = new Socket("localhost", 35557);
         entrada = new DataInputStream(socket.getInputStream());
         salida = new DataOutputStream(socket.getOutputStream());
         nombre = JOptionPane.showInputDialog("Introducir Nick :");
         pantallaTablero.setTitle(nombre);
         salida.writeUTF(nombre);
         System.out.println("1. Envia el nombre del cliente: "+nombre);
         
      } catch (IOException e) {
          
         System.out.println("\tEl servidor no esta levantado");
         System.out.println("\t=============================");
         
      }

      new ThreadCliente(entrada, salida,pantallaTablero).start();//Meter dentro del try
      //Aqui se podria setear la ficha
      
    }
}
