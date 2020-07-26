package Socket_time;
//gom co class ChatPanel + ClientChatter + ManagerChatter + OutputThread
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//Thread presents received messages automatically
public class OutputThread extends Thread {

    Socket socket; //socket is joining to be communication
    JTextArea txt; //text area contains communicated message
    BufferedReader bf; //input buffer of the socket
    String sender;  //sender, a site of the communication
    String receiver;   //receiver, other site of the communication

    public OutputThread(Socket s, JTextArea txt, String sender, String receiver) {
        super();
        this.socket = s;
        this.txt = txt;
        this.sender = sender;
        this.receiver = receiver;
        try {
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));  //doc du lieu
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Network Error!");
            System.exit(0);
        }
    }

    //get data from the input stream periodically (1 times/ sec)
    //The time when data comes can nt be known in advance
    @Override
    public void run() {
        while (true) {
            try {
                if (socket != null) {
                    String msg = "";
                    if ((msg = bf.readLine()) != null && msg.length() > 0) {
                        txt.append("\n" + receiver + ": " + msg);
                    }
                    sleep(1000);
                }
            } catch (Exception e) {}
        }
    }

}
