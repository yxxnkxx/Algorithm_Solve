import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N = -1;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int cnt = 1;
        StringBuilder sb=new StringBuilder();
        while (N != 0) {
            map = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    map[i][j] = sc.nextInt();
            // 다익스트라
            dist = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    dist[i][j] = Integer.MAX_VALUE;
            dist[0][0] = map[0][0]; // 초기화
            visited = new boolean[N][N];
            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            q.add(new int[]{0, 0, dist[0][0]});
            while (!q.isEmpty()) {
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];
                if (visited[r][c]) continue;

                visited[r][c] = true;
                if (r == N - 1 && c == N - 1) {
                    sb.append("Problem ").append(cnt).append(": ").append(dist[r][c]).append("\n");
                    break;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && dist[nr][nc] > map[nr][nc] + dist[r][c]) {
                        dist[nr][nc] = map[nr][nc] + dist[r][c];
                        q.add(new int[]{nr, nc, dist[nr][nc]});
                    }
                }
            }


            N = sc.nextInt();
            cnt++;
        }
        System.out.println(sb);
    }
}