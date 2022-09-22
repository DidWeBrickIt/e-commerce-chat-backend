package DWBI.p3_tech_chat.controllers;

import DWBI.p3_tech_chat.P3TechChatApplication;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateTableController implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String username = ctx.pathParam("username");
        if (P3TechChatApplication.messageService.createTable(username) == 1) {
            ctx.status(201);
        } else {
            ctx.status(417);
        }
    }
}
