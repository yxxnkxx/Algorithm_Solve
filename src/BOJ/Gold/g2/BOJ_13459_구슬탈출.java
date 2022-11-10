package BOJ.Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13459_구슬탈출 {
    static char[][] board;
    static int N, M;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static boolean[][][][] visited;
    static int ans;
    static boolean hole;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        int Rr = 0;
        int Rc = 0;
        int Br = 0;
        int Bc = 0;
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.contains("R")) {
                Rr = i;
                Rc = str.indexOf('R');
            }
            if (str.contains("B")) {
                Br = i;
                Bc = str.indexOf('B');
            }
            board[i] = str.toCharArray();
        }
        bfs(Rr, Rc, Br, Bc);
        if (ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(1);

    }

    static void bfs(int rr, int rc, int br, int bc) {
        // 해당 방향으로 벽을 만날 때까지 고고
        // 중간에 O를 만나면 스탑 -- bool 로 체크
        // 벽을 만나면 스탑

        visited[rr][rc][br][bc] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { rr, rc, br, bc, 0 });

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cnt = tmp[4];
            if (cnt >= 10)
                return;
            for (int d = 0; d < 4; d++) {
                int nR_r = tmp[0];
                int nC_r = tmp[1];
                int nR_b = tmp[2];
                int nC_b = tmp[3];
                while (board[nR_r + dr[d]][nC_r + dc[d]] != '#') {
                    nR_r += dr[d];
                    nC_r += dc[d];
                    if (board[nR_r][nC_r] == 'O')
                        break;
                }

                while (board[nR_b + dr[d]][nC_b + dc[d]] != '#') {
                    nR_b += dr[d];
                    nC_b += dc[d];
                    if (board[nR_b][nC_b] == 'O')
                        break;
                }

                if (board[nR_b][nC_b] == 'O')
                    continue; // 파란 구멍이 들어감
                if (board[nR_r][nC_r] == 'O') {
                    ans = Math.min(ans, cnt + 1); // 빨간공
                    return;
                }

                // 두 공이 만났을 때 처리
                if (nR_r == nR_b && nC_r == nC_b) {
                    int red = Math.abs(nR_r - tmp[0]) + Math.abs(nC_r - tmp[1]);
                    int blue = Math.abs(nR_b - tmp[2]) + Math.abs(nC_b - tmp[3]);
                    if (red > blue) {
                        nR_r -= dr[d];
                        nC_r -= dc[d];
                    } else {
                        nR_b -= dr[d];
                        nC_b -= dc[d];
                    }
                }

                if (!visited[nR_r][nC_r][nR_b][nC_b]) {
                    visited[nR_r][nC_r][nR_b][nC_b] = true;
                    q.add(new int[] { nR_r, nC_r, nR_b, nC_b, cnt + 1 });
                }

            }

        }

    }
}
