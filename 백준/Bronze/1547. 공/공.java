
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[4];
        arr[1] = 1;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            swap(arr, a, b);
        }
        for (int i = 1; i <= 3; i++) {
            if (arr[i] == 1) {
                System.out.println(i);
                return;
            }
        }

    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
