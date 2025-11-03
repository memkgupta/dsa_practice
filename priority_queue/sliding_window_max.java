class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        int l = 0;
        while (j < nums.length) {
            while (!q.isEmpty() && q.peekFirst() <= (j - k)) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[j]) {
                q.removeLast();
            }

            q.offer(j);
            if (
                j - (k - 1) >= 0 && (j - (k - 1)) < res.length && !q.isEmpty()
            ) {
                res[j - (k - 1)] = nums[q.peekFirst()];
            }
            j++;
        }
        return res;
    }
}
