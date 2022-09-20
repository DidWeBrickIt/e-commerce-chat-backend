package DWBI.p3_tech_chat.services;

import DWBI.p3_tech_chat.daos.MessageDao;
import DWBI.p3_tech_chat.entities.Message;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    private MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public int createTable(String username) {
        return this.messageDao.createMessageTable(username);
    }

    @Override
    public int postMessage(String username, Message message) {
        return this.messageDao.postMessage(username, message);
    }

    @Override
    public List<Message> getMessageByUsername(String username) {
        return this.messageDao.getMessagesByUsername(username);
    }

    @Override
    public void deleteMessagesByUsername(String username) {
        this.messageDao.deleteMessagesByUsername(username);
    }
}
