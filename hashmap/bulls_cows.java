class Solution {

    public String getHint(String secret, String guess) {
        int[] f_map = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            f_map[secret.charAt(i) - '0']++;
        }
        int c = 0;
        int b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                f_map[secret.charAt(i) - '0']--;
                b++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            char cr = guess.charAt(i);
            if (f_map[cr - '0'] > 0) {
                if (secret.charAt(i) == cr) {} else {
                    c++;
                    f_map[cr - '0']--;
                }
            }
        }
        return b + "A" + c + "B";
    }
}
