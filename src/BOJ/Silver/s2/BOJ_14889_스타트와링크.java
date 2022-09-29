package BOJ.Silver.s2;

import java.util.Scanner;

public class BOJ_14889_스타트와링크 {

	static int N;
	static int[][] map;
	static boolean[] select;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		select = new boolean[N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();

		select(0, 0);
		System.out.println(ans);
	}

	static void select(int cnt, int start) {
		if (cnt == N / 2) {
			find();
			return;
		}
		for (int i = start; i < N; i++) {
			select[i] = true;
			select(cnt + 1, i + 1);
			select[i] = false;
		}

	}

	static void find() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++) {
				if (select[i] && select[j]) {
					start += map[i][j];
					start += map[j][i];
				} else if (!select[i] && !select[j]) {
					link += map[i][j];
					link += map[j][i];
				}
			}

		if (Math.abs(start - link) < ans)
			ans = Math.abs(start - link);
	}
}
