package BOJ.Silver.s5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_7568_덩치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Person> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new Person(sc.nextInt(), sc.nextInt()));
		}

		for (Person p : list) {
			int cnt = 1;
			for (Person other : list) {
				if (p.compareTo(other) < 0) {
					cnt++;
				}
			}
			p.rank = cnt;
			System.out.println(p.rank);
		}

	}

}

class Person implements Comparable<Person> {
	int weight;
	int height;
	int rank;

	public Person(int weight, int height) {
		super();
		this.weight = weight;
		this.height = height;
	}

	@Override
	public int compareTo(Person o) {
		if (this.weight > o.weight && this.height > o.height) {
			return 1;
		} else if (this.weight < o.weight && this.height < o.height) {
			return -1;
		}
		return 0;
	}

}
