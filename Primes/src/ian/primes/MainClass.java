package ian.primes;

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	
	private Scanner scanner;
	String number;
	Integer decimalValue;
	List<Integer> primeNumbers = new ArrayList<Integer>();
	boolean found;
	int base, count;
	PrintWriter writer;
	
	public MainClass(){
		try {
			
			scanner = new Scanner(new File("PrimeNumbers.txt"));
			while(scanner.hasNext()){
				number = scanner.next();
				number = number.substring(0,number.length()-1);
				
				primeNumbers.add(new Integer(number));
				number = "";	
			}
			
			for(base = 10; base < 36 + 1; base++){
				count = 0;
				writer = new PrintWriter("PrimeEnds" + base + ".txt");
				for(Integer ii : primeNumbers){
					decimalValue = Integer.parseInt(ii.toString(), base);
					found = false;
						if (decimalValue <= 1) {
							writer.println(ii + " -> xxx" + decimalValue + "xxx");	// zero and one are not prime
						} else {
						    for (int i=2; i*i<=decimalValue; i++) {
						        if (decimalValue % i == 0){ 
						        	writer.println(ii + " -> xxx" + decimalValue + "xxx");
						        	found = true;
						        }
						    }
						    if(found == false){
						    	writer.println(ii + " ->" + decimalValue);
						    	count++;
						    }
						}
				}
				System.out.println("Base " + base + " works with " + (int)(((double)count / 168)*100) + "% primes.");
				writer.close();
				writer = null;
			}
			
					} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
