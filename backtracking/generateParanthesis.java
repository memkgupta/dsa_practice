class Solution {

    // stores all valid parentheses combinations
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // start backtracking with 0 open and close brackets used
        backtrack(n, 0, 0, new StringBuilder());
        return res;
    }

    private void backtrack(int n, int open, int close, StringBuilder sb) {
        // base case: when the string is complete (n pairs = n*2 chars)
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        // if we can still add an opening bracket, do it
        if (open < n) {
            sb.append('(');
            backtrack(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        // add a closing bracket only if it won’t break validity (close < open)
        if (close < open) {
            sb.append(')');
            backtrack(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}
