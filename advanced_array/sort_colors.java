class Solution {

    public void sortColors(int[] nums) {
        int[] map = new int[3];
        for (int i : nums) {
            map[i]++;
        }
        int i = 0;
        while (i < nums.length && map[0] > 0) {
            nums[i] = 0;
            map[0]--;
            i++;
        }
        while (i < nums.length && map[1] > 0) {
            nums[i] = 1;
            map[1]--;
            i++;
        }
        while (i < nums.length && map[2] > 0) {
            nums[i] = 2;
            map[2]--;
            i++;
        }
    }
}
