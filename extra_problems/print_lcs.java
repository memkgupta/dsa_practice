// User function Template for Java

class Solution {

    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int[] dp = new int[arr.length];
        int[] par = new int[arr.length];

        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            par[i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                    par[i] = j;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[max] < dp[i]) {
                max = i;
            }
        }
        int i = max;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[i]);
        while (par[i] != i) {
            i = par[i];
            list.add(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }
}
