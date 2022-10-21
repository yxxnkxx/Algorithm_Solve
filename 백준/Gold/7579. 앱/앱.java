
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int INF = 1000000001; //1000만 * 100

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] memory = new int[N + 1];
        int[] cost = new int[N + 1];
        int[][] dp = new int[N + 1][10001];
        for (int i = 1; i <= N; i++) {
            memory[i] = sc.nextInt();

        }  for (int i = 1; i <= N; i++) {
            cost[i] = sc.nextInt();

        }


        for (int i = 1; i <= N; i++)
            for (int j = 0; j <= 10000; j++) {
                if (cost[i] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
                }

            }
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= 10000; j++)
            if (dp[N][j] >= M && dp[N][j] != INF) {
                ans = j;
                break;
            }
        System.out.println(ans);
    }
}
