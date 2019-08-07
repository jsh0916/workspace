package BaekJoon;

import java.util.Scanner;

public class test {
    
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        int[] arr = new int[11];
        
        arr[0] = 1;
        
        for (int i = 1; i <= 10; i++) {
        	for (int j = 1; j <= 3; j++) {
        		if (i - j >= 0) {
        			arr[i] += arr[i - j];
        		}
        	}
        }
        
        int t = scan.nextInt();
        
        while (t-- > 0) {
        	int n = scan.nextInt();
        	System.out.println(arr[n]);
        }
    }
}
