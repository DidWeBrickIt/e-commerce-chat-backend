package DWBI.p3_tech_chat.controllers;

import DWBI.p3_tech_chat.P3TechChatApplication;
import DWBI.p3_tech_chat.entities.Message;
import DWBI.p3_tech_chat.entities.list;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GetMessagesByUsernameController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String username = ctx.pathParam("username");
        Gson gson = new Gson();
        String json = gson.toJson(P3TechChatApplication.messageService.getMessageByUsername(username));

        if (json.length() > 2) {
            ctx.status(200);
            ctx.result(json);
        } else {
            ctx.status(404);
        }
    }
}
