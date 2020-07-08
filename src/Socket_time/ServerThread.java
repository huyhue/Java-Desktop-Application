package Socket_time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ServerThread extends Thread {

    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //Receive
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            Message m1 = (Message) ois.readObject();
            if (m1 != null) {
                System.out.println("Received a message from client: " + m1.getTitle() + " " + m1.getBody());
                //Do something
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message m2 = new Message("Ebooks", "Java programming language");
                oos.writeObject(m2);
                System.out.println("Sent a message to client: " + m2.getTitle() + " " + m2.getBody());
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
