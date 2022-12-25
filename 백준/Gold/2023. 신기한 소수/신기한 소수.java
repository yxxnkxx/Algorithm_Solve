import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dfs(0, N);


        System.out.print(sb);

    }

    static void dfs(int num, int length) {
        if (length == 0) {
            if (isPrime(num)) sb.append(num).append("\n");
            return;
        }
        for (int i = 1; i < 10; i++) {
            int newNum = num * 10 + i;
            if (isPrime(newNum)) dfs(newNum, length - 1);
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}