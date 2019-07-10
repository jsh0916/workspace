package BaekJoon;

import java.util.Scanner;

public class Factorial {
	public static int Factorial (int num) {
        if (num > 1) {
            return num * Factorial(num-1);    
        } else {
            return 1;
        }
        
    }
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.close();
        
        System.out.println(Factorial(num));
    }
}
