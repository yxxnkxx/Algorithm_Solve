package BOJ.Silver.s3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2193_이친수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] arr = new long[N + 1][2]; // 0으로 끝나는 수, 1로 끝나는 수
        arr[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 1][1];
            arr[i][1] = arr[i - 1][0];
        }
        System.out.println(arr[N][0] + arr[N][1]);

    }
}
