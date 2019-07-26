package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.

   4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
     예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 
     또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.

     이 추측은 아직도 해결되지 않은 문제이다.

     백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.
   https://www.acmicpc.net/problem/6588
 * 
 * */
public class Glodbach_Conjecture {
	/*
	public static void main(String[] args) {
		int num = 1000000;
        int[] prime = new int[num];
        int pn = 0;
        boolean[] check = new boolean[num + 1];
        
        for (int i = 3; i <= num; i += 2) {
            if (check[i] == false) {
                prime[pn++] = i;
                
                for (int j = i * 2; j <= num; j += i) {
                    check[j] = true;
                }
            }
        }
        
        Scanner scan = new Scanner(System.in);
        int even = 1;
        while (even != 0) {
        	even = scan.nextInt();
        	
        	if (even != 0) {
        		int a = 0, b = 0;
        		int max_a = 0, max_b = 0;
        		int max = 0;
        		
        		for (int i = 0; i < pn; i++) {
        			for (int j = 1; j < pn; j++) {
        				if ((prime[i] + prime[j]) == even) {
        					if (prime[i] < prime[j]) {
        						a = prime[i];
        						b = prime[j];
        					} else {
        						a = prime[j];
        						b = prime[i];
        					}
        					
        					if (max < (b - a)) {
        						max_a = a;
        						max_b = b;
        					}
        				} else if ((prime[i] + prime[j]) > even) {
        					break;
        				}
        			}
        		}
        		
        		if (max_a != 0) {
        			System.out.println(even + " = " + max_a + " + " + max_b);        	
        		} else {
        			System.out.println("Goldbach's conjecture is wrong.");
        		}        		
        	}
        }
	}
	*/

	public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[MAX+1];
        ArrayList<Integer> prime = new ArrayList<Integer>();
        check[0] = check[1] = true;
        
        for (int i=2; i*i <= MAX; i++) {
            if (check[i] == true) {
                continue;
            }
            
            prime.add(i);
            
            for (int j=i+i; j<=MAX; j+=i) {
                check[j] = true;
            }
        }

        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            for (int i=1; i<prime.size(); i++) {
                int p = prime.get(i);

                if (check[n - p] == false) {
                    System.out.println(n + " = " + p + " + " + (n-p));
                    break;
                }
            }
        }
    }
}
