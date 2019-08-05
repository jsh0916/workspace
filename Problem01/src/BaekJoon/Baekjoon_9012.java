package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class Baekjoon_9012 {
	/*
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
	*/
	
	public static String isValid(String s) {
        s = s.trim();
        int n = s.length();
        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '(') {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            if (cnt < 0) {
                return "NO";
            }
        }
        if (cnt == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            System.out.println(isValid(sc.nextLine()));
        }
    }
}
