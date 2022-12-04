import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int ans;
    static Set<Integer> set;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();
        set = new HashSet<>();
        for (int i = 0; i <= 9; i++)
            set.add(i);
        for (int i = 0; i < M; i++)
            set.remove(sc.nextInt());

        // 100에서 누르는게 빠른지
        ans = Math.abs(100 - N);

        // 가능한 수의 중복순열, ans update
        // 자릿수구하기 -> 현재 자릿수 +1까지 가능하게
        int tmp = N;
        int length = 1;
        while (tmp > 0) {
            tmp /= 10;
            length++;
        }

        // 처음에 0으로 시작하니까 틀렸다 ㅜㅜ
        for (Integer i : set) {
            perm(1, length, i);
        }
        System.out.println(ans);

    }

    static void perm(int curr, int len, int num) {
        ans = Math.min(ans, Math.abs(num - N) + String.valueOf(num).length());

        if (curr == len) {
            return;
        }


        for (Integer i : set) {
            perm(curr + 1, len, num + i * (int) Math.pow(10, curr));
        }

    }


}