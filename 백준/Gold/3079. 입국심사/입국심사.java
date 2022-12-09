import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        long[] time = new long[N];
        for (int i = 0; i < N; i++)
            time[i] = sc.nextLong();
        long start = 1;
        long end = 1_000_000_000L * M;
        long ans = end;
        out:
        while (start <= end) {
            long mid = (start + end) / 2;
            // mid안에 가능한지 확인
            long tmp = 0;
            for (int i = 0; i < N; i++) {
                tmp += mid / time[i];
                if (tmp >= M) {
                    // mid분 안에 가능
                    ans = mid;
                    end = mid - 1;
                    continue out;
                }
            }
            if (tmp >= M) {
                // mid분 안에 가능
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(ans);

    }
}