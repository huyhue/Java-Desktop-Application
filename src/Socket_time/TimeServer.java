/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket_time;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class TimeServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9998);
            System.out.println("Server is listening");
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
        
        while(true){
            Socket socket;
            try {
                socket = serverSocket.accept();
                System.out.println("New clint connected");
                
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println(new Date().toString());
            } catch (IOException e) {
                System.out.println("Server exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
    }
}
