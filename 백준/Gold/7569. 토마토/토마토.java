import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Tomato {
        int m;
        int n;
        int h;
        int day;

        public Tomato(int m, int n, int h, int day) {
            this.m = m;
            this.n = n;
            this.h = h;
            this.day = day;
        }
    }


    static int M, N, H;
    static int[][][] map;


    static int[] dn = {1, -1, 0, 0, 0, 0};
    static int[] dm = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static int cntZero;
    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[M][N][H]; // 가로 M, 세로 N, 높이 H
        cntZero = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[m][n][h] = Integer.parseInt(st.nextToken());
                    if (map[m][n][h] == 1) {
                        q.add(new Tomato(m, n, h, 0));
                    }
                }
            }
        }


        int cnt = 0;

        while (!q.isEmpty()) {
            Tomato t = q.poll();
            cnt = t.day;
            change(t.m, t.n, t.h, t.day);

        }
        for (int h = 0; h < H; h++)
            for (int n = 0; n < N; n++)

                for (int m = 0; m < M; m++) {
                    if (map[m][n][h] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }

        System.out.println(cnt);
    }

    static void change(int m, int n, int h, int cnt) {


        for (int d = 0; d < 6; d++) {
            int nm = m + dm[d];
            int nn = n + dn[d];
            int nh = h + dh[d];
            if (nm >= 0 && nm < M && nn >= 0 && nn < N && nh >= 0 && nh < H && map[nm][nn][nh] == 0) {
                map[nm][nn][nh] = cnt + 1;
                q.add(new Tomato(nm, nn, nh, cnt + 1));
            }
        }
    }
}