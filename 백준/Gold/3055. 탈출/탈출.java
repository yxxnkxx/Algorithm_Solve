import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];

        Queue<int[]> sq = new LinkedList<>();
        Queue<int[]> wq = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == 'S')
                    sq.add(new int[]{r, c, 0});
                else if (map[r][c] == '*')
                    wq.add(new int[]{r, c});
            }
        }
        while (!sq.isEmpty()) {
            int wSize = wq.size();
            for (int i = 0; i < wSize; i++) {
                int[] water = wq.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = water[0] + dr[d];
                    int nc = water[1] + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
                        map[nr][nc] = '*';
                        wq.add(new int[]{nr, nc});
                    }
                }
            }

            int sSize = sq.size();
            for (int i = 0; i < sSize; i++) {
                int[] hog = sq.poll();
                int r = hog[0];
                int c = hog[1];
                int time = hog[2];
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if (map[nr][nc] == 'D') {
                            System.out.println(time + 1);
                            return;
                        } else if (map[nr][nc] == '.') {
                            map[nr][nc] = 'S';
                            sq.add(new int[]{nr, nc, time + 1});
                        }
                    }

                }
            }
        }
        System.out.println("KAKTUS");

    }
}