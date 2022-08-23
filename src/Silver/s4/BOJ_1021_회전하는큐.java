package Silver.s4;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1021_회전하는큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			int idx = queue.indexOf(num);
			if (idx < queue.size() - idx + 1) {
				// case 2
				while (queue.get(0) != num) {
					queue.addLast(queue.removeFirst());
					cnt++;
				}
				queue.removeFirst();

			} else {
				// case 3
				while (queue.get(0) != num) {
					queue.addFirst(queue.removeLast());
					cnt++;
				}
				queue.removeFirst();
			}
		}
		System.out.println(cnt);
	}

}
