package BOJ.Silver.s1;

import java.util.Scanner;

public class BOJ_11057_오르막수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long result = 1;
        for (int i=1; i<=9; i++) {
            result *= (N + i);
            result %= 10007;
        }
        System.out.println(result);



    }
}
