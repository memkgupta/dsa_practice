class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int end = 0;
        int start = 0;
        for (int i : piles) {
            end = Math.max(end, i);
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isPoss(piles, h, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    boolean isPoss(int[] piles, int h, int k) {
        int total = 0;
        for (int i : piles) {
            total += (int) Math.ceil((double) i / k);
            if (total > h) return false;
        }
        return total <= h;
    }
}
