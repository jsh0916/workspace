package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_9012 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		
		int num = scan.nextInt();
		
		for (int i = 0; i < num; i++) {
			String bracket = scan.next();
			String[] arr = bracket.split("");
			int j = 0;

			for (; j < arr.length; j++) {
				if (arr[j].equals("(")) {
					stack.push(arr[j]);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();						
					} else {
						break;
					}
				}
			}

			if (j == arr.length && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

			stack.clear();
		}
	}
}
