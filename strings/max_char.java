//Problem Statement: Given a string, return the character that occurs the maximum number of times in the string. If the maximum occurrence of two or more characters is the same, return any one of them.

class Solution {

    public static void main(String[] args) {
        System.out.println(max("takeuforward"));
    }

    public static char max(String s) {
        int[] f_map = new int[26];
        int max = 0;
        char res = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            f_map[c - 'a']++;
            if (f_map[c - 'a'] > max) {
                max = f_map[c - 'a'];
                res = c;
            }
        }
        return res;
    }
}
