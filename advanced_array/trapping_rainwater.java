class Solution {

    public int trap(int[] height) {
        /**
         * For solving this problem we can simply use the concept that
         * water collected on top of a building depends on the minimum height
         * of the tallest buildings to the left and right of it.
         *
         * In simple words — water fills only till the lowest boundary on either side.
         */

        // Two pointers: one from the start and one from the end
        int left = 0,
            right = height.length - 1;

        /**
         * For each position, we need to know:
         * - the tallest building to the left of it (leftMax)
         * - the tallest building to the right of it (rightMax)
         * So we initialize both of them to 0
         */
        int leftMax = 0,
            rightMax = 0;

        int water = 0; // total water collected

        /**
         * We will traverse the height array using two pointers: left and right.
         * This helps us calculate leftMax and rightMax on-the-fly without using extra space.
         *
         * At each step, we process the side with the smaller height because
         * water trapped depends on the minimum of the two boundaries.
         */
        while (left < right) {
            if (height[left] < height[right]) {
                /**
                 * If the current left height is smaller, it means the left side is the limiting factor.
                 *
                 * So:
                 * - Update leftMax to be the max seen so far from the left.
                 * - Water trapped at this index = leftMax - current height
                 *   (only if leftMax is greater, otherwise 0)
                 */
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++; // move the left pointer inward
            } else {
                /**
                 * Same logic but now for the right side.
                 *
                 * Since height[right] is smaller or equal to height[left],
                 * right side becomes the limiting boundary for water trapping.
                 */
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--; // move the right pointer inward
            }
        }

        // Finally, return the total amount of trapped rainwater
        return water;
    }
}
