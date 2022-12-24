package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String keyword = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            stack.push(str.charAt(idx));
            if (str.charAt(idx) == keyword.charAt(keyword.length() - 1) && stack.size() >= keyword.length()) {
                boolean check = true;
                for (int i = 0; i < keyword.length(); i++) {
                    if (stack.get(stack.size() - keyword.length() + i) != keyword.charAt(i)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int i = 0; i < keyword.length(); i++)
                        stack.pop();
                }
            }

            idx++;

        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());


    }
}
