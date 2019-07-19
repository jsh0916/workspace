package SH;

import java.util.Scanner;

/*
 * 패턴 안에서 중복되는 문자의 나열을 먼저 찾음. 이 과정에서 KMP법을 사용
 * 패턴 안에서 중복되는 문자의 나열을 찾기 위해 패턴끼리 겹쳐놓고 생각.
 * 일명 건너뛰기 표(?) 를 만들어서 몇 번째 문자부터 다시 검색할지에 대한 값을 미리 표를 만들어 놓음. 
 * ex) ABCBAD
 * 	    ABCBAD
 * */
public class KMPmatch {
	public static int kmpMatch (String txt, String pat) {
		int pt = 1;									// txt 커서
		int pp = 0;									// pat 커서
		int[] skip = new int[pat.length() + 1];		// 건너뛰기 표

		// 건너뛰기 표 만들기
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (pat.charAt(pt) == pat.charAt(pp)) {
				skip[++pt] = ++pp;
			} else if (pp == 0) {
				skip[++pt] = pp;
			} else {
				pp = skip[pp];
			}
		}
		
		// 검색
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0) {
				pt++;
			} else {
				pp = skip[pp];
			}
		}
		
		if (pp == pat.length()) {
			return pt - pp;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("텍스트：");
		String s1 = stdIn.next(); // 텍스트용 문자열

		System.out.print("패턴：");
		String s2 = stdIn.next(); // 패턴용 문자열

		int idx = kmpMatch(s1, s2); // 문자열 s1에서 문자열 s2를 KMP법으로 검색

		if (idx == -1) {
			System.out.println("텍스트에 패턴이 없습니다.");			
		}
		else {
			int len = 0;
			for (int i = 0; i < idx; i++) {
				len += s1.substring(i, i + 1).getBytes().length;				
			}
			len += s2.length();

			System.out.println((idx + 1) + "번째 문자와 일치합니다.");
			System.out.println("텍스트：" + s1);
			System.out.printf(String.format("패턴：%%%ds\n", len), s2);
		}
	}
}
