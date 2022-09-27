
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

				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}

		System.out.println(ans);

		if (ans != 0) {
			char[] result = new char[ans];
			int r = str1.length();
			int c = str2.length();
			int idx = 0;
			while (r >= 1 && c >= 1) {
				if (dp[r][c] == dp[r - 1][c])
					r -= 1;
				else if (dp[r][c] == dp[r][c - 1])
					c -= 1;
				else {
					result[idx] = str1.charAt(r - 1);
					r -= 1;
					c -= 1;
					idx++;
				}
			}

			for (int i = ans - 1; i >= 0; i--)
				System.out.print(result[i]);
		}

	}
}
