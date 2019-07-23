package BaekJoon;

import java.util.Scanner;

public class CharacterStudy {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().toUpperCase();
        boolean flag = true;								// 가장 많이 사용한 단어가 단수인지 복수인지 구분
        int[] mostUsedAlphabet = new int[26];				// 입력되는 문자열 모두 대문자로 변환

        for (int i = 0; i < str.length(); i++) {
        	mostUsedAlphabet[str.charAt(i) - 65] += 1;		// 해당되는 문자가 나올 때마다 1씩 증가
        }

        int max = 0;
        int maxIndex = 0;
        int duplicateMax = 0;

        for (int j = 0; j < mostUsedAlphabet.length; j++) {
        	if (max < mostUsedAlphabet[j]) {				// 가장 큰 값이 계속 업데이트 됨
        		max = mostUsedAlphabet[j];
        		maxIndex = j;
        	} else if (max == mostUsedAlphabet[j]) {
        		duplicateMax = max;							// 최대값이 중복되는지 체크하기 위함
        	}
        }

        if (duplicateMax == max) {
        	flag = false;
        }

        if (flag) {
        	System.out.println((char)(maxIndex + 65));				// 아스키 코드 변환
        } else {
        	System.out.println("?");
        }
    }
}
