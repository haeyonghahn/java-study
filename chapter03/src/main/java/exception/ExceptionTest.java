package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		
		try {
			
		}
		catch(ArithmeticException ex) {
			// 1. 사과
			System.out.println("미안합니다......");
			// 2. 로그 남기기 (파일, DB)
			System.out.println(ex);
			// 3. 정상 종료
			
		}
	}

}
