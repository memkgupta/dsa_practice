// User function Template for Java
class Solution {

    static String[] wordBreak(String[] dict, String s) {
        // code here
        Set<String> set = new HashSet<>();
        for (String ss : dict) {
            set.add(ss);
        }
        List<List<String>> res = rec(s, set, 0);
        res = res
            .stream()
            .filter(lst -> {
                int tsize = 0;
                for (String ss : lst) {
                    tsize += ss.length();
                }
                return tsize == s.length();
            })
            .toList();
        String[] resa = new String[res.size()];
        int pt = 0;
        for (List<String> l : res) {
            StringBuilder sb = new StringBuilder();
            for (String ss : l) {
                sb.append(ss + " ");
            }
            resa[pt++] = sb.toString();
        }
        return resa;
    }

    static List<List<String>> rec(String s, Set<String> dict, int index) {
        if (index >= s.length()) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);

            if (dict.contains(sub)) {
                List<List<String>> lst = rec(s, dict, i + 1);
                if (lst.isEmpty()) {
                    lst.add(new ArrayList<>());
                }
                for (List<String> su : lst) {
                    su.add(0, sub);
                }

                res.addAll(lst);
            }
        }
        return res;
    }
}
