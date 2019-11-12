/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import GUI.formPantallaClientePrueba;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author ferol
 */
public class Cliente {

   Socket socket;
   formPantallaClientePrueba pantalla;
   DataInputStream entrada;
   DataOutputStream salida;
   String nombre;

    public Cliente()
     {
         iniciarPantalla();
         conexion();
     }
    

     public static void main (String [] args)
     {
         new Cliente();
     }
     
         public void iniciarPantalla(){
            pantalla = new formPantallaClientePrueba();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pantalla.setVisible(true);
            }
        });
    }
         
    public void conexion(){
      try {
          
         socket = new Socket("localhost", 35557);
         entrada = new DataInputStream(socket.getInputStream());
         salida = new DataOutputStream(socket.getOutputStream());
         nombre = JOptionPane.showInputDialog("Introducir Nick :");
         pantalla.setTitle(nombre);
         salida.writeUTF(nombre);
         System.out.println("1. Envia el nombre del cliente: "+nombre);
      } catch (IOException e) {
         System.out.println("\tEl servidor no esta levantado");
         System.out.println("\t=============================");
      }

      new ThreadCliente(entrada, salida).start();
    }
}
