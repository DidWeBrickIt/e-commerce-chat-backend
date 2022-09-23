package DWBI.p3_tech_chat;

import DWBI.p3_tech_chat.controllers.*;
import DWBI.p3_tech_chat.daos.MessageDaoPostgres;
import DWBI.p3_tech_chat.services.MessageService;
import DWBI.p3_tech_chat.services.MessageServiceImpl;
import io.javalin.Javalin;



public class P3TechChatApplication {
	public static MessageService messageService = new MessageServiceImpl(new MessageDaoPostgres());
	public static void main(String[] args) {
		Javalin app = Javalin.create(config ->
		{
			config.enableDevLogging();
			config.enableCorsForAllOrigins();
		});

		//controllers
		DeleteMessagesByUsernameController deleteMessagesByUsernameController = new DeleteMessagesByUsernameController();
		CreateTableController createTableController = new CreateTableController();
		GetMessagesByUsernameController getMessagesByUsernameController = new GetMessagesByUsernameController();
		PostMessageController postMessageController = new PostMessageController();
		GetAllTablesController getAllTablesController = new GetAllTablesController();


		//call controllers
		app.delete("/{name}",deleteMessagesByUsernameController);
		app.post("/{name}", createTableController);
		app.get("/{name}/retrieve", getMessagesByUsernameController);
		app.post("/{name}/post", postMessageController);
		app.get("/tables", getAllTablesController );


		app.start();
	}

}
