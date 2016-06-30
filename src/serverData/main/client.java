package serverData.main;

import java.io.IOException;
import java.net.*;

public class client {
	Socket s;
	public client() {
		System.out.println("Client init");

	}
	
	public void init(String ip, int port){
	    try {
		s = new Socket(ip, port);
		System.out.println("Connected");
	    } catch (UnknownHostException e) {
		e.printStackTrace();
		System.out.println("Unknown Host");
	    } catch (IOException e) {
		e.printStackTrace();
		System.out.println("IOExeption error");
	}
    }

}
