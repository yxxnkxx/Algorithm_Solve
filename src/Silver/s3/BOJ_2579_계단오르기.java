package Silver.s3;

import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	static int N;
	static int[] stairs;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stairs = new int[N];
		dp = new int[N][3]; // 0은 자기 선택x, 1은 n-1 선택x, 2는 n-2 선택x(n-1, n개)

		for (int i = 0; i < N; i++)
			stairs[i] = sc.nextInt();

		dp[0][1] = stairs[0];
		/*
		 * 반례 3 10 20 100 0번째는 해당 idx를 고르지 않는 것이니까 0번째 값은 dp[0][1]로 초기화해야함!
		 * 
		 */

		for (int i = 1; i < N; i++)
			find(i);

		// N-1 번째는 무조건 밟아야함 -> dp[1] dp[2] 중 큰 값

		System.out.println(Math.max(dp[N - 1][1], dp[N - 1][2]));

	}

	static void find(int idx) {
		// 0은 idx를 고르지 않는 것
		// n-1 중 가장 큰 값 고르기, 연속은 0이 됨
		dp[idx][0] = Math.max(dp[idx - 1][1], dp[idx - 1][2]);

		// 1은 연속이 1, idx-1을 선택하지 않는 것, dp[idx-1][0]은 idx-1을 고르지 않는 값 중 가장 큰 값이므로 여기에 자기의
		// value를 더해줌
		dp[idx][1] = dp[idx - 1][0] + stairs[idx];

		// 2는 연속이2, idx-2를 선택하지 않는 것 -> dp[n-1][1]에 자기 자신을 더해줌
		dp[idx][2] = dp[idx - 1][1] + stairs[idx];

	}

}
