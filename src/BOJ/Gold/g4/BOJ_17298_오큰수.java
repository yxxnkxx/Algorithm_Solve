package BOJ.Gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {

	// array 활용
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		int[] origin = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			origin[i] = Integer.parseInt(st.nextToken());
		int size = N;
		for (int i = N - 1; i >= 0; i--) {
			int n = origin[i];
			int top = i + 1; // 오른쪽 변수가 top
			while (top <= size - 1 && origin[top] < n) // top이 범위 안에 있고 top의 값이 n보다 작거나 같으면 오큰수x
				top++;
			if (top >= size) {// top이 범위를 벗어나면 오큰수 존재x
				result[i] = -1;
			} else if (origin[top] > n) { // top이 크면 오큰수
				result[i] = origin[top];
				origin[i + 1] = origin[top]; // i의 오른쪽 값을 바로 top으로 바꿔줌
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(result[i] + " ");
		System.out.println(sb.toString());
	}

}
