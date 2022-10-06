import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp = new int[1000001];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp[1] = 0;
		System.out.println(find(N));
	}

	static int find(int num) {
		if (num == 1)
			return 0;

		if (dp[num] != 0)
			return dp[num];

		if (num % 2 == 0 && num % 3 == 0) {
			dp[num] = Math.min(find(num / 2), find(num / 3)) + 1;
			dp[num] = Math.min(dp[num], find(num - 1));
		} else if (num % 2 == 0)
			dp[num] = Math.min(find(num / 2), find(num - 1)) + 1;
		else if (num % 3 == 0)
			dp[num] = Math.min(find(num / 3), find(num - 1)) + 1;
		else
			dp[num] = find(num - 1) + 1;

		return dp[num];
	}
}
