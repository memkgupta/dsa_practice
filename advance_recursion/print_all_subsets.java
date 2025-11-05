class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // total subsets will be equal to 2^n
        int totalSubsets = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int mask = (1 << (j));
                if ((mask & i) > 0) list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }
}
