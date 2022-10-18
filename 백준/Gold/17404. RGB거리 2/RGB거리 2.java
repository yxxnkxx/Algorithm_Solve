import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] sted = {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}};
    static final int INF = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = sc.nextInt();
        int[][] dp = new int[N][3]; // 처음이랑 마지막을 정해놓기
        // 0,1,2를 고정하고 맨끝부터 채워나가면 ?
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        int ans = INF;
        for (int st = 0; st < 3; st++) {
            for (int i = 0; i < 3; i++) {
                if (i == st) dp[0][i] = arr[0][i];
                else dp[0][i] = INF;
            }
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];

            }
            for (int i = 0; i < 3; i++)
                if (i != st)
                    ans = Math.min(ans, dp[N - 1][i]);

        }
        System.out.println(ans);


    }


}