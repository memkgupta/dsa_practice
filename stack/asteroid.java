class Solution {

    public int[] asteroidCollision(int[] a) {
        // while()
        int i = 0;
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        while (i < n) {
            if (a[i] >= 0) {
                stack.push(a[i]);
            } else {
                while (
                    !stack.isEmpty() &&
                    stack.peek() > 0 &&
                    stack.peek() < Math.abs(a[i])
                ) {
                    stack.pop();
                }
                int t = a[i];
                if (!stack.isEmpty()) {
                    int peek = stack.peek();
                    if (Math.abs(t) == peek) {
                        stack.pop();
                    } else if (Math.abs(t) >= peek) {
                        stack.push(t);
                    }
                } else {
                    stack.push(t);
                }
            }
            i++;
        }
        n = stack.size();
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            // System.out.println(stack.peek());
            ans[n - j - 1] = stack.pop();
        }
        return ans;
    }
}
