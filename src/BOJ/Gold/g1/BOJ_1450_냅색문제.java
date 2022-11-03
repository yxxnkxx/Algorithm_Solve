package BOJ.Gold.g1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1450_냅색문제 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();

        }
        Arrays.sort(arr);

        // 둘로 나눠서 왼쪽의 누적합, 오른쪽의 누적합을 따로 구하기
    }
}
