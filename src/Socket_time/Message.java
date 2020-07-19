package Socket_time;
//class gom co Message + ServerSerialization + ClientSerialization + ServerThread(chua hieu lam, multiple client)
import java.io.Serializable;
public class Message implements Serializable{
    private String title;
    private String body;

    public Message(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
    
}
