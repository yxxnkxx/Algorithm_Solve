package prg.lv2;

public class PRG_전력망둘로나누기 {

    public static int solution(int n, int[][] wires) {
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            int st = wires[i][0];
            int ed = wires[i][1];
            matrix[st][ed] = 1;
            matrix[ed][st] = 1;
        }
        int answer = Integer.MAX_VALUE;
        // edge 하나씩 끊으면서 검사
        for (int i = 0; i < n - 1; i++) {
            int st = wires[i][0];
            int ed = wires[i][1];
            matrix[st][ed] = 0;
            matrix[ed][st] = 0;
            // 그래프 탐색, st에서 cnt랑 ed에서 cnt 차이 절대값
            int cnt1 = find(n, st, matrix, new boolean[n + 1], 1);
            int cnt2 = find(n, ed, matrix, new boolean[n + 1], 1);
            answer = Math.min(answer, Math.abs(cnt1-cnt2));
            matrix[st][ed] = 1;
            matrix[ed][st] = 1;
        }

        return answer;
    }

    private static int find(int n, int st, int[][] matrix, boolean[] visited, int cnt) {
        visited[st] = true;
        for (int i = 1; i <= n; i++) {
            if (matrix[st][i] == 1 && !visited[i]) {
                cnt= find(n, i, matrix, visited, cnt + 1);

            }
        }


        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{1,2},{2,3},{3,4}}));
    }
}
