package BaekJoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10972
public class Baekjoon_10972 {
	public static boolean next_permutation(int[] arr, int num) {
        int i = num - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i -= 1;

        if (i <= 0) {
            return false;
        }

        int j = num - 1;
        while (arr[i - 1] >= arr[j]) j -= 1;

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;
    
        j = num - 1;
        while (i < j) {
        	int temp2 = arr[i];
            arr[i] = arr[j];
            arr[j] = temp2;
            
            i += 1;
            j -= 1;
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
        
        if (next_permutation(arr, num)) {
            for (int i = 0; i < num; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }
}
