import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M, D;
	static int[][] map;
	static int[] pick;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N][M];
		pick = new int[3];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();

		comb(0, 0);
		System.out.println(ans);
	}

	static void comb(int depth, int start) {
		if (depth == 3) {
			int[][] copy = new int[N][M];
			for (int i = 0; i < N; i++)
				copy[i] = map[i].clone();

			game(0, 0);
			for (int i = 0; i < N; i++)
				map[i] = copy[i].clone();
			return;
		}
		for (int i = start; i < M; i++) {
			pick[depth] = i;
			comb(depth + 1, i + 1);
		}

	}

	static void game(int depth, int cnt) {
		// 게임 한번마다 궁수 3명이 하나씩 쏘기, 한 줄씩 내려오기 게임은 n번 진행하면 됨
		if (depth == N) {
			ans = Math.max(cnt, ans);
			return;
		}

		int[][] minIdx = new int[3][2];
		for (int i = 0; i < 3; i++)
			Arrays.fill(minIdx[i], -1);
		for (int i = 0; i < 3; i++) {
			int r = N;
			int c = pick[i];
			int min = Integer.MAX_VALUE;
			for (int j = depth; j < N; j++)
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 1) {
						int tmp = Math.abs(r - j) + Math.abs(c - k);
						if (tmp <= D && min > tmp) {
							min = tmp;
							minIdx[i][0] = j;
							minIdx[i][1] = k;
						}
						if (min == tmp && minIdx[i][1] > k) {
							minIdx[i][0] = j;
							minIdx[i][1] = k; // 가장 왼쪽
						}
					}
				}
			// 쏘는 건 동시에
		}

		// 쏘기
		for (int i = 0; i < 3; i++)
			if (minIdx[i][0] != -1 && map[minIdx[i][0]][minIdx[i][1]] == 1) {
				map[minIdx[i][0]][minIdx[i][1]] = 0;
				cnt++;
			}

		// 한줄씩 밑으로 이동하기
		for (int n = N - 1; n > 0; n--) {
			map[n] = map[n - 1].clone();
		}
		Arrays.fill(map[0], 0);
		game(depth + 1, cnt);

	}

}