class Solution {

    public int jump(int[] nums) {
        int coverage = 0;
        int jump = 0;
        int lastJumpIndex = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);
            if (i == lastJumpIndex) {
                jump++;
                lastJumpIndex = coverage;
                if (coverage >= nums.length - 1) return jump;
            }
        }
        return jump;
    }
}
