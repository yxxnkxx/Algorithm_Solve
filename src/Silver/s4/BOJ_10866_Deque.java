package Silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10866_Deque {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		MyDeque deque = new MyDeque();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push_back":
				int X = Integer.parseInt(st.nextToken());
				deque.offer(X);
				break;

			case "push_front":
				int Y = Integer.parseInt(st.nextToken());
				deque.offerFirst(Y);
				break;

			case "pop_front":
				sb.append(deque.poll());
				sb.append("\n");
				break;
			case "pop_back":
				sb.append(deque.pollLast());
				sb.append("\n");
				break;
			case "size":
				sb.append(deque.getSize());
				sb.append("\n");
				break;
			case "empty":
				if (deque.isEmpty())
					sb.append(1 + "\n");

				else
					sb.append(0 + "\n");
				break;
			case "front":
				sb.append(deque.peek() + "\n");
				break;
			case "back":
				sb.append(deque.peekLast() + "\n");
				break;
			}
		}
		System.out.println(sb.toString());

	}
}

class MyDeque {
	private DNode<Integer> head;
	private DNode<Integer> tail;
	private int size;

	public MyDeque() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public void offerFirst(Integer data) {
		// offerFirst
		DNode<Integer> newNode = new DNode<Integer>(data);
		newNode.next = head;
		if (head != null)
			head.prev = newNode;
		head = newNode;
		if (head.next == null)
			tail = head;
		size++;

	}

	public void offer(Integer data) {
		if (size == 0) {
			offerFirst(data);
			return;
		}
		DNode<Integer> newNode = new DNode<Integer>(data);
		newNode.prev = tail;
		tail.next = newNode;
		tail = newNode;
		size++;

		// offerLast
	}

	public Integer poll() {
		// pollFirst
		if (head == null)
			return -1;
		Integer data = head.data;
		head = head.next;
		if (head != null)
			head.prev = null;
		size--;

		if (size == 0)
			tail = null;
		return data;
	}

	public Integer pollLast() {
		if (tail == null)
			return -1;
		Integer data = tail.data;
		tail = tail.prev;
		if (tail != null)
			tail.next = null;
		size--;

		if (size == 0)
			head = null;
		return data;

	}

	public Integer peek() {
		if (head == null)
			return -1;
		return head.data;

	}

	public Integer peekLast() {
		if (tail == null)
			return -1;
		return tail.data;

	}

}

class DNode<E> {
	E data;
	DNode<E> prev;
	DNode<E> next;

	public DNode(E data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public DNode(E data, DNode<E> prev, DNode<E> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

}
