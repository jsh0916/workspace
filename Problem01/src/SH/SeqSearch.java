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
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("요솟수");
		int num = scan.nextInt();
		int[] x = new int[num + 1];
		
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
}
