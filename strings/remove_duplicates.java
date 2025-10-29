class Solution {

    String removeDuplicates(String s) {
        // using hashmap for counting frequency
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // update the frequency of the char
            map.put(c, map.getOrDefault(c, 0) + 1);
            // only append to the result if the char has not appeared previously
            if (map.get(c) == 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
