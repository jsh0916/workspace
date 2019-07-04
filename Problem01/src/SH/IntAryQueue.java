package SH;

public class IntAryQueue {
	private int max;		// 큐 용량
	private int num;		// 현재 데이터 수
	private int[] que;		// 큐 본체
	
	public IntAryQueue (int capacity) {
		num = 0;
		max = capacity;
		
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	// 실행 시 에외 : 큐가 비어 있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {}
	}
	
	// 실행 시 예외 : 큐가 가득 참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	public int enQueue (int x) {
		if (num >= max) {
			throw new OverflowIntQueueException();
		}
		
		que[num++] = x;
		
		return x;
	}
	
	public int deQueue () {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		
		int x = que[0];
		
		for (int i = 0; i < num - 1; i++) {
			que[i] = que[i + 1];
		}
		
		num--;
		
		return x;
	}
	
	// 큐에서 데이터를 peek (프런트 데이터를 봄)
	public int peek() throws EmptyIntQueueException {
		if (num <= 0) {
			throw new EmptyIntQueueException();
		}
		
		return que[num - 1];
	}
	
	// 큐에서 x를 검색하여 인덱스를 반환 (찾지 못하면 -1)
	public int indexOf (int x) {
		for (int i = 0; i < num; i++) {
			if (que[i] == x) {
				return i;
			}
		}
		
		return -1;
	}
	
	// 큐를 비움
	public void clear() {
		num = 0;
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
			System.out.println("큐가 비었습니다.");
		} else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[i] + " ");
			}
			
			System.out.println();
		}
	}
}
