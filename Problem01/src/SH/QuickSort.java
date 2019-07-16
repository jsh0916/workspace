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
	/*
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
	*/
	
	// Recursive
	/*
	public static void quickSort (int[] x, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = x[(left + right) / 2];
		
		System.out.printf("a[%d] ~ a[%d] : {", left, right);
		for (int i = left; i < right; i++) {
			System.out.printf("%d , ", x[i]);
		}
		System.out.printf("%d}\n", x[right]);
		
		do {
			while (x[pl] < pivot) {
				pl++;
			}
			
			while (x[pr] > pivot) {
				pr--;
			}
			
			if (pl <= pr) {
				swap (x, pl++, pr--);				
			}
		} while (pl <= pr);
		
		if (left < pr) {
			quickSort (x, left, pr);
		}
		
		if (pl < right) {
			quickSort (x, pl, right);			
		}
	}
	*/
	
	// Non-Recursive
	public static void quickSort(int[] x, int left, int right) {
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);
	
		lstack.push(left);
		rstack.push(right);
		
		System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, right);
		System.out.print("Lstack:");
		lstack.dump();
		System.out.print("Rstack:");
		rstack.dump();
		
		while (lstack.isEmpty() != true) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int pivot = x[(left + right)/2];
			
			System.out.printf("스택에서 분할하는 문제를 꺼냈습니다.a[%d]~a[%d]를 분할합니다.\n", left, right);

			do {
				while (x[pl] < pivot) {
					pl++;
				}
				
				while (x[pr] > pivot) {
					pr--;
				}
				
				if (pl <= pr) {
					swap(x, pl++, pr--);					
				}
			} while (pl <= pr);

			/*
			 * 요소의 개수가 적은 배열일수록 적은 횟수로 분할을 종료할 수 있다.
			 * 따라서 요소의 개수가 많은 그룹을 먼저나누기보단 요소의 개수가 적은 그룹을 먼저 나누면
			 * 스택에 쌓여 있는 데이터의 최대 개수를 줄일 수 있다.
			 * */
			if (pr - left < right - pl) {
				int temp;

				temp = left;
				left = pl;
				pl = temp;

				temp = right;
				right = pr;
				pr = temp;
			}

			if (left < pr) {
				lstack.push(left);
				rstack.push(pr);
				
				System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, pr);
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
			}
			
			if (pl < right) {
				lstack.push(pl);
				rstack.push(right);
				
				System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", pl, right);
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
			}
		}
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

		// partition(x, count);			--> pivot 을 기준으로 하위/상위 배열을 만듦. 
		quickSort(x, 0, count - 1);
		
		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < count; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
