package Chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
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
	
	////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 클라이언트별로 고유한 데이터를 저장 및 연결 수락 시 마다 Client 인스턴스 생성
	 * */
	
	class Client {
		Socket socket;
		
		Client(Socket socket) {
			this.socket = socket;
			receive();
		}

		// 데이터 받음
		void receive() {
			Runnable runnable = new Runnable( ) {
				@Override
				public void run() {
					try {
						while (true) {
							byte[] byteArr = new byte[100];
							
							InputStream inputStream = socket.getInputStream();

							// 클라이언트가 비정상 종료를 했을 경우 IOException 발생
							int readByteCount = inputStream.read(byteArr);

							// 클라이언트가 정상적으로 Socket의 close()를 호출했을 경우
							if (readByteCount == -1) {
								throw new IOException();
							}
							
							String message = "[요청 처리 : " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName() + "]";
							Platform.runLater(() -> displayText(message));
							
							String data = new String(byteArr, 0, readByteCount, "UTF-8");
							
							for (Client client : connections) {
								client.send(data);
							}
						}
					} catch (Exception e) {
						try {
							connections.remove(Client.this);
							String message = "[클라이언트 통신 안됨 : " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName() + "]";
							Platform.runLater(() -> displayText(message));
							socket.close();
						} catch (IOException e2) {
							
						}
					}
				}
			};

			executorService.submit(runnable);					// 스레드풀의 작업 스레드에서 연결 수락 작업을 처리하기 위해 submit() 호출		
		}

		// 데이터 전송
		void send(String data) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						byte[] byteArr = data.getBytes("UTF-8");
						OutputStream outputStream = socket.getOutputStream();
						outputStream.write(byteArr);
						outputStream.flush();
					} catch (Exception e) {
						try {
							String message = "클라이언트 통신 안됨 : " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName() + "]";
							Platform.runLater(() -> displayText(message));
							connections.remove(Client.this);
							socket.close();
						} catch (IOException e2) {
							
						}
					}
				}
			};

			executorService.submit(runnable);					// 스레드풀의 작업 스레드에서 연결 수락 작업을 처리하기 위해 submit() 호출
		}
	}

	// UI 생성코드
	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	Button btnStartStop;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction(e->{
			if (btnStartStop.getText().equals("start")) {
				startServer();
			} else if (btnStartStop.getText().equals("stop")){
				stopServer();
			}
		});
		root.setBottom(btnStartStop);
		
		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest(event->stopServer());
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
