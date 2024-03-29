package BaekJoon;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11052
public class Baekjoon_11052 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        int[] d = new int[num + 1];
        int[] arr = new int[num + 1];
        
        for (int i = 1; i <= num; i++) {
            arr[i] = scan.nextInt();
        }
        
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                if (d[i] < d[i - j] + arr[j]) {
                    d[i] = d[i - j] + arr[j];
                }
            }
        }
        
        System.out.println(d[num]);
    }
}
