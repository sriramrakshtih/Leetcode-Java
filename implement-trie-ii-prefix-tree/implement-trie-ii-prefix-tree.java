class Trie {
    Node root;
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) {
                curr.children[c-'a'] = new Node(c);
            }
            curr = curr.children[c-'a'];
            curr.count++;
        }
        curr.end++;
    }
    
    public int countWordsEqualTo(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return 0;
            }
            curr = curr.children[c-'a'];
        }
        return curr.end;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null) return 0;
            curr = curr.children[c - 'a'];
        }
        return curr.count;
    }
    
    
    public void erase(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) {
                curr.children[c-'a'] = new Node(c);
            }
            curr = curr.children[c-'a'];
            curr.count--;
        }
        curr.end--;
    }
    
    class Node {
        private char c;
        int count;
        int end;
        private Node [] children;
        
        public Node(char c) {
            this.c = c;
            this.count = 0;
            this.end = 0;
            this.children = new Node [26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */