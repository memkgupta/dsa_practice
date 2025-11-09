class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;

            TrieNode node = trie.root;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                node = node.childrens[c - 'a'];
                if (node == null) break;
                if (node.isEnd) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }
}

class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String s) {
        TrieNode traverse = root;
        for (char c : s.toCharArray()) {
            if (traverse.childrens[c - 'a'] == null) {
                traverse.childrens[c - 'a'] = new TrieNode();
            }
            traverse = traverse.childrens[c - 'a'];
        }
        traverse.isEnd = true;
    }
}

class TrieNode {

    boolean isEnd;
    TrieNode[] childrens;

    TrieNode() {
        this.childrens = new TrieNode[26];
        isEnd = false;
    }
}
