package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map.put(i, Integer.parseInt(st.nextToken()));
        }
        int[][] dp = new int[N + 1][N + 1];
        for (int left = 1; left <= N; left++) {
            out:
            for (int right = left; right <= N; right++) {
                if (dp[left][right] != 0) continue;

                int lidx = left;
                int ridx = right;
                while (lidx < ridx) {
                    int l = map.get(lidx);
                    int r = map.get(ridx);
                    if (l != r) {
                        dp[left][right] = 0;
                        continue out;
                    }
                    lidx++;
                    ridx--;
                }
                while (lidx >= left) {
                    dp[lidx][ridx] = 1;
                    lidx--;
                    ridx++;
                }

            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]).append("\n");

        }
        System.out.print(sb);

    }
}
