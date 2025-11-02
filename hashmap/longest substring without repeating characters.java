class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) >= l) {
                    l = map.get(s.charAt(i)) + 1;
                }
            }
            maxLen = Math.max(maxLen, i - l + 1);
            map.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
