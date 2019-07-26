package BaekJoon;

// 에라토스테네스의체
public class SieveOfEratosthenes {
	public static void main(String[] args) {
		int[] prime = new int[100];			// 소수 저장
		int pn = 0;							// 소수의 개수
		boolean[] check = new boolean[101];	// 지워졌으면 true, 안지워졌으면 false
		int n = 100;						// 100까지 소수
		
		for (int i = 2; i <= n; i++) {
			if (check[i] == false) {
				prime[pn++] = i;
				
				for (int j = i * 2; j <= n; j += i) {
					check[j] = true;
				}
			}
		}
		
		System.out.println("100까지 소수의 개수 : " + pn);
	}
}
