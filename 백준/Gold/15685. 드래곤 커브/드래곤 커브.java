
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = new int[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            arr[x][y] = i; // 시작점
            List<Integer> gen = new ArrayList<>();
            gen.add(d);
            x += dx[d];
            y += dy[d];
            arr[x][y] = i;

            for (int j = 1; j <= G; j++) {
                // 세대에 따라 이전 방향을 저장하면서 가기
                int size = gen.size();
                for (int g = size - 1; g >= 0; g--) {
                    int dir = (gen.get(g) + 1) % 4;
                    gen.add(dir);
                    x += dx[dir];
                    y += dy[dir];
                    arr[x][y] = i;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++) {
                if (check(i, j)) cnt++;
            }
        System.out.println(cnt);
    }

    static boolean check(int i, int j) {
        for (int x = 0; x <= 1; x++)
            for (int y = 0; y <= 1; y++) {
                if (arr[i + x][j + y] == 0) return false;
            }
        return true;
    }
}
