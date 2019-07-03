package SH;

import java.util.Scanner;

public class SeqSearch {
	/*
	 * 기본 선형 검색
	 * 
	public static int seqSearch (int[] x, int num, int key) {
		for (int i = 0; i < num; i++) {
			if (x[i] == key) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("요솟수");
		int num = scan.nextInt();
		int[] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + " ] : ");
			x[i] = scan.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = scan.nextInt();
		
		int idx = seqSearch (x, num, key);
		
		if (idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
		}
	}
	*/
	
	/*
	 * 보초법
	 * */
	public static int seqSearch (int[] x, int num, int key) {
		int i = 0;
		
		x[num] = key;			// 보초 추가
		
		while (true) {
			if (x[i] == key) {
				break;
			}
			
			i++;
		}
		
		return i == num ? -1 : i;
	}
	
	/*
	 * 요솟수가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞에서부터 순서대로 저장하고,
	 * 일치한 요솟수를 반환하는 메서드를 작성하세요. 예를 들어 요솟수가 8인 배열 a의 요소가 {1, 9, 2, 9, 4, 6, 7, 9}이고
	 * key가 9면 배열 idx에 {1, 3, 7}을 저장하고 3을 반환합니다.
	 * */
	public static int searchIdx (int[] a, int n, int key, int[] idx) {

		int j = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == key) {
				idx[j] = i;
				j++;
			}
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (idx[i] != 0) {
				System.out.print(idx[i] + " ");
				count++;
			}
		}
		
		System.out.println();
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("요솟수");
		int num = scan.nextInt();
		int[] x = new int[num + 1];
		int[] keyCount = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + " ] : ");
			x[i] = scan.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = scan.nextInt();
		
		int idx = seqSearch (x, num, key);
		int searchIndex = searchIdx (x, num, key, keyCount);
		
		/*
		if (idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
		}
		*/
		
		System.out.println(searchIndex);
	}
}
