// Problem Statement: Given a string, write a program to count the number of vowels, consonants, and spaces in that string.

class Solution {

    public static void main(String[] args) {
        int[] c = count("Take u forward is Awesome");
        System.out.println("Vowel :" + c[0]);
        System.out.println("Consonants :" + c[1]);
        System.out.println("Space :" + c[2]);
    }

    public static int[] count(String s) {
        s = s.toLowerCase();
        int[] res = new int[3];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') res[2]++;
            else if (isVowel(c)) res[0]++;
            else {
                res[1]++;
            }
        }
        return res;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
