package Socket_time;
// gom co class Server + Client
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void serve(){
        try {
            ServerSocket server = new ServerSocket(1985);
            System.out.println("Server is ready...");
            Socket socket = server.accept();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //doc du lieu tu client
            String request = br.readLine();
            if (request != null) {
                System.out.println("Received from a client: " + request);
                //Process: Select database, calcular...
                
                //Reponse to client
                PrintStream ps = new PrintStream(socket.getOutputStream());
                ps.println(request.toUpperCase());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.serve();
    }
}
