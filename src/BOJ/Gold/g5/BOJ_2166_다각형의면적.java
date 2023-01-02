package BOJ.Gold.g5;

import java.util.Scanner;

public class BOJ_2166_다각형의면적 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] X = new long[N + 1]; // 마지막엔 0번째 좌표 적기
        long[] Y = new long[N + 1];
        long result = 0;
        X[0] = X[N] = sc.nextLong();
        Y[0] = Y[N] = sc.nextLong();
        for (int i = 1; i < N; i++) {
            X[i] = sc.nextLong();
            Y[i] = sc.nextLong();
        }
        for (int i = 0; i < N; i++) {
            result += X[i] * Y[i + 1];
            result -= X[i + 1] * Y[i];
        }
        System.out.println(String.format("%.1f", Math.abs(result)/2.0));


    }
}
