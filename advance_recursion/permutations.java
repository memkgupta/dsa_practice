class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new int[nums.length], new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int[] vis, List<Integer> lst) {
        if (lst.size() == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] != 1) {
                vis[i] = 1;
                lst.add(nums[i]);
                helper(nums, vis, lst);
                vis[i] = 0;
                lst.remove(lst.size() - 1);
            }
        }
    }
}
