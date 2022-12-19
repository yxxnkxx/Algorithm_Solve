package prg.lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PRG_경주로건설 {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static public int solution(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        int[][][] visited = new int[R][C][4];
        int answer = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0}); // 시작점의 r,c,방향,비용
        for (int d = 0; d < 4; d++)
            visited[0][0][d] = -1; // 시작점 다시 방문X
        while (!q.isEmpty()) {
            int[] road = q.poll();
            int r = road[0];
            int c = road[1];
            int dir = road[2];
            int cost = road[3];

            if (r == R - 1 && c == C - 1) {
                answer = Math.min(answer, cost);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int newCost = (dir == d || (r == 0 && c == 0)) ? cost + 100 : cost + 600;

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && board[nr][nc] == 0 && (visited[nr][nc][d]== 0 || visited[nr][nc][d] >= newCost)) {
                    visited[nr][nc][d] = newCost;
                    q.add(new int[]{nr, nc, d, newCost});
                }
            }
        }


        return answer;
    }


    public static void main(String[] args) {
//        int[][] board = {{0,0,1,1}, {0, 0, 1, 1}, {0,0,0,0},{0,0,0,0}};
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}};
//        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }
}
