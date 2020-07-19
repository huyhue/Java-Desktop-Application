package Socket_time;
//class gom co Message + ServerSerialization + ClientSerialization + ServerThread(chua hieu lam, multiple client)
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSerialization {
    public void connect() {
        try {
            Socket socket = new Socket("localhost", 1985);
            
            //sending to server
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Message m1 = new Message("Study", "Give me some ebooks");
            oos.writeObject(m1);
            System.out.println("Sent to the server: " + m1.getTitle() + " " + m1.getBody());
            
            //receive data from server
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message m2 = (Message) ois.readObject();
            if (m2 != null) {
                System.out.println("Received from the server: " + m2.getTitle() + " " + m2.getBody());
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ClientSerialization c = new ClientSerialization();
        c.connect();
    }
}
