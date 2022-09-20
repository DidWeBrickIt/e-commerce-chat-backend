package DWBI.p3_tech_chat.controllers;

import DWBI.p3_tech_chat.P3TechChatApplication;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class DeleteMessagesByUsernameController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String username =ctx.pathParam("username");
        P3TechChatApplication.messageService.deleteMessagesByUsername(username);
    }
}
