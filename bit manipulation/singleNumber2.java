class Solution {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    one++;
                }
            }
            if (one % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }
}
