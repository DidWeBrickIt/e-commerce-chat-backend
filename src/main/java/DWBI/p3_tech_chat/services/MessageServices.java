package DWBI.p3_tech_chat.services;

import DWBI.p3_tech_chat.entities.Message;

import java.util.List;

public interface MessageServices {

    int createTable ();

    int postMessage ();

    List<Message> getMessagebyUsername ();

    int
}
