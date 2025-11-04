class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> mappings = new HashMap<>();
        HashMap<Character, Character> mappings_i = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mappings.containsKey(c1)) {
                if (mappings.get(c1) != c2) return false;
            } else if (mappings_i.containsKey(c2)) {
                if (mappings_i.get(c2) != c1) return false;
            } else {
                mappings.put(c1, c2);
                mappings_i.put(c2, c1);
            }
        }
        return true;
    }
}
