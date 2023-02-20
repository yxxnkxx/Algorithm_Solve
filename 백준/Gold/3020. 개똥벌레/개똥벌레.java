
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        Integer[] top = new Integer[N / 2]; // 종유석
        int[] low = new int[N / 2]; // 석순
        for (int i = 0; i < N / 2; i++) {
            int lowLength = Integer.parseInt(br.readLine());
            int topLength = Integer.parseInt(br.readLine());
            low[i] = lowLength;
            top[i] = topLength;
        }
        Arrays.sort(low);
        Arrays.sort(top, Collections.reverseOrder());

        int[] arr = new int[H + 1];

        // 석순 개수 새기
        // 최소값찾기
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            arr[i] = find(low, top, i, H);
            if (arr[i] < min) {
                min = arr[i];
                cnt = 1;
            } else if (arr[i] == min) cnt++;
        }
        System.out.println(min + " " + cnt);


    }

    static int find(int[] low, Integer[] top, int i, int H) {
        // i인 idx 찾기 ->  low는 시작점~끝, top은 0~해당 idx
        int start = 0;
        int end = low.length;
        int ans = 0;
        // low: lower bound
        while (start < end) {
            int mid = (start + end) / 2;
            if (low[mid] >= i) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        ans += (low.length - start);

        // top: upper bound
        start = 0;
        end = low.length;
        // low: lower bound
        while (start < end) {
            int mid = (start + end) / 2;
            if ((H - top[mid] + 1) <= i) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        ans += start;
        return ans;
    }
}