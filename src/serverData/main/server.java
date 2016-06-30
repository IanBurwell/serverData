package serverData.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class server {
    DataInputStream dis;
    DataOutputStream dos;
    ServerSocket server;
    Socket s;

    public server() {
	System.out.println("Server init");

    }

    public void init(int port) {
	try {
	    server = new ServerSocket(port);// may not be port just an id number
	    s = server.accept();

	    dos = new DataOutputStream(s.getOutputStream());
	    dis = new DataInputStream(s.getInputStream());
	    System.out.println("Data Streams created");

	    System.out.println("Connected");
	} catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("IOExeption error---");
	}
    }

    public void sendString(String output) {
	try {
	    dos.writeUTF(output);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public String readString(){
	try {
	    return dis.readUTF();
	} catch (IOException e) {
	    e.printStackTrace();
	    return "IOException";
	}
    }
}
