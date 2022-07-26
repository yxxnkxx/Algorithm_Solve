package BOJ0726;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2751_수정렬2 {
	static int[] sorted = new int[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// merge sort
		mergeSort(arr, 0, N - 1);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < arr.length; i++) {
			bw.write(Integer.toString(arr[i]) + "\n");

		}
		bw.close();

	}

	static int[] merge(int[] arr, int l, int mid, int r) {
		int i = l; // 왼쪽 배열의 시작 index
		int j = mid + 1; // 오른쪽 배열의 시작 index
		int k = l; // merge 결과 배열의 index

		while (i <= mid && j <= r) {
			if (arr[i] <= arr[j]) {
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

	static int[] mergeSort(int[] arr, int l, int r) {
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
