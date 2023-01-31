package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {

    static class FireBall {
        int id;
        int r;
        int c;
        int d; // 방향
        int s; // 속력
        int m; // 질량
//        boolean active;

        public FireBall(int id, int r, int c, int d, int s, int m) {
            this.id = id;
            this.r = r;
            this.c = c;
            this.d = d;
            this.s = s;
            this.m = m;
        }
    }

    static int N, M, K;
    static List<FireBall> fireBalls;
    static List<Integer>[][] map; // fireball의 index를 적음
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new List[N + 1][N + 1];
        fireBalls = new ArrayList<>(); // M개
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBalls.add(new FireBall(i, r, c, d, s, m));
            map[r][c].add(i);
        }
        int idx = M + 1;
        while (K-- > 0) {
            // 파이어볼 이동
            for (FireBall f : fireBalls) {
                int nr = f.r + dr[f.d] * f.s;
                int nc = f.c + dc[f.d] * f.s;
                // 순환 처리
                if (nr <= 0)
                    nr += N;
                else if (nr > N)
                    nr -= N;
                if (nc >= 0)
                    nc += N;
                else if (nc > N)
                    nc -= N;
                map[nr][nc].add(f.id);
                map[f.r][f.c].remove(f.id);
                f.r = nr;
                f.c = nc;
            }

            // 파이어볼 합치기
            for (int i=1; i<=N; i++)
                for (int j=1; j<=N; j++)
                    if (map[i][j].size()>=2) {

                    }

        }


    }
}
