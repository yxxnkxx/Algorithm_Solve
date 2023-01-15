import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> sumA = new HashMap<>();
        getSum(st, N, sumA, A);


        int M = Integer.parseInt(br.readLine());
        Map<Integer, Integer> sumB = new HashMap<>();

        int[] B = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        getSum(st, M, sumB, B); // 부배열의 합 (sumB)가 몇 번 등장하는지 hashmap에 저장

        long ans = 0; // 개수가 long 범위 초과 가능
        for (Integer valA : sumA.keySet()) {
            int cntA = sumA.get(valA);
            if (sumB.containsKey(T - valA)) {
                int cntB = sumB.get(T - valA);
                ans += (long) cntA * cntB;
            }
        }
        System.out.println(ans);


    }

    private static void getSum(StringTokenizer st, int m, Map<Integer, Integer> sumB, int[] b) {
        for (int i = 1; i <= m; i++) {
            b[i] = b[i - 1] + Integer.parseInt(st.nextToken());
            for (int j = 1; j <= i; j++) {
                int sum = b[i] - b[j - 1];
                if (sumB.containsKey(sum)) {
                    sumB.put(sum, sumB.get(sum) + 1);
                } else
                    sumB.put(sum, 1);

            }
        }
    }
}