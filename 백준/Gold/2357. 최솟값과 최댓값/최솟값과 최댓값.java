
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        minTree = new int[N * 4];
        maxTree = new int[N * 4];
        initMin(1, N, 1);
        initMax(1, N, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(findMin(1, N, 1, a, b));
            sb.append(" ");
            sb.append(findMax(1, N, 1, a, b));
            sb.append("\n");
        }
        System.out.print(sb);

    }

    static int initMin(int start, int end, int index) {
        if (start == end) return minTree[index] = arr[start];
        int mid = (start + end) / 2;
        minTree[index] = Math.min(initMin(start, mid, index * 2), initMin(mid + 1, end, index * 2 + 1));
        return minTree[index];
    }

    static int initMax(int start, int end, int index) {
        if (start == end) return maxTree[index] = arr[start];
        int mid = (start + end) / 2;
        maxTree[index] = Math.max(initMax(start, mid, index * 2), initMax(mid + 1, end, index * 2 + 1));
        return maxTree[index];
    }

    static int findMin(int start, int end, int index, int left, int right) {
        if (left > end || right < start) return Integer.MAX_VALUE;
        if (left <= start && right >= end) return minTree[index];
        int mid = (start + end) / 2;
        return Math.min(findMin(start, mid, index * 2, left, right), findMin(mid + 1, end, index * 2 + 1, left, right));

    }

    static int findMax(int start, int end, int index, int left, int right) {
        if (left > end || right < start) return -1;
        if (left <= start && right >= end) return maxTree[index];
        int mid = (start + end) / 2;
        return Math.max(findMax(start, mid, index * 2, left, right), findMax(mid + 1, end, index * 2 + 1, left, right));

    }
}
