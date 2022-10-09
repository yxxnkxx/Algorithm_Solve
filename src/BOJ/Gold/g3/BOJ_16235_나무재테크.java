package BOJ.Gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static int N, M, K;
	static int[][] map;
	static List<Integer>[][] trees;
	static int[][] A;
//	static List<int[]> trees;
	static int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
//		trees = new ArrayList<>();
		trees = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				trees[i][j] = new ArrayList<>();

		// 초기 양분은 5로 채워짐
		for (int i = 1; i <= N; i++)
			Arrays.fill(map[i], 5);

		A = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		} // 입력

		// 나무 나이 입력하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees[r][c].add(age);
		}

		for (int k = 0; k < K; k++) {
			int[][] tmp = new int[N + 1][N + 1];

			// 봄
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++) {
					if (trees[i][j].size() != 0) {
						Collections.sort(trees[i][j]);
						for (int t = 0; t < trees[i][j].size(); t++) {
							int age = trees[i][j].get(t);
							if (map[i][j] >= age) {
								map[i][j] -= age;
								trees[i][j].set(t, age + 1);
							} else {
								tmp[i][j] += age / 2;
								trees[i][j].remove(t);
								t--;
							}
						}
					}
				}

			// 여름
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++) {
					map[i][j] += tmp[i][j];
				}

			// 가을 번식
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++) {
					if (trees[i][j].size() != 0) {
						for (int t = 0; t < trees[i][j].size(); t++) {
							int age = trees[i][j].get(t);
							if (age % 5 == 0) {
								for (int d = 0; d < 8; d++) {
									int nr = i + dr[d];
									int nc = j + dc[d];
									if (nr > 0 && nr <= N && nc > 0 && nc <= N) {
										trees[nr][nc].add(1);
									}
								}
							}
						}
					}
				}

			// 겨울 양분 추가
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++) {
					map[i][j] += A[i][j];
				}

		}
		int cnt = 0;
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++) {
				cnt += trees[i][j].size();
			}

		System.out.println(cnt);
	}

}
