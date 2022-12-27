package BOJ.Gold.g3;

import java.util.Scanner;

public class BOJ_14890_경사로 {
    static int N, L;
    static int[][] map;
    static int[][] visited;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();


        for (int i = 0; i < N; i++) {
            if (canPass(i, 1)) ans++;
            if (canPass(i, 2)) ans++;
        }
        System.out.println(ans);
    }

    static boolean canPass(int i, int dir) {
        // dir이 1이면 row 검사, 2이면 col 검사
        if (dir == 1) {
            for (int c = 0; c < N - 1; c++) {
                if (map[i][c] == map[i][c + 1]) continue; // 같으면 ok
                if (Math.abs(map[i][c] - map[i][c + 1]) > 1) return false; // 두 경사로의 차이가 1보다 크다

                // 경사로를 놓을 곳 = 낮은 곳
                if (map[i][c] > map[i][c + 1]) {
                    // c+1 부터 c+L까지 경사로 놓는다
                    if (c + L >= N) return false;
                    int val = map[i][c + 1];
                    for (int x = c + 1; x <= c + L; x++) {
                        if (visited[i][x] == 1 || map[i][x] != val) return false; // 이미 경사로가 있거나 높이가 같지 않으면 불가능

                    }
                    // 여기까지 오면 경사로를 놓을 수 있다.
                    for (int x = c + 1; x <= c + L; x++) {
                        visited[i][x] = 1;
                    }


                } else {
                    // c부터 c-(L-1)까지 경사로 놓는다
                    if (c - L + 1 < 0) return false;
                    int val = map[i][c];
                    for (int x = c; x >= c - L + 1; x--) {
                        if (visited[i][x] == 1 || map[i][x] != val) return false;
                    }
                    for (int x = c; x >= c - L + 1; x--) {
                        visited[i][x] = 1;
                    }
                }
            }
        } else {
            // col 검사
            for (int r = 0; r < N - 1; r++) {
                if (map[r][i] == map[r + 1][i]) continue; // 같으면 ok
                if (Math.abs(map[r][i] - map[r + 1][i]) > 1) return false; // 두 경사로의 차이가 1보다 크다

                // 경사로를 놓을 곳 = 낮은 곳
                if (map[r][i] > map[r + 1][i]) {
                    // c+1 부터 c+L까지 경사로 놓는다
                    if (r + L >= N) return false;
                    int val = map[r + 1][i];
                    for (int x = r + 1; x <= r + L; x++) {
                        if (visited[x][i] == 2 || map[x][i] != val) return false; // 이미 경사로가 있거나 높이가 같지 않으면 불가능

                    }
                    // 여기까지 오면 경사로를 놓을 수 있다.
                    for (int x = r + 1; x <= r + L; x++) {
                        visited[x][i] = 2;
                    }


                } else {
                    // r부터 r-(L-1)까지 경사로 놓는다
                    if (r - L + 1 < 0) return false;
                    int val = map[r][i];
                    for (int x = r; x >= r - L + 1; x--) {
                        if (visited[x][i] == 2 || map[x][i] != val) return false;
                    }
                    for (int x = r; x >= r - L + 1; x--) {
                        visited[i][x] = 2;
                    }
                }
            }
        }

        return true;


    }
}
