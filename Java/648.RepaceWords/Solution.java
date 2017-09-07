import java.util.Arrays;
import java.util.List;

class TrieNode {
    Character ch;
    boolean isLeaf;
    TrieNode[] children;

    TrieNode(Character ch) {
        this.children = new TrieNode[26];
        this.ch = ch;
        this.isLeaf = false;
    }
}

public class Solution {
    
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] dict = {"cat", "bat", "rat"};
        List<String> wordList = Arrays.asList(dict); 
        String res = s.replaceWords(wordList, "the cattle was rattled by the battery");
        System.out.println(res);
    }

    // O(n) where n is the number of characters in word
    private void insert(TrieNode root, String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode(c);
            }
            node = node.children[c-'a'];
        }
        node.isLeaf = true;
    }

    private String search(TrieNode root, String word) {
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (char c: word.toCharArray()) {
            TrieNode next = cur.children[c-'a'];
            if (next != null) {
                sb.append(c);
                if (next.isLeaf) return sb.toString();
                cur = next;
            } else {
                // Not matched
                return null;
            }
        }
        return null;
    }

    public String replaceWords(List<String> dict, String sentence) {

        TrieNode root = new TrieNode(null);

        for (String word: dict) {
            // Insert dict into the trie
            insert(root, word);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // Search in trie
            String match = search(root, word);
            // Add matched result to the list
            if (match != null) {
                sb.append(match);
            } else {
                sb.append(word);
            }
            if (i < words.length - 1) sb.append(' ');
        }

        return sb.toString();
    }
}