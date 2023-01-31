import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class FireBall {
        int id;
        int r;
        int c;
        int d; // 방향
        int s; // 속력
        int m; // 질량

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
    static Map<Integer, FireBall>[][] map; // fireball의 index를 적음
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Map[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                map[i][j] = new HashMap<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            FireBall f = new FireBall(i, r, c, d, s, m);
            map[r][c].put(i, f);
        }
        idx = M + 1;
        while (K-- > 0) {
            // 파이어볼 이동
            List<FireBall> tmp = new ArrayList<>();
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (!map[i][j].isEmpty()) {
                        for (FireBall f : map[i][j].values()) {
                            int nr = f.r + dr[f.d] * f.s;
                            int nc = f.c + dc[f.d] * f.s;
                            // 순환 처리
                            if (nr <= 0) nr += N * (-nr / N + 1);
                            else if (nr > N) nr -= N * (nr / N);
                            if (nc <= 0) nc += N * (-nc / N + 1);
                            else if (nc > N) nc -= N * (nc / N);
                            if (nr == 0) nr = N;
                            if (nc == 0) nc = N;
                            tmp.add(new FireBall(f.id, nr, nc, f.d, f.s, f.m));
                        }
                        map[i][j] = new HashMap<>(); // i,j에는 이제 값x
                    }
            for (FireBall f : tmp) {
                map[f.r][f.c].put(f.id, f);
            }

            // 파이어볼 합치기
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (map[i][j].size() >= 2) {
                        split(i, j);
                    }

        }

        // 합 구하기
        int sum = 0;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                if (!map[i][j].isEmpty())
                    for (FireBall value : map[i][j].values()) {
                        sum += value.m;
                    }
        System.out.println(sum);


    }

    static void split(int i, int j) {
        Set<Integer> keySet = map[i][j].keySet();

        List<FireBall> list = map[i][j].keySet().stream().map(o -> map[i][j].get(o)).collect(Collectors.toList());
        int sum = list.stream().mapToInt(o -> o.m).sum() / 5;

        map[i][j] = new HashMap<>();// 기존 값 삭제하기
        if (sum != 0) {
            int newS = list.stream().mapToInt(o -> o.s).sum() / keySet.size();
            // 합쳐지는 파이어볼 방향 확인
            if (checkDir(list)) { // 모두 홀수 또는 짝수
                for (int d = 0; d < 4; d++) {
                    FireBall fireBall = new FireBall(idx, i, j, d * 2, newS, sum);
//                    fireBalls.put(idx, fireBall);
                    map[i][j].put(idx++, fireBall);
                }
            } else {
                for (int d = 0; d < 4; d++) {
                    FireBall fireBall = new FireBall(idx, i, j, d * 2 + 1, newS, sum);
//                    fireBalls.put(idx, fireBall);
                    map[i][j].put(idx++, fireBall);
                }
            }

        }


    }

    static boolean checkDir(List<FireBall> fireBalls) {
        boolean isOdd = false; // 홀수
        boolean isEven = false; // 짝수
        for (FireBall fireBall : fireBalls) {
            if (fireBall.d % 2 == 0) isEven = true;
            else isOdd = true;
        }

        return (isEven && !isOdd) || (!isEven && isOdd);
    }
}