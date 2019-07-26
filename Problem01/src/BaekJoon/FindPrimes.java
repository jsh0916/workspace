package BaekJoon;

import java.util.Scanner;

/*
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * https://www.acmicpc.net/problem/1929
 * 
 * */
public class FindPrimes {
	public static void main(String[] args) {
        int num = 1000000;
        boolean[] check = new boolean[num + 1];
        check[1] = true;
        
        for (int i = 2; i <= num; i++) {
            if (check[i] == false) {
                for (int j = i * 2; j <= num; j += i) {
                    check[j] = true;
                }
            }
        }
        
        Scanner scan = new Scanner(System.in);
        int min = scan.nextInt();
        int max = scan.nextInt();
        
        for (int i = min; i <= max; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
    }
	
	/*
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[m+1];
        check[0] = check[1] = true;
        for (int i=2; i*i <= m; i++) {
            if (check[i] == true) {
                continue;
            }
            for (int j=i+i; j<=m; j+=i) {
                check[j] = true;
            }
        }
        for (int i=n; i<=m; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
    }
	*/
}
