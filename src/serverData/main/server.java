package serverData.main;

import java.io.IOException;
import java.net.*;

public class server {

	ServerSocket server;
	Socket s;

	public server() {
		System.out.println("Server init");

	}


	public void init(int port) {
		try {
			server = new ServerSocket(port);// may not be port just an id number
			s = server.accept();
			System.out.println("Connected");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOExeption error---");
		}
	}
}
