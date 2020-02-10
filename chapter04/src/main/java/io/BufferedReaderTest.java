package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {

		// FileReader fr = null;
		BufferedReader br = null;

		try {
			// 기반스트림
			// fr = new FileReader("./src/BufferedReaderTest.java");

			// 보조스트림
			br = new BufferedReader(new FileReader("./src/io/BufferedReaderTest.java"));

			int index = 0;
			String line = null;
			while((line = br.readLine()) != null) {
				index++;
				System.out.print(index);
				System.out.print(":");
				System.out.println(line);
				System.out.print("\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다 - " + e);
		} catch (IOException e) {
			System.out.println("error - " + e); 
		} finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
