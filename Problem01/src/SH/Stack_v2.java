package SH;

import java.util.EmptyStackException;

// 객체를 만들 때 데이터타입을 명시
class Stack<T> {
	class Node<T> {
		private T data;
		private Node<T> next;			// stack 에서 다음 data의 주소를 저장.
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	// 스택은 맨위에 올라가있는 주소만 알면 되므로 멤버변수 선언.
	private Node<T> top;
	
	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		
		T item = top.data;
		top = top.next;					// pop 을 하면 top.next 에는 top - 1 의 객체가 들어있으므로 top 에 top.next 의 값을 대입.
		
		return item;
	}
	
	public void push(T item) {
		Node<T> t = new Node<T>(item);
		t.next = top;					// 기존의 top 에 있던 값을 새로운 객체 t 의 t.next 에 대입
		top = t;						// 그리고 새로 들어온 t 의 값을 top 으로.
	}
	
	public T peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
public class Stack_v2 {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
	}
}
