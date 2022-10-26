package BOJ.Gold.g2;

import java.util.*;

public class BOJ_17143_낚시왕 {

    static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }

    static int R, C, M;
    static int[][] map;
    static List<Shark> sharks;
    static int ans;

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        map = new int[R + 1][C + 1];
        sharks = new ArrayList<>(); // key=상어의 크기 (크기는 모두 다름), value=Shark 클래스
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            Shark shark = new Shark(r, c, s, d, z);
            sharks.add(shark);
            map[r][c] = z; // 상어 크기를 저장해두기
        }
        // 상어 크기순으로 정렬
        Collections.sort(sharks, new Comparator<Shark>() {
            @Override
            public int compare(Shark o1, Shark o2) {
                return o1.z - o2.z;
            }
        });

        for (int i = 1; i <= C; i++) {
            // 1. 낚시왕이 상어를 잡음
            catchShark(i);
            moveShark();

        }
        System.out.println(ans);

    }

    static void catchShark(int c) {
        for (int r = 1; r <= R; r++) {
            if (map[r][c] != 0) {
                ans += map[r][c];
                for (int i = 0; i < sharks.size(); i++) {
                    if (map[r][c] == sharks.get(i).z) {
                        sharks.remove(i);
                        break;
                    }
                }

                // 상어를 먹음
                map[r][c] = 0;
                return;
            }
        }
    }

    static void moveShark() {

        for (int z = sharks.size() - 1; z >= 0; z--) {
            Shark shark = sharks.get(z); // 상어가 큰 순서대로 입력이 들어옴
            // 제거를 그냥 하면 for문에서 혼선이 새익ㅁ..
            if (shark.z==-1) continue; // 제거 표시
            int nr = 0;
            int nc = 0;
            if (shark.d == 1 || shark.d == 2) {
                nr = shark.r + dr[shark.d] * (shark.s % (2 * (R - 1)));
                while (nr > R || nr < 1) {
                    if (nr > R) {
                        nr = R - (nr - R);
                        shark.d = 1;
                    }
                    if (nr < 1) {
                        nr = 1 + (1 - nr);
                        // 방향 바꾸기
                        shark.d = 2;
                    }
                }
                nc = shark.c;
            } else {
                nc = shark.c + dc[shark.d] * (shark.s % (2 * (C - 1)));
                while (nc > C || nc < 1) {
                    if (nc > C) {
                        nc = C - (nc - C);
                        shark.d = 4;
                    }
                    if (nc < 1) {
                        nc = 1 + (1 - nc);
                        shark.d = 3;
                    }
                }
                nr = shark.r;
            }
            if (map[shark.r][shark.c] == shark.z) map[shark.r][shark.c] = 0;
            if (map[nr][nc] > shark.z) {
                // 큰 거 부터 검사하니까 작은 애들이 큰 걸 만났을 때는 이미 이동 완료임, 여기로 이동할 수 없음
                shark.z=-1;

            } else {
                map[nr][nc] = shark.z;
                shark.r = nr;
                shark.c = nc;
            }

        }

    }
}
