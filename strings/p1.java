// Problem statement -> Check given string is palindrome or not Leetcode 125

class Solution {

    // main function
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            //skip all non alphanumeric numbers from left side
            while (i < s.length() && isNonAlphaNumeric(s.charAt(i))) {
                i++;
            }
            //skip all non alphanumeric numbers from right side
            while (j >= 0 && isNonAlphaNumeric(s.charAt(j))) {
                j--;
            }
            // for palindrome characters at left and right should be same else it is not a palindrome
            if (
                i < s.length() && j >= 0 && s.charAt(i) != s.charAt(j)
            ) return false;
            i++;
            j--;
        }
        return true;
    }

    // helper function to check wether a number is non alpha numeric
    public boolean isNonAlphaNumeric(char c) {
        if (c >= 'A' && c <= 'Z') return false;
        if (c >= '0' && c <= '9') return false;
        return true;
    }
}
