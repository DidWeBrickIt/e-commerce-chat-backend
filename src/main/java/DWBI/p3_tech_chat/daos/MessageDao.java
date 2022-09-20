package DWBI.p3_tech_chat.daos;

import DWBI.p3_tech_chat.entities.Message;

import java.util.List;

public interface MessageDao {

    int createMessageTable(String username);

    int postMessage(String username, Message message);

    List<Message> getAllMessages (String username);

    void deleteAllMessages(String username);
}
