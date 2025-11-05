/*
 * Every number can be represented as a 32-bit integer.
 * If there were no duplicates, then for each bit position (0–31),
 * the total count of '1's in that bit position across numbers [1..n-1]
 * would match the count across the array.
 *
 * But because one number is repeated, the bits of that number
 * will appear one extra time. So at any bit position where the duplicate
 * number has a '1', the total number of '1's in that bit position
 * in the array will be greater than expected.
 *
 * By comparing bit counts between the "ideal sequence" [1..n-1]
 * and the given array, we can reconstruct the duplicate number bit by bit.
 */
class Solution {

    public int findDuplicate(int[] nums) {
        // the length of array
        int n = nums.length;
        // maximum bit till we have to check
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }
        // duplicate
        int res = 0;
        /*
         * For each bit position from 0 to bit_max:
         *   - Count how many numbers in the array have this bit set (curr)
         *   - Count how many numbers from 1..n-1 should have this bit set (base)
         * If curr > base, it means this bit appears extra due to the duplicate.
         * So we set that bit in our result.
         */
        for (int j = 0; j <= bit_max; j++) {
            int base = 0;
            int curr = 0;
            int mask = 1 << j;
            for (int i = 0; i < n; i++) {
                if ((mask & nums[i]) != 0) curr++;
            }
            for (int i = 1; i < n; i++) {
                if ((mask & i) != 0) base++;
            }
            if (curr > base) {
                res = res | mask;
            }
        }

        return res;
    }
}
