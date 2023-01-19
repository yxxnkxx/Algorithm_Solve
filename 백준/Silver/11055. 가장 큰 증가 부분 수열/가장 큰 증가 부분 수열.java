import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        int ans = arr[0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // i보다 작은 index 중에 arr[i]보다 작은 arr[j]에 대해
                if (arr[j] < arr[i]) {
                    // i번째를 포함할지 안할지
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]); // j까지의 합 + arr[i]와 현재까지 dp[i] 중 최대값
                    ans = Math.max(ans, dp[i]);
                }
            }

        }
        System.out.println(ans);
    }
}