package DWBI.p3_tech_chat.daos;

import DWBI.p3_tech_chat.entities.Message;

import java.util.List;

public interface MessageDao {

    int createMessageTable(String username);

    int postMessage(String message);

    List<Message> getAllMessages ();

    void deleteAllMessages();
}
