package BOJ.Gold.g4;

import java.util.Scanner;

public class BOJ_2573_빙산 {
    static int N, M;
    static int[][] map;
    static int[][] tmp;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
        int cnt = 0;
        while (true) {
            // 빙산 녹기
            cnt++;
            tmp = new int[N][M]; // 얼마나 녹을건지 써놓기
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0)
                            tmp[i][j]++;
                    }
                }


            visited = new boolean[N][M];
            // dfs로 그래프 연결되어 있는지 찾기
            int bundle = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        map[i][j] -= tmp[i][j];
                        if (map[i][j] < 0) map[i][j] = 0;
                        if (map[i][j] != 0) {
                            bundle++;
                            dfs(i, j);
                        }
                    }
                }
            if (bundle>1) {
                System.out.println(cnt);
                break;
            }
            if (bundle==0) {
                System.out.println("0");
                break;
            }

            // 다 녹았으면 0
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {

            int nr = i + dr[d];
            int nc = j + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && !visited[nr][nc]) {
                map[nr][nc] -= tmp[nr][nc];
                if (map[nr][nc] < 0) map[nr][nc] = 0;
                if (map[nr][nc] != 0) {

                    dfs(nr, nc);
                }
        }

    }
}
}
