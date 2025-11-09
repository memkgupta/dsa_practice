import java.util.Arrays;

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // dp[i][j] will store:
        //  -1 → not yet computed
        //   1 → true (subset found)
        //   2 → false (subset not found)
        int[][] dp = new int[arr.length][sum + 1];

        // Initialize dp table with -1 (meaning not calculated yet)
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start recursion from index 0 and given sum
        return rec(arr, sum, 0, dp);
    }

    // Recursive helper function
    public static boolean rec(int arr[], int sum, int index, int[][] dp) {
        // Base case 1: If sum becomes negative → not possible
        if (sum < 0) return false;

        // Base case 2: If sum becomes zero → found a valid subset
        if (sum == 0) return true;

        // Base case 3: If we've gone past last index → no subset found
        if (index >= arr.length) return false;

        // If result already computed → use memoized value
        // dp[index][sum] = 1 → true, 2 → false
        if (dp[index][sum] != -1) {
            return dp[index][sum] == 1;
        }

        // Recursive case 1: include current element in subset
        boolean take = rec(arr, sum - arr[index], index + 1, dp);

        // Recursive case 2: exclude current element from subset
        boolean skip = rec(arr, sum, index + 1, dp);

        // If either inclusion or exclusion leads to a valid subset
        boolean result = take || skip;

        // Memoize result for current (index, sum)
        dp[index][sum] = result ? 1 : 2;

        // Return result to previous recursion level
        return result;
    }
}
