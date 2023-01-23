import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            int day = sc.nextInt();
            int profit = sc.nextInt();
            arr[i][0] = day;
            arr[i][1] = profit;
        }
        for (int i = 0; i < N; i++) {
            if (i + arr[i][0] > N) continue;
            dp[i] = Math.max(dp[i], arr[i][1]);
            int idx = i;
            while (idx < N) {
                int next = idx + arr[idx][0];
                for (int j = next; j < N; j++)
                    if (j + arr[j][0] <= N) {
                        // next부터 끝까지 채우기
                        dp[j] = Math.max(dp[j], dp[idx] + arr[j][1]);
                    }
                idx = next;
            }

        }
        int ans = 0;
        for (int i = 0; i < N; i++)
            ans = Math.max(dp[i], ans);
        System.out.println(ans);

    }
}