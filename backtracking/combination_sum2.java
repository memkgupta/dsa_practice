class Solution {

    // stores all unique combinations that sum up to target
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort to easily skip duplicates and apply pruning
        Arrays.sort(candidates);
        // start recursive backtracking
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void helper(
        int[] candidates,
        int start,
        int target,
        List<Integer> lst
    ) {
        // base case: if target goes negative, no valid combination possible
        if (target < 0) return;

        // base case: exact sum found, add the current list to result
        if (target == 0) {
            res.add(new ArrayList<>(lst));
            return;
        }

        // explore all candidates starting from current index
        for (int i = start; i < candidates.length; i++) {
            // skip duplicate elements to avoid repeated combinations
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // only proceed if current element can fit in remaining target
            if (candidates[i] <= target) {
                // choose the current element
                lst.add(candidates[i]);
                // move to next index since each element can be used only once
                helper(candidates, i + 1, target - candidates[i], lst);
                // backtrack: remove last element to explore next option
                lst.remove(lst.size() - 1);
            }
        }
    }
}
