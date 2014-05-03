package zp.dv.KOM.mychat;

import java.util.ArrayList;
import java.util.List;

public class Message {
    public static List<Message> ListMessage = new ArrayList<Message>();
    private String name;
    private String text;
    private String date;

    public Message(String name, String text, String date) {
        super();
        this.name = name;
        this.text = text;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "message [name=" + name + ", text=" + text + ", date=" + date
                + "]";
    }
}
