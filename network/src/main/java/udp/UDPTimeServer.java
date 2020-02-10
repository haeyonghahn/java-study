package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {

	private static final int PORT = 7000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			// 1. socket 생성
			socket = new DatagramSocket(PORT);

			while(true) {

				// 2. 데이터 수신
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket);	// blocking, 데이터가 넘어오면 해제된다.

				byte[] data = receivePacket.getData();	// 데이터 받아오기
				int length = receivePacket.getLength();	// 데이터의 길이
				String message = new String(data, 0, length, "UTF-8");

				if("".equals(message)) {
					System.out.println("[server] received:" + message);
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
					String str = format.format(new Date());
					byte[] time = str.getBytes("UTF-8");
					
					// 3. 데이터 송신
					// byte[] sendData = message.getBytes("UTF-8");
					DatagramPacket sendPacket = new DatagramPacket(time, time.length, receivePacket.getAddress(), receivePacket.getPort());
					socket.send(sendPacket);
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(socket != null && !socket.isClosed())
				socket.close();
		}
	}

}
