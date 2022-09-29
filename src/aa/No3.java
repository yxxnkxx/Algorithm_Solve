package aa;

import java.util.ArrayList;
import java.util.Scanner;

public class No3 {

	static ArrayList<Integer> tmp = new ArrayList<>();
	static int ans;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			ans = Integer.MAX_VALUE;
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			// 입력

			dfs(0, arr);
			if (ans == Integer.MAX_VALUE)
				ans = -1;
			System.out.println("#" + t + " " + ans);
		}

	}

	static void dfs(int cnt, int[] arr) {
		if (cnt >= ans || cnt > 5)
			return;

		// 정렬 확인
		boolean increase = true;
		boolean decrease = true;
		for (int i = 0; i < N - 1; i++) {
			// 내림차순 확인
			if (arr[i] < arr[i + 1])
				decrease = false;

			if (arr[i] > arr[i + 1])
				increase = false;
			if (!decrease && !increase)
				break;
		}

		if (increase || decrease) {
			if (cnt < ans)
				ans = cnt;
			return;
		}

		// shuffle
		for (int x = 1; x < N; x++) {
			int[] origin = arr.clone();
			int lidx = 0;
			int ridx = N / 2;
			int idx = 0;
			int tmp = x;

			if (tmp < N / 2) {
				tmp = N / 2 - tmp;
				while (lidx < N / 2 && ridx < N)
					if (tmp > 0) {
						arr[idx++] = origin[lidx++];
						tmp--;
					} else {
						arr[idx++] = origin[ridx++];
						arr[idx++] = origin[lidx++];
					}
				while (lidx < N / 2)
					arr[idx++] = origin[lidx++];
				while (ridx < N)
					arr[idx++] = origin[ridx++];
			} else {
				tmp -= N / 2 - 1;
				while (lidx < N / 2 && ridx < N)

					if (tmp > 0) {
						arr[idx++] = origin[ridx++];
						tmp--;
					} else {
						arr[idx++] = origin[lidx++];
						arr[idx++] = origin[ridx++];
					}
				while (lidx < N / 2)
					arr[idx++] = origin[lidx++];
				while (ridx < N)
					arr[idx++] = origin[ridx++];
			}

			dfs(cnt + 1, arr);
			arr = origin;

		}
	}

}
