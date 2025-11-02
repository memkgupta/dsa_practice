class Solution {

    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int b_p = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newProfit = prices[i] - b_p;
            if (newProfit < 0) {
                b_p = prices[i];
            }
            max = Math.max(max, newProfit);
        }
        return Math.max(0, max);
    }
}
