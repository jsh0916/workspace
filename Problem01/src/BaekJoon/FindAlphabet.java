package BaekJoon;

import java.util.Scanner;

public class FindAlphabet {
	public static void main (String[] args) {
		/*
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String[] arr_alpha = alphabet.split("");
			
			Scanner scan = new Scanner(System.in);
			String input = scan.next();
			String[] arr_input = input.split("");
			
			String[] answer = new String[arr_alpha.length];
			
			for (int i = 0; i < answer.length; i++) {
				answer[i] = -1 + "";
			}
			
			for (int i = 0; i < arr_input.length; i++) {
				for (int j = 0; j < arr_alpha.length; j++) {
					if (arr_input[i].equals(arr_alpha[j]) && answer[j].equals("-1")) {
						answer[j] = i + "";
					}
				}
			}
			
			for (String s : answer) {
				System.out.print(s + " ");
			}
		*/

		/*
		 * indexOf를 사용하면 해당 문자가 처음으로 등장하는 위치를 리턴한다. 만약 해당 문자가 문자열에 없으면 -1을 리턴한다.
		 * */
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        for (char c = 'a' ; c <= 'z' ; c++)
               System.out.print(input.indexOf(c) + " ");
	}
}
