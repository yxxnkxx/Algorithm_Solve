import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int start = 1;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            start = Math.max(arr[i], start);
        }

        /*
        반례: 5 2
        1 1 1 1 100
        최소 길이는 주어진 길이 중 가장 긴 값으로 해야됨, 아니면 while문에서 처리해주기
         */
        int end = 1000000000;
        int ans = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2; // 강의의 길이가 mid
            // 길이가 mid인 블루레이 M개에 강의를 모두 담을 수 있는지 확인하기
            int tmp = 1; // 필요한 블루레이의 개수
            int length = 0;
            for (int i = 0; i < N; i++) {
                if (length + arr[i] <= mid) {
                    length += arr[i];
                } else {
                    tmp++;
                    length = arr[i];
                }
            }

            if (tmp <= M) {
                // M개의 블루레이로 가능하다 -> 강의의 길이 줄여보기
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }


        }
        System.out.println(ans);

    }
}