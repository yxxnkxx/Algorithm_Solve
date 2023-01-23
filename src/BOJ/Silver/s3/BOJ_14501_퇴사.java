package BOJ.Silver.s3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14501_퇴사 {
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
            if (i + arr[i][0] > N) continue; // 완료일이 N을 넘으면 고려X
            dp[i] = Math.max(dp[i], arr[i][1]);
            int idx = i;
            while (idx < N) { // 다음날 검사
                int next = idx + arr[idx][0];
                for (int j = next; j < N; j++) // idx의 완료일 이후에 수행하는 작업
                    if (j + arr[j][0] <= N) { // next의 작업이 N일 내에 끝난다면
                        dp[j] = Math.max(dp[j], dp[idx] + arr[j][1]); // 답 update
                    }
                idx = next; // 다음 idx 검사
            }

        }
        int ans = 0;
        for (int i = 0; i < N; i++)
            ans = Math.max(dp[i], ans);
        System.out.println(ans);

    }
}
