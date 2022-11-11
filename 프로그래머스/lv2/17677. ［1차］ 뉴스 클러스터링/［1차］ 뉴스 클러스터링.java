import java.util.List;
import java.util.ArrayList;
class Solution {
    public int solution(String str1, String str2) {
        int mul = 65536;
        int answer = 0;


        // 소문자로 바꾸기
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String regex = "^[a-z]+$";
        List<String> input1 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String substr1 = str1.substring(i, i + 2);
            if (substr1.matches(regex))
                input1.add(substr1);
        }
        List<String> input2 = new ArrayList<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String substr2 = str2.substring(i, i + 2);
            if (substr2.matches(regex))
                input2.add(substr2);
        }
        boolean[] pick2 = new boolean[input2.size()];
        int intersection = 0;
        for (int i = 0; i < input1.size(); i++) {
            String str = input1.get(i);
            for (int j = 0; j < input2.size(); j++) {
                if (str.equals(input2.get(j)) && !pick2[j]) {
                    pick2[j] = true;
                    intersection++;
                    break;
                }
            }
        }
        int union = input1.size() + input2.size() - intersection;
        System.out.println("intersection = " + intersection);
        System.out.println("union = " + union);
        if (union == 0) answer = mul;
        else
            answer = (int) ((double) intersection / union * mul);
        return answer;
    }
}