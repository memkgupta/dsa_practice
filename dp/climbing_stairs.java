class Solution {

    int[] dp; // Memoization array to store results of subproblems

    public int climbStairs(int n) {
        // Initialize dp array with -1 (indicating uncomputed states)
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Start recursion from n steps
        return rec(n);
    }

    // Recursive function to compute number of ways to climb n stairs
    public int rec(int n) {
        // If n becomes negative, there’s no valid way to climb
        if (n < 0) {
            return 0;
        }

        // Base case: if exactly 0 steps remaining, one valid way (do nothing)
        if (n == 0) return 1;

        // If already computed, return stored result (avoid recomputation)
        if (dp[n] != -1) return dp[n];

        // Recurrence relation:
        // We can reach step n either from (n-1) or (n-2)
        // So total ways = ways(n-1) + ways(n-2)
        return dp[n] = rec(n - 1) + rec(n - 2);
    }
}
