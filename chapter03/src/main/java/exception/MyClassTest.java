package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyClass myClass = new MyClass();
		try {
			myClass.danger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
