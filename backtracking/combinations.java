class Solution {

    // stores all valid combinations
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // start generating combinations from 1 to n
        helper(n, k, 1, new ArrayList<>());
        return res;
    }

    public void helper(int n, int k, int start, List<Integer> lst) {
        // base case: when k elements have been chosen, add to result
        if (k == 0) {
            res.add(new ArrayList<>(lst));
            return;
        }

        // iterate through all possible numbers starting from 'start'
        for (int i = start; i <= n; i++) {
            // choose current number
            lst.add(i);

            // recurse with remaining k-1 elements and next start index (i+1)
            helper(n, k - 1, i + 1, lst);

            // backtrack: remove last added element to explore other options
            lst.remove(lst.size() - 1);
        }
    }
}
