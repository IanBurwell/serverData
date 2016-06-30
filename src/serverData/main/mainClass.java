package serverData.main;

import java.util.Scanner;


public class mainClass {
	String ip = "127.0.0.1", choice = "";
	int port = 3000;
	Scanner input = new Scanner(System.in);
	
	public mainClass() {//Runs when class called
		//System.out.println("Input ip: ");
		//ip = input.nextInt();
		System.out.println("Input port: ");
		port = input.nextInt();
		input.nextLine();
		
		System.out.println("Client or server (c/s)?");
		choice = input.nextLine();

		if(choice.equals("s")){
			System.out.println("Server opening...");
			new server(port);
		} else if(choice.equals("c")){
			System.out.println("Client opening...");
			new client(ip, port);
		}
	}
}
