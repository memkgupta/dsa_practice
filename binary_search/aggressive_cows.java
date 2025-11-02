class Solution {

    public int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        Arrays.sort(stalls);
        int start = 1,
            end = stalls[n - 1] - stalls[0],
            ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canPlace(stalls, n, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    boolean canPlace(int[] stalls, int n, int k, int dist) {
        int count = 1,
            last = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
            }
            if (count >= k) return true;
        }
        return false;
    }
}
