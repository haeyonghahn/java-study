package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	private static final String SERVER_IP = "0.0.0.0";
	private static final int SERVER_PORT = 8000;

	public static void main(String[] args) {

		Scanner scanner = null;
		Socket socket = null;
		String nickname;
	
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");

			// 4. reader/writer 생성
			// 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 5. join 프로토콜
			System.out.println("==== 도움말 명령어 ====");
			System.out.println("채팅 종료 : quit");
			System.out.println("귓속말 입력 : to '상대방 닉네임' '보낼 메시지'");
			System.out.println("팀장 선택 : leader"); 
			System.out.println("단, 팀장만 추방 기능이 가능합니다.");
			System.out.println("또한, 팀장은 선착순으로 하고싶은 사람이 명령어를 입력하고 \n"
					+ "팀장이 나간 이후 두 번 다시 팀장을 선택할 수 없습니다.");
			System.out.println("추방 : leave '추방시킬 닉네임'");
			System.out.print("닉네임>>");
			nickname = scanner.nextLine();
			System.out.println("접속 완료");
			printWriter.println("join:" + nickname);
			printWriter.flush();

			// 6. ChatClientThread 시작
			new ChatClientThread(socket, nickname).start();

			// 7. 키보드 입력 처리
			while(true) {	
				String input = scanner.nextLine();

				// 8. quit 프로토콜 처리
				// 키보드에서 quit을 입력하면 클라이언트가 종료된다.
				if("quit".equals(input)) {
					break;
				}

				// 상대방과 채팅할 때 "to '상대방 이름' '보낼 메시지'를 입력하면
				// 상대방에게 메시지가 보내진다.
				else if(input.startsWith("to")) {
					printWriter.println("to:" + input);
				}
				// 선착순으로 방장이 되고 싶은 사람이 'leader'라는 명령어 입력 시
				// 방장이 될 수 있다. 단, 방장이 나가면 그 방에는 방장이 없어진다.
				else if(input.equals("leader")) {
					printWriter.println(input);
				}
				// 방장이 가질 수 있는 권한 중 하나로써 방에 있는 팀원을 강퇴시킬 수 있다.
				else if(input.startsWith("leave")) {
					printWriter.println("leave:" + input);
				}
				else {
					// 클라이언트에서 서버로 data를 보낸다.
					printWriter.println("message:" + nickname + ":" + input);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[client#" + Thread.currentThread().getId() + "]" + log);

	}

}
