package SH;

import java.util.NoSuchElementException;

//객체를 만들 때 데이터타입을 명시
class Queue<T> {
	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	// Queue 는 앞뒤의 주소를 알고있어야 하므로 first, last 선언.
	private Node<T> first;
	private Node<T> last;
	
	public void add (T item) {
		Node<T> t = new Node<T>(item);
		
		// 마지막 Node 가 있다면 그 뒤에 새로 생성한 Node를 붙임
		if (last != null) {
			last.next = t;
		}
		
		last = t;
		
		if (first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		
		T data = first.data;
		first = first.next;
		
		if (first == null) {
			last = null;
		}
		
		return data;
	}
	
	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}

public class Queue_v2 {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
	}
}
