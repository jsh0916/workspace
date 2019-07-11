package BaekJoon;

import java.util.Scanner;

public class CharacterRepeat {
	/*
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		String arrResult = "";
		
		for (int i = 0; i < testCase; i++) {
			int repeatNum = scan.nextInt();
			String repeat = scan.next();

			arrResult += Result(testCase, repeatNum, repeat);
			arrResult += " ";
		}
		
		String[] arrStr = arrResult.split(" ");
		
		for (String str : arrStr) {
			System.out.println(str);
		}
	}
	
	public static String Result (int testCase, int repeatNumber, String repeat) {
		int repeatNum = repeatNumber;
		String sen = repeat;
		String[] arr_sen = sen.split("");
		
		String result = "";
		
		for (int j = 0; j < arr_sen.length; j++) {
			for (int i = 0; i < repeatNum; i++) {
				result += arr_sen[j];
			}
		}
		
		return result;
	}
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int cnt = sc.nextInt();
			String str = sc.nextLine();
			
			String result = "";
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < cnt; k++)
					result += str.charAt(j);
			}

			result = result.replaceAll(" ", "");
			System.out.println(result);
		}
		sc.close();		
	}
}
