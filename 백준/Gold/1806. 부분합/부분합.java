
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1]; // 누적합 저장
        for (int i=1; i<=N; i++)
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());

        int start = 1;
        int end = 1;
        int ans = 100001;
        while (start<=end && end<=N) {
            int sum = arr[end]-arr[start-1];
            if (sum>=S) {
                ans= Math.min(ans, end-start+1);
                start++;

            }
            else end++;

        }
        if (ans==100001) ans=0;
        System.out.println(ans);
    }
}
