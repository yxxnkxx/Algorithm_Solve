package Silver.s3;

import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N + 1]; // 스위치 배열, 0 은 사용x
		for (int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();

		int student = sc.nextInt();
		for (int i = 0; i < student; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			switch (gender) {
			case 1: // 남자
				for (int j = num; j <= N; j += num)
					change(j); // 배수에 해당하는 index switch
				break;
			case 2: // 여자
				int idx = 0;
				change(num);
				while (true) {
					int right = num + idx;
					int left = num - idx;

					// right,left가 배열의 index 안이고 두 값이 대칭이면
					if (right <= N && left > 0 && arr[right] == arr[left]) {
						change(right);
						change(left);
						idx++;
					} else {

						break;
					}
				}
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < arr.length; i++) {
			sb.append(arr[i] + " ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());

	}

	static void change(int i) {
		if (arr[i] == 0) {
			arr[i] = 1;
		} else {
			arr[i] = 0;
		}
	}

}
