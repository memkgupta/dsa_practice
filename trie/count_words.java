/*
class TrieNode {
    TrieNode[] children; // for lowercase English letters
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
*/

class Solution {

    // Method to count total number of words present in Trie
    public int wordCount(TrieNode root) {
        // just call helper recursive function and return the result
        return countWords(root);
    }

    // Recursive function that counts words starting from this node
    public int countWords(TrieNode node) {
        if (node == null) return 0;

        int total = 0;

        // if this node marks end of a word, count it
        if (node.isEndOfWord) {
            total++;
        }

        // traverse all child nodes
        for (TrieNode child : node.children) {
            if (child != null) {
                total += countWords(child);
            }
        }

        return total;
    }
}
