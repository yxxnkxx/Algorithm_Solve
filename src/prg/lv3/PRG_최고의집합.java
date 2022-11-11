package prg.lv3;

import java.util.Arrays;

public class PRG_최고의집합 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));

    }

    static public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1}; // 불가능
        // n개의 수가 가장 작을 때 곱이 제일 큰가?
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
