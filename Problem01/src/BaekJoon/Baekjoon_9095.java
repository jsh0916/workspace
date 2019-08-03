package BaekJoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
public class Baekjoon_9095 {
	/*
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
	*/
	
	static int go (int sum, int goal) {
        if (sum > goal) {
            return 0;
        } 

        if (sum == goal) {
            return 1;
        } 
        
        int now = 0;
        for (int i = 1; i <= 3; i++) {
        	now += go(sum + i, goal);
        }
        
        return now;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        int[] arr = new int[num];
        
        for (int i = 0; i < num; i++) {
            arr[i] = scan.nextInt();
            int n = go(0, num);
            
            System.out.println(n);
        }
    }
}
