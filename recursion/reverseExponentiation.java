class Solution {

    public int reverseExponentiation(int n) {
        // code here
        int reverse = n;
        if (reverse == 10) reverse = 1;
        return exp(n, reverse);
    }

    // binary exponentiation
    private int exp(int n, int e) {
        if (e == 0) return 1;
        int half = exp(n, e / 2);
        int res = half * half;
        if (e % 2 == 1) res *= n;
        return res;
    }
}
