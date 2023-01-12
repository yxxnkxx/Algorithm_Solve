
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};

    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            visited = new boolean[N][N];

        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        // 1. 적록색약 x
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    cnt++;
                    dfsNormal(i, j);
                }
        sb.append(cnt).append(" ");
        cnt = 0;
        // 2. 적록색약 O
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    cnt++;
                    dfsColor(i, j);
                }
        sb.append(cnt);
        System.out.println(sb);

    }

    static void dfsNormal(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == map[r][c])
                dfsNormal(nr, nc);
        }
    }

    static void dfsColor(int r, int c) {
        visited[r][c] = true;
        char color = map[r][c];
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                if (color == 'B') {
                    if (map[nr][nc] == color)
                        dfsColor(nr, nc);
                } else {
                    if (map[nr][nc] == 'R' || map[nr][nc] == 'G')
                        dfsColor(nr, nc);
                }

            }
        }
    }
}
