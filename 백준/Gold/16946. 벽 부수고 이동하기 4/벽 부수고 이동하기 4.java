
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] result;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = input.charAt(j) - '0';
        }
        int cnt = 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && visited[i][j]==0)
                    bfs(i, j, cnt++);
            }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(find(i, j)%10); // 10으로 나눈 나머지인거 주의하기
            sb.append("\n");
        }
        System.out.print(sb);

    }

    static void bfs(int r, int c, int cnt) {

        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> pick = new LinkedList<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int tr = tmp[0];
            int tc = tmp[1];
            if (visited[tr][tc] !=0) continue;
            visited[tr][tc] = cnt;
            pick.add(tmp);
            result[r][c]++; // 방문 가능한 곳
            for (int d = 0; d < 4; d++) {
                int nr = tr + dr[d];
                int nc = tc + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] != cnt && map[nr][nc] == 0)
                    q.add(new int[]{nr, nc});
            }
        }
        int ans = result[r][c];
        while (!pick.isEmpty()) {
            int[] tmp = pick.poll();
            int tr = tmp[0];
            int tc = tmp[1];
            result[tr][tc] = ans;
        }
    }

    static int find(int r, int c) {
        if (map[r][c] == 0) return 0;

        // 네 방향을 조사하고 만약 특정 두 방향이 서로 연결 가능한 경우에는 중복 빼주기
        int ans = 1;

        label: for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                for (int j = 0; j < d; j++) {
                    int checkr = r+dr[j];
                    int checkc = c+dc[j];
                    if (checkr >=0 && checkr< N && checkc>=0 && checkc< M && visited[nr][nc] == visited[checkr][checkc])
                        continue label;
                }
                ans+=result[nr][nc];
            }
        }
        return ans;
    }
}
