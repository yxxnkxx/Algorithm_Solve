
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = 1, cnt1 = 1, cnt2 = 1, max = 1;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				if (arr[i - 1] == arr[i]) {
					if (d == 1) {
						cnt1++;
						d = 0;
					} else if (d == 2) {
						cnt2++;
						d = 0;
					} else if (d == 0) {
						cnt1++;
						cnt2++;
					}
				} else if (arr[i - 1] < arr[i]) {
					if (d == 2) {
						cnt2 = 0;
					}
					cnt1++;
					d = 1;
				} else if (arr[i - 1] > arr[i]) {
					if (d == 1) {
						cnt1 = 0;
					}
					cnt2++;
					d = 2;
				}
			}
			if (max < (cnt1 > cnt2 ? cnt1 : cnt2)) {
				max = (cnt1 > cnt2 ? cnt1 : cnt2);
			}
		}
		System.out.println(max);
		sc.close();
	}
}