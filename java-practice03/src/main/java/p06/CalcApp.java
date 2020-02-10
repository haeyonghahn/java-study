package p06;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("실행결과:");
		System.out.print(">> ");

		while(true) {
			String expr = input.nextLine();
			
			if("quit".equals(expr))
				break;
			
			String[] tokens = expr.split(" ");
			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			
			if(tokens[1].equals("+")) {
				Add add = new Add();
				add.setValue(lValue, rValue);
				System.out.println(">> " + add.caculate());
				System.out.print(">> ");
			}
			else if(tokens[1].equals("-")) {
				Sub sub = new Sub();
				sub.setValue(lValue, rValue);
				System.out.println(">> " + sub.caculate());
				System.out.print(">> ");
			}
			else if(tokens[1].equals("*")) {
				Mul mul = new Mul();
				mul.setValue(lValue, rValue);
				System.out.println(">> " + mul.caculate());
				System.out.print(">> ");
			}
			else if(tokens[1].equals("/")) {
				Div div = new Div();
				div.setValue(lValue, rValue);
				System.out.println(">> " + div.caculate());
				System.out.print(">> ");	
			}
		}
	}

}
