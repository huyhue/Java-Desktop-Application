package Socket_time;
//class gom co Message + ServerSerialization + ClientSerialization + ServerThread(chua hieu lam, multiple client)
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSerialization {

    public void serve() {
        try {
            ServerSocket server = new ServerSocket(1985);
            System.out.println("Server is ready...");
            
            int count = 0;
            while (true) { //multiple client
                System.out.println("Client " + ++count);
                Socket socket = server.accept();

                //Receive data from client
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message m1 = (Message) ois.readObject();
                if (m1 != null) {
                    System.out.println("Received a message from client: " + m1.getTitle() + " " + m1.getBody());
                    //Do something
                    
                    Message m2 = new Message("Ebooks", "Java programming language");
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); //send data to client
                    oos.writeObject(m2);
                    System.out.println("Sent a message to client: " + m2.getTitle() + " " + m2.getBody());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSerialization server = new ServerSerialization();
        server.serve();
    }
}
