package BOJ.Gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16724_피리부는사나이 {
    static char[][] map;
    static int N, M;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] visited;
    static int ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();


        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (visited[i][j] == 0) {
                    cnt++;
                    ans+=dfs(i, j, cnt);

                }
        }
        System.out.println(ans);

    }

    static int move(char ch) {
        switch (ch) {
            case 'D':
                return 0;
            case 'U':
                return 1;
            case 'R':
                return 2;
            case 'L':
                return 3;
        }
        return -1;
    }

    static int dfs(int r, int c, int cnt) {
        visited[r][c] = cnt;
        char ch = map[r][c];
        int d = move(ch);
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (visited[nr][nc] == cnt)
            return 1; // cycle 찾음
        if (visited[nr][nc]!=0)
            return 0; // 이미 있는 cycle에 도달 -> 새로 설치할 필요 없음

        return dfs(nr, nc, cnt);


    }

}