package SH;

import java.util.Scanner;

public class HeapSort {
	public static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	// a[left] ~ a[right] 를 힙으로 만듭니다.
	public static void downHeap(int[] a, int left, int right) {
		int temp = a[left];		// 루트
		int child;				// 큰 값을 가진 노드
		int parent;				// 부모

		System.out.println("left : " + left + ", right : " + right);

		for (parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1;							// 왼쪽 자식
			int cr = cl + 1;									// 오른쪽 자식
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl;	// 큰 값을 가진 노드를 자식에 대입

			System.out.println("cl : " + cl + " cr : " + cr + " child : " + child);
			System.out.println("parent : " + parent + ", temp : " + temp + ", a[" + child + "] : " + a[child]);
			System.out.println();

			if (temp >= a[child]) {
				break;
			}
			
			a[parent] = a[child];
		}
		
		a[parent] = temp;
	}
	
	// 힙 정렬
	public static void heapSort(int[] a, int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {				// a[i] ~ a[n-1] 을 힙으로 만들기
			downHeap(a, i, n - 1);
		}
		
		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i);										// 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
			downHeap(a, 0, i - 1);								// a[0] ~ a[i-1] 을 힙으로 만듦.
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("힙 정렬");
		System.out.print("요솟수 : ");
		int nx = scan.nextInt();
		int[] x = new int[nx];
		
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = scan.nextInt();
		}
		
		heapSort(x, nx);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] = " + x[i]);
		}
	}
}
