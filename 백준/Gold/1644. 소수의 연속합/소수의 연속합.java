
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean[] prime = new boolean[4000001]; // 에라토스테네스의 체
        int[] nums = new int[4000001]; // 소수를 담을 배열
        int idx = 1;
        for (int i = 2; i <= 4000000; i++) {
            if (!prime[i]) {
                nums[idx++] = i;
                for (int j = i * 2; j <= 4000000; j += i)
                    prime[j] = true;
            }
        }

        for (int i = 1; i <= 4000000; i++) {
            if (nums[i] == 0) break;
            nums[i] += nums[i - 1]; // 누적합
        }
        int st = 1;
        int ed = 1;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        while (st <= ed && nums[ed] != 0) {
            int sum = nums[ed] - nums[st - 1];
            if (sum == N) cnt++;
            if (sum >= N) st++;
            else ed++;
        }
        System.out.println(cnt);

    }
}
