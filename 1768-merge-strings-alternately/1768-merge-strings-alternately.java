class Solution {
    public String mergeAlternately(String word1, String word2) {
        int idx = 0;
        int length1 = word1.length();
        int length2 = word2.length();
        StringBuilder result = new StringBuilder();

        while (idx < length1 && idx < length2) {
             result.append(word1.charAt(idx));
             result.append(word2.charAt(idx));
             idx++;
        }
        if (idx < length1) {
            result.append(word1.substring(idx, length1));
        } else {
            result.append(word2.substring(idx, length2));
        }
        return result.toString();
    }
}