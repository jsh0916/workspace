package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1158
public class Baekjoon_1158 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q_new = new LinkedList<>();
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		int count = 0;
		int j = 1;

		while (count < n - 1) {
			if (j % k != 0) {
				q.add(q.poll());
			} else {
				q_new.add(q.poll());
				count++;
			}

			j++;
		}
		
		System.out.print("<");
		while (!q_new.isEmpty()) {
			System.out.print(q_new.poll() + ", ");
		}
		System.out.print(q.poll() + ">");

		/*
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int n = 0;
			ArrayList<Integer> link = new ArrayList<>();
	
			for (int i = 0; i < N; i++) {
				link.add(i + 1);
			}
			StringBuilder sb = new StringBuilder("<");
	
			while (N != 1) {
				n = (n + M - 1) % N;
				sb.append(link.get(n));
				sb.append(", ");
				link.remove(n);
				N--;
			}
			n = (n + M - 1) % N;
			sb.append(link.get(n));
			sb.append(">");
			System.out.println(sb);
		*/
	}
}
