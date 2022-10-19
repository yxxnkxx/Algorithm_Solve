import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class Main {


    static class Passenger implements Comparable<Passenger> {
        int start_r;
        int start_c;

        int end_r;
        int end_c;

        int dist;
        boolean visited;

        public Passenger(int start_r, int start_c, int end_r, int end_c) {
            this.start_r = start_r;
            this.start_c = start_c;
            this.end_r = end_r;
            this.end_c = end_c;
            this.dist = 0;
            this.visited = false;
        }

        @Override
        public int compareTo(Passenger o) {
            if (this.dist == o.dist) {
                if (this.start_r == o.start_r)
                    return this.start_c - o.start_c;
                return this.start_r - o.start_r;
            }
            return this.dist - o.dist;
        }


    }

    static class Taxi {
        int r;
        int c;
        int cnt;
        int fuel;

        public Taxi(int r, int c, int fuel) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = 0;
            this.fuel = fuel;
        }

    }

    static int N, M;
    static List<Passenger> list;
    static int[][] map;
    static boolean[][] visited;
    static int sec = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static Taxi taxi;
    static int route;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();
        int fuel = sc.nextInt();
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                map[i][j] = sc.nextInt();


        // 택시
        taxi = new Taxi(sc.nextInt(), sc.nextInt(), fuel);
        for (int i = 0; i < M; i++)
            list.add(new Passenger(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));


        PriorityQueue<Passenger> pq = new PriorityQueue<>();
        // 이동 가능한 애들만 넣기(거리가 fuel보다 작거나 같은
        for (int i = 0; i < list.size(); i++) {
            Passenger p = list.get(i);
            route = isPossible(taxi.r, taxi.c, p.start_r, p.start_c);
            if (route != Integer.MAX_VALUE && route <= taxi.fuel) {
                p.dist = route;
                pq.add(p);
            }
        }


        while (!pq.isEmpty()) {
            Passenger p = pq.poll();
            p.visited = true;

            taxi.fuel -= p.dist;

            // 이동 거리 계산
            int move = isPossible(p.start_r, p.start_c, p.end_r, p.end_c);
            if (move == Integer.MAX_VALUE) // 이동하다가 연료 소진
                break;

            taxi.fuel += move;


            taxi.cnt += 1;
            taxi.r = p.end_r;
            taxi.c = p.end_c;
            pq.clear(); // 이미 있는 것도 위치를 다시 업데이트해야됨

            for (int i = 0; i < list.size(); i++) {
                Passenger tmp = list.get(i);
                if (tmp.visited)
                    continue;

                route = isPossible(taxi.r, taxi.c, tmp.start_r, tmp.start_c);
                if (route != Integer.MAX_VALUE) {
                    tmp.dist = route;
                    pq.add(tmp);
                }
            }
        }
        if (taxi.cnt == M) System.out.println(taxi.fuel);
        else System.out.println(-1);

    }

    private static int isPossible(int sr, int sc, int fr, int fc) {
        // 이동 가능한지 검사하기

        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            Arrays.fill(visited[i], false);

        q.add(new int[]{sr, sc, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == fr && tmp[1] == fc) {
                if (tmp[2] <= taxi.fuel)
                    return tmp[2];
                return Integer.MAX_VALUE;
            }

            visited[tmp[0]][tmp[1]] = true;
            for (int d = 0; d < 4; d++) {
                int nr = tmp[0] + dr[d];
                int nc = tmp[1] + dc[d];
                if (nr > 0 && nr <= N && nc > 0 && nc <= N && !visited[nr][nc] && map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, tmp[2] + 1});
                }
            }
        }

        return Integer.MAX_VALUE;

    }

}