package prg.lv2;

public class PRG_전력망둘로나누기 {

    public static int solution(int n, int[][] wires) {
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            int st = wires[i][0];
            int ed = wires[i][1];
            matrix[st][ed] = 1;
            matrix[ed][st] = 1;
        }

        // edge 하나씩 끊으면서 검사
        for (int i = 0; i < n; i++) {
            int st = wires[i][0];
            int ed = wires[i][1];
            matrix[st][ed] = 0;
            matrix[ed][st] = 0;
            // 그래프 탐색, st에서 cnt랑 ed에서 cnt 차이 절대값
            int cnt1 = find(st, matrix);
            int cnt2 = find(ed, matrix);
            matrix[st][ed] = 1;
            matrix[ed][st] = 1;
        }

        int answer = -1;
        return answer;
    }

    private static int find(int st, int[][] matrix) {
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
}
