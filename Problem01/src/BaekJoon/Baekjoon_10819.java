package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

// 	https://www.acmicpc.net/problem/10819

public class Baekjoon_10819 {
	/*public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int[] arr = new int[num];
		
		for (int i = 0; i < num; i++) {
			arr[i] = scan.nextInt();
		}

		int sum = 0;
		int max = 0;
		
		Arrays.sort(arr);
		for (int k = 0; k < num - 1; k++) {
			sum += Math.abs(arr[k] - arr[k + 1]);
		}
		max = sum;

		for (int a = 0; a < num; a++) {
			for (int b = a + 1; b < num; b++) {
				sum = 0;

				int temp = arr[a];
				arr[a] = arr[b];
				arr[b] = temp;
				
				for (int k = 0; k < num - 1; k++) {
					sum += Math.abs(arr[k] - arr[k + 1]);
				}
				
				if (max < sum) {
					max = sum;
				}

				Arrays.sort(arr);
			}
		}
		
		System.out.println(max);
	}*/
	public static boolean next_permutation(int[] arr) {
		int i = arr.length - 1;
		while(i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		
		if (i <= 0) {
			return false;
		}
		
		int j = arr.length - 1;
		while(arr[i - 1] >= arr[j]) {
			j--;
		}
		
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;
		
		j = arr.length - 1;
		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			i++;
			j--;
		}
		
		return true;
	}
	
	public static int absCalculator(int[] arr) {
		int sum = 0;
		
		for (int k = 0; k < arr.length - 1; k++) {
			sum += Math.abs(arr[k] - arr[k + 1]);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int[] arr = new int[num];
		
		for (int i = 0; i < num; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		int sum = 0;
		
		do {
			int temp_sum = absCalculator(arr);
			sum = Math.max(sum, temp_sum);
		} while (next_permutation(arr));
		
		System.out.println(sum);
	}
}
