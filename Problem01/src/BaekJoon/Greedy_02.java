package BaekJoon;

import java.util.Scanner;

public class Greedy_02 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt();
		int money = scan.nextInt();
		int[] arr_num = new int[num];
		int count = 0;
		
		for (int i = 0; i < num; i++) {
			arr_num[i] = scan.nextInt();
		}
		
		for (int i = num - 1; i > 0; i--) {
			count = count + money / arr_num[i];
			money %= arr_num[i];
		}
		
		System.out.println(count + money);
	}
}
