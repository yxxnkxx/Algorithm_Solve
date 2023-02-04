import java.util.*;

public class Main {
    static int N;
    static boolean find;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        find = false;

        dfs(1+"");


    }

    static StringBuilder sb = new StringBuilder();

    static void dfs(String input) {
        if (find) return;

        if (input.length()==N) {
            find = true;
            System.out.println(input);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (check(input + i, (input + i).length())) {
                dfs(input+i);
            }
        }

    }

    static boolean check(String input, int idx) {
        if (input.length() == 0) return true;

        for (int i = 1; i <= idx / 2; i++) {
            if (input.substring(idx - i * 2, idx - i).equals(input.substring(idx - i, idx)))
                return false;
        }
        return true;
    }
}