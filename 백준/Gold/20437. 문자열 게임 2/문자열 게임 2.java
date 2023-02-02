
import java.util.*;

public class Main {
    static int[] alpha;
    static Map<Integer, List<Integer>> maps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            alpha = new int[26]; // 알파벳 cnt 저장
            maps = new HashMap<>(); // key에 시작 + 끝 index 적기
            String input = sc.next();
            int K = sc.nextInt();
            int ans1 = Integer.MAX_VALUE;
            int ans2 = -1;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                int idx = c - 'a';
                alpha[idx]++;
                if (alpha[idx] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    maps.put(idx, list);
                } else {
                    List<Integer> arr = maps.get(idx);
                    arr.add(i);
                    maps.put(idx, arr);
                }
                if (alpha[idx] >= K) {
                    List<Integer> list = maps.get(idx);
                    for (int j = K - 1; j < list.size(); j++) {
                        int last = list.get(j);
                        int start = list.get(j + 1 - K);
                        ans1 = Math.min(ans1, last - start + 1);
                        ans2 = Math.max(ans2, last - start + 1);
                    }
                }

            }
            if (ans1 == Integer.MAX_VALUE)
                sb.append(-1).append("\n");
            else {
                sb.append(ans1).append(" ").append(ans2).append("\n");
            }

        }
        System.out.print(sb);
    }
}
