package BaekJoon;

public class SelfNumber {
	public static void main(String[] args) {
		boolean[] isSelfNumber = new boolean[10001]; // for 문을 1부터 시작하므로 배열의 크기를 10001까지
		
		for (int i = 1; i <= 10000; i++) {
			int dn = getDn(i);
			
			if (dn <= 10000) {
				isSelfNumber[dn] = true;
			}
		}
		
		for (int i = 1; i < isSelfNumber.length; i++) {
			if (!isSelfNumber[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static int getDn (int num) {
		int sum = num;
		
		while (num > 0) {
			sum = sum + num % 10;
			num /= 10;
		}
		
		return sum;
	}
}
