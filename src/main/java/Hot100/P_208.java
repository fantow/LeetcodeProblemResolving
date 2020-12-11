package Hot100;

import java.util.HashMap;
import java.util.Map;

public class P_208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    static class Trie{

        Node root;

        class Node{
            // 表示当前值是否是一个词的结尾
            boolean isWordEnd;

            // 表示当前节点代表的Char
            Character ch ;

            // 存储这个节点下面节点的Node
            Map<Character,Node> map = new HashMap<>();

            public Node(Character ch) {
                this.ch = ch;
            }
        }

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new Node('0');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            int length = chars.length;

            Map<Character,Node> map = this.root.map;
            for(int i = 0;i < length;i++){
                if(map.containsKey(chars[i])){
                    Node node = map.get(chars[i]);
                }else{
                    map.put(chars[i],new Node(chars[i]));
                }

                if(i == length - 1){
                    map.get(chars[i]).isWordEnd = true;
                }
                map = map.get(chars[i]).map;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            int length = word.length();
            if(length == 0){
                return false;
            }

            char[] chars = word.toCharArray();

            Map<Character,Node> map = this.root.map;
            // 需要保证word的结尾是end
            for(int i = 0;i < length;i++){
                if(!map.containsKey(chars[i])) {
                    return false;
                }

                if(i == length - 1){
                    if(map.get(chars[i]).isWordEnd == true){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    map = map.get(chars[i]).map;
                }
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            int length = prefix.length();
            if(length == 0){
                return false;
            }

            char[] chars = prefix.toCharArray();

            Map<Character,Node> map = this.root.map;
            // 需要保证word的结尾是end
            for(int i = 0;i < length;i++){
                if(!map.containsKey(chars[i])) {
                    return false;
                }

                map = map.get(chars[i]).map;
            }
            return true;
        }
    }
}
