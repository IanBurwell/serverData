package serverData.main;

import java.util.Scanner;

import serverData.resources.client;
import serverData.resources.server;

public class mainClass {
    String ip = "127.0.0.1", choice = "";
    int port = 3000;

    public mainClass() {// Runs when class called
	Scanner input = new Scanner(System.in);
	System.out.println("Input ip: ");
	ip = input.nextLine();

	System.out.println("Input port: ");
	port = input.nextInt();
	input.nextLine();

	System.out.println("Client or server (c/s)?");
	choice = input.nextLine();
	
	input.close();
	
	if (choice.equals("s")) {
	    serverSet();
	} else if (choice.equals("c")) {
	    clientSet();
	} else {
	    // TODO make it go back an ask again
	}

    }

    private void serverSet() {// TODO bad name for function revise
	System.out.println("Server opening...");
	server myServer = new server();
	myServer.init(port);
	serverMain(myServer);
    }

    private void clientSet() {// TODO bad name for function revise
	System.out.println("Client opening...");
	client myClient = new client();
	System.out.println("client being initialized");
	myClient.init(ip, port);
	clientMain(myClient);
    }

    private void clientMain(client myClient) {
	Scanner input = new Scanner(System.in);
	
	
	input.close();

    }

    
    private void serverMain(server myServer) {
	Scanner input = new Scanner(System.in);
	
	
	input.close();
    }

}