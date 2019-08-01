package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon_14888 {
	static boolean next_permutation(int[] b) {
		int i = b.length - 1;
		while (i > 0 && b[i - 1] >= b[i]) {
			i--;
		}
		
		if (i <= 0) {
			return false;
		}
		
		int j = b.length - 1;
		while (b[i - 1] >= b[j]) {
			j--;
		}
		
		int temp = b[i - 1];
		b[i - 1] = b[j];
		b[j] = temp;
		
		j = b.length - 1;
		while (i < j) {
			temp = b[i];
			b[i] = b[j];
			b[j] = temp;
			
			i++;
			j--;
		}
		
		return true;
	}
	
	static int calc(int[] a, int[] b) {
		int n = a.length;
		int ans = a[0];
		
		for (int i = 1; i < n; i++) {
			if (b[i - 1] == 0) {
				ans += a[i];
			} else if (b[i - 1] == 1) {
				ans -= a[i];
			} else if (b[i - 1] == 2) {
				ans *= a[i];
			} else {
				ans /= a[i];
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		
		int[] b = new int[n - 1];
		int m = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = scan.nextInt();
			
			for (int k = 0; k < cnt; k++) {
				b[m++] = i;
			}
		}
		
		Arrays.sort(b);
		
		ArrayList<Integer> result = new ArrayList<>();
		do {
			int temp = calc(a,b);
			result.add(temp);
		} while (next_permutation(b));
		
		System.out.println(Collections.max(result));
		System.out.println(Collections.min(result));
		
	}
}