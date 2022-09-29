package SWEA.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3499_PerfectShuffle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			int mid = (N + 1) / 2;
			for (int i = 0; i < mid; i++)
				queue1.add(sc.next());
			for (int i = mid; i < N; i++)
				queue2.add(sc.next());
			StringBuilder sb = new StringBuilder();
			sb.append("#" + (t + 1) + " ");
			if (N % 2 == 0) {
				while (!queue1.isEmpty()) {
					sb.append(queue1.poll() + " ");
					sb.append(queue2.poll() + " ");
				}

			} else { // 홀수일 때는 st1이 st2보다 1개 더 많음
				while (!queue2.isEmpty()) {
					sb.append(queue1.poll() + " ");
					sb.append(queue2.poll() + " ");
				}
				sb.append(queue1.poll());
			}
			System.out.println(sb.toString());

		}
	}

}
