package p04;

public class StringUtil {

	public static String concatenate(String[] str) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length; i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
}
