package SH;

import java.util.Scanner;

public class QuickSort {
	// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
	public static void swap (int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	// 배열을 나눔
	public static void partition (int[] a, int n) {
		int pl = 0;			// 왼쪽 커서
		int pr = n - 1;		// 오른쪽 커서
		int pivot = a[n / 2];	// pivot(가운데 위치의 값)
		
		// 배열 a[] 를 pivot 을 기준으로 나눔
		do {
			while (a[pl] < pivot) {
				pl++;
			}
			while (a[pr] > pivot) {
				pr--;
			}
			
			swap (a, pl++, pr--);
		} while (pl <= pr);
		
		System.out.println("피벗의 값은 " + pivot + "입니다.");
		
		System.out.println("피벗 이하의 그룹");
		for (int i = 0; i <= pl - 1; i++) {		// pl, pr 이 교차할때 까지 do ~ while 문을 실행하므로 피벗 이하의 그룹을 표시하기 위해선 index 의 값을 pl - 1 까지.
			System.out.print(a[i] + " ");		// a[0] ~ a[pl - 1]
		}
		
		System.out.println();
		
		
		if (pl > pr + 1) {
			System.out.println("피벗과 일치하는 그룹");
			for (int i = pr + 1; i <= pl - 1; i++) {
				System.out.print(a[i] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println("피벗 이상의 그룹");
		for (int i = pr + 1; i < n; i++) {
			System.out.print(a[i] + " ");		// a[pr + 1] ~ a[n - 1]
		}
		
		System.out.println();
	}
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("배열을 나눕니다.");
		System.out.print("요솟수 : ");
		int count = scan.nextInt();
		int[] x = new int[count];
		
		for (int i = 0; i < count; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = scan.nextInt();
		}

		partition(x, count);
	}
}
