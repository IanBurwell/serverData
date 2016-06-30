package serverData.main;

import java.io.IOException;
import java.net.*;

public class client {
	Socket s;
	public client(String ip, int port) {
		System.out.println("Client init");

		try {
			s = new Socket(ip, port);
			System.out.println("Connected");
			Game ex = new Game();
			ex.setVisible(true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Unknown Host");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOExeption error");
		}

	}
}
