package BOJ0726;

import java.util.Scanner;

public class BOJ_11651_좌표정렬2 {
	static int[][] sorted = new int[100001][2];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt(); // x
			arr[i][1] = sc.nextInt(); // y
		}

		// merge sort
		mergeSort(arr, 0, N - 1);

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i][0] + " " + arr[i][1] + "\n");
		}

	}

	static int[][] merge(int[][] arr, int l, int mid, int r) {
		int i = l; // 왼쪽 배열의 시작 index
		int j = mid + 1; // 오른쪽 배열의 시작 index
		int k = l; // merge 결과 배열의 index

		while (i <= mid && j <= r) {
			if (arr[i][1] < arr[j][1]) { // y좌표
				sorted[k++] = arr[i++];
			} else if (arr[i][1] == arr[j][1] && arr[i][0] < arr[j][0]) {
				sorted[k++] = arr[i++];
			} else {
				sorted[k++] = arr[j++];
			}
		}

		if (i > mid) {
			for (int right = j; right <= r; right++) {
				sorted[k++] = arr[right];
			}
		} else {
			for (int left = i; left <= mid; left++) {
				sorted[k++] = arr[left];
			}
		}

		// 원래 배열에 복사
		for (int tmp = l; tmp <= r; tmp++) {
			arr[tmp] = sorted[tmp];
		}

		return arr;

	}

	static int[][] mergeSort(int[][] arr, int l, int r) {
		int mid;
		if (arr.length == 1) {
			return arr;
		}

		if (l < r) {
			mid = (l + r) / 2;
			arr = mergeSort(arr, l, mid);
			arr = mergeSort(arr, mid + 1, r);
			arr = merge(arr, l, mid, r);
		}

		return arr;
	}

}
