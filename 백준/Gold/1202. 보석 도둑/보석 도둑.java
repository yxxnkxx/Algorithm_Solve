
import java.util.*;

public class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int val;

        public Jewel(int weight, int val) {
            this.weight = weight;
            this.val = val;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.val - o.val;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 보석을 무게 기준 오름차순 정렬

        // 가방을 오름차순 정렬

        // 가방을 훑으면서 가방의 무게보다 작거나 같은 보석 중 가장 val이 큰 보석을 더하기

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++)
            jewels[i] = new Jewel(sc.nextInt(), sc.nextInt());
        Arrays.sort(jewels, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.val - o1.val;
            }

            return o1.weight - o2.weight;
        });

        int[] bag = new int[K];
        for (int i = 0; i < K; i++)
            bag[i] = sc.nextInt();
        Arrays.sort(bag);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        int idx = 0;
        for (int i = 0; i < K; i++) {
            while (idx < N && jewels[idx].weight <= bag[i]) {
                pq.add(jewels[idx].val); // pq에 val 추가
                idx++;
            }
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }


        System.out.println(ans);
    }
}
