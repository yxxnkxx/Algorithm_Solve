import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int size = 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    size = Math.max(size, dp[i]);
                }
            }

        StringBuilder sb = new StringBuilder();
        int idx = size;
        int[] ans = new int[size+1];
        for (int i = N-1; i >=0; i--) {
            if (idx == 0) break;
            if (dp[i] == idx) {
                ans[idx]=arr[i];
                idx--;
            }
        }
        System.out.println(size);
        for (int i=1; i<=size;i++)
            sb.append(ans[i]+" ");
        System.out.println(sb);

    }
}