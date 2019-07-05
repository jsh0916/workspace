package BaekJoon;

public class Hansoo {
	public static void main(String[] args) {
		int num = 1000;
		int count = Calc(num);
		
		System.out.println(count);
	}
	
	public static int Calc (int num) {
		int count = 0;
		
		if (num < 100) {
			count = num;
		} else {
			count = 99;
			
			for (int i = 100; i <= num; i++) {
				int cc = i;
				int num1 = cc%10;
				cc /= 10;
				
				int num2 = cc%10;
				int num3 = cc/10;
				
				System.out.println("num1 : " + num1 + " num2 : " + num2 + " num3 : " + num3);
				
				if ((num3 - num2) == (num2 - num1)) {
					count++;
				}			
			}
		}
		
		return count;
	}
}
