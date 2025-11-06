class Trie {

    TrieNode root;

    public Trie() {
        // I’m initializing the Trie with an empty root node
        root = new TrieNode();
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode crawl = root;

        // I’ll iterate through each character of the word
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a'; // mapping char to index (0–25)

            // If the path for this character doesn’t exist, create it
            if (crawl.arr[idx] == null) {
                crawl.arr[idx] = new TrieNode();
            }

            // Move to the next node
            crawl = crawl.arr[idx];
        }

        // After the full word is inserted, mark the last node as end of word
        crawl.isEndOfWord = true;
    }

    // Checks if a word exists in the Trie
    public boolean search(String word) {
        TrieNode crawl = root;

        // Traverse for each character in the word
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';

            // If at any point path breaks -> word not found
            if (crawl.arr[idx] == null) {
                return false;
            }

            // Move deeper
            crawl = crawl.arr[idx];
        }

        // At the end, check if this node marks a complete word
        return crawl.isEndOfWord == true;
    }

    // Checks if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode crawl = root;

        // Just like search, but we don’t care about endOfWord here
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';

            // If prefix path breaks, it doesn’t exist
            if (crawl.arr[idx] == null) {
                return false;
            }

            // Keep going deeper
            crawl = crawl.arr[idx];
        }

        // If traversal is successful, prefix exists
        return true;
    }
}

// Node class for Trie
class TrieNode {

    TrieNode[] arr; // stores reference to 26 lowercase letters
    boolean isEndOfWord; // tells if a word ends here

    TrieNode() {
        this.arr = new TrieNode[26]; // initially, all 26 are null
        this.isEndOfWord = false;
    }
}
