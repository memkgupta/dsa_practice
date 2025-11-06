class Solution {

    public int fib(int n) {
        // Base case: Fibonacci of 0 is 0
        if (n == 0) return 0;

        // Base case: Fibonacci of 1 and 2 are both 1
        if (n == 1 || n == 2) return 1;

        // Initialize first two Fibonacci numbers
        int a = 1; // Represents fib(i-2)
        int b = 1; // Represents fib(i-1)
        int c = 0; // Will store fib(i)

        // Iteratively compute Fibonacci values from 3 up to n
        // Each iteration computes the next Fibonacci number
        for (int i = n; i > 2; i--) {
            c = a + b; // Current Fibonacci = sum of previous two
            a = b; // Move forward: second becomes first
            b = c; // Current becomes second for next iteration
        }

        // 'c' now holds the nth Fibonacci number
        return c;
    }
}
