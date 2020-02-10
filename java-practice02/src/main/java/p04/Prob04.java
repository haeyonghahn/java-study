package p04;

import java.util.Scanner;

public class Prob04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		char[] array = reverse(str);
		printCharArray(array);
	}

	public static char[] reverse(String str) {
		char[] charArray = new char[str.length()];
		int num = str.length() - 1;
		for(int i=0; i<str.length(); i++) {
			 charArray[i] = str.charAt(num);
			 num--;
		}	
		return charArray;
	}
	
	public static void printCharArray(char[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
}
