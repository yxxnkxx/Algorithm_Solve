package BOJ.Gold.g1;

import java.util.Scanner;

public class BOJ_2042_구간합구하기 {
    static int N, M, K;
    static long[] tree;
    static long[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        tree = new long[N * 4];
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextLong();
        // 구간합 구하기
        init(1, N, 1);

        for (int i = 0; i < (M + K); i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 1) {
                // 변경
                long c = sc.nextLong();
                update(1, N, 1, b, arr[b], c);
                arr[b] = c;
            } else {
                // 구간합 구하기
                int c = sc.nextInt();
                sb.append(getSum(1, N, 1, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static long init(int start, int end, int index) {
        // start부터 end까지의 값을 tree[index]에 담음
        if (start == end) return tree[index] = arr[start]; // start==end면 해당 index값을 저장
        int mid = (start + end) / 2;
        tree[index] = init(start, mid, index * 2) + init(mid + 1, end, index * 2 + 1);
        // 트리의 왼쪽에는 start~mid까지의 합, 오른쪽은 mid+1~end까지의 합
        return tree[index];

    }

    /**
     * start: 시작 구간
     * end: 끝 구간
     * index: 구간합을 저장한 tree의 index
     * updateIdx: 값을 바꿀 배열의 index
     * oldValue: 바꿀 값의 원래 값
     * newValue: 바꿀 값
     */
    static void update(int start, int end, int index, int updateIdx, long oldValue, long newValue) {
        if (updateIdx < start || updateIdx > end) {
            // 범위 밖 -> 변경x
            return;
        }
        tree[index] -= oldValue;
        tree[index] += newValue;

        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, index * 2, updateIdx, oldValue, newValue);
        update(mid + 1, end, index * 2 + 1, updateIdx, oldValue, newValue);
    }

    /**
     * start, end: index에 저장된 구간합의 범위
     * left, right: 구하려고 하는 구간합
     */
    static long getSum(int start, int end, int index, int left, int right) {
        if (left > end || right < start) return 0; // 범위밖
        if (left <= start && right >= end) return tree[index];  // 범위 안에 있는 경우 해당 구간합 return
        int mid = (start + end) / 2;
        return getSum(start, mid, index * 2, left, right) + getSum(mid + 1, end, index * 2 + 1, left, right);
    }

}
