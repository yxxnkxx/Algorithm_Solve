package SWEA.d3;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_2930_힙 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ArrayList<Integer> heap = new ArrayList<>();
			sb.append("#" + t + " ");
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();
				switch (command) {
				case 1:
					// 삽입
					add(heap, sc.nextInt());
					break;
				case 2:
					// 최댓값 출력 후 삭제
					int del = remove(heap);
					sb.append(del + " ");
					break;
				}
			}
			sb.append("\n");

		} // tc
		System.out.println(sb.toString());

	} // main

	static void add(ArrayList<Integer> heap, int K) {
		heap.add(K);
		int idx = heap.size() - 1;
		while (idx >= 0) { // 루트 노드에 갈 때까지
			int parent = idx / 2;
			if (heap.get(parent) < heap.get(idx)) { // 부모가 자식보다 작으면
				swap(heap, parent, idx); // swap
				idx = parent; // 반복
			} else {
				break;
			}
		}

	}

	static int remove(ArrayList<Integer> heap) {
		if (heap.size() == 0)
			return -1; // 비어있을 때
		int tmp = heap.get(0);
		swap(heap, 0, heap.size() - 1); // 마지막 index의 값과 root 교환
		heap.remove(heap.size() - 1); // 삭제

		int idx = 0;
		while (idx < heap.size() - 1) {
			int child = idx * 2;
			if (child + 1 > heap.size() - 1)
				break;
			if (heap.get(idx * 2) < heap.get(idx * 2 + 1))
				child = idx * 2 + 1;
			if (heap.get(child) > heap.get(idx)) { // 자식이 부모보다 크면
				swap(heap, child, idx); // 교환
				idx = child;
			} else {
				break;
			}
		}
		return tmp;

	}

	static void swap(ArrayList<Integer> heap, int i, int j) {
		int tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tmp);

	}

}
