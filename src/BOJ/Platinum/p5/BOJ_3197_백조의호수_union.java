package BOJ.Platinum.p5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3197_백조의호수_union {


    static int R, C;
    static char[][] map;
    static List<int[]> swans;
    static int R0, C0, R1, C1;
    static Queue<int[]> water;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[] p;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        swans = new ArrayList<>();// 각 백조의 r, c 좌표
        water = new LinkedList<>();
        p = new int[R * C];
        visited = new boolean[R][C];
        for (int i = 0; i < p.length; i++)
            p[i] = i;


        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    swans.add(new int[]{i, j});
                }
                if (map[i][j] != 'X') {
                    water.add(new int[]{i, j});
                }
            }
        } // 입력
        R0 = swans.get(0)[0];
        C0 = swans.get(0)[1];
        R1 = swans.get(1)[0];
        C1 = swans.get(1)[1];

        int pos0 = (C * R0) + C0;
        int pos1 = (C * R1) + C1;
        int day = 0;
        while (find(pos0) != find(pos1)) {
            day++;
            int size = water.size();
            while (size-- > 0) {
                int[] tmp = water.poll();
                if (visited[tmp[0]][tmp[1]]) continue;
                visited[tmp[0]][tmp[1]] = true;
                int posTmp = (C * tmp[0]) + tmp[1];
                for (int d = 0; d < 4; d++) {
                    int nr = tmp[0] + dr[d];
                    int nc = tmp[1] + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        int posN = (C * nr) + nc;
                        if (map[nr][nc] == 'X' && !visited[nr][nc]) {
                            p[find(posN)] = p[find(posTmp)];
                            water.add(new int[]{nr, nc});
                            map[nr][nc] = '.';

                        } else if (map[nr][nc] == '.' && find(posTmp) != find(posN))
                            p[find(posN)] = p[find(posTmp)];
                    }
                }
            }
            // 현재 큐에 있는 애들 중에서 이동 가능한지 찾아서 union
            size = water.size();
            for (int i=0; i<size; i++) {
                int[] tmp = water.poll();
                water.add(tmp);
                int posTmp = (C * tmp[0]) + tmp[1];
                for (int d = 0; d < 4; d++) {
                    int nr = tmp[0] + dr[d];
                    int nc = tmp[1] + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        int posN = (C * nr) + nc;
                         if (map[nr][nc] == '.' && find(posTmp) != find(posN))
                            p[find(posN)] = p[find(posTmp)];
                    }
                }
            }


        }
        System.out.println(day);

    }


    static int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[py] = px;
        }
    }


}
