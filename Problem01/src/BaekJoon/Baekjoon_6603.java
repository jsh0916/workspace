package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon_6603 {
	public static boolean next_permutation(int[] d) {
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
		
		while(true) {
			int n = scan.nextInt();
			
			if (n==0) {
				break;
			}
			
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
			}
			
			int[] d = new int[n];
			for (int i = 0 ; i < n; i++) {
				if (i < n - 6) {
					d[i] = 0;
				} else {
					d[i] = 1;
				}
			}
			
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			do {
				ArrayList<Integer> cur = new ArrayList<>();
				
				for (int i = 0; i < n; i++) {
					if (d[i] == 1) {
						cur.add(a[i]);
					}
				}
				
				ans.add(cur);
			} while (next_permutation(d));
			
			Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
				public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
					int n = l1.size();
					int m = l2.size();
					int i = 0;
					while (i < n && i < m) {
						int t1 = l1.get(i);
						int t2 = l2.get(i);
						
						if (t1 > t2) {
							return 1;
						} else if (t1 < t2) {
							return -1;
						}
						
						i++;
					}
					
					if (i == n && i != m) {
						return -1;
					} else if (i != n && i == m) {
						return 1;
					}
					
					return 0;
				}
			});
			
			for (ArrayList<Integer> v : ans) {
				for (int x : v) {
					System.out.print(x + " ");
				}

				System.out.println();
			}

			System.out.println();
		}
	}
}
