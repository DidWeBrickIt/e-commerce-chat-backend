package DWBI.p3_tech_chat.services;

import DWBI.p3_tech_chat.entities.Message;

import java.util.List;

public interface MessageService {

    int createTable (String username);

    int postMessage (String username, Message message);

    List<Message> getMessageByUsername (String username);

    void deleteMessagesByUsername(String username);

    List<String> getAllTables();
}
