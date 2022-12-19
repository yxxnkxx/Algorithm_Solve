
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int C, R;
    static char[][] map;
    static int[][][] visited; // 방향까지 저장
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[] start = new int[2];
        Arrays.fill(start, -1);
        int[] end = new int[2];
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++)
                if (map[i][j] == 'C') {
                    if (start[0] == -1) {
                        start[0] = i;
                        start[1] = j;
                    } else {
                        end[0] = i;
                        end[1] = j;
                    }
                }
        }

        // 삼차원 배열 -> 이전 방향이 어떤 방향이었는지 체크함
        visited = new int[R][C][5];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 4, 0}); // r, c, 방향, 거울 수
        for (int d = 0; d < 4; d++)
            visited[start[0]][start[1]][d] = 1; // start로 다시 가지 않도록
        /*
        4 5
        C..*
        ...*
        ...*
        *.**
        ...C

         */

        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] node = q.poll();

            int r = node[0];
            int c = node[1];
            int d = node[2];
            int cnt = node[3];


            if (r == end[0] && c == end[1]) {
                ans = Math.min(ans, cnt);
                continue;
            }

            visited[r][c][d] = cnt;
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '*' && (visited[nr][nc][dir] == 0 || visited[nr][nc][dir] > cnt)) {
                    // 방문 처리 여기서하기 -> 시간 절약

                    if (dir == d) {
                        visited[nr][nc][dir] = cnt;
                        q.add(new int[]{nr, nc, dir, cnt});
                    } else {
                        visited[nr][nc][dir] = cnt + 1;
                        q.add(new int[]{nr, nc, dir, cnt + 1});
                    }
                }

            }

        }
        System.out.println(ans - 1); // 맨처음 방향 바꾼건 빼기
    }
}
