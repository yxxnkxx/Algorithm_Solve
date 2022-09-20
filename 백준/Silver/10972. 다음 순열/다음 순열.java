import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		nextPerm(arr);
	}

	static void nextPerm(int[] arr) {
		int a = -1; // 꼭대기
		int c = 0; // a-1보다 큰 수 찾기
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < arr[i])
				a = i;
		}

		if (a == -1) {
			System.out.println(-1);
			return;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > arr[a - 1]) {
				c = i;
				break;
			}
		}
		// a-1과 c를 swap
		int tmp = arr[a - 1];
		arr[a - 1] = arr[c];
		arr[c] = tmp;
		// a부터 끝까지 거꾸로
		for (int i = 0; i < a; i++)
			System.out.print(arr[i] + " ");
		for (int i = arr.length - 1; i >= a; i--) {
			System.out.print(arr[i] + " ");
		}
	}

}