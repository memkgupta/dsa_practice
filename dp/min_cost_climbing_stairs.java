class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[cost.length + 2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }

    public int min(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        int one = cost[i] + min(cost, i + 1);
        int two = cost[i] + min(cost, i + 2);
        return Math.min(one, two);
    }
}
