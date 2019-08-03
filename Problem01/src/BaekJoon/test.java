package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class test {
	static boolean next_permutation(int[] d) {
        int i = d.length - 1;
        while (i > 0 && d[i - 1] >= d[i]) {
            i--;
        }
        
        if (i <= 0) {
            return false;
        }
        
        int j = d.length - 1;
        while (d[i - 1] >= d[j]) {
            j--;
        }
        
        int temp = d[i - 1];
        d[i - 1] = d[j];
        d[j] = temp;
        
        j = d.length - 1;
        while (i < j) {
            temp = d[i];
            d[i] = d[j];
            d[j] = temp;
            
            i++;
            j--;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        int[] arr = new int[num];
        
        for (int i = 0; i < num; i++) {
            arr[i] = scan.nextInt();
        }
        
        int[] d = new int[num];
        
        for (int i = 0; i < num; i++) {
            d[i] = i;
        }
        
        int max = 0;
        
        do {
            int sum = 0;
            for (int i = 0; i < num - 1; i++) {
                sum += Math.abs(arr[d[i]] - arr[d[i + 1]]);
            }
            
            max = Math.max(max, sum);
        } while (next_permutation(d));
        
        System.out.println(max);
    }
}
