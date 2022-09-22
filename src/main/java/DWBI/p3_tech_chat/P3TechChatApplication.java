package DWBI.p3_tech_chat;

import DWBI.p3_tech_chat.controllers.CreateTableController;
import DWBI.p3_tech_chat.controllers.DeleteMessagesByUsernameController;
import DWBI.p3_tech_chat.controllers.GetMessagesByUsernameController;
import DWBI.p3_tech_chat.controllers.PostMessageController;
import DWBI.p3_tech_chat.daos.MessageDaoPostgres;
import DWBI.p3_tech_chat.services.MessageService;
import DWBI.p3_tech_chat.services.MessageServiceImpl;
import io.javalin.Javalin;



public class P3TechChatApplication {
	public static MessageService messageService = new MessageServiceImpl(new MessageDaoPostgres());
	public static void main(String[] args) {
		Javalin app = Javalin.create();

		//controllers
		DeleteMessagesByUsernameController deleteMessagesByUsernameController = new DeleteMessagesByUsernameController();
		CreateTableController createTableController = new CreateTableController();
		GetMessagesByUsernameController getMessagesByUsernameController = new GetMessagesByUsernameController();
		PostMessageController postMessageController = new PostMessageController();


		//call controllers
		app.delete("/{username}",deleteMessagesByUsernameController);
		app.post("/{username}", createTableController);
		app.get("/{username}/retrieve", getMessagesByUsernameController);
		app.post("/{username}/post", postMessageController);


		app.start();
	}

}
