class Solution {

    int[][] dp = new int[20][2000];

    public int findTargetSumWays(int[] nums, int target) {
        for (int i = 0; i < 20; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(nums, target, 0, 0);
    }

    public int rec(int[] nums, int target, int curr, int i) {
        if (curr == target && i == nums.length) {
            return 1;
        }
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][curr > 0 ? curr : 1000 - curr] != -1) {
            return dp[i][curr > 0 ? curr : 1000 - curr];
        }
        int count = 0;
        count += rec(nums, target, curr + nums[i], i + 1);
        count += rec(nums, target, curr - nums[i], i + 1);
        return dp[i][curr > 0 ? curr : 1000 - curr] = count;
    }
}
