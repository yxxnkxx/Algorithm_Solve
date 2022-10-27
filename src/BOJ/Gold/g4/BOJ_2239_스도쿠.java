package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_2239_스도쿠 {
    static int[][] map;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = input.charAt(j) - '0';
                if (map[i][j] == 0) list.add(new int[]{i, j});
            }
        } // 입력
        fill(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                sb.append(map[i][j]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean fill(int depth) {
        if (depth == list.size()) {
            return true;
        }
        int r = list.get(depth)[0];
        int c = list.get(depth)[1];
        for (int v = 1; v <= 9; v++) {
            if (isPossible(r, c, v)) {
                map[r][c] = v;
                boolean check = fill(depth + 1);
                if (check) return true;
            }
        }
        map[r][c] = 0;
        return false; // 끝까지 왔는데도 못 채우면 뒤로 돌아가기
    }

    static boolean isPossible(int r, int c, int v) {
        // 가로 세로
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == v) return false;
            if (map[i][c] == v) return false;
        }

        //3*3
        int start_r = (r / 3) * 3;
        int start_c = (c / 3) * 3;
        for (int i = start_r; i < start_r + 3; i++)
            for (int j = start_c; j < start_c + 3; j++)
                if (map[i][j] == v) return false;
        return true;
    }
}
