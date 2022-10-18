package BOJ.Gold.g2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2749_피보나치수3 {

    static final int MOD = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Long N = sc.nextLong();
        int[] arr = new int[300];
        arr[0]=0;
        arr[1]=1;
        for (int i=2; i<300; i++) {
            arr[i] = (arr[i-1]+arr[i-2])%MOD;
        }
        System.out.println(Arrays.toString(arr));

    }
}
