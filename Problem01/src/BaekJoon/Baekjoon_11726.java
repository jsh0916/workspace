package BaekJoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11726

public class Baekjoon_11726 {
	/* Top-Down
	public static int[] d;
	
	public static int go (int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		
		if (d[num] > 0) {
			return d[num];
		}
		
		d[num] = go(num - 1) + go(num - 2);
		
		return d[num] % 10007;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		d = new int[num + 1];
		
		System.out.println(go(num));
	}
	*/
	
	// Bottom-Up
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1001];
        d[0] = 1;
        d[1] = 1;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-1] + d[i-2];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
    }
}
