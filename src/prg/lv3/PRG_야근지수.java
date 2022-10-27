package prg.lv3;


import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PRG_야근지수 {
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) pq.add(work);
        for (int i=0; i<n; i++){
            if (pq.isEmpty()) break;
            if (pq.peek()==0) break;
            pq.add(pq.poll()-1); // 큰 값 하나 빼서 다시 넣기 n번 반복,
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += num * num;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n=3;
        int[] works={1,1};
        System.out.println(solution(n, works));
    }
}
