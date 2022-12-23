
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Tower implements Comparable<Tower> {
        int idx;
        int val;

        public Tower(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Tower o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tower[] arr = new Tower[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = new Tower(i + 1, Integer.parseInt(st.nextToken()));
        Stack<Tower> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Tower t = arr[i];
            while (!stack.isEmpty() && stack.peek().val <= t.val) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append(0 + " ");
            } else {
                sb.append(stack.peek().idx + " ");

            }
            stack.add(t);
        }
        System.out.println(sb);

    }
}
