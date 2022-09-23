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
    public int createTable(String name) {
        return this.messageDao.createMessageTable(name);
    }

    @Override
    public int postMessage(String name, Message message) {
        return this.messageDao.postMessage(name, message);
    }

    @Override
    public List<Message> getMessageByUsername(String name) {
        return this.messageDao.getMessagesByUsername(name);
    }

    @Override
    public void deleteMessagesByUsername(String name) {
        this.messageDao.deleteMessagesByUsername(name);
    }

    @Override
    public List<String> getAllTables() {
        return this.messageDao.getAllTables();
    }
}
