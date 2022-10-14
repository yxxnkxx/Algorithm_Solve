import java.util.Scanner;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[][] rot;
	static int[] order;
	static boolean[] visited;
	static int[] dr = { 1, 0, -1, 0 }; // 남 동 북 서
	static int[] dc = { 0, 1, 0, -1 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				map[i][j] = sc.nextInt();
		rot = new int[K][3];
		order = new int[K];
		visited = new boolean[K];
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			rot[i] = new int[] { r, c, s };
		}
		// 순열
		perm(0);

		System.out.println(ans);
	}

	static void perm(int depth) {
		if (depth == K) {
			rotation();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[depth] = i;
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}

	static void rotation() {
		int[][] copy = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++)
			copy[i] = map[i].clone();

		for (int k = 0; k < K; k++) {
			int r = rot[order[k]][0];
			int c = rot[order[k]][1];
			int tmp = rot[order[k]][2];
			for (int s = tmp; s > 0; s--) {
				int start = map[r - s][c - s]; // 시작 저장
				int R = r - s;
				int C = c - s;
				int d = 0;
				while (d < 4) {
					int nr = R + dr[d];
					int nc = C + dc[d];
					if (nr >= r - s && nr <= r + s && nc >= c - s && nc <= c + s) {
						map[R][C] = map[nr][nc];
						R = nr;
						C = nc;
					} else
						d++;

				}
				map[R][C + 1] = start;
			}
		}

		// 최소값 찾기
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++)
				sum += map[i][j];
			ans = Math.min(sum, ans);
		}

		// 배열 원상 복구
		for (int i = 1; i <= N; i++)
			map[i] = copy[i].clone();

	}

}