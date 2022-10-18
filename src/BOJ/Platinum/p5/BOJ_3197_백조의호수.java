package BOJ.Platinum.p5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3197_백조의호수 {

    static int R, C;
    static char[][] map;
    static List<int[]> swans;
    static int R0, C0, R1, C1;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] visited;

    static Queue<int[]> water;
//    static Queue<int[]> next;
//    static Queue<int[]> curr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        swans = new ArrayList<>();// 각 백조의 r, c 좌표
        water = new LinkedList<>();
        visited = new int[R][C];
        for (int i = 0; i < R; i++)
            Arrays.fill(visited[i], -1);

        // 방문 가능 여부를 매번 초기화하지 않고 이전에 방문한 곳들은 그 날짜로, 불가능한 곳은 -1로

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


        // 현재 갈 수 있는 곳 검사
        if (isPossible(0))
            System.out.println(0);
        else {
            find(0);
        }


    }

    static void find(int day) {

        // 현재 갈 수 있는 곳을 돌면서 다음에 갈 수 있는 곳을 next queue에 넣기
        int size = water.size();
        boolean[][] curr = new boolean[R][C];
        while (size-- > 0) {
            int[] tmp = water.poll();
            System.out.println(tmp[0]+" "+tmp[1]);
            if (tmp[0] == R1 && tmp[1] == C1 && visited[tmp[0]][tmp[1]] != -1) {
                System.out.println(visited[tmp[0]][tmp[1]]);
                return;
            }
            if (curr[tmp[0]][tmp[1]]) continue;
            curr[tmp[0]][tmp[1]] = true;
            for (int d = 0; d < 4; d++) {
                int nr = tmp[0] + dr[d];
                int nc = tmp[1] + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 'X' && visited[nr][nc] != day) {
                    map[nr][nc] = '.';
                    water.add(new int[]{nr, nc});
                    if (visited[tmp[0]][tmp[1]] != -1) {
                        visited[nr][nc] = visited[tmp[0]][tmp[1]] + 1;
                    }
                }
            }
        }


        find(day + 1);

    }

    static boolean isPossible(int day) {


        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{R0, C0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == R1 && tmp[1] == C1) return true;
            if (visited[tmp[0]][tmp[1]] == day) continue;
            visited[tmp[0]][tmp[1]] = day;

            for (int d = 0; d < 4; d++) {
                int nr = tmp[0] + dr[d];
                int nc = tmp[1] + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 'X' && visited[nr][nc] != day) {
                    q.add(new int[]{nr, nc});

                }
            }
        }


        return false;

    }
}
