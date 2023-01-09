
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int curr;
        Map<Integer, Node> child;

        public Node(int curr) {
            this.curr = curr;
            this.child = new HashMap<>();
        }

        public boolean addNode(int newNode) {
            if (this.child.containsKey(newNode))
                return false; // 이미 있음
            this.child.put(newNode, new Node(newNode)); // 자식 노드 매달기
            return true; // 추가 완료
        }

    }


    static int N;

    public static void main(String[] args) throws IOException {
        // 번호를 트리로 매달기 -> 트리로 매달다가 이미 트리에 있는 노드인데 리프 노드라면 일관성 X
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        out:
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            Node root = new Node(0); // root 노드 설정
            String[] input = new String[N];
            for (int i = 0; i < N; i++)
                input[i] = br.readLine();
            Arrays.sort(input, Comparator.comparingInt(String::length));
            for (int i = 0; i < N; i++) {
                Node curr = root; // 현재 노드 확인
                String number = input[i];
                for (int j = 0; j < number.length(); j++) {
                    int num = number.charAt(j) - '0';
                    if (curr.addNode(num)) {
                        // 새로 추가함
                        curr = curr.child.get(num); // 현재 노드 변경
                    } else {
                        // 이미 있다
                        curr = curr.child.get(num); // 자식 노드로 이동
                        // 이미 있는 노드라면 리프 노드인지 판단하기
                        if (curr.child.size() == 0) {
                            sb.append("NO").append("\n");
                            continue out;
                        }
                    }
                }
            }
            // 모두 추가했다면
            sb.append("YES").append("\n");

        }
        System.out.print(sb);
    }
}
