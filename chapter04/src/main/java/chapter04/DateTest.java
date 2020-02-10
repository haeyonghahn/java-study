package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date now = new Date();
		
		System.out.println(now);
		printDate1(now);
		printDate2(now);
	}

	public static void printDate1(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy년 MM월 dd일 hh시 mm분 ss초");
		String date = sdf.format(d);
		System.out.println(date);
	}
	
	public static void printDate2(Date d) {
		// 년도(+1900) : 년도는 1900을 뺀 값이 나오게 되어있다.
		int year = d.getYear();
		
		// 월 (0~11m, +1) : 월은 0부터 11로 세팅되어있으므로 1을 더해줘야 한다.
		int month = d.getMonth();
		
		// 일
		int date = d.getDate();
		
		// 시
		int hours = d.getHours();
		
		// 초
		int seconds = d.getSeconds();
		
		System.out.println((year+1900) + "-" + 
						   (month+1)   + "-" + 
						   (date)      + " " +
						   (hours)	   + ":" +
						   (seconds));
	}
} 
