package chapter03;

public class ArrayUitls {

	public static double[] intToDouble(int[] src) {
		double[] result = null;
		
		if(src == null) {
			return result;
		}
		
		int length = src.length;
		result = new double[length];
		
		for(int i=0; i<length; i++) {
			result[i] = src[i];
		}
		return result;
	}
}
