class Trie {

    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public String getRoot(String word) {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (current.children[index] == null) {
                return word;
            }

            current = current.children[index];
            prefix.append(ch);

            if (current.isEndOfWord) {
                return prefix.toString();
            }
        }

        return word;
    }
}

class Solution {
    public String replaceWords(java.util.List<String> dictionary, String sentence) {

        Trie trie = new Trie();

        for (String root : dictionary) {
            trie.insert(root);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i <= sentence.length(); i++) {

            if (i == sentence.length() || sentence.charAt(i) == ' ') {

                if (result.length() > 0) {
                    result.append(" ");
                }

                result.append(trie.getRoot(word.toString()));
                word.setLength(0);
            }
            else {
                word.append(sentence.charAt(i));
            }
        }

        return result.toString();
    }
}