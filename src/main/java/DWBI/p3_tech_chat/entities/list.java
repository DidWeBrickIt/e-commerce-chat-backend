package DWBI.p3_tech_chat.entities;

import java.util.List;

public class list {


    List<Message> messages;

    public list(List<Message> messages) {
        this.messages = messages;
    }

    public list() {
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "list{" +
                "messages=" + messages +
                '}';
    }
}
