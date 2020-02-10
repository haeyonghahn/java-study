package p05;

public class Prob05 {

	public static void main(String[] args) {

		for(int i=1; i<=100; i++ ) {
			int count = 0;
			int number = 0;
			number = i % 10;
			if(number == 3 || number == 6 || number == 9)
				count++;
			number = i / 10;
			if(number == 3 || number == 6 || number == 9)
				count++;
			if(count == 1)
				System.out.println(i + " 짝 ");
			else if(count == 2)
				System.out.println(i + " 짝짝");
		}
	}
}