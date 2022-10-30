package prg.lv2;

import java.util.*;

public class PRG_메뉴리뉴얼 {
    static List<String> list = new ArrayList<>();
    static List<Character[]> combs = new ArrayList<>();

    static public String[] solution(String[] orders, int[] course) {




        // orders에 포함된 알파벳을 set으로 만들기 -> 배열로 만들어서 course의 수 만큼 조합을 구함
        Set<Character> set = new HashSet<>();
        for (String str : orders) {
            for (int i = 0; i < str.length(); i++)
                set.add(str.charAt(i));
        }
        Character[] chars = set.toArray(new Character[0]);
        // 조합 구하기
        for (int i = 0; i < course.length; i++) {
            int r = course[i];
            Character[] pick = new Character[r];
            combs=new ArrayList<>(); // 초기화
            comb(chars, pick, r, 0, 0);
            find(orders);
        }
        Collections.sort(list);
        String[] answer = list.toArray(list.toArray(new String[0]));
        // 각 조합 별로 orders에 2개 이상이면 ans에 추가하기


        return answer;
    }

    static public void comb(Character[] chars, Character[] pick, int r, int depth, int start) {
        if (depth == r) {
            combs.add(pick.clone());
            return;
        }

        for (int i = start; i < chars.length; i++) {
            pick[depth] = chars[i];
            comb(chars, pick, r, depth + 1, i + 1);
        }
    }

    static public void find(String[] orders) {
        List<Character[]> answer=new ArrayList<>();
        int ans=0;
        for (int i=0; i<combs.size(); i++) {
            Character[] pick = combs.get(i);
            int cnt=0;
            out: for (int j=0; j<orders.length; j++) {
                String str = orders[j];
                int tmp=0;
                for (int k=0; k<pick.length; k++) {
                    if (str.contains(pick[k].toString()))
                        tmp++;
                    else continue out;
                }
                if (tmp==pick.length) cnt++;
            }
            if (ans<cnt) {
                ans=cnt;
                answer.clear();
                answer.add(pick);
            } else if (ans==cnt)
                answer.add(pick);
        }
        if (ans>=2) {
            for (int i = 0; i < answer.size(); i++) {
                String tmp = "";
                for (int j = 0; j < answer.get(i).length; j++) {
                    tmp += answer.get(i)[j];
                }
                list.add(tmp);
            }
        }

    }

    public static void main(String[] args) {
        String[] orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }
}
