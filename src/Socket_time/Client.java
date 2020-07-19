package Socket_time;
// gom co class Server + Client
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public void connect() {
        try {
            Socket socket = new Socket("localhost", 1985);
            
            //sending to server
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("Study and Share");
            
            //Receiving from server
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String reponse = br.readLine();
            if (reponse != null) {
                System.out.println("Server answered: " + reponse);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Client c = new Client();
        c.connect();
    }
}
