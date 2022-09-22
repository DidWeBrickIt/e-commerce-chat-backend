package DWBI.p3_tech_chat.entities;

public class Message {

    private int msgId;
    private String username;
    private String message;

    public Message() {
    }

    public Message(int msgId, String username, String message) {
        this.msgId = msgId;
        this.username = username;
        this.message = message;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgId=" + msgId +
                ", username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
