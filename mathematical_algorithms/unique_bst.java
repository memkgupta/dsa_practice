// catalan numbers
class Solution {

    // we can solve this problem using concept of catalan numbers basically the
    // no of trees will be nth catalan number where n is no of nodes in tree
    int[] dp = new int[20];

    public int numTrees(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += numTrees(i - 1) * numTrees(n - i);
        }
        return dp[n] = count;
    }
}
