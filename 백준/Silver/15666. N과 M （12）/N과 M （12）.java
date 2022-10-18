
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N; i++)
            set.add(sc.nextInt());

        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        int[] out = new int[M];
        comb(arr, new int[M], 0, 0, M);
        System.out.println(sb);
    }

    static void comb(Integer[] arr, int[] out, int start, int depth, int M) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(out[i] + " ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            comb(arr, out, i, depth + 1, M);
        }
    }
}
