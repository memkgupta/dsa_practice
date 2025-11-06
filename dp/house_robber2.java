class Solution {

    int[] t;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        t = new int[100];
        Arrays.fill(t, -1);

        int c1 = solve(nums, 0, nums.length - 2);
        Arrays.fill(t, -1);
        int c2 = solve(nums, 1, nums.length - 1);
        return Math.max(c1, c2);
    }

    int solve(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (t[i] != -1) {
            return t[i];
        }

        int steal = nums[i] + solve(nums, i + 2, j);
        int ns = solve(nums, i + 1, j);
        return t[i] = Math.max(steal, ns);
    }
}
