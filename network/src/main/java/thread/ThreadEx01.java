package thread;

public class ThreadEx01 {

	public static void main(String[] args) {

//		for(int i=1; i<=10; i++) {
//			System.out.print(i);
//		}
		Thread digitalThread = new DigitalThread();
		digitalThread.start();
		
		for(char c='a'; c<='z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
