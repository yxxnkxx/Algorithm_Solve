package BOJ.Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3109_빵집 {


    static int R, C;
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    static char[][] map;
    static int[][] visited;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();


        for (int[] arr : visited)
            Arrays.fill(arr, -1);

        for (int i = 0; i < R; i++) {
            dfs(i, i, 0);
        }
        System.out.println(ans);
    }

    static boolean dfs(int start, int r, int c) {

        if (c == C - 1) {
            ans++;

            return true;
        }

        for (int d = 0; d < 3; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc < C && map[nr][nc] == '.' && visited[nr][nc] == -1) {

                visited[nr][nc] = start;
                if (dfs(start, nr, nc)) return true;
            }
        }
        return false;
    }
}
