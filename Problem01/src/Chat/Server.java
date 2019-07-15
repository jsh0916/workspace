package Chat;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Server extends Application {

	ExecutorService executorService;							// 스레드풀
	ServerSocket serverSocket;									// 클라이언트의 연결을 수락
	List<Client> connections = new Vector<Client>();			// 멀티쓰레드를 사용하기위해 Vector 사용

	/*
	 * 실행화면에서 [start] 버튼을 클릭하면 startServer() 호출되고 [start] 버튼은 [stop] 으로 변경
	 * [stop] 버튼을 클릭하면 stopServer() 호출되고 다시 [start] 버튼으로 변경
	 * */

	// 서버 시작 코드
	void startServer() {
		executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()		// CPU 코어의 수만큼 스레드를 만들도록 한다.
		);
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			
			Runnable runnable = new Runnable() {				// 수락 작업 생성
				@Override
				public void run() {
					Platform.runLater(() -> {
						displayText("서버시작");
						btnStartStop.setText("stop");
					});
					
					while (true) {
						try {
							Socket socket = serverSocket.accept();	// 연결 수락
							String message = "[연결 수락 : " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName() + "]";

							Platform.runLater(() -> displayText(message));

							Client client = new Client(socket);
							connections.add(client);				// Client 객체 저장

							Platform.runLater(() -> displayText("[연결 개수" + connections.size() + "]"));
						} catch (Exception e) {
							if (!serverSocket.isClosed()) {
								stopServer();
							}
							
							break;
						}
					}
				}
			};
			
			executorService.submit(runnable);					// 스레드풀의 작업 스레드에서 연결 수락 작업을 처리하기 위해 submit() 호출
		} catch (Exception e) {
			if (!serverSocket.isClosed()) {
				stopServer();
			}
			
			return;
		}
	}
	
	// 서버 종료 코드
	void stopServer() {
		try {
			Iterator<Client> iterator = connections.iterator();
			
			while (iterator.hasNext()) {						// 모든 소켓 닫기
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			
			if (serverSocket != null && !serverSocket.isClosed()) {	// ServerSocket 닫기
				serverSocket.close();
			}
			
			if (executorService != null && !executorService.isShutdown()) {	// ExecutorService 종료
				executorService.shutdown();
			}
			
			Platform.runLater(() -> {
				displayText("[서버 멈춤]");
				btnStartStop.setText("start");
			});
		} catch (Exception e) {

		}
	}

	// UI 생성코드
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
