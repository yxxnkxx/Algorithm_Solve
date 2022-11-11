
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1}; // 불가능

        int share = s / n;
        int mod = s % n;

        int[] answer = new int[n];
        Arrays.fill(answer, share);
        int idx = n - 1;
        while (mod-- > 0) {
            answer[idx]++;
            idx--;
        }
        return answer;
    }
}