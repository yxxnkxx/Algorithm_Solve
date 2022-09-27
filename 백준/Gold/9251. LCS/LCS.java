
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		int ans = 0;
		for (int i = 1; i <= str1.length(); i++)
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					ans = Math.max(dp[i][j], ans);
				} else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}

		System.out.println(ans);
	}

}
