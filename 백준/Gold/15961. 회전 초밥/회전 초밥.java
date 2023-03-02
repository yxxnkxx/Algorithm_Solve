import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] count = new int[d + 1]; // 가짓수
        count[c] = 1; // 가짓수 저장
        int cnt = 1; // c 포함
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i < k) {
                count[arr[i]]++;
                if (count[arr[i]] == 1) cnt++;
            }
        }
        int ans = cnt;
        for (int i = k; i < N; i++) {
            count[arr[i - k]]--;
            if (count[arr[i - k]] == 0) cnt--;
            count[arr[i]]++;
            if (count[arr[i]] == 1) cnt++;
            ans = Math.max(ans, cnt);
        }
        for (int i = 0; i < k; i++) {
            count[arr[N + i - k]]--;
            if (count[arr[N + i - k]] == 0) cnt--;
            count[arr[i]]++;
            if (count[arr[i]] == 1) cnt++;
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);


    }
}