package serverData.resources;

import java.io.*;
import java.io.IOException;
import java.net.*;
import serverData.GUI.*;

public class client {
    Socket s;
    DataOutputStream dos;
    DataInputStream dis;


    public client() {
	System.out.println("Client init");
    }

    public void init(String ip, int port) {
	try {
	    s = new Socket(ip, port);
	    System.out.println("Connected");

	    dos = new DataOutputStream(s.getOutputStream());
	    dis = new DataInputStream(s.getInputStream());
	    System.out.println("Data Streams created");
	    
	    //Game ex = new Game();
	    //ex.setVisible(true);

	} catch (UnknownHostException e) {
	    e.printStackTrace();
	    System.out.println("Unknown Host");
	} catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("IOExeption error");
	}
    }

    public void sendString(String output) {
	try {
	    dos.writeUTF(output);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public String readString() {
	try {
	    return dis.readUTF();
	} catch (IOException e) {
	    e.printStackTrace();
	    return "IOException";
	}
    }
}
