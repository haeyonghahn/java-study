package chapter03;

public class ArrayUitlsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 =  {10, 20, 30, 40, 50};
		
		double[] d1 = ArrayUitls.intToDouble(a1);
		
		for(int i=0; i<d1.length; i++) {
			System.out.print(d1[i] + " ");
		}
	}

}
