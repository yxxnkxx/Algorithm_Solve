package BOJ.Platinum.p5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_14003_가장긴증가하는부분수열5 {

    static List<Integer> LIS;
    static int[] index;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        index = new int[N];
        LIS = new ArrayList<>();
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

//            for (int i = 0; i < N; i++) // n^2 시간초과
//                for (int j = 0; j < i; j++) {
//                    if (arr[j] < arr[i]) {
//                        dp[i] = Math.max(dp[j] + 1, dp[i]);
//                        size = Math.max(size, dp[i]);
//                    }
//                }

        // 이분 탐색을 활용해서 리스트에 값 추가하기
        LIS.add(arr[0]);
        index[0] = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > LIS.get(LIS.size() - 1)) {
                LIS.add(arr[i]);
                index[i] = LIS.size() - 1;
            } else {
                binarySearch(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(LIS.size()).append("\n");
        // 뒤에서부터 경로 역추적하기
        int[] ans = new int[LIS.size()];
        int len = LIS.size()-1;
        for (int i=N-1; i>=0; i--) {
            if (index[i]==len) {
                ans[len] = arr[i];
                len--;
            }
        }
        for (int an : ans) sb.append(an).append(" ");
        System.out.println(sb);

    }

    static void binarySearch(int idx) {
        int start, end, mid;
        start = 0;
        end = LIS.size() - 1;

        while (start < end) {
            mid = (start + end) / 2;
            if (LIS.get(mid) >= arr[idx])
                end = mid;
            else start = mid + 1;
        }
        // idx가 놓일 위치를 찾는 것
        LIS.set(start, arr[idx]);
        index[idx] = start;

    }
}
