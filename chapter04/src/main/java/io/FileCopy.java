package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("yahoo_logo.png");
			os = new FileOutputStream("yahoo_logo.copy.png");
		
			int data = -1;
			while((data = is.read()) != -1) {
				os.write(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다 - " + e);
		} catch (IOException e) {
			System.out.println("에러 - " + e);
		} finally {
			try {
				if(is != null)
					is.close();
				if(os != null)
					os.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
