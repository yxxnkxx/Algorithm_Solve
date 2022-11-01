
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        int[] path = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0) {
                if (dp[i / 2] + 1 < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                    path[i] = i / 2;
                }
            }
            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < dp[i]) {
                    dp[i] = dp[i / 3] + 1;
                    path[i] = i / 3;
                }
            }

            if (dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                path[i] = i - 1;
            }
        }

        System.out.println(dp[N]);
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(N).append(" ");
            if (N == 1) break;
            N = path[N];
        }
        System.out.println(sb);
    }


}
