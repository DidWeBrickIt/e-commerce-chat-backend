package DWBI.p3_tech_chat.daos;

import DWBI.p3_tech_chat.entities.Message;

import java.util.List;

public class MessageDaoPostgres implements MessageDao{

    @Override
    public int createMessageTable(String username) {
        return 0;
    }

    @Override
    public int postMessage(String message) {
        return 0;
    }

    @Override
    public List<Message> getAllMessages() {
        return null;
    }

    @Override
    public void deleteAllMessages() {

    }
}
