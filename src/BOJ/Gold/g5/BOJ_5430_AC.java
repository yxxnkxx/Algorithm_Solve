package BOJ.Gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

public class BOJ_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        out:
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

//            int[] arr = Stream.of(input.substring(1, input.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
            String[] arr = input.substring(1, input.length() - 1).split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++)
                deque.addLast(Integer.parseInt(arr[i]));

            // 명령 ㄱㄱ
            boolean first = true;
            for (int i = 0; i < p.length(); i++) {
                char command = p.charAt(i);
                if (command == 'R') {
                    first = !first;
                } else {
                    // 배열이 비어있으면 에러
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        continue out;
                    }
                    // first가 true라면 앞에부터 제거
                    else if (first) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if (deque.isEmpty()) {
                sb.append("[]\n");
                continue;
            }

            sb.append("[");

            if (first) {
                while (!deque.isEmpty()) {
                    sb.append(deque.removeFirst()).append(",");
                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.removeLast()).append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}
