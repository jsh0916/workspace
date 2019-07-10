package BaekJoon;

import java.util.Scanner;

public class NumberSum {
	public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String sum_n = scan.next();
        
        int result = sum (n, sum_n);
        
        System.out.println(result);
    }
    
    public static int sum (int n, String sum_n) {
        int allSum = 0;
        
        for (int i = 0; i < n; i++) {
        	allSum += Integer.parseInt(Character.toString(sum_n.charAt(i)));
        }
        
        return allSum;
    }
}
