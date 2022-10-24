package prg.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRG_다트게임 {
    static public int solution(String dartResult) {

        String[] input = dartResult.split("[^0-9]+");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++)
            nums[i] = Integer.parseInt(input[i]);

        String[] comm = dartResult.split("[0-9]+");

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            char bonus = comm[i + 1].charAt(0);
            int mul = 0;
            switch (bonus) {
                case 'S':
                    mul = 1;
                    break;
                case 'D':
                    mul = 2;
                    break;
                case 'T':
                    mul = 3;
                    break;
            }

            nums[i] = (int) (Math.pow(num, mul));
            if (comm[i + 1].length() == 2) {
                // option o
                char opt = comm[i + 1].charAt(1);
                if (opt == '*') {
                    nums[i] *= 2;
                    if (i > 0)
                        nums[i - 1] *= 2;

                } else {
                    nums[i] *= -1;
                }

            }

        }

        int answer = 0;
        for (Integer num : nums)
            answer += num;


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1D2S3T*"));
    }
}
