package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Localhost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostname = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				System.out.println(address & 0x000000ff);
			}
			
			System.out.println(hostname);
			System.out.println(hostAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
