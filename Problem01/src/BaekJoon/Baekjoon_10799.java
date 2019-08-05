package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/10799
public class Baekjoon_10799 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		
		String str = scan.next();
		int i = 0;
		int count = 0;
		
		while (i < str.length()) {
			if (str.charAt(i) == '(') {
				stack.push(i);
			} else {
				int index = (int) stack.pop();
				
				if ((index + 1) == i) {
					count += stack.size();
				} else {
					count += 1;
				}
			}
			
			i++;
		}
		
		System.out.println(count);
	}
}
