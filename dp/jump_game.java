class Solution {

    public boolean canJump(int[] nums) {
        int coverage = 0;

        if (nums.length == 1) return true;
        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);
            if (nums[i] == 0 && coverage <= i) break;
            if (coverage >= nums.length - 1) return true;
        }
        return false;
    }
}
