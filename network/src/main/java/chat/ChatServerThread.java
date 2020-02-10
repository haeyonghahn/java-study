package chat;

import java.io.Writer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

// accept를 할 때 클라이언트가 많을 경우 블로킹이 다수가 되므로 Thread로 처리한 것이다.
// 쓰레드 프로그래밍은 task를 나누는 것이 중요하다.
public class ChatServerThread extends Thread {

	private Socket socket = null;
	List<Writer> listWriters = null;
	PrintWriter printWriter = null;
	HashMap<String, Object> map = null;
	HashMap<Object, Integer> leaderMap = null;

	private String nickname = null;
	private static int writerNumber = 0;
	private static int count = 0;

	public ChatServerThread(Socket socket, List<Writer> listWriters, HashMap<String, Object> map,
			HashMap<Object, Integer> leaderMap) {
		this.socket = socket;
		this.listWriters = listWriters;
		this.map = map;
		this.leaderMap = leaderMap;
	}

	@Override
	public void run() {

		BufferedReader bufferedReader = null; 

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			printWriter  = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while(true) {

				// 클라이언트에서 data가 넘어올 때 blocking이 해제된다.
				String data = bufferedReader.readLine();
				System.out.println(data);

				if(data == null) {
					ChatServer.log("클라이언트로부터 연결 끊김");
					doQuit(printWriter);
					break;
				}

				String[] tokens = data.split(":");
				System.out.println(tokens[1]);
				if("join".equals(tokens[0])) {
					writerNumber++;
					map.put(tokens[1], printWriter);
					leaderMap.put(printWriter, writerNumber);
					doJoin(tokens[1], printWriter);
				}
				else if("message".equals(tokens[0])) {
					doMessage(tokens[2]);
				}
				else if("quit".equals(tokens[0])) {
					doQuit(printWriter);
				}
				else if("to".equals(tokens[0])) {
					// tokens[1] : to 박명수 hihi gg
					unicast(tokens[1]);
				}
				else if("leader".equals(tokens[0])) {				
					if(count == 0) {
						leaderMap.put(printWriter, count);
						doLeader();
						count++;
					}
					else {
						count = 1;
						printWriter.println("방장이 이미 설정되어있거나 방장이 나갔습니다.");
						continue;
					}
				}
				else if("leave".equals(tokens[0])) {
					unicast(tokens[1]);
				}
				else {
					ChatServer.log("에러: 알수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	// 방장이 아무도 설정되어 있지 않으면 방장을 설정
	// 이후, leader라는 값이 들어오면 
	private void doLeader() {
		for(Writer writer : listWriters) {
			PrintWriter printWriter = (PrintWriter) writer;
			printWriter.println(this.nickname + "님이 방장으로 설정되었습니다.");
			printWriter.flush();
		}
	}

	private void unicast(String message) throws IOException {
		// data[0] : to/leave, data[1] : 받는 사람 nickname, data[2] : 내용
		String[] data = message.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<data.length; i++) {
			if((i != 0) && i != 1)
				sb.append(data[i] + " ");
		}
		
		if(data[0].equals("to")) {
			PrintWriter printWriter = (PrintWriter) map.get(data[1]);
			printWriter.println(nickname + "님이 " + data[1] + "님에게 귓속말을 보내셨습니다. : " + sb.toString());
			printWriter.flush();
		}
		else if(data[0].equals("leave")) {
			if(leaderMap.get(printWriter) == 0) {
				for(Writer writer : listWriters) {
					if(!writer.equals(map.get(data[1]))) {
						PrintWriter printWriter = (PrintWriter) writer;
						printWriter.println(data[1] + "님이 강퇴당하셨습니다.");
						printWriter.flush();
					}
					else {
						String noting = " ";
						PrintWriter printWriter = (PrintWriter) writer;
						printWriter.println(noting);
						printWriter.flush();
					}
				}
			}
			else {
				printWriter.println("강퇴 기능을 사용하실 수 없습니다.");
			}
		}
	}

	private void doJoin(String nickname, Writer writer) throws IOException {
		this.nickname = nickname;
		String message = nickname + "이(가) 채팅에 참여했습니다.";
		broadcast(message);

		addWriter(writer);

	}

	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}

	// 서버에 연결된 모든 클라이언트들에게 메시지를 전달하기 위한 메소드이다.
	// listWriters 메소드는 채팅 서버에 연결된 모든 클라이언트들을 저장하고 있는 List이다.
	private void broadcast(String message) throws IOException {
		synchronized (listWriters) {
			// for문을 이용하여 클라이언트들에게 메시지를 전달한다.
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(message);
				printWriter.flush();
			}
		}
	}

	private void doMessage(String message) throws IOException {
		String data = nickname + ":" + message;
		broadcast(data);
	}

	private void doQuit(Writer writer) throws IOException {
		removeWriter(writer);
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		listWriters.remove(writer);
	}
}
