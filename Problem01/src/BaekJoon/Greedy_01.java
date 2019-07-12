package BaekJoon;

import java.util.Scanner;

public class Greedy_01 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);

		int input = scan.nextInt();
		int payback = 1000 - input;

		int count = 0;

		/* 
		 * 처음엔 while 문에서 if ~ else 로 나눠줘야겠다고 생각했는데 다시 생각해보니 필요가 없음.
		while (true) {
			if (payback >= 500) {
				count = count + payback/500;
				payback %= 500;
			} else if (payback >= 100 && payback < 500) {
				count = count + payback/100;
				payback %= 100;
			} else if (payback >= 50 && payback < 100){
				count = count + payback/50;
				payback %= 50;
			} else if (payback >= 10 && payback < 50){
				count = count + payback/10;
				payback %= 10;
			} else if (payback >= 5 && payback < 10){
				count = count + payback/5;
				payback %= 5;
			} else {
				count = count + payback;
				break;
			}
		}
		*/
	
		count = count + payback/500;
		payback %= 500;

		count = count + payback/100;
		payback %= 100;

		count = count + payback/50;
		payback %= 50;

		count = count + payback/10;
		payback %= 10;

		count = count + payback/5;
		payback %= 5;

		count = count + payback;
			
		System.out.println(count);
	}
}
