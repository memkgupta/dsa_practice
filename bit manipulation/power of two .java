class Solution {

    public boolean isPowerOfTwo(int n) {
        int count = 0;
        if (n < 0) return false;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int bit = n & mask;
            if (bit > 0) count++;
        }
        return count == 1;
    }
}
