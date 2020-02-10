package p02;

public class Prob02 {
	public static void main(String[] args) {
		
		int k=0;
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=10; j++) {
				System.out.print((j+k) + " ");
			}
			System.out.println();
			k++;
		}
	}
}
