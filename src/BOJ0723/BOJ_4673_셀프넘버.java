package BOJ0723;

public class BOJ_4673_셀프넘버 {

	public static int[] findSelf(int n, int[] nums) {
		int result = n;
		while (n != 0) {
			result += n % 10;
			n /= 10;
		}

		if (result < 10000 && nums[result] == 0) {
			nums[result] = 1;
			return findSelf(result, nums);
		}

		return nums;

	}

	public static void main(String[] args) {
		int n = 1;
		int[] nums = new int[10001];
		while (n < 10000) {
			if (nums[n] == 0) {
				System.out.println(n);
				nums = findSelf(n, nums);
			}
			n++;
		}

	}

}
