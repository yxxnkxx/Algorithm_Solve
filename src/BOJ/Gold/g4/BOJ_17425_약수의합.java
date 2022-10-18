package BOJ.Gold.g4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17425_약수의합 {

    // 1~100만까지 소수를 구하기
    // 1~100만까지 소인수분해 + 약수의 합 구하기 (1...소수)(1...소수) 로 dp ㄱ

    public static void main(String[] args) {
        long[] div = new long[1000001];
        long[] dp = new long[1000001];
        Arrays.fill(div,1);
        for (int i=2;i<=1000000; i++) {
            for (int j=i; j<=1000000; j+=i)
                div[j]+=i; // i를 약수로 가지는 값에 더해줌
        }
        for (int i=1;i<=1000000; i++) {
            dp[i]+=div[i]+dp[i-1];
        }
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        StringBuilder sb= new StringBuilder();


        while (T-->0) {
            int N =sc.nextInt();
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);

    }


}

