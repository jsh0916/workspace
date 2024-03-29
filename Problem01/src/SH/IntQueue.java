package SH;

import java.util.Scanner;

// 링 버퍼로 큐 만들기
public class IntQueue {
	private int max;			// 큐의 용량
	private int front;			// 첫 번째 요소 커서
	private int rear;			// 마지막 요소 커서
	private int num;			// 현재 데이터 수
	private int[] que;			// 큐 본체
	
	// 실행 시 예외 : 큐가 비어 있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() { }
	}
	
	// 실행 시 예외 : 큐가 가득 참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() { }
	}
	
	public IntQueue (int capacity) {
		num = front = rear = 0;
		max = capacity;
		
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	// 큐에 데이터를 인큐
	public int enque (int x) throws OverflowIntQueueException {
		if (num >= max) {
			throw new OverflowIntQueueException();
		}
		
		que[rear++] = x;
		num++;
		
		if (rear == max) {
			rear = 0;
		}
		
		return x;
	}
	
	// 큐에서 데이터를 디큐
	public int deque () throws EmptyIntQueueException {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		
		int x = que[front++];
		num--;
		
		if (front == max) {
			front = 0;
		}
		
		return x;
	}
	
	// 큐에서 데이터를 피크 (프런트 데이터를 봄)
	public int peek() throws EmptyIntQueueException {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		
		return que[front];
	}
	
	// 큐에서 x를 검색하여 인덱스를 반환 (찾지못하면 -1)
	public int indexOf (int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x) {
				return i;
			}
		}
		
		return -1;
	}
	
	// 큐를 비움
	public void clear() {
		num = front = rear = 0;
	}
	
	// 큐의 용량을 반환
	public int capacity() {
		return max;
	}
	
	// 큐에 쌓여 있는 데이터 수를 반환
	public int size() {
		return num;
	}
	
	// 큐가 비어 있나요?
	public boolean isEmpty() {
		return num <= 0;
	}
	
	// 큐가 가득 찼나요?
	public boolean isFull() {
		return num >= max;
	}
	
	// 큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
	public void dump() {
		if (num <= 0) {
			System.out.println("큐가 비어 있습니다.");
		} else {
			for (int i = 0; i < num; i++) {
				System.out.println(que[(i + front) % max] + " ");
			}
			
			System.out.println();
		}
	}
}

class IntQueueTester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		IntQueue s = new IntQueue(64);
		
		while (true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1) 인큐	(2) 디큐		(3) 피크 		(4) 덤프		(0) 종료 : ");
			
			int menu = scan.nextInt();
			if (menu == 0)
				break;
			
			int x;
			switch (menu) {
				case 1:		// 인큐
					System.out.print("데이터 : ");
					x = scan.nextInt();
					try {
						s.enque(x);
					} catch (IntQueue.OverflowIntQueueException e) {
						System.out.println("큐가 가득찼습니다.");
					}
					
					break;
				case 2:		// 디큐
					try {
						x = s.deque();
						System.out.println("디큐한 데이터는 " + x + " 입니다.");						
					} catch (IntQueue.EmptyIntQueueException e) {
						System.out.println("큐가 비어 있습니다.");
					}
					
					break;
				case 3:		// 피크
					try {
						x = s.peek();
						System.out.println("peek 한 데이터는 " + x + " 입니다.");
					} catch (IntQueue.EmptyIntQueueException e) {
						System.out.println("큐가 비어 있습니다.");
					}
					
					break;
				case 4:		// 덤프
					s.dump();
					break;
			}
		}
	}
}
