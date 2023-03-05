
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M; //세로 가로
    static char[][] map;
    static int[][] visited; //
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();
        visited = new int[N][M];
        int cnt = 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j, cnt++);
                }
            }
        System.out.println(ans);
    }

    static void bfs(int i, int j, int idx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, 0});
        visited[i][j]=idx;
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int dis = arr[2];
            ans = Math.max(ans, dis);
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 'L' && visited[nr][nc] != idx) {
                    visited[nr][nc] = idx;
                    q.add(new int[]{nr, nc, dis + 1});
                }
            }
        }
    }
}
