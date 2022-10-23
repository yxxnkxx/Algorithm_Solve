import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] total;
    static int[][] dp;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            total = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            dp = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                total[i] = total[i - 1] + arr[i]; // 누적합

            }
            for (int i = 1; i < N; i++)
                dp[i][i + 1] = arr[i] + arr[i + 1]; // 인접한 두개는 각각의 값 그대로

            for (int gap = 2; gap < N; gap++) {
                for (int i = 1; i + gap <= N; i++) {
                    int j = i + gap;
                    dp[i][j] = INF;
                    for (int k = i; k < j; k++)
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    dp[i][j] += total[j] - total[i - 1];
                }
            }

            sb.append(dp[1][N]).append("\n");
        }
        System.out.print(sb);
    }

    static int find(int st, int ed) {
        if (dp[st][ed] != INF) return dp[st][ed];
        if (st == ed) return dp[st][ed] = arr[st];
        // 이전과정의 합을 더해주기
        int sum = total[ed] - total[st - 1];
        if (st + 1 == ed) return dp[st][ed] = arr[st] + arr[ed] + sum; // 인접한 경우는 그냥 더하기
        for (int i = st; i < ed; i++) {
            dp[st][ed] = Math.min(dp[st][ed], find(st, i) + find(i + 1, ed) + sum);
        }

        return dp[st][ed];
    }
}