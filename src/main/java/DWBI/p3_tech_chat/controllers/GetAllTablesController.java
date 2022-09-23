package DWBI.p3_tech_chat.controllers;

import DWBI.p3_tech_chat.P3TechChatApplication;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetAllTablesController implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(P3TechChatApplication.messageService.getAllTables());

        if (json.length() > 2) {
            ctx.status(200);
            ctx.result(json);
        } else {
            ctx.status(404);
        }
    }
}
