package BOJ.Silver.s1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1911_흙길보수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int cnt = 0;
        int curr = 0; // 널판지의 끝 좌표
        for (int i = 0; i < N; i++) {

            int st = Math.max(arr[i][0], curr);
            int ed = arr[i][1];
            if (ed <= curr) continue;
            int tmp = ((ed - st) % L != 0) ? ((ed - st) / L) + 1 : (ed - st) / L;
            curr = st + tmp * L;
            cnt += tmp;
        }
        System.out.println(cnt);
    }
}
