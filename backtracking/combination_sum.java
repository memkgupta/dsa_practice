class Solution {

    // Global list to store all valid combinations
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Sort the array to easily handle duplicates and enable early stopping
        Arrays.sort(candidates);

        // Start backtracking from index 0 with an empty combination
        helper(candidates, target, 0, new ArrayList<>());

        // Return all valid combinations that sum up to the target
        return res;
    }

    // Recursive backtracking function
    public void helper(
        int[] candidates,
        int target,
        int index,
        List<Integer> list
    ) {
        // Base case: if target becomes 0, current combination is valid
        if (target == 0) {
            // Add a copy of the current combination to the result
            res.add(new ArrayList<>(list));
            return;
        }

        // Iterate through the array starting from current index
        for (int i = index; i < candidates.length; i++) {
            // If current candidate exceeds the remaining target, stop exploring further
            if (target - candidates[i] < 0) {
                break;
            }

            // Choose current candidate (take it)
            list.add(candidates[i]);

            // Recurse with reduced target, allowing reuse of the same element (so index stays i)
            helper(candidates, target - candidates[i], i, list);

            // Backtrack: remove the last added element before exploring the next candidate
            list.remove(list.size() - 1);
        }
    }
}
