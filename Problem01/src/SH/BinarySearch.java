package SH;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 이진 검색
public class BinarySearch {
	//요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색
	/*
	static int binSearch (int[] a, int num, int key) {
		int pl = 0;				// 검색 범위의 첫 인덱스
		int pr = num - 1;			// 검색 범위의 끝 인덱스
		
		do {
			int pc = (pl + pr) / 2;
			
			if (a[pc] == key) {
				return pc;
			} else if (a[pc] < key) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		} while (pl <= pr);
		
		return -1;
	}
	*/
	
	static int binSearchX (int[] a, int num, int key) {
		int pl = 0; // 검색범위 맨 앞의 index
		int pr = num - 1; // 검색범위 맨 뒤의 index

		do {
			int pc = (pl + pr) / 2; // 중앙요소의 index
			if (a[pc] == key) {
				for (; pc > pl; pc--) { // key와 같은 맨 앞의 요소를 찾습니다
					if (a[pc - 1] < key) {
						break;
					}
				}
				return pc; // 검색성공
			} else if (a[pc] < key)
				pl = pc + 1; // 검색범위를 앞쪽 절반으로 좁힘
			else {
				pr = pc - 1; // 검색범위를 뒤쪽 절반으로 좁힘
			}
				
		} while (pl <= pr);

		return -1; // 검색실패
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
				
		System.out.print("요솟수 : ");
		int num = scan.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0] :");
		x[0] = scan.nextInt();
		
		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = scan.nextInt();
			} while (x[i] < x[i - 1]);			// 바로 앞의 요소보다 작으면 다시 입력
		}
		
		System.out.print("검색할 값 : ");
		int key = scan.nextInt();
		
		int idx = binSearchX (x, num, key);
		
		if (idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
		}
	}
}
