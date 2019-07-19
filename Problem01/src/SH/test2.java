package SH;

/*
 * Task Given a string, S, of length N that is indexed from 0 to N - 1, 
 * print its even-indexed and odd-indexed characters as 2 space-separated strings on a single line 
 * (see the Sample below for more detail).
 * 
 * 
 Sample Input

	2
	Hacker
	Rank
 Sample Output
	
	Hce akr
	Rn ak
 * */
import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		
		for (int i = 0; i < num; i++) {
			String s = scan.nextLine();
			String even = "";
			String odd = "";
			
			for (int j = 0; j < s.length(); j++) {
				if (j % 2 == 0) {
					even += s.substring(j, j + 1);
				} else { 
					odd += s.substring(j, j + 1);
				}
			}
			
			System.out.println(even + " " + odd);
		}
	}
}
