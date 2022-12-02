import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        long[] arr = new long[N];
        long start = 0; // 무조건 가능한 경우
        long end = 0; // 불가능한 경우 (입력 가능한 최대값)
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
            end = Math.max(end, arr[i]);
        }

        System.out.println(find(N, M, arr, start, end));

    }

    static long find(int N, long M, long[] arr, long start, long end) {
        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long tmp = 0;
            for (int i = 0; i < N; i++) {
                if (mid < arr[i])
                    tmp += arr[i] - mid;
            }
            if (tmp >= M) {
                ans = mid; // 자를 수 있음
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }


        return ans;
    }

}