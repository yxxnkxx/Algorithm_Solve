import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[] ans = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        Arrays.sort(arr);
        int st = 0;
        int ed = N - 1;
        find(st, ed);
        System.out.println(ans[0]+" "+ans[1]);
    }

    static void find(int st, int ed) {
        if (ed<=st) return;;
        int sum = arr[st] + arr[ed];

        if (Math.abs(min) > Math.abs(sum)) {
            ans[0] = arr[st];
            ans[1] = arr[ed];
            min = sum;

        }
        if (sum < 0) find(st+1, ed);
        else find(st, ed-1);


    }


}