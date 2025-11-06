class Solution {

    HashMap<String, Boolean> map = new HashMap<>();
    int[][] dp = new int[1000][1000];

    public String longestPalindrome(String s) {
        int size = Integer.MIN_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                String ss = s.substring(i, j + 1);
                if (dp[i][j] == 1 || isPalindrome(ss, i, j)) {
                    if ((j - i + 1) > size) {
                        res = ss;
                        size = j - i + 1;
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int ii, int jj) {
        if (dp[ii][jj] != 0) {
            return dp[ii][jj] == 1;
        }
        int i = 0;

        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                dp[ii][jj] = 2;
                return false;
            }
            i++;
            j--;
        }
        dp[ii][jj] = 1;
        return true;
    }
}
