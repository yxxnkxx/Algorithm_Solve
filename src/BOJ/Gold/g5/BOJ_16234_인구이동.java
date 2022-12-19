package BOJ.Gold.g5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16234_인구이동 {
    static int N; // 땅 크기
    static int L, R;
    static int[][] map;
    static int[][] visited;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int cnt = 0; // 영역의 개수
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        int day = 0; // 이동 날짜
        while (true) {
            boolean move = false;
            visited = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    sum = 0;
                    cnt = 0;
                    int visit = i * N + j + 1; // 방문 여부를 각각의 index마다 기록하기
                    if (visited[i][j] == 0) { // 아직 방문하지 않았다면
                        visited[i][j] = visit;
                        dfs(i, j, visit);
                    }

                    if (cnt > 1) {
                        move = true;
                        int val = sum / cnt;
                        for (int r = 0; r < N; r++)
                            for (int c = 0; c < N; c++) {
                                if (visited[r][c] == visit) {
                                    map[r][c] = val;
                                }
                            }
                    }
                }
            if (!move) {
                break;
            }


            day++;
        }
        System.out.println(day);

    }

    static void dfs(int i, int j, int visit) {
        cnt++;
        sum += map[i][j];

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0 && Math.abs(map[nr][nc] - map[i][j]) >= L && Math.abs(map[nr][nc] - map[i][j]) <= R) {
                visited[nr][nc] = visit;
                dfs(nr, nc, visit);
            }
        }

    }

}
