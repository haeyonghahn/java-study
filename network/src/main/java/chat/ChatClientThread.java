package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.HashMap;

// ChatClientThread를 쓴 이유는 클라이언트에서 입력하는 메시지랑 다수의 사용자에게 메시지를 전달하기 위해서 쓰레드를 이용하여 처리한 것이다.
// 쓰레드 프로그래밍은 task를 나누는 것이 중요하다.
public class ChatClientThread extends Thread {

	private BufferedReader bufferedReader;
	private String nickName;
	private Socket socket;
	
	public ChatClientThread(Socket socket, String nickName) {
		this.socket = socket;
		this.nickName = nickName;
	}
	
	@Override
	public void run() {
		try {
			// 서버에서 넘어온 데이터를 받아온다.
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while(true) {
				// 서버에서 data가 넘어올 때 blocking이 해제된다.
				String msg = bufferedReader.readLine();
				
				if(msg.equals(" ")) {
					System.out.println("접속이 종료되었습니다.");
					socket.close();
					System.exit(0);
				}
				
				System.out.println(">>" + msg);
			}
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("접속이 종료되었습니다.");
		} finally {
			try {
				if(socket != null && socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
