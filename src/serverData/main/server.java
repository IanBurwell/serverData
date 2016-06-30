package serverData.main;

import java.io.IOException;
import java.net.*;

public class server {
	ServerSocket server;
	Socket s;
	public server(int port) {
		System.out.println("Server init");

		try {
			server = new ServerSocket(port);// may not be port just an id number
			s = server.accept();
			System.out.println("Connected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOExeption error---");
		}
		
		
	}
}
