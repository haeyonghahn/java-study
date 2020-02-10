package exception;

public class MyException extends Exception {

	// 객체를 구분할 수 있는 ID
	private static final long serialVersionUID = 1L;

	public MyException() {
		super("MyException Occurs");
	}
	
	public MyException(String message) {
		super(message);
	}
}
