package BOJ.Silver.s3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Document {
	static int[] max = new int[10];
	int index;
	int priority;

	public Document(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}

}

public class BOJ_1966_PrinterQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Queue<Document> queue = new LinkedList<>();
			Arrays.fill(Document.max, 0); // max 초기화
			for (int i = 0; i < N; i++) {
				int priority = sc.nextInt();
				Document.max[priority]++;
				queue.offer(new Document(i, priority));
			}

			int cnt = 1;
			int max = 0;
			while (true) {
				for (int i = 9; i >= 1; i--)
					if (Document.max[i] > 0) {
						max = i;
						break;
					} // queue에 있는 가장 큰 priority 찾기
				if (queue.peek().priority < max) {
					queue.offer(queue.poll()); // max보다 우선순위가 작으면 poll해서 다시 offer

				} else {
					if (queue.peek().index == M)
						break; // 우선순위가 같은 것 중에 index가 M이면 해당 cnt가 answer
					Document doc = queue.poll(); // 우선순위가 가장 높은 것을 poll
					Document.max[doc.priority]--; // 해당 우선순위를 감소시켜줌
					cnt++; // 인쇄 순서
				}

			}
			System.out.println(cnt);

		}
	}

}
