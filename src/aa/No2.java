package aa;

import java.util.HashMap;
import java.util.Scanner;

public class No2 {
	static HashMap<Integer, Boolean> map;
	static int[][] arr;
	static int K; // 몬스터와 고객의 수의 합
	static int N;
	static int ans;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			K = 0;
			ans = Integer.MAX_VALUE;
			map = new HashMap<Integer, Boolean>();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] != 0) {
						map.put(arr[i][j], false);
						K++;
					}
				}

			// 가능한 경우의 수: 중복된 수가 포함된 순열
			// 몬스터와 고객은 같은 번호로 취급해서 몬스터를 먼저 방문해야함!
			// 처음에는 몬스터 방문
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + ans);

		} // tc
	}

	static void dfs(int depth, int x, int y) {
		if (depth == K) {
			if (sum < ans)
				ans = sum;
			return;
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 0 && !map.get(arr[i][j])) {
					sum += Math.abs(x - i) + Math.abs(y - j);
					map.put(arr[i][j], true);
					dfs(depth + 1, i, j);
					sum -= Math.abs(x - i) + Math.abs(y - j);
					map.put(arr[i][j], false);
				}

				if (arr[i][j] < 0 && map.get(arr[i][j] * (-1)) && !map.get(arr[i][j])) {
					sum += Math.abs(x - i) + Math.abs(y - j);
					map.put(arr[i][j], true);
					dfs(depth + 1, i, j);
					sum -= Math.abs(x - i) + Math.abs(y - j);
					map.put(arr[i][j], false);
				}
			}
	}

}
