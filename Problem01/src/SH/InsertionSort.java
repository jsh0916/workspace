package SH;

import java.util.Scanner;

public class InsertionSort {
	public static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			int temp = a[i];

			for (j = i; j > 0 && a[j - 1] > temp; j--) {
				a[j] = a[j-1];
			}

			a[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("삽입 정렬");
		System.out.print("요솟수 : ");
		int nx = scan.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = scan.nextInt();
		}

		insertionSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] : " + x[i]);
		}		
	}
}
