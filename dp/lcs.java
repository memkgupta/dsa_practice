class Solution {

    /**
    Initializing the DP table for memoization  ,
    dp[i][j] == -1 -> uncomputed
    dp[i][j] -> the longest possible sequence from the substring of text1 from index i and substring of text2
    from index j
     */
    int[][] dp = new int[1001][1001];

    public int longestCommonSubsequence(String text1, String text2) {
        for (int i = 0; i < 1000; i++) {
            // Filling the default values in DP table
            Arrays.fill(dp[i], -1);
        }
        // Calling the recursive function
        return rec(text1, text2, 0, 0);
    }

    public int rec(String text1, String text2, int i, int j) {
        // Base condition : If we have covered any of the string then no subsequence can be found hence return 0
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            /** We have already calculated value for this state hence return this */
            return dp[i][j];
        }

        /*
    We will have two cases
    1. Character at i and j of text1 and text2 respectively matches then it is obvious that it will be part of the subsequence
    2. Characters dont match and in this case we will have two choice and we will return max of both choice
        a. Wether to stop at i and wait for j to get a matching character
        b. Wether to stop at j and wait for i to get a matching character
    */

        if (text1.charAt(i) == text2.charAt(j)) {
            int matchAndMove = 1 + rec(text1, text2, i + 1, j + 1);
            dp[i][j] = matchAndMove;
        } else {
            int moveJ = rec(text1, text2, i, j + 1);
            int moveI = rec(text1, text2, i + 1, j);
            dp[i][j] = Math.max(moveJ, moveI);
        }
        return dp[i][j];
    }
}
