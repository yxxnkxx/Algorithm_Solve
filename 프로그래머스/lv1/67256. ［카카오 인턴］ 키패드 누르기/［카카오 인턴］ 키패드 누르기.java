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
        int leftDis = Math.abs(left[0]-pos[0]) + Math.abs(left[1]-pos[1]);
        int rightDis = Math.abs(right[0]-pos[0]) + Math.abs(right[1]-pos[1]);
        // 왼손
       

        if (rightDis < leftDis) return true;
        else if (rightDis > leftDis) return false;
        else {
            if (hand.equals("right")) return true;
            else return false;
        }


    }
}