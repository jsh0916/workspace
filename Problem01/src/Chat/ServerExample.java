package Chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main (String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001)); 
			// ServerSocket 생성 --> 클라이언트의 연결 요청을 기다리면서 연결 수락 담당
			// Socket --> 연결된 클라이언트와 통신
			
			while (true) {
				System.out.println("[연결 기다림]");
				
				Socket socket = serverSocket.accept(); // 클라이언트 연결 수락
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // 연결된 클라이언트의 IP와 포트정보를 알려줌.
				System.out.println("[연결 수락함] " + isa.getHostName());
			
				byte[] bytes = null;
				String message = null;
				
				// 2. 서버가 클라이언트에서 보낸 "hello server" 메세지를 받음
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String (bytes, 0, readByteCount, "UTF-8");
				System.out.println("[데이터 받기 성공] : " + message);
				
				// 3. 서버에서 클라이언트로 "hello client" 메세지를 보냄
				OutputStream os = socket.getOutputStream();
				message = "hello client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");
				
				is.close();
				os.close();
				socket.close();
				
				if (!serverSocket.isClosed()) {
					try {
						serverSocket.close();
					} catch (IOException e) {
						
					}
				}
			}
		} catch (Exception e) {
			
		}
		
		if (!serverSocket.isClosed()) {
			try {
				serverSocket.close();				
			} catch (IOException e) {

			}
		}
	}
}
