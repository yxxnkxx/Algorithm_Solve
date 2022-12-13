package BOJ.Gold.g5;

import java.util.Scanner;

public class BOJ_2436_공약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long mul = A * B;
        long[] ans = new long[2];
        // A*B의 약수이면서 A의 배수인 수 찾기
        for (long i = A; i * i <= mul; i += A) {
            // A의 배수들
            // i랑 mul/i의 최소공약수가 A라면 답으로 업데이트
            if (mul % i == 0) { // i가 mul의 약수
                long num1 = i;
                long num2 = mul / i;

                while (num1 > 0) {
                    long tmp = num2 % num1;
                    num2 = num1;
                    num1 = tmp;
                }
                if (num2 == A) {
                    ans[0] = i;
                    ans[1] = mul / i;
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1]);

    }
}
