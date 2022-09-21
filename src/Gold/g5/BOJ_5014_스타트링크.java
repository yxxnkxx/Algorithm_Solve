package Gold.g5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5014_스타트링크 {
	static int F, S, G, U, D;
	static int ans;
	static boolean visited[] = new boolean[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt(); // +
		D = sc.nextInt(); // -
		ans = -1;
		bfs(S, 0);
		if (ans == -1)
			System.out.println("use the stairs");
		else
			System.out.println(ans);

	}

	static void bfs(int floor, int cnt) {
		Queue<Integer> q = new LinkedList<>();

		q.add(floor);

		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				size--;
				int tmp = q.poll();
				if (tmp == G) {
					ans = cnt;
					return;
				}

				if (tmp < 1 || tmp > F)
					continue;
				if (visited[tmp])
					continue;
				visited[tmp] = true;
				q.add(tmp + U);
				q.add(tmp - D);
			}

			cnt++;

		}

	}
}
