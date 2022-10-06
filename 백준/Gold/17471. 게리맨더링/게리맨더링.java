import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static boolean[] pick;
	static boolean[] visited;
	static int[][] adjArr;
	static int[] val;
	static int sumT;
	static int sumF;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		val = new int[N + 1];
		for (int i = 1; i <= N; i++)
			val[i] = sc.nextInt();
		pick = new boolean[N + 1];
		visited = new boolean[N + 1];
		adjArr = new int[N + 1][];
		for (int i = 1; i <= N; i++) {
			int size = sc.nextInt();
			adjArr[i] = new int[size];
			for (int j = 0; j < size; j++)
				adjArr[i][j] = sc.nextInt();
		}

		// 부분집합
		divide(1);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);

	}

	static void divide(int depth) {
		if (depth == N + 1) {
			sumT = 0;
			sumF = 0;

			// 공집합 전체집합은 제외
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 1; i <= N; i++) {
				if (pick[i])
					cnt1++;
				if (!pick[i])
					cnt2++;
			}
			if (cnt1 == N || cnt2 == N)
				return; // 공집합 전체집합이면 제외

			boolean check = false;
			for (int i = 1; i <= N; i++)
				if (pick[i]) {
					check = bfs(i, true);
					break;
				}
			if (check) {
				check = false;
				for (int i = 1; i <= N; i++)
					if (!pick[i]) {
						check = bfs(i, false);
						break;
					}
			}

			if (check) {
				ans = Math.min(ans, Math.abs(sumT - sumF));
			}
			return;
		}

		pick[depth] = true;
		divide(depth + 1);
		pick[depth] = false;
		divide(depth + 1);

	}

	static boolean bfs(int i, boolean check) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		Arrays.fill(visited, false);
		while (!q.isEmpty()) {
			int tmp = q.poll();
			if (visited[tmp])
				continue;
			visited[tmp] = true;
			if (check)
				sumT += val[tmp];
			else
				sumF += val[tmp];
			for (int j = 0; j < adjArr[tmp].length; j++) {
				int link = adjArr[tmp][j];
				if (pick[link] == check && !visited[link]) {
					q.add(link);
				}
			}
		}

		for (int n = 1; n <= N; n++) {
			if (pick[n] == check && !visited[n])
				return false;
		}
		return true;

	}

}