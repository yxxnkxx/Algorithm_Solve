package prg.lv2;

public class PRG_프렌즈4블록 {
    static int[] dr = {0, 1, 1}; // 자기 자신을 제외한 2*2 블록의 index
    static int[] dc = {1, 0, 1};
    static boolean[][] removed; // 제거한 블록

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++)
            map[i] = board[i].toCharArray();
        // i=0~m-2까지
        // j=0~n-2까지만 검사,
        int answer = 0;
        while (true) {
            removed = new boolean[m][n];// 제거된 거는 true로 변경
            boolean canContinue = false; // 하나라도 제거되면 다음 블록을 검사해야 함
            for (int i = 0; i < m - 1; i++)
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != 0)
                        if (check(map, i, j)) canContinue = true; // 제거되면 true로
                }
            if (!canContinue) break; // 제거된 블록이 없으면 break
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (removed[i][j]) answer++; // 제거된 블록 세기
            // 배열 중력 작용
            move(map, m, n);


        }


        return answer;
    }

    private static boolean check(char[][] map, int i, int j) {
        int[][] memo = new int[3][2];
        char c = map[i][j];
        // 2*2 블록의 값이 같은지 확인
        for (int d = 0; d < 3; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (map[nr][nc] != c)
                return false; // 
            memo[d][0] = nr; // nr nc 기록하고 removed 표시하기
            memo[d][1] = nc;
        }
        // 여기까지오면 4개가 같은 것 -> boolean true로 만들기
        removed[i][j] = true;

        for (int d = 0; d < 3; d++) {
            int nr = memo[d][0];
            int nc = memo[d][1];
            removed[nr][nc] = true; // removed true로
        }
        return true;
    }

    static void move(char[][] map, int m, int n) {
        char[][] tmp = new char[m][n];

        for (int c = 0; c < n; c++) {
            int idx = m - 1;
            for (int r = m - 1; r >= 0; r--) {
                if (!removed[r][c]) tmp[idx--][c] = map[r][c];
                // 제거되지 않은 블록들만 밑에서부터 채움
            }
        }

        for (int i = 0; i < m; i++)
            map[i] = tmp[i].clone(); // 배열 복사
    }
}