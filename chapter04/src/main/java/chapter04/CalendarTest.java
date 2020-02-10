package chapter04;

import java.util.Calendar;

public class CalendarTest {

	//public static final int MONTH = 1;
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		//final int i = 10;
		
		printDate(cal);
		
		
	}

	public static void printDate(Calendar cal) {
		// 년도
		int year = cal.get(Calendar.YEAR);
		// 월 (0~11, +1)
		int month = cal.get(Calendar.MONTH);
		// 일
		int date = cal.get(Calendar.DATE);
		// 시
		int hours = cal.get(Calendar.HOUR);
		// 분
		int minute = cal.get(Calendar.MINUTE);
		// 초
		int second = cal.get(Calendar.SECOND);
	
		System.out.println(year + "년" +
						   month + "월" +
				   		   date + "일" +
						   hours + "시" +
				   		   minute + "분" +
						   second + "초");
	}
}
