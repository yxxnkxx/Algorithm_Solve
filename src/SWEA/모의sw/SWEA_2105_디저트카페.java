package SWEA.모의sw;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_2105_디저트카페 {
	static int N;
	static int[][] map;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static int sr, sc;
	static boolean[][] visited;
	static ArrayList<Integer> list;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			ans = -1;
			map = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					map[i][j] = scan.nextInt();

			// 가능한 길이의 조합 -> 최대를 구해야하니까 n-1부터 시작하기
			// 답은 가로+세로 길이 *2 -> 사각형의 둘레
			// 길이의 최소는 1+1
			out: for (int sum = N - 1; sum >= 2; sum--) {
				for (int x = sum - 1; x >= 1; x--) {
					int y = sum - x;
					// x=row, y=col
					for (int i = 0; i < N; i++)
						for (int j = 0; j < N; j++) {
							// 시작지점 저장하기
							sr = i;
							sc = j;
							find(x, y, i, j, 0, 0);
							if (ans != -1)
								break out;
							list.clear();
						}
				}
			}
			System.out.println("#" + t + " " + ans);
		}

	}

	static void find(int x, int y, int r, int c, int dx, int dy) {
		// 시작 지점으로 돌아왔다면 답 구하기
		if (x * 2 == dx && y * 2 == dy && r == sr && c == sc) {
			ans = Math.max((x + y) * 2, ans);
			return;
		}

		if (!(r == sr && c == sc) && visited[r][c])
			return; // 시작지점이 아닌데 다시 방문한 좌표에 돌아오면 return

		// 이미 방문한 숫자면 return
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == map[r][c])
				return;
		}
		visited[r][c] = true;
		list.add(map[r][c]);
		// depth는 x부터 시작함

		int nr = r;
		int nc = c;
		int d = 0;
		// dx랑 dy를 더해주기
		if (dx < x) {
			d = 0;
			dx += 1;
		} else if (dy < y) {
			d = 1;
			dy += 1;
		} else if (dx < 2 * x) {
			d = 2;
			dx += 1;
		} else if (dy < 2 * y) {
			d = 3;
			dy += 1;
		}
		nr = r + dr[d];
		nc = c + dc[d];
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) // 해당 방향을 충족하는 경우에만 dfs 계속
			find(x, y, nr, nc, dx, dy);
		visited[r][c] = false;
	}

}
