class Solution {

    public int countPrimes(int n) {
        // pre calculating the sieve
        int[] sieve = new int[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            // if the current number is marked -1 it means it is a multiple of a prime number hence will not check it
            if (sieve[i] == -1) {
                continue;
            }
            // else count will increase
            count++;
            // mark all multiples of this prime number
            for (int j = 2 * i; j < n; j += i) {
                sieve[j] = -1;
            }
        }
        return count;
    }
}
