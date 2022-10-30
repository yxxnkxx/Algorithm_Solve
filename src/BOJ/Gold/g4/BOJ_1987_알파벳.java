package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {

    static int R, C;
    static char[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();
        visited[0][0]=true;
        boolean[] pick = new boolean[26];
        pick[map[0][0]-'A']=true;
        dfs(0, 0, pick, 1);
        System.out.println(ans);
    }

    static void dfs(int r, int c, boolean[] pick, int cnt) {

        ans = Math.max(ans,cnt);

        for (int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if (nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc] && !pick[map[nr][nc]-'A']) {
                visited[nr][nc]=true;
                pick[map[nr][nc]-'A']=true;
                dfs(nr, nc, pick, cnt+1);
                visited[nr][nc]=false;
                pick[map[nr][nc]-'A']=false;
            }
        }


    }
}
