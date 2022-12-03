package BOJ.Gold.g4;

import java.util.*;

public class BOJ_3190_뱀 {
    static final int APPLE = 2;
    static final int SNAKE = 1;

    static int[] dr = {0, 1, 0, -1}; // D기준 (오른쪽으로 회전) 오-아-왼-위
    static int[] dc = {1, 0, -1, 0}; // 오-아-왼-위

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N + 1][N + 1];
        int K = sc.nextInt(); // 사과 개수
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r][c] = APPLE; // 사과는 2
        }
        int L = sc.nextInt(); // 방향 전환
        Map<Integer, String> dirMap = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int sec = sc.nextInt();
            String dir = sc.next();
            dirMap.put(sec, dir);
        }
        Deque<int[]> snake = new ArrayDeque<>();
        map[1][1] = SNAKE; // 뱀은 1로 표시
        snake.offerFirst(new int[]{1, 1});
        int sec = 0;
        int dir = 0; // 처음 방향은 오른쪽

        while (true) {
            sec++;

            int[] head = snake.peekFirst(); // head

            // 머리를 다음칸에 위치
            int nr = head[0] + dr[dir];
            int nc = head[1] + dc[dir];

            if (nr < 1 || nr > N || nc < 1 || nc > N) {
                // 벽에 부딪힘
                System.out.println(sec);
                break;
            }

            // 머리 옮겨주기
            if (map[nr][nc] == 1) {
                // 자신의 몸에 부딪힘
                System.out.println(sec);
                break;
            }
            // 사과가 있는지 검사
            if (map[nr][nc] != APPLE) {
                // 사과가 없으면 꼬리 없애기
                int[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            // 새로운 head 추가
            map[nr][nc] = 1;
            snake.addFirst(new int[]{nr, nc});


            // 회전하는지 확인
            if (dirMap.get(sec) != null) {
                String rotate = dirMap.get(sec);
                if (rotate.equals("L")) {
                    dir = (4 + dir - 1) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }

        }

    }
}
