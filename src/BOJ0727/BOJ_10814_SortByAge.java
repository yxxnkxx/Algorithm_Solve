package BOJ0727;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_10814_SortByAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Member> list = new LinkedList<>();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			list.add(new Member(age, name));
		}
		Collections.sort(list);
		for (Member m : list) {
			System.out.println(m);
		}
	}

}

class Member implements Comparable<Member> {
	static int cnt;
	int num;
	int age;
	String name;

	public Member(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		this.num = cnt++;
	}

	@Override
	public int compareTo(Member o) {
		if (this.age != o.age) {
			return this.age - o.age;
		} else {
			return this.num - o.num;
		}
	}

	@Override
	public String toString() {
		return age + " " + name;
	}

}