package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

//https://www.acmicpc.net/problem/1406
public class Baekjoon_1406 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Character> lstack = new Stack<>();
		Stack<Character> rstack = new Stack<>();
		
		String str = scan.next();
		int num = scan.nextInt();
		scan.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			lstack.push(str.charAt(i));
		}
		
		while (num-- > 0) {
			String nextStr = scan.nextLine();
			
			if (nextStr.equals("L")) {
				if (!lstack.isEmpty()) {
					rstack.push(lstack.pop());				
				}
			} else if (nextStr.equals("D")) {
				if (!rstack.isEmpty()) {
					lstack.push(rstack.pop());
				}
			} else if (nextStr.equals("B")){
				if (!lstack.isEmpty()) {
					lstack.pop();					
				}
			} else {
				lstack.push(nextStr.split(" ")[1].charAt(0));
			}
		}
		
		while (!lstack.empty()) {
			rstack.push(lstack.pop());
		}
		
		while (!rstack.empty()) {
			System.out.print(rstack.pop());
		}
		
		/*
		String[] str = scan.next().split("");
		int num = scan.nextInt();
		int i = 0;
		int index = str.length;
		scan.nextLine();
		
		LinkedList<String> list = new LinkedList<>();
		for (int j = 0; j < str.length; j++) {
			list.add(str[i]);
		}
		
		while (i < num) {
			String nextStr = scan.nextLine();
			
			if (nextStr.equals("L")) {
				if (index > 0) {
					index--;					
				}
			} else if (nextStr.equals("D")) {
				if (index < list.size()) {
					index++;
				}
			} else if (nextStr.equals("B")){
				if (index > 0) {
					list.remove(index - 1);
					index--;
				}
			} else {
				list.add(index++, nextStr.split(" ")[1]);
			}
			
			i++;
		}
		
		for (String ch : list) {
			System.out.print(ch);
		}
		*/
		
		
	}
}
