
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] visited;
    static int[][] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        int prev = 0; // 치즈의 개수
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) prev++;
            }
        visited = new int[N][M];
        tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(tmp[i], -1);
        }
        // 가장자리는 0으로 시작
        for (int i = 0; i < N; i++) {
            visited[i][0] = 1;
            visited[i][M - 1] = 1;
        }
        for (int j = 0; j < M; j++) {
            visited[0][j] = 1;
            visited[N - 1][j] = 1;
        }


        int day = 1;

        int curr; // 현재 남아 있는 치즈의 개수
        while (true) {
            // 공기 확인
            // 공기라면 해당 day로 만들기
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if (visited[i][j] == day) // 1일차라면 공기는 2일로 칠한다 -> 다음에 확인할 때 2일차 공기를 다시 확인
                        fillAir(i, j, day); // 공기랑 인접한 게 빈 공간이라면 공기로 표시하기


            // 공기와 인접한 치즈 녹이기
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if (map[i][j] == 1 && visited[i][j] == 0 && canMelt(i, j)) {
                        // 아직 녹지 않은 치즈라면
                        tmp[i][j] = day;
                    }

            curr = 0;
            // visited를 day로 만들기
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++) {
                    if (tmp[i][j] == day) {
                        visited[i][j] = day + 1;
                        map[i][j] = 0;
                    }
                    if (map[i][j] == 1) {
                        // 녹지않은 치즈
                        curr++;
                    }
                }
            
            if (curr == 0) {
                System.out.println(day);
                System.out.println(prev);
                break;
            }

            prev = curr; // prev update
            day++;


        }


    }

    static void fillAir(int i, int j, int day) {
        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && visited[nr][nc] == 0) {
                visited[nr][nc] = day + 1;
                fillAir(nr, nc, day);
            }
        }
    }

    static boolean canMelt(int i, int j) {
        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] != 0) {
                return true;
            }
        }
        return false;
    }

}