package SH;

import java.util.LinkedList;

public class HashTable {
	public static void main(String[] args) {
		HashT h = new HashT(3);
		
		h.put("sung", "She is pretty");
		h.put("jin", "She is a model");
		h.put("hee", "She is an angel");
		h.put("min", "She is cute");
		
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
		System.out.println(h.get("jae"));
	}
}

class HashT {
	class Node {											// Hashtable 에 저장할 데이터를 Node에 저장
		String key;											// 검색할 키
		String value;										// 검색결과로 보여줄 값
		
		public Node (String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		String value() {
			return value;
		}
		
		void value (String value) {
			this.value = value;
		}		
	}
	
	LinkedList<Node>[] data;								// 데이터를 저장할 LinkedList 선언

	HashT (int size) {										// Hash 테이블의 크기를 미리 지정
		this.data = new LinkedList[size];
	}
	
	int getHashCode (String key) {							// key 값을 받아서 hashcode 를 return
		int hashcode = 0;
		
		for (char c : key.toCharArray()) {					// 각 문자의 ASCII 값을 가져와서 hashcode 변수에 더함
			hashcode += c;
		}
		
		return hashcode;
	}
	
	int convertToIndex (int hashcode) {						// hashcode 를 배열방의 크기로 나눈 나머지를 index 로 return
		return hashcode % data.length;
	}
	
	Node searchKey (LinkedList<Node> list, String key) {	// index 로 배열방을 찾은 후 배열방에 node가 여러개 존재하는 경우 검색 key 를 가지고 해당 노드를 찾아오는 함수
		if (list == null)
			return null;
		
		for (Node node : list) {
			if (node.key.equals(key)) {
				return node;
			}
		}
		
		return null;
	}
	
	void put (String key, String value) {					// 데이터를 받아서 저장
		int hashcode = getHashCode(key);					// key 를 가지고 hashcode 를 받아옴
		int index = convertToIndex(hashcode);				// 받아온 hashcode를 가지고 배열방 번호를 받아옴
		LinkedList<Node> list = data[index];				// 배열방 번호로 기존 번호방에 있는 데이터를 가지고 옴

		System.out.println(key + ", hashcode(" + hashcode + "), index(" + index + ")");

		if (list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}
		
		Node node = searchKey(list, key);					// 기존 key 로 해당 list 값을 가지고 있는지 확인
		
		if (node == null) {									// node 가 null이면 해당 데이터가 없다는 뜻이고 null이 아니면 데이터를 update
			list.addLast(new Node(key, value));
		} else {
			node.value(value);
		}
	}
	
	String get (String key) {								// key 를 가지고 데이터를 가지고 오는 함수
		int hashcode = getHashCode(key);					// key를 가지고 hashcode 를 받아옴
		int index = convertToIndex(hashcode);				// 받아온 hashcode로 index를 받음
		LinkedList<Node> list = data[index];				// index에서 linkedlist를 가지고옴
		Node node = searchKey(list, key);					// list 안에 해당키를 가진 node를 받아옴
		
		return node == null? "Not found" : node.value();
	}
}
