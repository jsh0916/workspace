package BaekJoon;

import java.util.Scanner;

public class Baekjoon_10971 {
	public static boolean next_permutation(int[] arr_d) {
		int i = arr_d.length - 1;
		while (i > 0 && arr_d[i - 1] >= arr_d[i]) {
			i--;
		}
		
		if (i <= 0) return false;
		
		int j = arr_d.length - 1;
		while (arr_d[i - 1] >= arr_d[j]) {
			j--;
		}
		
		int temp = arr_d[i - 1];
		arr_d[i - 1] = arr_d[j];
		arr_d[j] = temp;
		
		j = arr_d.length - 1;
		while(i < j) {
			temp = arr_d[i];
			arr_d[i] = arr_d[j];
			arr_d[j] = temp;
			
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int[] arr_d = new int[num];
		int[][] arr = new int[num][num];
		
		for (int i = 0; i < num; i++) {
			arr_d[i] = i;
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		do {
			if (arr_d[0] != 0) break;	// 1,2,3,4 나 2,3,4,1 3,4,1,2 4,1,2,3 은 전부 같음. 따라서 처음 시작이 1인것만 검사하고 나머진 안해도 됨.
			boolean ok = true;
			int sum = 0;
			for (int i = 0; i < num - 1; i++) {
				if (arr[arr_d[i]][arr_d[i+1]] == 0) {
					ok = false;
				} else {
					sum += arr[arr_d[i]][arr_d[i+1]];
				}
			}
			
			if (ok && arr[arr_d[num - 1]][arr_d[0]] != 0) {
				sum += arr[arr_d[num - 1]][arr_d[0]];
				
				if (ans > sum) {
					ans = sum;
				}
			}
		} while (next_permutation(arr_d));
		
		System.out.println(ans);
	}
}
