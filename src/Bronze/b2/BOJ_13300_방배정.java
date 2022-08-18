package Bronze.b2;

import java.util.Scanner;

public class BOJ_13300_방배정 {
	static int[][] students = new int[2][6];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 0; i < N; i++)
			students[sc.nextInt()][sc.nextInt() - 1]++;

		int cnt = 0;
		for (int s = 0; s < 2; s++) {
			for (int y = 0; y < 6; y++) {
				int x = students[s][y];
				if (x == 0)
					continue;
				cnt += (x / K);
				if (x % K != 0)
					cnt++;
			}
		}
		System.out.println(cnt);

	}
}
