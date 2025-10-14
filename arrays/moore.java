class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;  // count of current candidate
        int max = 0;    // current candidate for majority

        for (int i = 0; i < nums.length; i++) {

            // If count is 0, take current element as new candidate
            if (count == 0) {
                max = nums[i];
            }

            // If current element equals candidate, increment count
            if (nums[i] == max) {
                count++;
            } else {
                // Else, cancel out a vote
                count--;
            }
        }

        // At the end, max will hold the majority element
        return max;
    }
}
