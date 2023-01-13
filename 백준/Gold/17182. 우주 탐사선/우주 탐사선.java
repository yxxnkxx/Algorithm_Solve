
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int start;

    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;
        // 플로이드 와샬
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);

        dfs(start, 0, 1 << start);

        System.out.println(ans);


    }

    static void dfs(int idx, int time, int visit) {
        if (visit == ((1 << N) - 1)) {
            ans = Math.min(ans, time);
            return;
        }

        for (int i = 0; i < N; i++)
            if (i != idx && (visit & (1 << i)) == 0)
                dfs(i, time + map[idx][i], (visit | (1 << i)));
    }
}
