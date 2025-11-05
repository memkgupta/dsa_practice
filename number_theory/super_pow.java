class Solution {

    public int superPow(int a, int[] b) {
        // We will use Euler's Totient function and Euler's theorem to calculate the exponention
        // since we are given mod = 1337 phi(m) = 1140
        // first calculate the exponent after modulation with 1337
        // i.e (a^b)%n = (a^(b%phi(n)))%n
        // (b%phi(n))
        int pow = calcModPow(b, 1140);
        // if pow = 0 => add 1140
        if (pow == 0) pow += 1140;
        // finally calculate the modular exponentiation
        return binexp(a, pow);
    }

    public int binexp(int a, int b) {
        if (b == 0) return 1;
        int ans = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                ans = (ans * (a % 1337)) % 1337;
            }
            a = ((a % 1337) * (a % 1337)) % 1337;
            b >>= 1;
        }
        return ans;
    }

    public int calcModPow(int[] nums, int mod) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (((sum * 10) % mod) + ((nums[i]) % mod)) % mod;
        }
        return sum;
    }
}
