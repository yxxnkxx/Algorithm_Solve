package BOJ.Gold.g2;

import java.util.*;

public class BOJ_17244_아맞다우산 {


    static class Items {

        int id;
        int r;
        int c;

        public Items(int id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
        }
    }


    static List<Items> items;
    static int N, M;
    static char[][] map;

    static int start_r;
    static int start_c;
    static int[] order;
    static boolean[] pick;
    static int itemCnt;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[M][N];
        int[][] visited = new int[M][N];
        for (int i = 0; i < M; i++)
            Arrays.fill(visited[i], -1);
        items = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String input = sc.next();
            map[i] = input.toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S') {
                    start_r = i;
                    start_c = j;
                } else if (map[i][j] == 'X') {
                    items.add(new Items(items.size(), i, j));
                }
            }
        }

        itemCnt = items.size();

        order = new int[itemCnt];
        pick = new boolean[itemCnt];
        perm(0);


        System.out.println(ans);
    }


    static void perm(int depth) {
        if (depth == itemCnt) {
            bfs();
            return;
        }
        for (int i = 0; i < itemCnt; i++) {
            if (!pick[i]) {
                pick[i] = true;
                order[depth] = i;
                perm(depth + 1);
                pick[i] = false;
            }
        }
    }

    static void bfs() {

        Queue<int[]> q = new LinkedList<>();

        int R = start_r;
        int C = start_c;

        int Time = 0;
        int[][] visit = new int[M][N];
        for (int i = 0; i < M; i++)
            Arrays.fill(visit[i], -1);
        out: for (int i = 0; i < itemCnt; i++) {

            Items item = items.get(order[i]); // 방문할 곳
            int dest_r = item.r;
            int dest_c = item.c;
            int id = item.id;


            q.add(new int[]{R, C, Time});

            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int r = tmp[0];
                int c = tmp[1];
                int time = tmp[2];


                if (r == dest_r && c == dest_c) {
                    // 목적지까지 도착함, 다음으로 이동
                    q.clear();
                    R = dest_r;
                    C = dest_c;
                    Time = time;

                    continue out;

                }

                if (visit[r][c] == id) continue;
                visit[r][c]=id;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if ((map[nr][nc] == '.' || map[nr][nc]=='X')&& visit[nr][nc] != id) {

                        q.add(new int[]{nr, nc, time + 1});
                    }
                }

            }
        }

        q.add(new int[]{R, C, Time});
        // 마지막에는 E를 향해서 ㄱㄱ
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            int time = tmp[2];

            if (map[r][c] == 'E') {
                // 목적지까지 도착함, 다음으로 이동
                ans = Math.min(ans, time);
                break;

            }

            if (visit[r][c] == 6) continue;
            visit[r][c]=6;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (map[nr][nc] != '#' && visit[nr][nc] != 6) {

                    q.add(new int[]{nr, nc, time + 1});

                }
            }

        }


    }
}



