package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1]; // 누적합 저장
        for (int i=1; i<=N; i++)
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());

        // 투포인터
        int start = 1;
        int end = 1;
        int ans = 100001;
        while (start<=end && end<=N) { // 종료 조건 : 배열의 끝까지 훑은 경우
            int sum = arr[end]-arr[start-1]; // start~end까지의 누적합
            if (sum>=S) {
                ans= Math.min(ans, end-start+1); // sum이 S 이상인 경우 길이 update
                start++; // start를 증가시켜 더 작은 길이가 가능한지 검사

            }
            else end++; // sum이 S 미만인 경우 end++

        }
        if (ans==100001) ans=0;
        System.out.println(ans);
    }
}
