package SH;

import java.util.Comparator;

public class LinkedList<E> {
	// 노드
	class Node<E> {
		private E data;				// 데이터
		private Node<E> next;		// 다음 노드를 참조(뒤쪽 포인터)
		
		// 생성자
		Node (E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head;			// 머리 노드
	private Node<E> crnt;			// 선택 노드, 현재 선택한 노드를 가리킴.
	
	public LinkedList() {
		head = crnt = null;
	}
	
	// 노드 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;			// 현재 스캔 중인 노드
		
		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {	// 검색 성공
				crnt = ptr;
				return ptr.data;
			}

			ptr = ptr.next;			// 다음 노드를 선택
		}

		return null;				// 검색 실패
	}
	
	// 머리에 노드 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head;			// 삽입 전의 머리 노드
		head = crnt = new Node<E>(obj, ptr);	// 새로 삽입한 노드의 데이터는 obj 가 되고 뒤쪽 포인터(ptr.next)가 가리키는 곳은 ptr(기존의 머리노드, head) 이 됨.
	}
	
	// 꼬리에 노드 삽입
	public void addLast(E obj) {
		if (head == null) {
			addFirst(obj);
		} else {
			Node<E> ptr = head;
			
			while (ptr.next != null) {			// while 문 종료 시, ptr 은 꼬리 노드를 가리킴.
				ptr = ptr.next;
			}
			
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	
	// 머리 노드를 삭제
	public void removeFirst() {
		if (head != null) {
			head = crnt = head.next;
		}
	}
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		if (head != null) {
			if (head.next == null) {			// 노드가 하나만 있으면
				removeFirst();					// 머리 노드를 삭제
			} else {
				Node<E> ptr = head;				// 스캔 중인 노드
				Node<E> pre = head;				// 스캔 중인 노드의 앞쪽 노드

				while (ptr.next != null) {		// while 문 종료 시, ptr은 꼬리 노드를 가리키고 pre는 꼬리로부터 두번째 노드를 가리킴
					pre = ptr;
					ptr = ptr.next;
				}
				
				pre.next = null;				// pre는 삭제 후의 꼬리 노드
				crnt = pre;
			}
		}
	}
	
	// 노드 p를 삭제
	public void remove(Node p) {
		if (head != null) {
			if (p == head) {
				removeFirst();
			} else {
				Node<E> ptr = head;
				
				while (ptr.next != p) {			// while 문이 종료된 후 ptr이 참조하는 곳은 삭제할 노드의 앞쪽 노드.
					ptr = ptr.next;
					
					if (ptr == null) {
						return;					// p가 리스트에 없음.
					}
				}
				
				ptr.next = p.next;				// while 문이 종료되고 삭제할 노드(p)의 뒤쪽 포인터(p.next) 를 앞쪽 포인터(ptr.next)에 대입하여 앞쪽포인터가 참조하는 곳을 삭제할 데이터의 다음 데이터로 변경
				crnt = ptr;
			}
		}
	}
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	// 모든 노드를 삭제
	public void clear() {
		while (head != null) {
			removeFirst();
		}
		
		crnt = null;
	}
	
	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if (crnt == null || crnt.next == null) { // crnt == null 이면 노드에 데이터가 없는것이고, crnt.next == null 이면 꼬리노드이므로 선택노드를 하나 뒤쪽으로 옮길 수 없음
			return false;
		}
		
		crnt = crnt.next;
		return true;
	}
	
	// 선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == null) {
			System.out.println("선택한 노드가 없습니다.");
		} else {
			System.out.println(crnt.data);
		}
	}
	
	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;
		
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
}
