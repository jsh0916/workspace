package BaekJoon;

import java.util.Scanner;

public class Baekjoon_2193 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		long[] d = new long[num + 1];
		d[1] = 1;
		
		if (num >= 2) {
			d[2] = 1;
		}
		
		for (int i = 3; i <= num; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		
		System.out.println(d[num]);
	}
}
