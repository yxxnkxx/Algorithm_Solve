import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> down = new PriorityQueue<>(Comparator.reverseOrder()); // poll 하면 큰 수가 나옴
        PriorityQueue<Integer> up = new PriorityQueue<>();
        int mid = Integer.parseInt(br.readLine());
        sb.append(mid).append("\n");
        for (int i = 2; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num < mid) down.add(num);
            else up.add(num);
            // up down 사이즈 비교
            // i가 홀수이면 up down 사이즈가 같아야 함
            if (i % 2 == 1) {
                if (up.size() > down.size()) {
                    down.add(mid);
                    mid = up.poll();
                } else if (up.size() < down.size()) {
                    up.add(mid);
                    mid = down.poll();
                }
            } else {
                // i가 짝수면 down +1 = up
                // 이전은 홀수번째니까 down==up이었을 것, 새로운 수를 추가해서 수정해야할 경우는 down에 새로운 수가 추가된 경우
                if (down.size() + 1 > up.size()) {
                    up.add(mid);
                    mid = down.poll();
                }
            }
            sb.append(mid).append("\n");
        }
        System.out.print(sb);

    }
}