package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class IOExample {

	public static void main(String[] args) throws IOException {

		byte[] src = {1, 2, 3, 4};
		byte[] dest = null;
		
		// 소스에다가 바로 스트림을 꽂았으므로 이것은 주스트림이다.
		InputStream is = new ByteArrayInputStream(src);
		OutputStream os = new ByteArrayOutputStream();
		
		int data = -1;
		while((data = is.read()) != -1) {
			os.write(data);
		}
		
		System.out.println(Arrays.toString(src));
		dest = ((ByteArrayOutputStream)os).toByteArray();
		for(int i=0; i<dest.length; i++) {
			System.out.print(dest[i] + " ");
		}
		System.out.println();
		
		System.out.println(Arrays.toString(dest));
	}
}
