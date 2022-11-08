package BOJ.Gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N;
    static int[][] map;
    static int ans;
    static boolean[][] visited;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (!visited[i][j])
                    ans = Math.max(ans, dfs(i, j));
            }

        System.out.println(ans + 1);
    }

    static int dfs(int i, int j) {
        if (visited[i][j]) return dp[i][j];

        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > map[i][j])
                dp[i][j] = Math.max(dp[i][j], dfs(nr, nc) + 1);
        }

        return dp[i][j];
    }
}
