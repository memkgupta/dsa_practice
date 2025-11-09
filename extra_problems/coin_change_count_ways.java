class Solution {

    public int count(int coins[], int sum) {
        // code here.
        int[][] mem = new int[coins.length][sum + 1];
        for (int[] m : mem) {
            Arrays.fill(m, -1);
        }
        return rec(coins, sum, 0, mem);
    }

    public int rec(int coins[], int sum, int index, int[][] mem) {
        if (sum == 0) {
            return 1;
        }
        if (index >= coins.length) return 0;
        if (mem[index][sum] != -1) return mem[index][sum];
        int count = 0;

        int take = 0;
        int skip = 0;
        if (coins[index] <= sum) {
            take = rec(coins, sum - coins[index], index, mem);
        }
        skip = rec(coins, sum, index + 1, mem);
        count += take + skip;

        return mem[index][sum] = count;
    }
}
