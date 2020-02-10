package chat;

import java.io.Writer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatServer {

	private static final int PORT = 8000;
	static List<Writer> listWriters;
	static HashMap<String, Object> map = new HashMap<>();
	static HashMap<Object, Integer> leaderMap = new HashMap<>();

	public static void main(String[] args) {
		
		listWriters = new ArrayList<Writer>();
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("bind " + hostAddress + ":" + PORT);

			while(true) {
				// 클라이언트와 연결된다면 accept() 블로킹이 해제되며 thread를 생성한다.
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters, map, leaderMap).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[server#" + Thread.currentThread().getId() + "]" + log);

	}
}

