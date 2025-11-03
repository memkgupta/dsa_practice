class Solution {

    static int toggleBits(int n, int l, int r) {
        int mask = ((1 << r) - 1) ^ ((1 << (l - 1)) - 1);

        return n ^ mask;
    }
}
