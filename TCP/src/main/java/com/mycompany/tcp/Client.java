/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Üveys SARAÇ
 */
public class Client {

    static ObjectOutputStream clientOutput;
    static ObjectInputStream clientInput;
    static Socket clientSocket;
    static String serverIp="localhost";
    static int serverPort=5000;

    public static void main(String[] args) {
        try {
            clientSocket = new Socket(serverIp, serverPort);
            clientOutput = new ObjectOutputStream(clientSocket.getOutputStream());
            clientInput = new ObjectInputStream(clientSocket.getInputStream());

            clientOutput.writeObject("merhaba server");
            String value = clientInput.readObject().toString();
            System.out.println("Server said = " + value);
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
