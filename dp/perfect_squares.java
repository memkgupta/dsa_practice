class Solution {

    int[] dp; // DP array to store minimum number of perfect squares for each value

    public int numSquares(int n) {
        // Step 1: Generate all perfect squares less than or equal to n
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            int sq = (int) Math.pow(i, 2);
            if (sq > n) break;
            squares.add(sq);
        }

        // Step 2: Initialize DP array
        dp = new int[n + 1];
        dp[0] = 0; // Base case: 0 requires 0 perfect squares

        // Step 3: Bottom-up DP to fill dp[i] for all values up to n
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            // Try every square <= i
            for (int j = 0; j < squares.size(); j++) {
                int sq = squares.get(j);
                if (sq <= i) {
                    // If we take 'sq', we add 1 to the solution for (i - sq)
                    min = Math.min(min, 1 + dp[i - sq]);
                } else {
                    break; // Optimization: stop when square > i
                }
            }

            dp[i] = min; // Store the best (minimum) count
        }

        return dp[n]; // Final answer for n
    }

    // Optional recursive + memoized version (not used in main)
    public int rec(int n, List<Integer> squares) {
        // Base cases
        if (n < 0) return Integer.MAX_VALUE; // Invalid case
        if (n == 0) return 0; // No squares needed to make 0

        // If already computed, return stored result
        if (dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;

        // Try subtracting each square and recursively compute
        for (int sq : squares) {
            if (sq <= n) {
                int take = 1 + rec(n - sq, squares);
                min = Math.min(min, take);
            } else {
                break;
            }
        }

        // Store and return the minimum found
        return dp[n] = min;
    }
}
