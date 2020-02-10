package p03;

import java.util.Scanner;

public class Prob03 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int number = input.nextInt();
		int sum = 0;

		if(number % 2 == 0) {
			for(int i=0; i<=number; i++) {
				if(i % 2 == 0) {
					sum += i;
				}
			}
		}
		else {
			for(int i=0; i<=number; i++) {
				if(i % 2 == 1) {
					sum += i;
				}
			}
		}
		System.out.println("결과 값 : " + sum);

	}
}
