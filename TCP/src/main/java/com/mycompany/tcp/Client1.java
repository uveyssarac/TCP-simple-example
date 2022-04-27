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
public class Client1 {

    static ObjectOutputStream clientOutput;
    static ObjectInputStream clientInput;
    static Socket client1Socket;
    static String serverIp="localhost";
    static int serverPort=5000;

    public static void main(String[] args) {
        try {
            client1Socket = new Socket(serverIp, serverPort);
            clientOutput = new ObjectOutputStream(client1Socket.getOutputStream());
            clientInput = new ObjectInputStream(client1Socket.getInputStream());

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
