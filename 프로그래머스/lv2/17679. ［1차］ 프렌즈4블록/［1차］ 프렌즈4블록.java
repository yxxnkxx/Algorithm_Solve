class Solution {
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 0, 1};
    static boolean[][] removed;

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++)
            map[i] = board[i].toCharArray();
        // i=0~m-2까지
        // j=0~n-2까지만 검사,
        int answer = 0;
        while (true) {
            removed = new boolean[m][n];// 제거된 거는 true로 변경
            boolean canContinue = false;
            for (int i = 0; i < m - 1; i++)
                for (int j = 0; j < n - 1; j++) {
                    // 4개를 검사해서 모두 다 같으면 removed를 false로 만들기
                    if (map[i][j] != 0)
                        if (check(map, i, j)) canContinue = true;
                }
            if (!canContinue) break;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (removed[i][j]) answer++;
            // 배열 중력 작용
            move(map, m, n);


        }


        return answer;
    }
    
    private static boolean check(char[][] map, int i, int j) {
        int[][] memo = new int[3][2];
        char c = map[i][j];
        for (int d = 0; d < 3; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            // 만약 이번이 아니라 이미 제거된 거면, nr, nc값 다시 탐색하기

            if (map[nr][nc] != c)
                return false;
            memo[d][0] = nr;
            memo[d][1] = nc;
        }
        // 여기까지오면 4개가 같은 것 -> boolean false로 만들기
        removed[i][j] = true;

        for (int d = 0; d < 3; d++) {
            int nr = memo[d][0];
            int nc = memo[d][1];
            removed[nr][nc] = true;
        }
        return true;
    }

    static void move(char[][] map, int m, int n) {
        char[][] tmp = new char[m][n];

        for (int c = 0; c < n; c++) {
            int idx = m - 1;
            for (int r = m - 1; r >= 0; r--) {
                if (!removed[r][c]) tmp[idx--][c] = map[r][c];
            }
        }

        for (int i = 0; i < m; i++)
            map[i] = tmp[i].clone();
    }
}