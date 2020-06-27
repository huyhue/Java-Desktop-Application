/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket_time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class TimeClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 9998);
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
        
        try {
            InputStream input;
            input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String time = reader.readLine();
            System.out.println(time);
        } catch (IOException e) {
            System.out.println("I/O error: "+e.getMessage());
        }
    }
}
