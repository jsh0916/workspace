package BaekJoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1463
public class Baekjoon_1463 {
	/* Top-Down 방식
	public static int[] d;
	
	public static int go(int n) {
		if (n == 1) {
			return 0;
		}
		
		if (d[n] > 0) {
			return d[n];
		}
		
		d[n] = go(n - 1) + 1;
		
		if (n % 2 == 0) {
			int temp = go(n/2) + 1;
			
			if (d[n] > temp) {
				d[n] = temp;
			}
		}
		
		if (n % 3 == 0) {
			int temp = go(n/3) + 1;
			
			if (d[n] > temp) {
				d[n] = temp;
			}
		}
		
		return d[n];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		d = new int[n + 1];
		System.out.println(go(n));
	}
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] d = new int[n + 1];
		d[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + 1;
			
			if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
				d[i] = d[i/2] + 1;
			}
			
			if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
				d[i] = d[i/3] + 1;
			}
		}
		
		System.out.println(d[n]);
	}
}
