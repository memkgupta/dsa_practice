class Solution {

    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int res = rec(coins, amount);

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public int rec(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        int total = Integer.MAX_VALUE;
        if (dp[amount] != -1) {
            return dp[amount];
        }
        for (int i = 0; i < coins.length; i++) {
            int coin = rec(coins, amount - coins[i]);

            if (coin != Integer.MAX_VALUE) {
                total = Math.min(total, 1 + coin);
            }
        }
        return dp[amount] = total;
    }
}
