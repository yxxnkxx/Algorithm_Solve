package SWEA.모의sw;

import java.util.Scanner;

public class SWEA_4008_숫자만들기 {

	static int N;
	static int[] nums;
	static int[] op = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			nums = new int[N];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < 4; i++)
				op[i] = sc.nextInt();
			for (int i = 0; i < N; i++)
				nums[i] = sc.nextInt();
			dfs(0, nums[0]);
			System.out.println("#" + t + " " + (max - min));

		}
	}

	static void dfs(int idx, int res) {

		if (idx == N - 1) {
			min = Math.min(res, min);
			max = Math.max(res, max);
			return;
		}

		for (int i = 0; i < 4; i++)
			if (op[i] != 0) {
				op[i]--;
				dfs(idx + 1, cal(i, res, nums[idx + 1]));
				op[i]++;
			}

	}

	static int cal(int op, int num1, int num2) {
		switch (op) {
		case 0:
			return num1 + num2;
		case 1:
			return num1 - num2;
		case 2:
			return num1 * num2;
		case 3:
			return num1 / num2;
		default:
			return Integer.MIN_VALUE;
		}
	}

}
