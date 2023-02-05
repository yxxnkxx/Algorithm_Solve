import java.util.*;

public class Main {
    static class Edge {
        int st;
        int ed;

        public Edge(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "st=" + st +
                    ", ed=" + ed +
                    '}';
        }
    }

    static int N; // 세로선 // col
    static int M;// 가로선 개수
    static int H; // 가로 개수 // row
    static Edge[][] map;
    static List<int[]> edges; // 놓을 수 있는 가로선 리스트


    public static void main(String[] args) {
        // 세로 기준 짝수 개의 가로선이 있어야 가능
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        map = new Edge[H + 1][N + 1];
        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(); // 위치
            int b = sc.nextInt(); // 몇번 ?
            map[a][b] = new Edge(b, b + 1);
            map[a][b + 1] = new Edge(b + 1, b);
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++)
                if (map[i][j] == null && map[i][j + 1] == null) {
                    edges.add(new int[]{i, j});
                }
        }

        // 0개부터 3개까지 가능한지 확인하기
        // 일단 0
        if (check()) {
            System.out.println(0);
            return;
        }
        for (int c = 1; c <= 3; c++) {

            comb(c, new int[c], 0, 0);
        }
        System.out.println(-1);


    }

    static boolean check() {
        // map 검사하기

        for (int i = 1; i <= N; i++) {
            if (!go(i, i, 1)) return false;
        }
        return true;
    }

    static boolean go(int start, int c, int r) {
        // r이 H가 될 때까지 가기, H가 되었는데 start!=c이면 false
        if (r == H+1) {
            return start == c;
        }

        if (map[r][c] != null) {
            // 어느쪽으로 갈 것인가..
            Edge e = map[r][c];
            return go(start, e.ed, r + 1);

        } else {
            return go(start, c, r + 1);
        }
    }

    static void comb(int n, int[] out, int depth, int start) {
        if (depth == n) {
            // 유효한 case인지 검사하기
            if (checkEdge(out)) {
                for (int i = 0; i < n; i++) {
                    int[] arr = edges.get(out[i]);
                    map[arr[0]][arr[1]] = new Edge(arr[1], arr[1] + 1);
                    map[arr[0]][arr[1] + 1] = new Edge(arr[1] + 1, arr[1]);
                }
                if (check()) {
                    System.out.println(n);
                    System.exit(0); // 찾았으면 종료하기
                }
                for (int i = 0; i < n; i++) {
                    int[] arr = edges.get(out[i]);
                    map[arr[0]][arr[1]] = null;
                    map[arr[0]][arr[1] + 1] = null;
                }
            }
            return;
        }

        for (int i = start; i < edges.size(); i++) {
            out[depth] = i;
            comb(n, out, depth + 1, i + 1);
        }
    }

    static boolean checkEdge(int[] out) {
        for (int i = 0; i < out.length; i++) {
            int[] first = edges.get(out[i]);
            for (int j = i + 1; j < out.length; j++) {
                int[] next = edges.get(out[j]);
                if (first[0] == next[0] && Math.abs(first[1] - next[1]) == 1)
                    return false;
            }
        }
        return true;
    }


}