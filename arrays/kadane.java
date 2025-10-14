class Solution {
    public int maxSubArray(int[] nums) {
        // Stores the maximum subarray sum found so far
        int max = Integer.MIN_VALUE;

        // Stores the current subarray sum
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add current element to current sum
            sum += nums[i];

            // Update max if current sum is greater
            max = Math.max(max, sum);

            // If sum becomes negative, reset it (start new subarray)
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the largest subarray sum
        return max;
    }
}
