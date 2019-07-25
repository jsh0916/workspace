package BaekJoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class HowManyWord {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        StringTokenizer stk = new StringTokenizer(s, " ");
        System.out.println(stk.countTokens());
	}
}
