
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
      static public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int bIdx = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            while (bIdx >= 0 && B[bIdx] > A[i]) {
                pq.add(B[bIdx]);
                bIdx--;
            }
            if (pq.size() > 0 && pq.peek() > A[i]) {
                pq.poll(); // A[i]보다 큰 원소 중에서 가장 작은 값 하나 빼기
                answer++;
            }
        }


        return answer;
    }
}