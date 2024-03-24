import BinarySearchTree.Node;

public class Trie_1 {
    class TrieNode{
        TrieNode[] children;
        boolean end;

        TrieNode(){
            children = new TrieNode[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            end = false;
        }
    }

    TrieNode root = new TrieNode();
}
