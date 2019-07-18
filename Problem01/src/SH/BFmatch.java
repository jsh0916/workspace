package SH;

import java.util.Scanner;

public class BFmatch {
	// 브루트-포스법으로 문자열을 검색하는 method
	public static int bfMatch(String txt, String pat) {
		int pt = 0;							// txt 커서
		int pp = 0;							// pattern 커서
		int count = 0;
		
		while (pt != txt.length() && pp != pat.length()) {
			if (pp == 0 || pp == pat.length()) {
				System.out.print(pt);
				count++;
			} else {
				System.out.print(" ");
			}

			System.out.println(" " + txt);
			System.out.print(" ");

			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;

				for (int i = 0; i < pt; i++) {
					System.out.print(" ");
				}

				System.out.println("+");

				for (int i = 0; i <= count; i++) {
					System.out.print(" ");
				}

				System.out.print(pat);
			} else {
				for (int i = 0; i <= pt; i++) {
					System.out.print(" ");
				}

				System.out.println("|");

				for (int i = 0; i <= count; i++) {
					System.out.print(" ");
				}

				System.out.print(pat);

				pt = pt - pp + 1;
				pp = 0;
			}
			
			System.out.println();
		}
		
		if (pp == pat.length()) {
			return pt - pp;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = scan.next();			// 텍스트용 문자열
		
		System.out.print("패턴 : ");
		String s2 = scan.next();			// pattern용 문자열
		
		int idx = bfMatch(s1, s2);			// 문자열 s1에서 문자열 s2를 검색
		
		if (idx == -1) {
			System.out.println("텍스트에 패턴이 없습니다.");
		} else {
			// 일치하는 문자 바로 앞까지의 길이를 구함
			int len = 0;
			
			for (int i = 0; i < idx; i++) {
				len += s1.substring(i, i+1).getBytes().length;
			}
			
			len += s2.length();
			
			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
		}
	}
}
