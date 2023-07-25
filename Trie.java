import java.util.HashMap;
import java.util.Map;

public class Trie {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    
    }
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public Trie(String str) {
        populateSuffixTrie(str);

    
    }
    public void populateSuffixTrie(String str) {
        for (int i = 0; i < str.length(); i++) {
            insertSubStringStartingAt(i, str);
        }
    }

    public void insertSubStringStartingAt(int index, String str) {
        TrieNode node = root;
        for (int i = index; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!node.children.containsKey(letter)) {
                TrieNode newNode = new TrieNode();
                node.children.put(letter, newNode);
            }
            node = node.children.get(letter);
        }
        node.children.put(endSymbol, null);

    }

    public boolean contains(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return node.children.containsKey(endSymbol);
    }

    public static void main(String[] args) {
        Trie trie = new Trie("richard");

        System.out.println(trie.contains("ichardr")) ;
    }
}
