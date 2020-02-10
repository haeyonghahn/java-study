package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileTest {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("./hello.txt");
			int data = is.read();
			System.out.println((char)data);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			// 네트워크가 종료되었가나 input.close();
			// 자원관리할 것들을 적어준다.
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
