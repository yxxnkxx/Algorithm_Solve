package BOJ.Gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {

    static class Gear {
        // 맞닿은 구간은 왼쪽 3시(charAt(2)- 오른쪽 9시(charAt(6))
        String status;

        public Gear(String status) {
            this.status = status;
        }

        public void rotate(int dir) {
            if (dir == 1) {
                // 시계 방향
                this.status = this.status.charAt(7) + this.status.substring(0, 7);

            } else if (dir == -1) {
                // 반시계 방향
                this.status = this.status.substring(1, 8) + this.status.charAt(0);
            }
        }

        @Override
        public String toString() {
            return "Gear{" +
                    "status='" + status + '\'' +
                    '}';
        }
    }

    static Gear[] gears = new Gear[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 4; i++)
            gears[i] = new Gear(br.readLine());

        // 회전에 따라 각 gear의 회전 방향 정하기
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int[] dirs = new int[5];
            Arrays.fill(dirs, -2);
            fillDir(dirs, num, dir); // 회전 방향 찾기 재귀
            for (int j = 1; j <= 4; j++) {
                gears[j].rotate(dirs[j]);
            }

        }
        // 점수 계산
        int score = 0;
        for (int i = 1; i <= 4; i++) {
            if (gears[i].status.charAt(0) == '1') {
                score += 1 << (i - 1); // 비트연산활용
            }
        }
        System.out.println(score);

    }

    static void fillDir(int[] dirs, int num, int dir) {
        if (dirs[num] != -2) return;
        dirs[num] = dir; // 방향 설정


        // 내 방향이 0이라면 아직 방향이 정해지지 않은 내 왼쪽, 오른쪽도 0, *-1해도 0이니까 그냥 한 함수에서


        // num+1, num-1에 대해 방향이 있는지 확인, 방향이 아직 정해지지 않았다면 N극 S극 따지기
        // 자신의 오른쪽에 있는 기어
        if (num + 1 <= 4 && dirs[num + 1] == -2) {
            char currDir = gears[num].status.charAt(2); // 왼쪽에 있는 톱니바퀴의 3시 방향
            char rightDir = gears[num + 1].status.charAt(6); // 오른쪽에 있는 톱니바퀴의 9시 방향
            if (currDir != rightDir) {
                fillDir(dirs, num + 1, dir * -1); // 자신과 반대방향으로 채움
            } else {
                // 방향이 같다면 회전x
                fillDir(dirs, num + 1, 0);
            }
        }
        if (num - 1 >= 1 && dirs[num - 1] == -2) {
            char currDir = gears[num].status.charAt(6); // 오른쪽에 있는 톱니바퀴의 3시 방향
            char leftDir = gears[num - 1].status.charAt(2); // 왼쪽에 있는 톱니바퀴의 9시 방향
            if (currDir != leftDir) {
                fillDir(dirs, num - 1, dir * -1); // 자신과 반대방향으로 채움
            } else {
                // 방향이 같다면 회전x
                fillDir(dirs, num - 1, 0);
            }
        }


    }
}
