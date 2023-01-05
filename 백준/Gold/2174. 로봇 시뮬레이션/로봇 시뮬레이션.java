import java.util.Scanner;

public class Main {
    static class Robot {
        int num;
        int x;
        int y;
        int dir;

        public Robot(int num, int x, int y, int dir) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // N E S W


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // x축
        int B = sc.nextInt(); // y축
        int[][] map = new int[A + 1][B + 1];
        int N = sc.nextInt();
        int M = sc.nextInt();
        Robot[] robots = new Robot[N + 1];
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dir = getDir(sc.next());
            map[x][y] = i;
            robots[i] = new Robot(i, x, y, dir);
        }

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            String comm = sc.next();
            int repeat = sc.nextInt();
            Robot robot = robots[num];
            if (comm.equals("F")) {
                // 방향 구하기
                for (int r = 1; r <= repeat; r++) {
                    int nx = robot.x + dx[robot.dir];
                    int ny = robot.y + dy[robot.dir];
                    // 벽
                    if (nx <= 0 || nx > A || ny <= 0 || ny > B) {
                        System.out.printf("Robot %d crashes into the wall\n", num);
                        return;
                    }
                    // 다른 로봇에 충돌

                    if (map[nx][ny] != 0) {
                        System.out.printf("Robot %d crashes into robot %d\n", num, map[nx][ny]);
                        return;
                    }

                    // 이동
                    map[robot.x][robot.y] = 0;
                    map[nx][ny] = robot.num;
                    robot.x = nx;
                    robot.y = ny;
                }
            } else {
                // 방향만 바꾸기
                repeat = repeat % 4;
                if (comm.equals("L")) {
                    robot.dir = (4 + robot.dir - repeat) % 4;
                } else {
                    robot.dir = (robot.dir + repeat) % 4;
                }

            }
        }
        System.out.println("OK");


    }

    static int getDir(String dir) {
        switch (dir) {
            case "N":
                return 0;
            case "E":
                return 1;
            case "S":
                return 2;
            case "W":
                return 3;
        }
        return -1;
    }
}