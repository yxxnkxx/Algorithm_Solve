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

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

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

        int ans = 0;
        // bfs 비트마스킹
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_r, start_c, 0, 0, 0});
        int itemCnt = items.size();
        while (!q.isEmpty()) {

            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            int cnt = tmp[2];
            int time = tmp[3];
            int visit = tmp[4];

            if (map[r][c] == 'E') {
                if (visit == Math.pow(2, itemCnt) - 1) {
                    ans = time;
                    break;
                }
            }
            if (map[r][c] == 'E') continue;

            if (map[r][c] == 'X') {
                int id = 0;

                for (int i = 0; i < itemCnt; i++) {
                    if (items.get(i).r == r && items.get(i).c == c) {
                        id = items.get(i).id;
                        break;
                    }
                }

                if ((visit & (1 << id)) == 0) {// 방문한적 없음
                    q.add(new int[]{r, c, cnt + 1, time, (visit | (1 << id))});

                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (map[nr][nc] != '#' && visited[nr][nc] != visit) {
                    visited[nr][nc] = visit;
                    q.add(new int[]{nr, nc, cnt, time + 1, visit});

                }
            }

        }
        System.out.println(ans);
    }


}

