import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = sc.nextInt();
			int[] coin = new int[N];
			for (int i = 0; i < N; i++)
				coin[i] = sc.nextInt();
			int M = sc.nextInt();
			int[] dp = new int[M + 1];
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = coin[i]; j <= M; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}
			sb.append(dp[M]).append("\n");
		}
		System.out.print(sb);
	}
}