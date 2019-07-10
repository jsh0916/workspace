package Chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
	public static void main (String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();

			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
			
			byte[] bytes = null;
			String message = null;
			
			// 1. 클라이언트가 먼저 "hello server" 를 서버로 보낸다.
			OutputStream os = socket.getOutputStream();
			message = "hello server";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			
			System.out.println("[데이터 보내기 성공]");
			
			// 4. 클라이언트가 서버에서 보낸 데이터를 받는다.
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String (bytes, 0, readByteCount, "UTF-8"); // 바이트 배열을 문자열로 변환
			
			System.out.println("[데이터 받기 성공] : " + message);
			
			os.close();
			is.close();
		} catch (Exception e) {
			
		}
		
		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				
			}
		}
	}
}
