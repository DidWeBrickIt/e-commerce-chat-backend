package DWBI.p3_tech_chat.controllers;

import DWBI.p3_tech_chat.P3TechChatApplication;
import DWBI.p3_tech_chat.entities.Message;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class PostMessageController implements Handler {
    int idMaker = 100;

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String username = ctx.pathParam("username");
        String json = ctx.body();
        Gson gson = new Gson();
        Message message = gson.fromJson(json, Message.class);
        message.setMsgId(idMaker);
        int result = P3TechChatApplication.messageService.postMessage(username,message);

        idMaker++;

        if (result == 1) {
            ctx.status(200);
        } else {
            ctx.status(417);
        }

    }


}
