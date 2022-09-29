package SWEA.d3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1208_Flattern_heap {

	public static void main(String[] args) {
		int T = 10;
		int size = 100;

		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt(); // 덤프 횟수

			PriorityQueue<Integer> maxbox = new PriorityQueue<>();
			PriorityQueue<Integer> minbox = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < size; i++) {
				int n = sc.nextInt();
				maxbox.offer(n);
				minbox.offer(n);
			}

			int dis = minbox.peek() - maxbox.peek();
			while (N > 0 && dis > 1) {

				int min = maxbox.poll();
				int max = minbox.poll();
				minbox.offer(max - 1);
				maxbox.offer(min + 1);
				dis = minbox.peek() - maxbox.peek();
				N--;

			}
			System.out.println("#" + (t + 1) + " " + dis);
		}
	}

}
