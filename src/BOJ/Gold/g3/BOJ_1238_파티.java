package BOJ.Gold.g3;

import java.util.*;

public class BOJ_1238_파티 {

    static class Edge implements Comparable<Edge> {
        int st;
        int ed;
        int dis;

        public Edge(int st, int ed, int dis) {
            this.st = st;
            this.ed = ed;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dis - o.dis;
        }
    }

    static int N, M, X;
    static List<Edge>[] adjList;
    static List<Edge>[] reverseList;
    static boolean[] visited;
    static int[] distance;
    static int[] distance_reverse;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();
        adjList = new ArrayList[N + 1];
        reverseList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int dis = sc.nextInt();
            adjList[st].add(new Edge(st, ed, dis));
            reverseList[ed].add(new Edge(ed, st, dis));
        }

        dijkstra();

        int[] result = distance.clone();
        dijkstra_reverse();

        result[0]=0;
        int ans = 0;
        for (int i=1; i<=N; i++) {
            result[i] += distance[i];
            ans = Math.max(result[i], ans);
        }
        System.out.println(ans);

    }

    static void dijkstra() {
         distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, X, 0));
        distance[X] = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visited[e.ed]) continue;
            visited[e.ed] = true;
            for (int i = 0; i < adjList[e.ed].size(); i++) {
                Edge tmp = adjList[e.ed].get(i);
                if (!visited[tmp.ed] && distance[tmp.ed] >= distance[tmp.st] + tmp.dis) {
                    distance[tmp.ed] = distance[tmp.st] + tmp.dis;
                    pq.add(new Edge(tmp.st, tmp.ed, distance[tmp.ed]));
                }
            }
        }
    }

    static void dijkstra_reverse() {
        distance_reverse = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, X, 0));
        distance[X] = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visited[e.ed]) continue;
            visited[e.ed] = true;
            for (int i = 0; i < reverseList[e.ed].size(); i++) {
                Edge tmp = reverseList[e.ed].get(i);
                if (!visited[tmp.ed] && distance[tmp.ed] >= distance[tmp.st] + tmp.dis) {
                    distance[tmp.ed] = distance[tmp.st] + tmp.dis;
                    pq.add(new Edge(tmp.st, tmp.ed, distance[tmp.ed]));
                }
            }
        }
    }

}
