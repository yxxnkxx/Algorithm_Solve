package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static char[][] map;
    static int[][] visited;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();
        // dp 사용 불가
        // bfs
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0, 0}); // 방문 표시

        for (int i = 0; i < N; i++)
            Arrays.fill(visited[i], -1);

        while (!q.isEmpty()) {
            int[] spot = q.poll();
            int r = spot[0];
            int c = spot[1];
            int num = spot[2];
            if (visited[r][c] != -1 && visited[r][c] <= num) continue;
            visited[r][c] = num;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == '0' && (visited[nr][nc] == -1 || visited[nr][nc] > num)) {
                        q.add(new int[]{nr, nc, num});
                    } else {
                        if (visited[nr][nc] == -1 || visited[nr][nc] > num + 1)
                            q.add(new int[]{nr, nc, num + 1});
                    }
                }
            }
        }
        System.out.println(visited[N - 1][M - 1]);
    }
}
