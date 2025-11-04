class Solution {

    public int missingNumber(int[] nums) {
        // Variable to store the sum of all elements in the array
        int sum = 0;

        // Calculate the sum of all numbers present in the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 'n' represents the total count of numbers that should be present (including the missing one)
        int n = nums.length;

        // The sum of the first 'n' natural numbers (0 to n) is n*(n+1)/2
        // Subtracting the sum of array elements from this total gives the missing number
        return ((n * (n + 1)) / 2) - sum;
    }
}
