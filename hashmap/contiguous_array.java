class Solution {

    public int findMaxLength(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int el = nums[i];
            if (el == 1) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                maxLen = Math.max(maxLen, i + 1);
            } else {
                if (map.containsKey(count)) {
                    int prev = map.get(count);
                    maxLen = Math.max(maxLen, i - prev);
                } else {
                    map.put(count, i);
                }
            }
        }
        return maxLen;
    }
}
