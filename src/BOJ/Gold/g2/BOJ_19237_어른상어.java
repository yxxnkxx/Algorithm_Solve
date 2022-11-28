package BOJ.Gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_19237_어른상어 {

    static class Shark implements Comparable<Shark> {
        int r; // r좌표
        int c; // c좌표
        int num; // 번호
        int dir; // 방향
        int[][] priority; // 우선순위 배열
        boolean removed;
        // 방향은 1,2,3,4 위 아래 왼 오

        public Shark(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
            removed = false;

        }

        @Override
        public int compareTo(Shark o) {
            return this.num - o.num;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", num=" + num +
                    ", dir=" + dir +
                    ", priority=" + Arrays.deepToString(priority) +
                    '}';
        }
    }

    static class Smell {
        int val; // 몇 번 상어의 냄새인지
        int life; // 몇 번 남았는지 -> k가 되면 삭제

        public Smell(int val, int life) {
            this.val = val;
            this.life = life;
        }
    }


    static int N; // N*N격자
    static int M; // 상어 번호
    static int K; // 상어는 k번이동

    static int[][] map; // N*N
    static Smell[][] smells;

    static List<Shark> sharks;

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        smells = new Smell[N][N]; // 냄새 기록
        sharks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    sharks.add(new Shark(i, j, map[i][j]));
                }
            }
        }

        // 입력

        Collections.sort(sharks); // 번호 순 정렬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            // 상어 방향
            sharks.get(i).dir = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            Shark s = sharks.get(i);
            int[][] priority = new int[5][4]; //[향하는 방향(1~4)][우선순위 방향]
            for (int d = 1; d <= 4; d++) {
                st = new StringTokenizer(br.readLine());
                for (int p = 0; p < 4; p++) {
                    priority[d][p] = Integer.parseInt(st.nextToken());
                }
            }
            s.priority = priority;
            sharks.set(i, s);
        }

        // map은 상어들의 위치


        int cnt = 0;

        for (int i = M - 1; i >= 0; i--) {
            Shark s = sharks.get(i);
            smells[s.r][s.c] = new Smell(s.num, K); // 처음 상태의 냄새 기록
        }
        while (cnt <= 1000) {
            // 1. 현재 냄새 뿌리기

            // 2. 이동
            int[][] tmp = new int[N][N];
            for (int i = M - 1; i >= 0; i--) {
                Shark s = sharks.get(i);
                if (s.removed) continue; // 제거됐으면 안봄
                int[] priority = s.priority[s.dir]; // 현재 방향의 우선순위 배열
                boolean isEmpty = false;
                for (int d = 0; d < 4; d++) {
                    int dir = priority[d]; // 이동할 후보 보기
                    int nr = s.r + dr[dir];
                    int nc = s.c + dc[dir];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && smells[nr][nc] == null) {
                        isEmpty = true;
                        // 이미 tmp가 있으면 걔 없애고 작은 애가 위치함
                        if (tmp[nr][nc] != 0) {
                            sharks.get(tmp[nr][nc] - 1).removed = true;
                        }
                        tmp[nr][nc] = s.num;


                        s.r = nr;
                        s.c = nc;
                        s.dir = dir;
                        break;
                    }
                }
                if (!isEmpty) {
                    // 자기 자신의 냄새가 있는 곳으로 이동
                    for (int d = 0; d < 4; d++) {
                        int dir = priority[d]; // 이동할 후보 보기
                        int nr = s.r + dr[dir];
                        int nc = s.c + dc[dir];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N && smells[nr][nc] != null && smells[nr][nc].val == s.num) {
                            tmp[nr][nc] = s.num;
                            s.r = nr;
                            s.c = nc;
                            s.dir = dir;
                            break;
                        }
                    }
                }

            }

            // map을 tmp로 바꾸기
            // 3. 1만 남았는지 확인
            boolean onlyOne = true;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    // 없어질 냄새 확인
                    if (smells[i][j] != null) {
                        Smell smell = smells[i][j];

                        smell.life--;
                        if (smell.life == 0) {
                            smells[i][j] = null;
                        }
                    }
                    // 1만 남았는지 확인
                    if (map[i][j] != 0 && map[i][j] != 1) {
                        onlyOne = false;
                    }

                    // map과 smell에 추가
                    map[i][j] = tmp[i][j];
                    if (map[i][j] != 0) {
                        smells[i][j] = new Smell(map[i][j], K);
                    }
                }
            if (onlyOne) {
                System.out.println(cnt);
                return;
            }


            // 1000초가 넘어도 남아있으면 -1

            cnt++;
        }

        System.out.println(-1);

    }
}
