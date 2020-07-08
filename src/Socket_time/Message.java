/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket_time;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
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
