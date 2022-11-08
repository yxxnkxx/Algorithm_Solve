import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static Map<Integer, int[]> posMap;

    static public String solution(int[] numbers, String hand) {


        String answer = "";
        int[][] map = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -1}};

        posMap = new HashMap<>();
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == -1) continue;
                posMap.put(map[i][j], new int[]{i, j});

            }

        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};
        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {
                case 1:
                case 4:
                case 7:
                    answer += "L";
                    int[] posL = posMap.get(numbers[i]);
                    left[0] = posL[0];
                    left[1] = posL[1];
                    break;
                case 3:
                case 6:
                case 9:
                    answer += "R";
                    int[] posR = posMap.get(numbers[i]);
                    right[0] = posR[0];
                    right[1] = posR[1];
                    break;
                default:
                    boolean isRight = find(left, right, numbers[i], hand);
                    if (isRight) {
                        answer += "R";
                        int[] pos1 = posMap.get(numbers[i]);
                        right[0] = pos1[0];
                        right[1] = pos1[1];

                    } else {
                        answer += "L";
                        int[] pos2 = posMap.get(numbers[i]);
                        left[0] = pos2[0];
                        left[1] = pos2[1];
                    }
                    break;
            }
        }


        return answer;
    }

    static boolean find(int[] left, int[] right, int num, String hand) {
        // bfs로 거리 찾기
        int[] pos = posMap.get(num);
        int leftDis = -1;
        int rightDis = -1;
        // 왼손
        Queue<int[]> leftQ = new LinkedList<>();
        leftQ.add(new int[]{left[0], left[1], 0});
        boolean[][] visited = new boolean[4][3];
        int[] tmp;
        while (!leftQ.isEmpty()) {
            tmp = leftQ.poll();
            int r = tmp[0];
            int c = tmp[1];
            int cnt = tmp[2];
            if (r == pos[0] && c == pos[1]) {
                leftDis = cnt;
                break;
            }

            if (visited[r][c]) continue;
            visited[r][c] = true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 3 && !visited[nr][nc])
                    leftQ.add(new int[]{nr, nc, cnt + 1});
            }
        }

        // 오른손
        Queue<int[]> rightQ = new LinkedList<>();
        rightQ.add(new int[]{right[0], right[1], 0});
        visited = new boolean[4][3];

        while (!rightQ.isEmpty()) {
            tmp = rightQ.poll();
            int r = tmp[0];
            int c = tmp[1];
            int cnt = tmp[2];
            if (r == pos[0] && c == pos[1]) {
                rightDis = cnt;
                break;
            }

            if (visited[r][c]) continue;
            visited[r][c] = true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 3 && !visited[nr][nc])
                    rightQ.add(new int[]{nr, nc, cnt + 1});
            }
        }

        if (rightDis < leftDis) return true;
        else if (rightDis > leftDis) return false;
        else {
            if (hand.equals("right")) return true;
            else return false;
        }


    }
}