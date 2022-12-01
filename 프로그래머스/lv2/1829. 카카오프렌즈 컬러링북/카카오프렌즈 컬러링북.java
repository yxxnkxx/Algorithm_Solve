class Solution {

    static boolean[][] visited;
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int[] dr;
    static int[] dc;

    static int size;

    static public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        dr = new int[]{-1, 1, 0, 0};
        dc = new int[]{0, 0, 1, -1};
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    size = 0;
                    dfs(m, n, picture, i, j);
                }
            }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static void dfs(int m, int n, int[][] picture, int r, int c) {
        visited[r][c] = true;
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, ++size);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && picture[nr][nc] == picture[r][c] && !visited[nr][nc]) {
                dfs(m, n, picture, nr, nc);
            }
        }

    }
}