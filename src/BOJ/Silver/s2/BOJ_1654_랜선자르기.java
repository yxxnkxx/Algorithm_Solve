package BOJ.Silver.s2;

import java.util.Scanner;

public class BOJ_1654_랜선자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long[] arr = new long[K];
        for (int i = 0; i < K; i++)
            arr[i] = sc.nextLong();
        long start = 1;
        long end = (long) Math.pow(2, 31) + 1;
        long ans = 0;
        while (start < end) {
            long mid = (start + end) / 2;
            long tmp = 0;
            for (int i = 0; i < K; i++)
                tmp += arr[i] / mid;
            if (tmp >= N) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        System.out.println(ans);
    }
}
