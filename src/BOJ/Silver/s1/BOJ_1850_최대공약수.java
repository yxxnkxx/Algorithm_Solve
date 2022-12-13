package BOJ.Silver.s1;

import java.util.Scanner;

public class BOJ_1850_최대공약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        while (B > 0) {
            long tmp = A % B;
            A = B;
            B = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A; i++)
            sb.append(1);
        System.out.println(sb);

    }
}
