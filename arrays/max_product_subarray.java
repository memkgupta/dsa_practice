class Solution {

    public int maxProduct(int[] nums) {
        // 'pre' will store the prefix product (product from start to current index)
        int pre = 1;
        // 'suff' will store the suffix product (product from end to current index)
        int suff = 1;
        // Initialize 'max' to the smallest possible integer value
        // so we can correctly compute the maximum later
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        // We’ll iterate from both ends simultaneously:
        // i moves from start -> end for prefix
        // (n - i - 1) moves from end -> start for suffix
        for (int i = 0; i < n; i++) {
            // If prefix product becomes 0, reset it to 1 (since 0 breaks the product chain)
            if (pre == 0) pre = 1;

            // Same for suffix — if 0 appears, reset
            if (suff == 0) suff = 1;

            // Multiply prefix product with current number (left to right)
            pre = pre * nums[i];

            // Multiply suffix product with element from the right side (right to left)
            suff = suff * nums[n - i - 1];

            // Compare current prefix and suffix products to get the maximum
            // This works because the maximum product subarray can start or end anywhere
            max = Math.max(max, Math.max(pre, suff));
        }

        // Return the maximum product found
        return max;
    }
}
