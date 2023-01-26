import java.util.*;

public class Main {

    static class Mul implements Comparable<Mul> {
        int r;
        int c;
        int val;

        public Mul(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Mul o) {
            if (this.val == o.val)
                return (this.r + this.c) - (o.r + o.c);
            return this.val - o.val;
        }
    }

    static int N;
    static boolean[] visited;
    static int ans;

    /**
     * 7
     * 3
     * 2
     * 1
     * 1
     * 0
     * 0
     * -3
     * ans = 8
     * 0*0보다 0*-3이 우선해야 한다
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 0 이하
        // 1 이상
        List<Integer> minusNum = new ArrayList<>();
        List<Integer> plusNum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num >= 1) plusNum.add(num);
            else minusNum.add(num);
        }


        List<Mul> plus = new ArrayList<>();
        List<Mul> minus = new ArrayList<>();

        Collections.sort(minusNum); // 작은수부터
        plusNum.sort(Comparator.reverseOrder()); // 큰수부터


        int idx = 0;
        getSum(minusNum, idx);
        getSum(plusNum, idx);
        System.out.println(ans);

    }

    private static void getSum(List<Integer> plusNum, int idx) {
        while (idx < plusNum.size()) {
            if (idx + 1 < plusNum.size()) {
                int curr = plusNum.get(idx);
                int next = plusNum.get(idx + 1);
                if (curr * next > curr + next) {
                    ans += curr * next;
                    idx += 2;
                } else {
                    ans += curr;
                    idx++;
                }
            } else {
                ans += plusNum.get(idx);
                idx++;

            }
        }
    }

}