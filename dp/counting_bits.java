class Solution {

    // we can solve this in O(n) time complexity using lookup table in which we pre calculate no of count bits from 0 - 255 basically 8 bits , and then for each 32 bit number we check 8bits from the lookup table
    int[] lookup = new int[256];

    public int countSetBits(int n) {
        return (
            lookup[n & 0xff] + //first 8 bits
            lookup[(n >> 8) & 0xff] + // 2nd 8 bits
            lookup[(n >> 16) & 0xff] + // 3rd 8 bits
            lookup[n >> 24]
        ); // 4th 8th bits
    }

    public int[] countBits(int n) {
        for (int i = 0; i < 256; i++) {
            lookup[i] = (i & 1) + lookup[i / 2];
        }
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countSetBits(i);
        }
        return res;
    }
}
