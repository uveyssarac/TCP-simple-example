/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Üveys SARAÇ
 */
public class Server {
    static ServerSocket serverSocket;
    static int serverPort=5000;
    static ObjectInputStream clientInput;
    static ObjectOutputStream clientOutput;
    
    public static void main(String[] args) {
        System.out.println("Hello Server");
        //while(true){
        try {
            serverSocket=new ServerSocket(serverPort);
            System.out.println("Server start to accept");
            Socket client=serverSocket.accept();//blocking
            Socket client1=serverSocket.accept();//blocking
            System.out.println("Client is here: ");
            clientOutput = new ObjectOutputStream(client.getOutputStream());
            clientInput = new ObjectInputStream(client.getInputStream());
            
            System.out.println("Server message from client ");
            String value = clientInput.readObject().toString();
            System.out.println("Client said = " + value);
            
            clientOutput.writeObject("merhaba client");
            
            clientOutput = new ObjectOutputStream(client1.getOutputStream());
            clientInput = new ObjectInputStream(client1.getInputStream());
            
            System.out.println("Server message from client1 ");
            value = clientInput.readObject().toString();
            System.out.println("Client1 said = " + value);
            
            clientOutput.writeObject("merhaba client1");
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //}  
    }
}

