class Solution {

    Set<List<Integer>> lst;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        lst = new HashSet<>();
        rec(nums, 0, new ArrayList<>());
        return new ArrayList<>(lst);
    }

    public void rec(int[] nums, int index, List<Integer> ls) {
        if (index >= nums.length) {
            lst.add(new ArrayList<>(ls));
            return;
        }
        // take
        ls.add(nums[index]);
        rec(nums, index + 1, ls);
        ls.remove(ls.size() - 1);
        rec(nums, index + 1, ls);
    }
}
