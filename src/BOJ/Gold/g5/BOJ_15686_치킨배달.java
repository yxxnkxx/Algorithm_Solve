package BOJ.Gold.g5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
	static int N, M;
	static List<int[]> house;
	static List<int[]> chicken;
	static final int INF = Integer.MAX_VALUE;
	static int ans = INF;
	static int[] pickC;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int v = sc.nextInt();
				switch (v) {
				case 1:
					house.add(new int[] { i, j });
					break;

				case 2:
					chicken.add(new int[] { i, j });
					break;
				}

			}
		pickC = new int[M];

		comb(0, 0);
		System.out.println(ans);

	}

	static void comb(int depth, int start) {
		if (depth == M) {
			find();
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			pickC[depth] = i;
			comb(depth + 1, i + 1);
		}

	}

	static void find() {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int hr = house.get(i)[0];
			int hc = house.get(i)[1];
			int dist = INF;
			for (int j = 0; j < M; j++) {
				int cr = chicken.get(pickC[j])[0];
				int cc = chicken.get(pickC[j])[1];
				dist = Math.min(dist, Math.abs(hr - cr) + Math.abs(hc - cc));
			}
			sum += dist;
		}
		ans = Math.min(sum, ans);

	}
}
