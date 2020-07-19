package Socket_time;
//gom co class TimeClient + TimeServer

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

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
            input = socket.getInputStream(); //nhan lay
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String time = reader.readLine();
            System.out.println(time);
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
