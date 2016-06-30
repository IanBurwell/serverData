package ian.primes;

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	private Scanner scanner, input;
	String number;
	Integer decimalValue;
	List<Integer> numberList = new ArrayList<Integer>();
	int base;
	double count = 0;
	PrintWriter writer;
	String fileChoice;

	public MainClass(){
		input = new Scanner(System.in);
		
		System.out.print("which file? ");
		fileChoice = input.next();
		System.out.println("working...");
		
		doStuff(fileChoice);
	}
	
	void doStuff(String fileChoice) {
		try {
			writer = new PrintWriter(new File("result.txt"));
			scanner = new Scanner(new File(fileChoice));
			while(scanner.hasNext()){
				number = scanner.next();
				number = number.substring(0,number.length()-1);

				numberList.add(new Integer(number));
				number = "";	
			}

			for(base = 10; base < 500 + 1; base++){
				count = 0;
				for(Integer ii : numberList){
					decimalValue = convertToBase(ii, base, 10);
					checkForPrime(ii);
				}
				writer.println(count/numberList.size() * 100);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("done. result.txt now contains a list of percent frequencies for bases 10 to 500.");
		writer.close();
	}

	int convertToBase(int num, int base1, int base2)
	{
		int inDecimal = 0;
		int newNum = 0;
		for(int x=0;x<countDigits(num);x++)
			inDecimal = inDecimal + findDigit(num, x+1) * (int)Math.pow(base1, x);
		int largestDigit = 0;
		while(inDecimal/Math.pow(base2, largestDigit)!=0)
			largestDigit++;
		for(int x=largestDigit;x>=0; x--)
		{
			newNum = newNum + (inDecimal/(int)Math.pow(base2, x)) * (int)Math.pow(10, x);
			inDecimal = inDecimal - (inDecimal/(int)Math.pow(base2, x) * (int)Math.pow(base2, x));
		}
		return newNum;
	}

	int countDigits(double num)
	{
		int x = 0;
		while((int)(num/Math.pow(10,x))!=0)
			x++;
		if(x==0)
			return 1;
		else
			return x;
	}

	int findDigit(int num, int n)
	{
		int temp = (int)Math.pow(10, n-1);
		if(temp==0)
			temp = 1;
		int answer = (num/temp)%10;
		if(answer<0)
			answer = answer*-1;
		return answer;
	}

	boolean checkForPrime(int ii) {
		boolean found = false;

		if (decimalValue <= 1) {
		} else {
			for (int i=2; i*i<=decimalValue; i++) {
				if (decimalValue % i == 0){ 
					found = true;
				}
			}
			if(found == false){
				count++;
			}
		}

		return found;
	}
}
