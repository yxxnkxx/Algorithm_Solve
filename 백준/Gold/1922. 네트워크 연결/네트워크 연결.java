import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int st;
        int ed;
        int d;

        public Edge(int st, int ed, int d) {
            this.st = st;
            this.ed = ed;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return this.d - o.d;
        }


    }

    static int N, M;
    static List<Edge>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int d = sc.nextInt();
            adjList[st].add(new Edge(st, ed, d));
            adjList[ed].add(new Edge(ed, st, d));
        }


        // prim
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[1] = true;
        // a와 b는 같을 수도 있다 -> 자기 자신을 연결하는 길이도 세야하나?
        pq.addAll(adjList[1]);
        int ans = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visited[e.ed]) continue;
            visited[e.ed] = true;
            ans += e.d;
            pq.addAll(adjList[e.ed]);

        }
        System.out.println(ans);
    }

}