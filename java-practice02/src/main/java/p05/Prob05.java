package p05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		Random r = new Random();
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		System.out.println("1-100");

		int k = r.nextInt(100) + 1;
		int low = 1;
		int high = 100;

		while(true) {
			System.out.print(low + ">>");
			int number = input.nextInt();
			if(k > number) {
				low = number;
				System.out.println("더 높게");
				System.out.println(low + "-" + high);
			}
			else if(k < number) {
				high = number;
				System.out.println("더 낮게");
				System.out.println(low + "-" + high);
			}
			else {
				System.out.println("맞았습니다.");
				System.out.print("다시하시겠습니까(y/n)>>");
				String answer = input.next();
				if(answer.equals("y")) {
					k = r.nextInt(100) + 1;
					low = 1;
					high = 100;
					System.out.println("수를 결정하였습니다. 맞추어 보세요");
					System.out.println("1-100");
				}	
				else if(answer.equals("n"))
					break;
			}	
		}
	}

}
