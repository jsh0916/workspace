package BaekJoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
public class Baekjoon_9095 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int[] arr = new int[num];
		
		for (int i = 0; i < num; i++) {
			int count = 0;
			arr[i] = scan.nextInt();

			for (int l1 = 1; l1 <= 3; l1++) {
				if (l1 == arr[i]) {
					count++;
				}
				for (int l2 = 1; l2 <= 3; l2++) {
					if (l1+l2 == arr[i]) {
						count++;
					}
					for (int l3 = 1; l3 <= 3; l3++) {
						if (l1+l2+l3 == arr[i]) {
							count++;
						}
						for (int l4 = 1; l4 <= 3; l4++) {
							if (l1+l2+l3+l4 == arr[i]) {
								count++;
							}
							for (int l5 = 1; l5 <= 3; l5++) {
								if (l1+l2+l3+l4+l5 == arr[i]) {
									count++;
								}
								for (int l6 = 1; l6 <= 3; l6++) {
									if (l1+l2+l3+l4+l5+l6 == arr[i]) {
										count++;
									}
									for (int l7 = 1; l7 <= 3; l7++) {
										if (l1+l2+l3+l4+l5+l6+l7 == arr[i]) {
											count++;
										}
										for (int l8 = 1; l8 <= 3; l8++) {
											if (l1+l2+l3+l4+l5+l6+l7+l8 == arr[i]) {
												count++;
											}
											for (int l9 = 1; l9 <= 3; l9++) {
												if (l1+l2+l3+l4+l5+l6+l7+l8+l9 == arr[i]) {
													count++;
												}
												for (int l0 = 1; l0 <= 3; l0++) {
													if (l1+l2+l3+l4+l5+l6+l7+l8+l9+l0 == arr[i]) {
														count++;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

			System.out.println(count);
		}
	}
}
