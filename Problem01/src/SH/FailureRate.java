package SH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  N			stages				  result
	5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
	4	[4,4,4,4,4]					[4,1,2,3]
 * */
public class FailureRate {
	public static int[] solution(int N, int[] stages) {
		int remain[] = new int[N+1];
        int pass[] = new int[N];
        
        for (int i=0; i<stages.length;i++) {
            remain[stages[i]-1]++;

            for (int j=0; j<stages[i]-1; j++) {
                pass[j]++;
            }
        }
        
        double[] fail = new double[N];
        
        for (int i= 0; i<N; i++) {
            if (pass[i] == 0 && remain[i] == 0) {
                fail[i]=0;
            } else {
            	fail[i] = (double)remain[i]/(double)pass[i];            	
            }
        }

        Map<Integer, Double> failmap = new HashMap<Integer, Double>();
        
        for (int i=0; i<N;i++) {
            failmap.put(i+1, fail[i]);
        }
        
        int[] answer = new int[N];
        
        for (int i=0; i<N; i++) {
            double max = -1;
            int maxkey = 0; 
            
            for (Integer key : failmap.keySet()) {
               if (max <failmap.get(key)) {
                   max = failmap.get(key);
                   maxkey = key;
               }
            }
            
            answer[i]=maxkey;
            failmap.remove(maxkey);
        }

        return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
		
		int[] answer = solution(5, arr);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
