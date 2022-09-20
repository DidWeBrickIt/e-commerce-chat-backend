package DWBI.p3_tech_chat.entities;

public class Message {

    private int msgId;
    private String message;

    public Message() {
    }

    public Message(int msgId, String message) {
        this.msgId = msgId;
        this.message = message;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
